/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.event.*;
public class LOGOanimation extends javax.swing.JFrame {

    /**
     * Creates new form LOGOanimation
     */
    public LOGOanimation() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        STOP = new javax.swing.JButton();
        START = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        STOP.setText("STOP");
        STOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STOPActionPerformed(evt);
            }
        });

        START.setText("START");
        START.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STARTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(STOP)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(174, 174, 174)
                    .addComponent(START)
                    .addContainerGap(941, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(STOP)
                .addGap(39, 39, 39))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(749, Short.MAX_VALUE)
                    .addComponent(START)
                    .addGap(36, 36, 36)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
int z=0;
Icon a=new ImageIcon("C:\\Users\\Admin\\Desktop\\seas ict\\Semester 3\\DSA Lab\\AULOGO\\Transparent\\1.png");
Icon b=new ImageIcon("C:\\Users\\Admin\\Desktop\\seas ict\\Semester 3\\DSA Lab\\AULOGO\\\\Transparent\\2.png");
Icon c=new ImageIcon("C:\\Users\\Admin\\Desktop\\seas ict\\Semester 3\\DSA Lab\\AULOGO\\\\Transparent\\3.png");
Icon d=new ImageIcon("C:\\Users\\Admin\\Desktop\\seas ict\\Semester 3\\DSA Lab\\AULOGO\\\\Transparent\\4.png");
Icon e2=new ImageIcon("C:\\Users\\Admin\\Desktop\\seas ict\\Semester 3\\DSA Lab\\AULOGO\\\\Transparent\\5.png");
Timer t=new Timer(250, new ActionListener()
{public void actionPerformed(ActionEvent e){
            z++;
            switch(z){
                case 1:{
                 jLabel1.setIcon(a);
                 break;
                }
                case 2:{
                 jLabel1.setIcon(b);
                 break;
                }
                case 3:{
                 jLabel1.setIcon(c);
                 break;
                }
                case 4:{
                 jLabel1.setIcon(d);
                 break;
                }
                case 5:{
                 jLabel1.setIcon(e2);
                 break;
                }
            }
//            if(z==5){
//                System.exit(0);
//            }
        }
});
    private void STARTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STARTActionPerformed
       t.start();
        // TODO add your handling code here:
    }//GEN-LAST:event_STARTActionPerformed

    private void STOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STOPActionPerformed
t.stop();        // TODO add your handling code here:
    }//GEN-LAST:event_STOPActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LOGOanimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGOanimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGOanimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGOanimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGOanimation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton START;
    private javax.swing.JButton STOP;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
