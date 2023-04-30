package com.AnLa.UI.DateChooser;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;

public final class Dates extends javax.swing.JPanel {

    private Event event;
    private final int MONTH;
    private final int YEAR;
    private final int DAY;
    private int m;
    private int y;
    private int selectDay = 0;
    private int startDate;
    private int max_of_month;

    public Dates() {
        initComponents();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String toDay = df.format(date);
        DAY = Integer.valueOf(toDay.split("-")[0]);
        MONTH = Integer.valueOf(toDay.split("-")[1]);
        YEAR = Integer.valueOf(toDay.split("-")[2]);
    }

    public void showDate(int month, int year, SelectedDate select) {
        m = month;
        y = year;
        // selectDay = 0;
        Calendar cd = Calendar.getInstance();
        cd.set(year, month - 1, 1);
        int start = cd.get(Calendar.DAY_OF_WEEK);
        max_of_month = cd.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (start == 1) {
            start += 7;
        }
        clear();
        start += 5;
        startDate = start;
        for (int i = 1; i <= max_of_month; i++) {
            Button cmd = (Button) getComponent(start);
            cmd.setColorSelected(getForeground());
            cmd.setText(i + "");
            if (i == DAY && month == MONTH && year == YEAR) {
                cmd.setBackground(new Color(224, 214, 229));
            } else {
                cmd.setBackground(Color.WHITE);
            }
            if (i == select.getDay() && month == select.getMonth() && year == select.getYear()) {
                cmd.setBackground(getForeground());
                cmd.setForeground(new Color(255, 255, 255));
            }
            start++;
        }
    }

    private void clear() {
        for (int i = 7; i < getComponentCount(); i++) {
            ((JButton) getComponent(i)).setText("");
        }
    }

    public void clearSelected() {
        for (int i = 7; i < getComponentCount(); i++) {
            JButton cmd = (JButton) getComponent(i);
            if (MONTH == m && y == YEAR && !cmd.getText().equals("") && Integer.valueOf(cmd.getText()) == DAY) {
                cmd.setBackground(new Color(224, 214, 229));
                cmd.setForeground(new java.awt.Color(75, 75, 75));
            } else {
                cmd.setBackground(Color.WHITE);
                cmd.setForeground(new java.awt.Color(75, 75, 75));
            }
        }
        selectDay = 0;
    }

    private void addEvent() {
        for (int i = 7; i < getComponentCount(); i++) {
            ((Button) getComponent(i)).setEvent(event);
        }
    }

    public void setSelected(int index) {
        selectDay = index;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMo = new Button();
        cmdTu = new Button();
        cmdWe = new Button();
        cmdTh = new Button();
        cmdFr = new Button();
        cmdSa = new Button();
        cmdSu = new Button();
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
        cmd13 = new Button();
        cmd14 = new Button();
        cmd15 = new Button();
        cmd16 = new Button();
        cmd17 = new Button();
        cmd18 = new Button();
        cmd19 = new Button();
        cmd20 = new Button();
        cmd21 = new Button();
        cmd22 = new Button();
        cmd23 = new Button();
        cmd24 = new Button();
        cmd25 = new Button();
        cmd26 = new Button();
        cmd27 = new Button();
        cmd28 = new Button();
        cmd29 = new Button();
        cmd30 = new Button();
        cmd31 = new Button();
        cmd32 = new Button();
        cmd33 = new Button();
        cmd34 = new Button();
        cmd35 = new Button();
        cmd36 = new Button();
        cmd37 = new Button();
        cmd38 = new Button();
        cmd39 = new Button();
        cmd40 = new Button();
        cmd41 = new Button();
        cmd42 = new Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(7, 7));

        cmdMo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        cmdMo.setForeground(new java.awt.Color(118, 118, 118));
        cmdMo.setText("Mo");
        cmdMo.setFont(DateFont);
        cmdMo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(cmdMo);

        cmdTu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        cmdTu.setForeground(new java.awt.Color(118, 118, 118));
        cmdTu.setText("Tu");
        cmdTu.setFont(DateFont);
        cmdTu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(cmdTu);

        cmdWe.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        cmdWe.setForeground(new java.awt.Color(118, 118, 118));
        cmdWe.setText("We");
        cmdWe.setFont(DateFont);
        cmdWe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(cmdWe);

        cmdTh.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        cmdTh.setForeground(new java.awt.Color(118, 118, 118));
        cmdTh.setText("Th");
        cmdTh.setFont(DateFont);
        cmdTh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(cmdTh);

        cmdFr.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        cmdFr.setForeground(new java.awt.Color(118, 118, 118));
        cmdFr.setText("Fr");
        cmdFr.setFont(DateFont);
        cmdFr.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(cmdFr);

