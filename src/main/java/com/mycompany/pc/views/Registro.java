/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pc.views;

import com.mycompany.pc.views.informacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringJoiner;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.JPanel;
/**
 *
 * @author danie
 */
public class Registro extends javax.swing.JPanel {
 
    String line;
    public static String IDtecnico_update ;
    public Registro() {
        
        initComponents();
        InitStyles();
        tabla();
        
    }
   
    private void InitStyles(){
        title.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font");
        title.setForeground(Color.black);
    }
    
    public void tabla() {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        try {
            URL url = new URL("https://bic-edalmarc-back-end.cyclic.app/inform/read");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            conn.disconnect();

            // Analizar la respuesta JSON como un objeto JSON
            JSONObject jsonResponse = new JSONObject(response.toString());

            // Obtener el arreglo JSON dentro del objeto JSON
            JSONArray jsonArray = jsonResponse.getJSONArray("data");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String column1Value = jsonObject.getString("_id");
                String column2Value = jsonObject.getString("fechaInicio");
                String column3Value = jsonObject.getString("fechaFinal");
                JSONArray column4Array = jsonObject.getJSONArray("descripcion");
                StringJoiner materialsJoinerr = new StringJoiner(", "); // Utilizamos StringJoiner para concatenar los elementos del array
                for (int j = 0; j < column4Array.length(); j++) {
                    String material = column4Array.getString(j);
                    materialsJoinerr.add(material);
                }
                String column4Value = materialsJoinerr.toString();
                JSONArray column5Array = jsonObject.getJSONArray("materiales");
                StringJoiner materialsJoiner = new StringJoiner(", "); // Utilizamos StringJoiner para concatenar los elementos del array
                for (int j = 0; j < column5Array.length(); j++) {
                    String material = column5Array.getString(j);
                    materialsJoiner.add(material);
                }
                String column5Value = materialsJoiner.toString();
                int column6Value = jsonObject.getInt("monto");
                String column7Value = jsonObject.getString("responsable");

                // Agregar una nueva fila a la tabla
                model.addRow(new Object[]{column1Value, column2Value, column3Value, column4Value,column5Value, column6Value, column7Value});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDtecnico_update = (String) model.getValueAt(fila_point, columna_point);
                    informacion infoPanel = new informacion();

                    // Crear un JFrame para mostrar el JPanel
                    JFrame frame = new JFrame("Información");

                    // Establecer el administrador de diseño BorderLayout para el JFrame
                    frame.setLayout(new BorderLayout());

                    // Agregar el JPanel al JFrame en la región izquierda (WEST)
                    frame.add(infoPanel, BorderLayout.WEST);

                    // Establecer el tamaño y otras propiedades del JFrame
                    frame.setSize(1020, 720);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setVisible(true);
                }

            }

        });

    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(750, 430));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(0, 0));
        bg.setPreferredSize(new java.awt.Dimension(750, 430));

        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Registrar un Tecnico o un Administrador");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha Inicio", "Fecha Final", "Descripcion", "Materiales", "Monto", "Responsable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(4).setResizable(false);
            tabla.getColumnModel().getColumn(5).setResizable(false);
            tabla.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addGap(227, 227, 227))
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addGap(80, 80, 80))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
