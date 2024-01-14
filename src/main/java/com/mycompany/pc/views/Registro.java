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
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.TableRowSorter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDFont;
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
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tabla.setRowSorter(sorter);
        try {
            URL url = new URL("https://bic-edalmarc-back-end.cyclic.app/inform/read");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
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
        clientes = new javax.swing.JButton();

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
            tabla.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(25);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(25);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(20);
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

        clientes.setBackground(new java.awt.Color(255, 255, 255));
        clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figuras/cliente.png"))); // NOI18N
        clientes.setBorder(null);
        clientes.setBorderPainted(false);
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
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
                .addGap(18, 18, 18)
                .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descargar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
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

            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setDialogTitle("Seleccione la carpeta de destino");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File carpetaDestino = fileChooser.getSelectedFile();
                String nombreArchivo = "registro_" + fechaActual + ".pdf";
                String rutaCompleta = carpetaDestino.getAbsolutePath() + File.separator + nombreArchivo;

                // Crear un nuevo documento PDF
                PDDocument document = new PDDocument();
                PDPage page = new PDPage();
                document.addPage(page);

                PDPageContentStream contentStream = null; // Inicializar contentStream fuera del try para cerrarlo en finally

                try {
                    contentStream = new PDPageContentStream(document, page);
                    float margin = 50;
                    float yStart = page.getMediaBox().getHeight() - margin;
                    float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
                    float yPosition = yStart;
                    float tableHeight = 20f; // Ajusta según sea necesario
                    float marginX = 50f;

                    float nexty = yStart;

                    for (int i = 0; i < tabla.getRowCount(); i++) {

                        if (nexty - 15 < margin) {
                            // Agregar una nueva página
                            contentStream.close();
                            page = new PDPage();
                            document.addPage(page);
                            contentStream = new PDPageContentStream(document, page);
                            contentStream.setFont(PDType1Font.HELVETICA, 12);
                            nexty = page.getMediaBox().getHeight() - margin;
                        }

                        nexty -= 20;
                        contentStream.moveTo(marginX, nexty);
                        contentStream.lineTo(marginX + tableWidth, nexty);
                        contentStream.stroke();

                        contentStream.setFont(PDType1Font.HELVETICA, 12);
                        contentStream.beginText();
                        contentStream.newLineAtOffset(marginX, nexty - 15);

                        String materiales = tabla.getValueAt(i, 4).toString();
                        String[] lines = materiales.split("\\r?\\n");

                        // Imprimir cada línea de materiales
                        for (String line : lines) {
                            float lineWidth = PDType1Font.HELVETICA.getStringWidth(line) / 1000 * 12;

                            if (nexty - 15 < margin) {
                                // Agregar una nueva página
                                contentStream.endText();
                                contentStream.close();
                                page = new PDPage();
                                document.addPage(page);
                                contentStream = new PDPageContentStream(document, page);
                                contentStream.setFont(PDType1Font.HELVETICA, 12);
                                nexty = page.getMediaBox().getHeight() - margin;
                                contentStream.beginText();
                                contentStream.newLineAtOffset(marginX, nexty - 15);
                            }

                            List<String> sublines = splitText(line, PDType1Font.HELVETICA, 12, tableWidth);

                            for (String subline : sublines) {
                                contentStream.showText("Materiales: " + subline);
                                contentStream.newLineAtOffset(0, -15);
                                nexty -= 15;

                                // Verificar si hay suficiente espacio en la página actual
                                if (nexty - 15 < margin) {
                                    // Agregar una nueva página
                                    contentStream.endText();
                                    contentStream.close();
                                    page = new PDPage();
                                    document.addPage(page);
                                    contentStream = new PDPageContentStream(document, page);
                                    contentStream.setFont(PDType1Font.HELVETICA, 12);
                                    nexty = page.getMediaBox().getHeight() - margin;
                                    contentStream.beginText();
                                    contentStream.newLineAtOffset(marginX, nexty - 15);
                                }
                            }
                        }

                        String monto = "$" + tabla.getValueAt(i, 5).toString().replace('\n', ' ');
                        String responsable = tabla.getValueAt(i, 6).toString().replace('\n', ' ');

                        contentStream.showText("Monto: " + monto);
                        contentStream.newLineAtOffset(tableWidth / 2, 0);
                        contentStream.showText("responsable: " + responsable);

                        contentStream.endText();

                        nexty -= 15;
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al exportar datos a PDF", "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    // Asegúrate de cerrar el PDPageContentStream en el bloque finally
                    if (contentStream != null) {
                        try {
                            contentStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        document.save(rutaCompleta);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al guardar el documento PDF", "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        try {
                            document.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al cerrar el documento PDF", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Datos exportados a " + rutaCompleta, "Exportación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_descargarActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        // TODO add your handling code here:
        clientes infoPanel = new clientes();

        // Crear un JFrame para mostrar el JPanel
        JFrame frame = new JFrame("clientes");

        // Establecer el administrador de diseño BorderLayout para el JFrame
        frame.setLayout(new BorderLayout());

        // Agregar el JPanel al JFrame en la región izquierda (WEST)
        frame.add(infoPanel, BorderLayout.WEST);

        // Establecer el tamaño y otras propiedades del JFrame
        frame.setSize(620, 550);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        
    }//GEN-LAST:event_clientesActionPerformed

    private List<String> splitText(String text, PDFont font, float fontSize, float maxWidth) throws IOException {
        List<String> lines = new ArrayList<>();
        int lastSpace = -1;
        float width = 0;

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            width += font.getStringWidth(String.valueOf(character)) / 1000 * fontSize;

            if (character == ' ') {
                lastSpace = i;
            }

            if (width > maxWidth) {
                if (lastSpace >= 0) {
                    lines.add(text.substring(0, lastSpace));
                    text = text.substring(lastSpace + 1);
                    i = 0;
                    lastSpace = -1;
                    width = 0;
                } else {
                    lines.add(text.substring(0, i));
                    text = text.substring(i);
                    i = 0;
                    width = 0;
                }
            }
        }

        lines.add(text);
        return lines;
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton clientes;
    private javax.swing.JButton descargar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
