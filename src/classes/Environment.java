/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Environment extends javax.swing.JFrame {

    static AtomicIntegerArray transmitting;
    static CyclicBarrier gate;
    static ImageIcon[] icon;
    private int length;
    private int width;
    static int duration;
    private Sensor[] s;
    private Thread[] threads;
    private Sensor[][] board;
    private int total;
    static AtomicInteger reds;
    static AtomicInteger blues;
    private int redN;
    private int blueN;
    private Map<Sensor, Integer> s_x;
    private Map<Sensor, Integer> s_y;

    /**
     * Creates new form Menu
     */
    public Environment() {
        initComponents();

        icon = new ImageIcon[2];
        icon[0] = new ImageIcon(this.getClass().getResource("/images/red.png"));
        icon[1] = new ImageIcon(this.getClass().getResource("/images/blue.png"));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        Length = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Width = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Random = new javax.swing.JRadioButton();
        Choice = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        RedNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        BlueNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Duration = new javax.swing.JTextField();
        Run = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        IterationNumber = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        reds_number = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        blues_number = new javax.swing.JTextField();
        SensorsNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Build = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        jRadioButton2.setText("jRadioButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText(" Length");

        Length.setText("10");
        Length.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LengthActionPerformed(evt);
            }
        });

        jLabel2.setText(" Width");

        Width.setText("10");
        Width.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WidthActionPerformed(evt);
            }
        });

        jLabel3.setText("Sensors deployment options:");

        Random.setText("Color Randomly");
        Random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RandomActionPerformed(evt);
            }
        });

        Choice.setText("Color by Choice ");
        ButtonGroup group = new ButtonGroup();
        group.add(Random);
        group.add(Choice);
        Choice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoiceActionPerformed(evt);
            }
        });

        jLabel5.setText(" # of Reds");

        RedNumber.setText("10000");

        jLabel6.setText(" # of Blues");

        BlueNumber.setText("10000");

        jLabel7.setText("Simulation Duration (in time units)");

        Duration.setText("10");

        Run.setText("Run");
        Run.setEnabled(false);
        Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunActionPerformed(evt);
            }
        });

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        jLabel8.setText("  Statistics:");

        jLabel9.setText(" Iteration#");

        IterationNumber.setEditable(false);

        jLabel10.setText(" Red#");

        reds_number.setEditable(false);

        jLabel11.setText(" Blue#");

        blues_number.setEditable(false);

        SensorsNumber.setText("20000");
        SensorsNumber.setToolTipText("");
        SensorsNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SensorsNumberActionPerformed(evt);
            }
        });

        jLabel12.setText(" # of Sensors");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1716, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Build.setText("Build");
        Build.setEnabled(false);
        Build.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuildActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(Duration, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(87, 87, 87))
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(IterationNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(reds_number)
                                    .addComponent(blues_number)))
                            .addComponent(Choice)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel12))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(RedNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(BlueNumber)
                                    .addComponent(SensorsNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Length, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(Width)))
                            .addComponent(jLabel3)
                            .addComponent(Random)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Build, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Run, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Length, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Random)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Choice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SensorsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(RedNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BlueNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Build)
                    .addComponent(Run))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Exit)
                .addGap(1, 1, 1)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(IterationNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(reds_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(blues_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 565, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName("");
        Length.getAccessibleContext().setAccessibleName("length");
        jLabel2.getAccessibleContext().setAccessibleName(" ");
        Width.getAccessibleContext().setAccessibleName("width");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LengthActionPerformed

    }//GEN-LAST:event_LengthActionPerformed

    private void RandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RandomActionPerformed
        // TODO add your handling code here:
        RedNumber.setEnabled(false);
        BlueNumber.setEnabled(false);
        SensorsNumber.setEnabled(true);
        Build.setEnabled(true);
    }//GEN-LAST:event_RandomActionPerformed

    private void RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunActionPerformed

        //System.out.println("REDS & BLUES: " + reds + " " + blues);
        duration = Integer.parseInt(Duration.getText());
        Run.setEnabled(false);
        Build.setEnabled(false);
        reds_number.setText("" + reds);
        blues_number.setText("" + blues);
        Thread main = (new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < total; i++) {
                    threads[i].start();
                }
                try {
                    gate.await();
                } catch (InterruptedException | BrokenBarrierException ex) {
                    Logger.getLogger(Environment.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < total; i++) {
                    try {
                        threads[i].join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Environment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        main.start();
        (new Thread() {
            @Override
            public void run() {
                while (main.isAlive()) {
                    reds_number.setText("" + reds);
                    blues_number.setText("" + blues);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Environment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                reds_number.setText("" + reds);
                blues_number.setText("" + blues);
                Build.setEnabled(true);
            }
        }).start();
    }//GEN-LAST:event_RunActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void WidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WidthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WidthActionPerformed

    private void ChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoiceActionPerformed
        // TODO add your handling code here:
        RedNumber.setEnabled(true);
        BlueNumber.setEnabled(true);
        SensorsNumber.setEnabled(false);
        Build.setEnabled(true);
    }//GEN-LAST:event_ChoiceActionPerformed

    private void SensorsNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SensorsNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SensorsNumberActionPerformed

    private void BuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuildActionPerformed

        jPanel1.removeAll();
        jPanel1.revalidate();
        jPanel1.repaint();
        s_x = new HashMap<>();
        s_y = new HashMap<>();
        reds_number.setText("");
        blues_number.setText("");

        Random rand = new Random();
        length = Integer.parseInt(Length.getText()) * 50;
        width = Integer.parseInt(Width.getText()) * 50;
        if (length * width > 100000000) {
            System.exit(0);
        }

        redN = 0;
        blueN = 0;
        if (Random.isSelected()) {
            total = Integer.parseInt(SensorsNumber.getText());
        } else {
            redN = Integer.parseInt(RedNumber.getText());
            blueN = Integer.parseInt(BlueNumber.getText());
            total = redN + blueN;
        }

        transmitting = new AtomicIntegerArray(total);
        gate = new CyclicBarrier(total + 1);
        threads = new Thread[total];
        s = new Sensor[total];
        board = new Sensor[length][width];
        //System.out.println("REDS & BLUES: " + reds + " " + blues);
        for (int i = 0; i < total; i++) {
            int x, y;
            do {
                x = rand.nextInt(length);
                y = rand.nextInt(width);
            } while (board[x][y] != null);

            int color = 0;
            if (i >= redN) {
                color = 1;
            }
            if (Random.isSelected()) {
                color = rand.nextInt(2);
                if (color == 0) {
                    redN++;
                } else {
                    blueN++;
                }
            }
            s[i] = new Sensor(color, 50, i);
            s[i].label.setBounds(x, y, 3, 3);
            s_x.put(s[i], x);
            s_y.put(s[i], y);
            board[x][y] = s[i];
            jPanel1.add(s[i].getLabel());
            threads[i] = new Thread(s[i]);
        }
        for (int k = 0; k < total; k++) {
            int x = s_x.get(s[k]);
            int y = s_y.get(s[k]);
            int r = s[k].getRange();
            for (int i = max(x - r, 0); i < min(x + r + 1, width); i++) {
                for (int j = max(y - r, 0); j < min(y + r + 1, length); j++) {
                    if (!(x == i && y == j) && board[i][j] != null && (int) (Math.sqrt((x - i) * (x - i) + (y - j) * (y - j))) <= r) {
                        s[k].neighbors.add(board[i][j].getNumber());
                    }
                }
            }
        }
        jPanel1.revalidate();
        jPanel1.repaint();
        RedNumber.setText("" + redN);
        BlueNumber.setText("" + blueN);
        SensorsNumber.setText("" + total);
        reds = new AtomicInteger(redN);
        blues = new AtomicInteger(blueN);

        Run.setEnabled(true);
    }//GEN-LAST:event_BuildActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Environment.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Environment();
        });
        //Environment e = new Environment();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BlueNumber;
    private javax.swing.JButton Build;
    private javax.swing.JRadioButton Choice;
    private javax.swing.JTextField Duration;
    private javax.swing.JButton Exit;
    private javax.swing.JTextField IterationNumber;
    private javax.swing.JTextField Length;
    private javax.swing.JRadioButton Random;
    private javax.swing.JTextField RedNumber;
    private javax.swing.JButton Run;
    private javax.swing.JTextField SensorsNumber;
    private javax.swing.JTextField Width;
    private javax.swing.JTextField blues_number;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField reds_number;
    // End of variables declaration//GEN-END:variables
}
