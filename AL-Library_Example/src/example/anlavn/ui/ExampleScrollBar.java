package example.anlavn.ui;
// Make By Bình An || AnLaVN || KatoVN

import anlavn.ui.Mode;
import anlavn.ui.ScrollBar;

public class ExampleScrollBar extends javax.swing.JFrame {

    public ExampleScrollBar() {
        Mode.setMode(true);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        brp = new javax.swing.ButtonGroup();
        scpPan = new javax.swing.JScrollPane();
        panBackground = new javax.swing.JPanel();
        rdoDM = new javax.swing.JRadioButton();
        rdoLM = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scpPan.setHorizontalScrollBar(null);
        scpPan.setVerticalScrollBar(new ScrollBar());

        brp.add(rdoDM);
        rdoDM.setSelected(true);
        rdoDM.setText("Dark Mode");
        rdoDM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rdoDMFocusGained(evt);
            }
        });

        brp.add(rdoLM);
        rdoLM.setText("Light Mode");
        rdoLM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rdoLMFocusGained(evt);
            }
        });

        javax.swing.GroupLayout panBackgroundLayout = new javax.swing.GroupLayout(panBackground);
        panBackground.setLayout(panBackgroundLayout);
        panBackgroundLayout.setHorizontalGroup(
            panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBackgroundLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdoDM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoLM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        panBackgroundLayout.setVerticalGroup(
            panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoDM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 768, Short.MAX_VALUE)
                .addComponent(rdoLM)
                .addContainerGap())
        );

        scpPan.setViewportView(panBackground);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpPan, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpPan, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdoDMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rdoDMFocusGained
        System.out.println("Dark mode");
        Mode.setMode(true);
        setModeApp();
    }//GEN-LAST:event_rdoDMFocusGained

    private void rdoLMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rdoLMFocusGained
        System.out.println("Light mode");
        Mode.setMode(false);
        setModeApp();
    }//GEN-LAST:event_rdoLMFocusGained

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExampleScrollBar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new ExampleScrollBar().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup brp;
    private javax.swing.JPanel panBackground;
    private javax.swing.JRadioButton rdoDM;
    private javax.swing.JRadioButton rdoLM;
    private javax.swing.JScrollPane scpPan;
    // End of variables declaration//GEN-END:variables
    
    private void setModeApp(){
        Mode.setModeComponent(panBackground);
        Mode.setModeComponent(scpPan.getVerticalScrollBar());
        
        Mode.setModeComponent(rdoDM);
        Mode.setModeComponent(rdoLM);
    }
}