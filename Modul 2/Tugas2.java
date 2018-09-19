/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStream;

import com.sun.media.sound.WaveFileWriter;
import sun.audio.AudioStream;

/**
 *
 * @author Zaki
 */
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class Tugas2 extends javax.swing.JFrame {

    /**
     * Creates new form ReadWriteAudio
     */
  //  AudioStream au = null;
    ImageIO aus;
    File file;
    public Tugas2() {
        initComponents();
        setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        txdirectory = new javax.swing.JTextField();
        btread = new javax.swing.JButton();
        btsave = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txdirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txdirectoryActionPerformed(evt);
            }
        });

        btread.setText("Read");
        btread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btreadActionPerformed(evt);
            }
        });

        btsave.setText("Save");
        btsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txdirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btread)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btsave)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txdirectory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btread)
                    .addComponent(btsave))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btreadActionPerformed
        // TODO add your handling code here:
        BufferedImage image = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        chooser.setFileFilter(new javax.swing.filechooser.FileFilter(){
            
            public String getDescription(){
                return "All Imange";
            }
            
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()){
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg")
                            || f.getName().toLowerCase().endsWith(".png");
                }
            }
        });
        int res = chooser.showOpenDialog(Tugas2.this);
        if(res == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            try{
                FileInputStream in = new FileInputStream(file);
                //image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                image = ImageIO.read(in);
            }catch(Exception ex){
                Logger.getLogger(Tugas2.class.getName()).log(Level.SEVERE, null, ex);
            }
            String name = file.getAbsolutePath();
            txdirectory.setText(name);
        }
    }//GEN-LAST:event_btreadActionPerformed

    private void btsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsaveActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        int r = chooser.showSaveDialog(this);
        if (r==JFileChooser.APPROVE_OPTION){
            File sf = chooser.getSelectedFile();
            try{
              InputStream inp = new FileInputStream(file);
              OutputStream out = new FileOutputStream(sf);
              
              int data = inp.read();
              while(data != -1){
                  out.write(data);
                  data = inp.read();
              }
              out.flush();
              out.close();
            }catch(IOException ioe){
                JOptionPane.showMessageDialog(null, "Trouble" + ioe);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Cancelled by User");
        }
    }//GEN-LAST:event_btsaveActionPerformed

    private void txdirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txdirectoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txdirectoryActionPerformed

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
            java.util.logging.Logger.getLogger(Tugas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tugas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tugas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tugas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tugas2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btread;
    private javax.swing.JButton btsave;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txdirectory;
    // End of variables declaration//GEN-END:variables
}