        cmdSa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        cmdSa.setForeground(new java.awt.Color(118, 118, 118));
        cmdSa.setText("Sa");
        cmdSa.setFont(DateFont);
        cmdSa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(cmdSa);

        cmdSu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        cmdSu.setForeground(new java.awt.Color(255, 1, 1));
        cmdSu.setText("Su");
        cmdSu.setFont(DateFont);
        cmdSu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(cmdSu);

        cmd1.setForeground(new java.awt.Color(75, 75, 75));
        cmd1.setFont(DateFont);
        cmd1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd1.setName("day"); // NOI18N
        add(cmd1);

        cmd2.setForeground(new java.awt.Color(75, 75, 75));
        cmd2.setFont(DateFont);
        cmd2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd2.setName("day"); // NOI18N
        add(cmd2);

        cmd3.setForeground(new java.awt.Color(75, 75, 75));
        cmd3.setText("1");
        cmd3.setFont(DateFont);
        cmd3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd3.setName("day"); // NOI18N
        add(cmd3);

        cmd4.setForeground(new java.awt.Color(75, 75, 75));
        cmd4.setText("2");
        cmd4.setFont(DateFont);
        cmd4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd4.setName("day"); // NOI18N
        add(cmd4);

        cmd5.setForeground(new java.awt.Color(75, 75, 75));
        cmd5.setText("3");
        cmd5.setFont(DateFont);
        cmd5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd5.setName("day"); // NOI18N
        add(cmd5);

        cmd6.setForeground(new java.awt.Color(75, 75, 75));
        cmd6.setText("4");
        cmd6.setFont(DateFont);
        cmd6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd6.setName("day"); // NOI18N
        add(cmd6);

        cmd7.setForeground(new java.awt.Color(75, 75, 75));
        cmd7.setText("5");
        cmd7.setFont(DateFont);
        cmd7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd7.setName("day"); // NOI18N
        add(cmd7);

        cmd8.setForeground(new java.awt.Color(75, 75, 75));
        cmd8.setText("6");
        cmd8.setFont(DateFont);
        cmd8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd8.setName("day"); // NOI18N
        add(cmd8);

        cmd9.setForeground(new java.awt.Color(75, 75, 75));
        cmd9.setText("7");
        cmd9.setFont(DateFont);
        cmd9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd9.setName("day"); // NOI18N
        add(cmd9);

        cmd10.setForeground(new java.awt.Color(75, 75, 75));
        cmd10.setText("8");
        cmd10.setFont(DateFont);
        cmd10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd10.setName("day"); // NOI18N
        add(cmd10);

        cmd11.setForeground(new java.awt.Color(75, 75, 75));
        cmd11.setText("9");
        cmd11.setFont(DateFont);
        cmd11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd11.setName("day"); // NOI18N
        add(cmd11);

        cmd12.setForeground(new java.awt.Color(75, 75, 75));
        cmd12.setText("10");
        cmd12.setFont(DateFont);
        cmd12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd12.setName("day"); // NOI18N
        add(cmd12);

        cmd13.setForeground(new java.awt.Color(75, 75, 75));
        cmd13.setText("11");
        cmd13.setFont(DateFont);
        cmd13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd13.setName("day"); // NOI18N
        add(cmd13);

        cmd14.setForeground(new java.awt.Color(75, 75, 75));
        cmd14.setText("12");
        cmd14.setFont(DateFont);
        cmd14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd14.setName("day"); // NOI18N
        add(cmd14);

        cmd15.setForeground(new java.awt.Color(75, 75, 75));
        cmd15.setText("13");
        cmd15.setFont(DateFont);
        cmd15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd15.setName("day"); // NOI18N
        add(cmd15);

        cmd16.setForeground(new java.awt.Color(75, 75, 75));
        cmd16.setText("14");
        cmd16.setFont(DateFont);
        cmd16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd16.setName("day"); // NOI18N
        add(cmd16);

        cmd17.setForeground(new java.awt.Color(75, 75, 75));
        cmd17.setText("15");
        cmd17.setFont(DateFont);
        cmd17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd17.setName("day"); // NOI18N
        add(cmd17);

        cmd18.setForeground(new java.awt.Color(75, 75, 75));
        cmd18.setText("16");
        cmd18.setFont(DateFont);
        cmd18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd18.setName("day"); // NOI18N
        add(cmd18);

        cmd19.setForeground(new java.awt.Color(75, 75, 75));
        cmd19.setText("17");
        cmd19.setFont(DateFont);
        cmd19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd19.setName("day"); // NOI18N
        add(cmd19);

        cmd20.setForeground(new java.awt.Color(75, 75, 75));
        cmd20.setText("18");
        cmd20.setFont(DateFont);
        cmd20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd20.setName("day"); // NOI18N
        add(cmd20);

