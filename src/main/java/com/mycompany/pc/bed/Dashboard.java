/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pc.bed;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.pc.views.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;

/**
 *
 * @author DANIEL
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        InitStyles();
        FlatLightLaf.setup();
        SetDate();
        InitContent();
    }
    
    private void InitStyles(){
        mensaje.putClientProperty( "FlatLaf.style", "font: 14 $light.font" );
        mensaje.setForeground(Color.black);
        navText.putClientProperty( "FlatLaf.style", "font: bold $h3.regular.font" );
        navText.setForeground(Color.white);
        dateText.putClientProperty( "FlatLaf.style", "font: 24 $light.font" );
        dateText.setForeground(Color.white);
        appName.putClientProperty( "FlatLaf.style", "font: bold $h1.regular.font" );
        appName.setForeground(Color.white);
    }
    
    private void SetDate(){
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        dateText.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }
    
    private void InitContent(){
        ShowJPanel(new Principal());
    }
    
    private void ShowJPanel(JPanel p){
        p.setSize(750,430);
        p.setLocation(0,0);
        
        content.removeAll();
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        appName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Reportes = new javax.swing.JButton();
        principal = new javax.swing.JButton();
        configuracion = new javax.swing.JButton();
        tecnicos2 = new javax.swing.JButton();
        configuracion1 = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        navText = new javax.swing.JLabel();
        dateText = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 640));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMinimumSize(new java.awt.Dimension(1020, 640));
        background.setPreferredSize(new java.awt.Dimension(1020, 640));

        menu.setBackground(new java.awt.Color(98, 142, 141));
        menu.setPreferredSize(new java.awt.Dimension(270, 640));

        appName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appName.setText("EDALMARC. SAS");

        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Reportes.setBackground(new java.awt.Color(122, 163, 162));
        Reportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Reportes.setForeground(new java.awt.Color(255, 255, 255));
        Reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figuras/reporte.png"))); // NOI18N
        Reportes.setText("Reportes");
        Reportes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        Reportes.setBorderPainted(false);
        Reportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Reportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Reportes.setIconTextGap(14);
        Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportesActionPerformed(evt);
            }
        });

        principal.setBackground(new java.awt.Color(122, 163, 162));
        principal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        principal.setForeground(new java.awt.Color(255, 255, 255));
        principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figuras/casa (1).png"))); // NOI18N
        principal.setText("Principal");
        principal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        principal.setBorderPainted(false);
        principal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        principal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        principal.setIconTextGap(14);
        principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                principalActionPerformed(evt);
            }
        });

        configuracion.setBackground(new java.awt.Color(122, 163, 162));
        configuracion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        configuracion.setForeground(new java.awt.Color(255, 255, 255));
        configuracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figuras/work-from-home.png"))); // NOI18N
        configuracion.setText("Ayuda");
        configuracion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 12, 1, 1, new java.awt.Color(0, 0, 0)));
        configuracion.setBorderPainted(false);
        configuracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        configuracion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        configuracion.setIconTextGap(12);

        tecnicos2.setBackground(new java.awt.Color(122, 163, 162));
        tecnicos2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tecnicos2.setForeground(new java.awt.Color(255, 255, 255));
        tecnicos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figuras/editar.png"))); // NOI18N
        tecnicos2.setText("Tecnicos");
        tecnicos2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 12, 1, 1, new java.awt.Color(0, 0, 0)));
        tecnicos2.setBorderPainted(false);
        tecnicos2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tecnicos2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tecnicos2.setIconTextGap(12);
        tecnicos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecnicos2ActionPerformed(evt);
            }
        });

        configuracion1.setBackground(new java.awt.Color(122, 163, 162));
        configuracion1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        configuracion1.setForeground(new java.awt.Color(255, 255, 255));
        configuracion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figuras/configuracion.png"))); // NOI18N
        configuracion1.setText("Configuración");
        configuracion1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 12, 1, 1, new java.awt.Color(0, 0, 0)));
        configuracion1.setBorderPainted(false);
        configuracion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        configuracion1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        configuracion1.setIconTextGap(12);

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(tecnicos2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(configuracion1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(principal, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(tecnicos2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(Reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(configuracion1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(principal, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        header.setBackground(new java.awt.Color(137, 173, 172));
        header.setPreferredSize(new java.awt.Dimension(744, 150));

        navText.setText("Administracion/control/Bitacoras");

        dateText.setText("Hoy es {dayname} {day} de {month} de {year}");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateText, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        content.setMinimumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        mensaje.setText("Bienvenido de nuevo!");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(mensaje)
                        .addContainerGap(640, Short.MAX_VALUE))
                    .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(mensaje)
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void principalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_principalActionPerformed
        // TODO add your handling code here:
        ShowJPanel(new Principal());
    }//GEN-LAST:event_principalActionPerformed

    private void tecnicos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tecnicos2ActionPerformed
        // TODO add your handling code here:
        ShowJPanel(new Tecnicos());
    }//GEN-LAST:event_tecnicos2ActionPerformed

    private void ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportesActionPerformed
        // TODO add your handling code here:
        ShowJPanel(new Registro());
    }//GEN-LAST:event_ReportesActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reportes;
    private javax.swing.JLabel appName;
    private javax.swing.JPanel background;
    private javax.swing.JButton configuracion;
    private javax.swing.JButton configuracion1;
    private javax.swing.JPanel content;
    private javax.swing.JLabel dateText;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel mensaje;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel navText;
    private javax.swing.JButton principal;
    private javax.swing.JButton tecnicos2;
    // End of variables declaration//GEN-END:variables
}
