package OpenAI;
// Make By Bình An || AnLaVN || KatoVN

import com.anlavn.openai.ChatGPT;
import com.anlavn.ui.ScrollBar;

public class ExampleChatGPT2 extends javax.swing.JFrame {

    public ExampleChatGPT2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtque = new javax.swing.JTextField();
        scr = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        slider = new javax.swing.JSlider();
        token = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OpenAI ChatGPT");

        txtque.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqueActionPerformed(evt);
            }
        });

        scr.setVerticalScrollBar(new ScrollBar());

        txt.setEditable(false);
        txt.setColumns(20);
        txt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt.setLineWrap(true);
        txt.setRows(5);
        txt.setWrapStyleWord(true);
        scr.setViewportView(txt);

        slider.setMaximum(4000);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        token.setText("50");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addComponent(txtque, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(token, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scr, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(token))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtque, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqueActionPerformed
        chatThread.start();
    }//GEN-LAST:event_txtqueActionPerformed

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        token.setText(String.valueOf(slider.getValue()));
    }//GEN-LAST:event_sliderStateChanged

    public static void main(String args[]) {
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExampleChatGPT2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExampleChatGPT2().setVisible(true);
            }
        });
    }
    
    ChatGPT chatgpt = new ChatGPT("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");
    Thread chatThread = new Thread() {
        @Override public void run() {
            String question = txtque.getText().trim();
            txtque.setText("");
            txt.setText("...Loading...");
            txt.setText(chatgpt.Chat(question, ChatGPT.Model.Davinci, slider.getValue()));
        }
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scr;
    private javax.swing.JSlider slider;
    private javax.swing.JLabel token;
    private javax.swing.JTextArea txt;
    private javax.swing.JTextField txtque;
    // End of variables declaration//GEN-END:variables
}