        cmd21.setForeground(new java.awt.Color(75, 75, 75));
        cmd21.setText("19");
        cmd21.setFont(DateFont);
        cmd21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd21.setName("day"); // NOI18N
        add(cmd21);

        cmd22.setForeground(new java.awt.Color(75, 75, 75));
        cmd22.setText("20");
        cmd22.setFont(DateFont);
        cmd22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd22.setName("day"); // NOI18N
        add(cmd22);

        cmd23.setForeground(new java.awt.Color(75, 75, 75));
        cmd23.setText("21");
        cmd23.setFont(DateFont);
        cmd23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd23.setName("day"); // NOI18N
        add(cmd23);

        cmd24.setForeground(new java.awt.Color(75, 75, 75));
        cmd24.setText("22");
        cmd24.setFont(DateFont);
        cmd24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd24.setName("day"); // NOI18N
        add(cmd24);

        cmd25.setForeground(new java.awt.Color(75, 75, 75));
        cmd25.setText("23");
        cmd25.setFont(DateFont);
        cmd25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd25.setName("day"); // NOI18N
        add(cmd25);

        cmd26.setForeground(new java.awt.Color(75, 75, 75));
        cmd26.setText("24");
        cmd26.setFont(DateFont);
        cmd26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd26.setName("day"); // NOI18N
        add(cmd26);

        cmd27.setForeground(new java.awt.Color(75, 75, 75));
        cmd27.setText("25");
        cmd27.setFont(DateFont);
        cmd27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd27.setName("day"); // NOI18N
        add(cmd27);

        cmd28.setForeground(new java.awt.Color(75, 75, 75));
        cmd28.setText("26");
        cmd28.setFont(DateFont);
        cmd28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd28.setName("day"); // NOI18N
        add(cmd28);

        cmd29.setForeground(new java.awt.Color(75, 75, 75));
        cmd29.setText("27");
        cmd29.setFont(DateFont);
        cmd29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd29.setName("day"); // NOI18N
        add(cmd29);

        cmd30.setForeground(new java.awt.Color(75, 75, 75));
        cmd30.setText("28");
        cmd30.setFont(DateFont);
        cmd30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd30.setName("day"); // NOI18N
        add(cmd30);

        cmd31.setForeground(new java.awt.Color(75, 75, 75));
        cmd31.setText("29");
        cmd31.setFont(DateFont);
        cmd31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd31.setName("day"); // NOI18N
        add(cmd31);

        cmd32.setForeground(new java.awt.Color(75, 75, 75));
        cmd32.setText("30");
        cmd32.setFont(DateFont);
        cmd32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd32.setName("day"); // NOI18N
        add(cmd32);

        cmd33.setForeground(new java.awt.Color(75, 75, 75));
        cmd33.setText("31");
        cmd33.setFont(DateFont);
        cmd33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd33.setName("day"); // NOI18N
        add(cmd33);

        cmd34.setForeground(new java.awt.Color(75, 75, 75));
        cmd34.setFont(DateFont);
        cmd34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd34.setName("day"); // NOI18N
        add(cmd34);

        cmd35.setForeground(new java.awt.Color(75, 75, 75));
        cmd35.setFont(DateFont);
        cmd35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd35.setName("day"); // NOI18N
        add(cmd35);

        cmd36.setForeground(new java.awt.Color(75, 75, 75));
        cmd36.setFont(DateFont);
        cmd36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd36.setName("day"); // NOI18N
        add(cmd36);

        cmd37.setForeground(new java.awt.Color(75, 75, 75));
        cmd37.setFont(DateFont);
        cmd37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd37.setName("day"); // NOI18N
        add(cmd37);

        cmd38.setForeground(new java.awt.Color(75, 75, 75));
        cmd38.setFont(DateFont);
        cmd38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd38.setName("day"); // NOI18N
        add(cmd38);

        cmd39.setForeground(new java.awt.Color(75, 75, 75));
        cmd39.setFont(DateFont);
        cmd39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd39.setName("day"); // NOI18N
        add(cmd39);

        cmd40.setForeground(new java.awt.Color(75, 75, 75));
        cmd40.setFont(DateFont);
        cmd40.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd40.setName("day"); // NOI18N
        add(cmd40);

        cmd41.setForeground(new java.awt.Color(75, 75, 75));
        cmd41.setFont(DateFont);
        cmd41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd41.setName("day"); // NOI18N
        add(cmd41);

