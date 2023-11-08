/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pc.views;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.awt.Image;
import org.bson.Document;
import org.bson.types.ObjectId;


/**
 *
 * @author danie
 */
public class informacion extends javax.swing.JPanel {

     String IDtecnico_update;

    public informacion() {
        initComponents();
        IDtecnico_update = Registro.IDtecnico_update;
        InitStyles();

        // Llamar a un método para cargar y mostrar la imagen
        showImage();
        showFirma();
    }

    private void InitStyles() {
        // Configura estilos de tu JPanel si es necesario
    }

    // Método para cargar y mostrar la imagen desde MongoDB
    private void showImage() {
        try (MongoClient client = MongoClients.create("mongodb+srv://Edalmarc:udrNYnjBDhQvub8x@bic-edalmarc.svgqcpw.mongodb.net/Edalmarc?retryWrites=true&w=majority")) {
            MongoDatabase database = client.getDatabase("Edalmarc");
            MongoCollection<Document> collection = database.getCollection("images");

            // Reemplaza "id_mason_value" con el valor real por el que deseas buscar
            ObjectId idMasonValue = new ObjectId(IDtecnico_update);
            System.out.println(idMasonValue);
            
            Document imageDocument = collection.find(Filters.eq("id_mason", idMasonValue)).first();

            if (imageDocument != null) {
                Document imageObject = imageDocument.get("image", Document.class);
                if (imageObject != null) {
                    org.bson.types.Binary imageData = imageObject.get("data", org.bson.types.Binary.class);
                    System.out.println(imageData);
                    if (imageData != null) {
                        byte[] imageDataBytes = imageData.getData();

                        // Cargar la imagen
                    ImageIcon originalImageIcon = new ImageIcon(imageDataBytes);

                    // Redimensionar la imagen a 435x375 píxeles
                    Image originalImage = originalImageIcon.getImage();
                    Image resizedImage = originalImage.getScaledInstance(435, 375, Image.SCALE_SMOOTH);

                    // Crear un ImageIcon a partir de la imagen redimensionada
                    ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

                    // Establecer el ImageIcon redimensionado en el JLabel
                    jLabel1.setIcon(resizedImageIcon);
                    } else {
                        jLabel1.setText("Los datos de la imagen son nulos.");
                    }
                } else {
                    jLabel1.setText("El objeto 'image' no se encontró en el documento.");
                }
            } else {
                jLabel1.setText("La imagen no se encontró en la base de datos.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            jLabel1.setText("Error al cargar la imagen.");
        }
    }
    
        private void showFirma() {
        try (MongoClient client = MongoClients.create("mongodb+srv://Edalmarc:udrNYnjBDhQvub8x@bic-edalmarc.svgqcpw.mongodb.net/Edalmarc?retryWrites=true&w=majority")) {
            MongoDatabase database = client.getDatabase("Edalmarc");
            MongoCollection<Document> collection = database.getCollection("firmas");

            // Reemplaza "id_mason_value" con el valor real por el que deseas buscar
            ObjectId idMasonValue = new ObjectId(IDtecnico_update);
            System.out.println(idMasonValue);
            
            Document imageDocument = collection.find(Filters.eq("id_mason", idMasonValue)).first();

            if (imageDocument != null) {
                Document imageObject = imageDocument.get("firma", Document.class);
                if (imageObject != null) {
                    org.bson.types.Binary imageData = imageObject.get("data", org.bson.types.Binary.class);
                    System.out.println(imageData);
                    if (imageData != null) {
                        byte[] imageDataBytes = imageData.getData();

                            // Cargar la imagen
                    ImageIcon originalImageIcon = new ImageIcon(imageDataBytes);

                    // Redimensionar la imagen a 435x375 píxeles
                    Image originalImage = originalImageIcon.getImage();
                    Image resizedImage = originalImage.getScaledInstance(435, 375, Image.SCALE_SMOOTH);

                    // Crear un ImageIcon a partir de la imagen redimensionada
                    ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

                    // Establecer el ImageIcon redimensionado en el JLabel
                    jLabel2.setIcon(resizedImageIcon);
                    } else {
                        jLabel2.setText("Los datos de la imagen son nulos.");
                    }
                } else {
                    jLabel2.setText("El objeto 'image' no se encontró en el documento.");
                }
            } else {
                jLabel2.setText("La imagen no se encontró en la base de datos.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            jLabel2.setText("Error al cargar la imagen.");
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1020, 720));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(0, 0));
        bg.setPreferredSize(new java.awt.Dimension(1020, 720));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
