package com.AnLa.Example;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.FILE.Log;
import com.AnLa.FILE.Properties;
import com.AnLa.FILE.Raw;


public class ExamplesFile extends javax.swing.JFrame {

    public ExamplesFile() {
        initComponents();
        lang.setProperties("en.properties");
        getAndSetLanguages();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgr = new javax.swing.ButtonGroup();
        txt = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        rdoEN = new javax.swing.JRadioButton();
        rdoVN = new javax.swing.JRadioButton();
        hello = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActionPerformed(evt);
            }
        });

        bgr.add(rdoEN);
        rdoEN.setSelected(true);
        rdoEN.setText("English");
        rdoEN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rdoENFocusGained(evt);
            }
        });

        bgr.add(rdoVN);
        rdoVN.setText("Tieng Viet");
        rdoVN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rdoVNFocusGained(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hello, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdoEN, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jButton1))
                    .addComponent(rdoVN, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hello, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoEN)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(rdoVN)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActionPerformed
        Log.add(txt.getText());
        txt.setText("");
    }//GEN-LAST:event_txtActionPerformed

    private void rdoENFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rdoENFocusGained
        lang.setProperties("en.properties");
        getAndSetLanguages();
    }//GEN-LAST:event_rdoENFocusGained

    private void rdoVNFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rdoVNFocusGained
        lang.setProperties("vi.properties");
        getAndSetLanguages();
    }//GEN-LAST:event_rdoVNFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Raw raw = new Raw("test.dat");
        raw.writeData(txt.getText());
        txt.setText("");
        System.out.println(raw.readData());
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamplesFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamplesFile().setVisible(true);
            }
        });
    }
    
    Properties lang = new Properties();
    
    private void getAndSetLanguages(){
        label.setText(lang.getString("log"));
        hello.setText(lang.getString("hello"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgr;
    private javax.swing.JLabel hello;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel label;
    private javax.swing.JRadioButton rdoEN;
    private javax.swing.JRadioButton rdoVN;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
}