        cmd42.setForeground(new java.awt.Color(75, 75, 75));
        cmd42.setFont(DateFont);
        cmd42.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd42.setName("day"); // NOI18N
        add(cmd42);
    }// </editor-fold>//GEN-END:initComponents

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        addEvent();
    }
    
    private final java.awt.Font DateFont =  new java.awt.Font("Segoe UI", 0, 24);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.AnLa.UI.DateChooser.Button cmd1;
    private com.AnLa.UI.DateChooser.Button cmd10;
    private com.AnLa.UI.DateChooser.Button cmd11;
    private com.AnLa.UI.DateChooser.Button cmd12;
    private com.AnLa.UI.DateChooser.Button cmd13;
    private com.AnLa.UI.DateChooser.Button cmd14;
    private com.AnLa.UI.DateChooser.Button cmd15;
    private com.AnLa.UI.DateChooser.Button cmd16;
    private com.AnLa.UI.DateChooser.Button cmd17;
    private com.AnLa.UI.DateChooser.Button cmd18;
    private com.AnLa.UI.DateChooser.Button cmd19;
    private com.AnLa.UI.DateChooser.Button cmd2;
    private com.AnLa.UI.DateChooser.Button cmd20;
    private com.AnLa.UI.DateChooser.Button cmd21;
    private com.AnLa.UI.DateChooser.Button cmd22;
    private com.AnLa.UI.DateChooser.Button cmd23;
    private com.AnLa.UI.DateChooser.Button cmd24;
    private com.AnLa.UI.DateChooser.Button cmd25;
    private com.AnLa.UI.DateChooser.Button cmd26;
    private com.AnLa.UI.DateChooser.Button cmd27;
    private com.AnLa.UI.DateChooser.Button cmd28;
    private com.AnLa.UI.DateChooser.Button cmd29;
    private com.AnLa.UI.DateChooser.Button cmd3;
    private com.AnLa.UI.DateChooser.Button cmd30;
    private com.AnLa.UI.DateChooser.Button cmd31;
    private com.AnLa.UI.DateChooser.Button cmd32;
    private com.AnLa.UI.DateChooser.Button cmd33;
    private com.AnLa.UI.DateChooser.Button cmd34;
    private com.AnLa.UI.DateChooser.Button cmd35;
    private com.AnLa.UI.DateChooser.Button cmd36;
    private com.AnLa.UI.DateChooser.Button cmd37;
    private com.AnLa.UI.DateChooser.Button cmd38;
    private com.AnLa.UI.DateChooser.Button cmd39;
    private com.AnLa.UI.DateChooser.Button cmd4;
    private com.AnLa.UI.DateChooser.Button cmd40;
    private com.AnLa.UI.DateChooser.Button cmd41;
    private com.AnLa.UI.DateChooser.Button cmd42;
    private com.AnLa.UI.DateChooser.Button cmd5;
    private com.AnLa.UI.DateChooser.Button cmd6;
    private com.AnLa.UI.DateChooser.Button cmd7;
    private com.AnLa.UI.DateChooser.Button cmd8;
    private com.AnLa.UI.DateChooser.Button cmd9;
    private com.AnLa.UI.DateChooser.Button cmdFr;
    private com.AnLa.UI.DateChooser.Button cmdMo;
    private com.AnLa.UI.DateChooser.Button cmdSa;
    private com.AnLa.UI.DateChooser.Button cmdSu;
    private com.AnLa.UI.DateChooser.Button cmdTh;
    private com.AnLa.UI.DateChooser.Button cmdTu;
    private com.AnLa.UI.DateChooser.Button cmdWe;
    // End of variables declaration//GEN-END:variables

    public void next() {
        if (selectDay == max_of_month) {
            selectDay = 0;
        }
        JButton cmd = (JButton) getComponent(startDate - 1 + selectDay + 1);
        String n = cmd.getText();
        if (!n.equals("") && Integer.valueOf(n) <= max_of_month) {
            selectDay++;
            event.execute(null, selectDay);
            cmd.setBackground(new Color(206, 110, 245));
        }
    }

    public void back() {
        if (selectDay <= 1) {
            selectDay = max_of_month + 1;
        }
        JButton cmd = (JButton) getComponent(startDate - 1 + selectDay - 1);
        String n = cmd.getText();
        if (!n.equals("") && cmd.getName() != null) {
            selectDay--;
            event.execute(null, selectDay);
            cmd.setBackground(new Color(206, 110, 245));
        }
    }

    public void up() {
        JButton cmd = (JButton) getComponent(startDate - 1 + selectDay - 7);
        String n = cmd.getText();
        if (!n.equals("") && cmd.getName() != null) {
            selectDay -= 7;
            event.execute(null, selectDay);
            cmd.setBackground(new Color(206, 110, 245));
        }
    }

    public void down() {
        if (getComponents().length > startDate - 1 + selectDay + 7) {
            JButton cmd = (JButton) getComponent(startDate - 1 + selectDay + 7);
            String n = cmd.getText();
            if (!n.equals("") && cmd.getName() != null) {
                selectDay += 7;
                event.execute(null, selectDay);
                cmd.setBackground(new Color(206, 110, 245));
            }
        }
    }

}
