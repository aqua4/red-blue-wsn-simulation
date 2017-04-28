/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static classes.Environment.blues;
import static classes.Environment.finished;
import static classes.Environment.gate;
import static classes.Environment.icon;
import static classes.Environment.reds;
import static classes.Environment.table;
import static classes.Environment.transmitting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Sensor implements Runnable {

    private final Set<Integer> blue_sensors; // nearby blue sensors
    private final Set<Integer> red_sensors;  // nearby red sensors
    private final int number;         // sensor's number
    private int color;          // 0 - red, 1 - blue
    private int state;          // current state
    private final int[] status;       // 0 - sleeping, 1 - listening to reds, 2 - listening to blues, 3 - transmitting
    private final int time_to_sleep;
    private final int time_to_reds;
    private final int time_to_blues;
    private final int time_to_transmit;
    private final int size;
    private final int start;
    private int local_clock;
    private final int range;      // transmission range
    ArrayList<Integer> neighbors;
    JLabel label;

    public Sensor(int c, int r, int n) {

        color = c;
        range = r;
        number = n;
        blue_sensors = new HashSet<>();
        red_sensors = new HashSet<>();
        neighbors = new ArrayList();
        label = new JLabel(icon[color]);
        transmitting.set(number, 0);

        Random rand = new Random();
        time_to_sleep = rand.nextInt(3) + 60;
        time_to_reds = rand.nextInt(3) + 3;
        time_to_blues = rand.nextInt(3) + 3;
        time_to_transmit = rand.nextInt(3) + 3;
        size = time_to_sleep + time_to_reds + time_to_blues + time_to_transmit;
        local_clock = rand.nextInt(size) + 1;
        state = local_clock;
        start = local_clock;

        status = new int[size + 1];
        // 0 for sleep by default
        for (int i = time_to_sleep + 1; i <= time_to_reds + time_to_sleep; i++) {
            status[i] = 1;
        }
        for (int i = time_to_sleep + time_to_reds + 1; i <= time_to_blues + time_to_reds + time_to_sleep; i++) {
            status[i] = 2;
        }
        for (int i = size - time_to_transmit + 1; i <= size; i++) {
            status[i] = 3;
        }
    }

    JLabel getLabel() {
        return this.label;
    }

    int getNumber() {
        return this.number;
    }

    int getRange() {
        return this.range;
    }

    int getColor() {
        return this.color;
    }

    int getState() {
        return status[state];
    }

    private void changeColor(int c) {
        table[number][local_clock - start] = true;
        this.color = c;
        this.label.setIcon(icon[c]);
        if (c == 0) {
            reds.incrementAndGet();
            blues.decrementAndGet();
        } else if (c == 1) {
            reds.decrementAndGet();
            blues.incrementAndGet();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                gate.await();
            } catch (InterruptedException | BrokenBarrierException ex) {
                Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (finished) {
                break;
            }
            state = local_clock % (size + 1);
            if (state == 0) {
                transmitting.set(number, 0);
            }
            switch (status[state]) {
                case 1:
                    neighbors.stream().filter((i) -> (transmitting.get(i) == 1)).forEachOrdered((i) -> {
                        red_sensors.add(i);
                    });
                    break;
                case 2:
                    neighbors.stream().filter((i) -> (transmitting.get(i) == 2)).forEachOrdered((i) -> {
                        blue_sensors.add(i);
                    });
                    break;
                case 3:
                    int blues = blue_sensors.size();
                    int reds = red_sensors.size();
                    if (blues > 0 || reds > 0) {
                        double balance = (blues - reds + .0) / (blues + reds + .0);
                        if (balance < -0.25 && color == 0) {
                            changeColor(1);
                        }
                        if (balance > 0.25 && color == 1) {
                            changeColor(0);
                        }
                        red_sensors.clear();
                        blue_sensors.clear();
                    }
                    transmitting.set(number, color + 1);
                    break;
                default:
                    break;
            }
            ++local_clock;
        }
    }
}
