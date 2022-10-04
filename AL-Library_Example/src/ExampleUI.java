

import com.AnLa.UI.Mode;
import com.AnLa.UI.ScrollBar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ExampleUI extends javax.swing.JFrame {

    public ExampleUI() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpPan = new javax.swing.JScrollPane();
        panBackground = new javax.swing.JPanel();
        rdoDM = new javax.swing.JRadioButton();
        rdoLM = new javax.swing.JRadioButton();
        btnWFileChooser = new javax.swing.JButton();
        btnWMessage = new javax.swing.JButton();
        btnWConfrim = new javax.swing.JButton();
        btnWInput = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scpPan.setHorizontalScrollBar(null);
        scpPan.setVerticalScrollBar(new ScrollBar());

        rdoDM.setSelected(true);
        rdoDM.setText("Dark Mode");
        rdoDM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rdoDMFocusGained(evt);
            }
        });

        rdoLM.setText("Light Mode");
        rdoLM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rdoLMFocusGained(evt);
            }
        });

        btnWFileChooser.setText("WFileChooser");
        btnWFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWFileChooserActionPerformed(evt);
            }
        });

        btnWMessage.setText("WMessage");
        btnWMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWMessageActionPerformed(evt);
            }
        });

        btnWConfrim.setText("WConfirm");
        btnWConfrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWConfrimActionPerformed(evt);
            }
        });

        btnWInput.setText("WInput");
        btnWInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBackgroundLayout = new javax.swing.GroupLayout(panBackground);
        panBackground.setLayout(panBackgroundLayout);
        panBackgroundLayout.setHorizontalGroup(
            panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBackgroundLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rdoDM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoLM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnWFileChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnWMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnWConfrim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnWInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        panBackgroundLayout.setVerticalGroup(
            panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBackgroundLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(rdoDM)
                .addGap(18, 18, 18)
                .addComponent(rdoLM)
                .addGap(18, 18, 18)
                .addComponent(btnWFileChooser)
                .addGap(18, 18, 18)
                .addComponent(btnWMessage)
                .addGap(18, 18, 18)
                .addComponent(btnWConfrim)
                .addGap(18, 18, 18)
                .addComponent(btnWInput)
                .addContainerGap(269, Short.MAX_VALUE))
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
            .addComponent(scpPan, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
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

    private void btnWFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWFileChooserActionPerformed
        System.out.println("Windows File Chooser");
        JFileChooser filechooser = Mode.WFileChooser();
        filechooser.showOpenDialog(null);
    }//GEN-LAST:event_btnWFileChooserActionPerformed

    private void btnWMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWMessageActionPerformed
        System.out.println("Windows Message");
        Mode.WMessage(rootPane, "Hello, this is a message dialog", "Message Tittle", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnWMessageActionPerformed

    private void btnWConfrimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWConfrimActionPerformed
        System.out.println("Windows Confirm");
        System.out.println("User: "+Mode.WConfirm(rootPane, "Hello, this is a confirm dialog"));
    }//GEN-LAST:event_btnWConfrimActionPerformed

    private void btnWInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWInputActionPerformed
        System.out.println("Windows Input");
        System.out.println("User Input: "+Mode.WInput("Hello, this is a Input dialog"));
    }//GEN-LAST:event_btnWInputActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExampleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new ExampleUI().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnWConfrim;
    private javax.swing.JButton btnWFileChooser;
    private javax.swing.JButton btnWInput;
    private javax.swing.JButton btnWMessage;
    private javax.swing.JPanel panBackground;
    private javax.swing.JRadioButton rdoDM;
    private javax.swing.JRadioButton rdoLM;
    private javax.swing.JScrollPane scpPan;
    // End of variables declaration//GEN-END:variables
    
    private void setModeApp(){
        Mode.setModeUI(panBackground);
        Mode.setModeUI(scpPan.getVerticalScrollBar());
        
        Mode.setModeUI(rdoDM);
        Mode.setModeUI(rdoLM);
        Mode.setModeUI(btnWFileChooser);
        Mode.setModeUI(btnWMessage);
        Mode.setModeUI(btnWConfrim);
        Mode.setModeUI(btnWInput);
    }
}