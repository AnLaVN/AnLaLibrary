package com.AnLa.UI.DateChooser;

public final class Months extends javax.swing.JPanel {

    private Event event;
    private int m;
    private final String LNG[] = {"Tháng Giêng", "Tháng Hai", "Tháng Ba", "Tháng Tư", "Tháng Năm", "Tháng Sáu", "Tháng Bảy", "Tháng Tám", "Tháng Chín", "Tháng Mười", "Tháng Mười Một", "Tháng Mười Hai"};

    public Months() {
        initComponents();
        for(int i = 0 ; i <12 ; i++){
            if(this.getComponent(i) instanceof Button btn){
                btn.setText("");
           }
        }
    }

    private void addEvent() {
        for (int i = 0; i < getComponentCount(); i++) {
            ((Button) getComponent(i)).setText(LNG[i]);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmd1 = new Button();
        cmd2 = new Button();
        cmd3 = new Button();
        cmd4 = new Button();
        cmd5 = new Button();
        cmd6 = new Button();
        cmd7 = new Button();
        cmd8 = new Button();
        cmd9 = new Button();
        cmd10 = new Button();
        cmd11 = new Button();
        cmd12 = new Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(4, 4));

        cmd1.setForeground(new java.awt.Color(75, 75, 75));
        cmd1.setText("January");
        cmd1.setFont(DateFont);
        cmd1.setName("1"); // NOI18N
        cmd1.setOpaque(true);
        add(cmd1);

        cmd2.setForeground(new java.awt.Color(75, 75, 75));
        cmd2.setText("February");
        cmd2.setFont(DateFont);
        cmd2.setName("2"); // NOI18N
        cmd2.setOpaque(true);
        add(cmd2);

        cmd3.setForeground(new java.awt.Color(75, 75, 75));
        cmd3.setText("March");
        cmd3.setFont(DateFont);
        cmd3.setName("3"); // NOI18N
        cmd3.setOpaque(true);
        add(cmd3);

        cmd4.setForeground(new java.awt.Color(75, 75, 75));
        cmd4.setText("April");
        cmd4.setFont(DateFont);
        cmd4.setName("4"); // NOI18N
        cmd4.setOpaque(true);
        add(cmd4);

        cmd5.setForeground(new java.awt.Color(75, 75, 75));
        cmd5.setText("May");
        cmd5.setFont(DateFont);
        cmd5.setName("5"); // NOI18N
        cmd5.setOpaque(true);
        add(cmd5);

        cmd6.setForeground(new java.awt.Color(75, 75, 75));
        cmd6.setText("June");
        cmd6.setFont(DateFont);
        cmd6.setName("6"); // NOI18N
        cmd6.setOpaque(true);
        add(cmd6);

        cmd7.setForeground(new java.awt.Color(75, 75, 75));
        cmd7.setText("July");
        cmd7.setFont(DateFont);
        cmd7.setName("7"); // NOI18N
        cmd7.setOpaque(true);
        add(cmd7);

        cmd8.setForeground(new java.awt.Color(75, 75, 75));
        cmd8.setText("August");
        cmd8.setFont(DateFont);
        cmd8.setName("8"); // NOI18N
        cmd8.setOpaque(true);
        add(cmd8);

        cmd9.setForeground(new java.awt.Color(75, 75, 75));
        cmd9.setText("September");
        cmd9.setFont(DateFont);
        cmd9.setName("9"); // NOI18N
        cmd9.setOpaque(true);
        add(cmd9);

        cmd10.setForeground(new java.awt.Color(75, 75, 75));
        cmd10.setText("October");
        cmd10.setFont(DateFont);
        cmd10.setName("10"); // NOI18N
        cmd10.setOpaque(true);
        add(cmd10);

        cmd11.setForeground(new java.awt.Color(75, 75, 75));
        cmd11.setText("November");
        cmd11.setFont(DateFont);
        cmd11.setName("11"); // NOI18N
        cmd11.setOpaque(true);
        add(cmd11);

        cmd12.setForeground(new java.awt.Color(75, 75, 75));
        cmd12.setText("December");
        cmd12.setFont(DateFont);
        cmd12.setName("12"); // NOI18N
        cmd12.setOpaque(true);
        add(cmd12);
    }// </editor-fold>//GEN-END:initComponents

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        addEvent();
    }
    
    private final java.awt.Font DateFont =  new java.awt.Font("Segoe UI", 0, 20);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.AnLa.UI.DateChooser.Button cmd1;
    private com.AnLa.UI.DateChooser.Button cmd10;
    private com.AnLa.UI.DateChooser.Button cmd11;
    private com.AnLa.UI.DateChooser.Button cmd12;
    private com.AnLa.UI.DateChooser.Button cmd2;
    private com.AnLa.UI.DateChooser.Button cmd3;
    private com.AnLa.UI.DateChooser.Button cmd4;
    private com.AnLa.UI.DateChooser.Button cmd5;
    private com.AnLa.UI.DateChooser.Button cmd6;
    private com.AnLa.UI.DateChooser.Button cmd7;
    private com.AnLa.UI.DateChooser.Button cmd8;
    private com.AnLa.UI.DateChooser.Button cmd9;
    // End of variables declaration//GEN-END:variables

}
