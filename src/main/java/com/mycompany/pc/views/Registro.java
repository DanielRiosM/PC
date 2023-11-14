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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
/**
 *
 * @author danie
 */
public class Registro extends javax.swing.JPanel {
 
    String line;
    public static String IDtecnico_update ;
    private final String nombreUsuario = System.getProperty("user.name");
    private final String rutaCarpeta = "C:\\Users\\"+nombreUsuario+"\\edalmarc\\";  // Reemplaza esto con tu ruta personalizada
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
        descargar = new javax.swing.JButton();

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
            tabla.getColumnModel().getColumn(6).setResizable(false);
        }

        descargar.setBackground(new java.awt.Color(255, 255, 255));
        descargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figuras/descarga.png"))); // NOI18N
        descargar.setBorder(null);
        descargar.setBorderPainted(false);
        descargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descargarActionPerformed(evt);
            }
        });

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
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descargar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descargar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
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

    private void descargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descargarActionPerformed
        // TODO add your handling code here:
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String fechaActual = sdf.format(new Date());

            // Configurar el JFileChooser
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setDialogTitle("Seleccione la carpeta de destino");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File carpetaDestino = fileChooser.getSelectedFile();
                String nombreArchivo = "registro_" + fechaActual + ".csv";
                String rutaCompleta = carpetaDestino.getAbsolutePath() + File.separator + nombreArchivo;

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaCompleta))) {
                    int cols = tabla.getColumnCount();

                    // Escribir encabezados
                    for (int i = 0; i < cols; i++) {
                        writer.write(tabla.getColumnName(i));
                        if (i < cols - 1) {
                            writer.write(",");
                        }
                    }
                    writer.newLine();

                    // Escribir datos
                    for (int i = 0; i < tabla.getRowCount(); i++) {
                        for (int j = 0; j < cols; j++) {
                            String cellValue = tabla.getValueAt(i, j).toString().replace('\n', ' ');
                            writer.write(cellValue);
                            if (j < cols - 1) {
                                writer.write(",");
                            }
                        }
                        writer.newLine();
                    }

                    JOptionPane.showMessageDialog(null, "Datos exportados a " + rutaCompleta, "Exportación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al exportar datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener la fecha actual", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_descargarActionPerformed
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton descargar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
