package com.AnLa.Example;
// Make By Bình An || AnLaVN || KatoVN

import com.AnLa.NET.Network;
import java.io.IOException;
import java.util.HashMap;

public class ExampleNetwork extends javax.swing.JFrame {

    public ExampleNetwork() {
        initComponents();
        
        
        //Try catch IP, if can't get IP, then set visible false
        new Thread(){@Override public void run() {
            while(true){
                try {
                    String ip = Network.myIPv4();
                    lblIP.setText(ip);
                } catch (IOException ex) {lblIP.setText("Obtaining IP...");}
            }
        }}.start();
        
        
        
        new Thread(){@Override public void run() {
            while(true){
                //Create myWLAN, myIP variable
                HashMap<String, String> myWLAN = Network.myWLAN();
                
                //If else State, if State is connected then get other information
                String State = myWLAN.get("State");
                lblState.setText("State: " + State);
                if(State.equals("connected")){
                    pan.setVisible(true);
                    
                    
                    lblSSID.setText("SSID: " + myWLAN.get("SSID"));
                    lblRR.setText("Receive rate (Mbps): " + myWLAN.get("Receive rate (Mbps)"));
                    lblTR.setText("Transmit rate (Mbps): " + myWLAN.get("Transmit rate (Mbps)"));
                    pgbSignal.setValue(Integer.parseInt(myWLAN.get("Signal").replaceAll("%", "")));
                }else{ pan.setVisible(false);}
            }
        }}.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblState = new javax.swing.JLabel();
        pan = new javax.swing.JPanel();
        lblSSID = new javax.swing.JLabel();
        lblRR = new javax.swing.JLabel();
        lblTR = new javax.swing.JLabel();
        pgbSignal = new javax.swing.JProgressBar();
        lblSignal = new javax.swing.JLabel();
        lblIP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ExampleNetwork");

        lblState.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblState.setText("State:");

        lblSSID.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblSSID.setText("SSID: ");

        lblRR.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblRR.setText("Receive rate (Mbps):");

        lblTR.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTR.setText("Transmit rate (Mbps):");

        pgbSignal.setStringPainted(true);

        lblSignal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblSignal.setText("Signal:");

        javax.swing.GroupLayout panLayout = new javax.swing.GroupLayout(pan);
        pan.setLayout(panLayout);
        panLayout.setHorizontalGroup(
            panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pgbSignal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSSID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTR, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addComponent(lblSignal, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panLayout.setVerticalGroup(
            panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblSSID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRR)
                .addGap(11, 11, 11)
                .addComponent(lblTR, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSignal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pgbSignal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblIP.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblIP.setText("Obtaining IP...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIP, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblState)
                    .addComponent(lblIP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExampleNetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }java.awt.EventQueue.invokeLater(() -> {
            new ExampleNetwork().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblRR;
    private javax.swing.JLabel lblSSID;
    private javax.swing.JLabel lblSignal;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTR;
    private javax.swing.JPanel pan;
    private javax.swing.JProgressBar pgbSignal;
    // End of variables declaration//GEN-END:variables
}