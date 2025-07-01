/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.healthtrackapp;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Updates.set;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.result.DeleteResult;
import java.util.Iterator;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.bson.types.ObjectId;

/**
 *
 * @author bimazznxt
 */
public class UI extends javax.swing.JFrame {

    private DefaultListModel<HealthData> healthHistoryListModel;
    private Font multiLanguageFont; // Variabel untuk menyimpan font
    private MongoCollection<Document> healthRecordsCollection;
    private ObjectId currentUserId; // To store the logged-in user's ID

    /**
     * Creates new form UI
     */
    public UI(ObjectId userId) {
        this.currentUserId = userId;
        // Coba muat font kustom saat inisialisasi
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/NotoSans-Regular.ttf"); // Sesuaikan path jika berbeda
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017"); // Your MongoDB connection string
            MongoDatabase database = mongoClient.getDatabase("UAS"); // Your database name
            healthRecordsCollection = database.getCollection("healthrecords");
            if (is != null) {
                multiLanguageFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, 14f); // Ukuran font 14
                is.close();
            } else {
                System.err.println("Font file not found: /fonts/NotoSans-Regular.ttf");
                // Gunakan font default jika font kustom tidak ditemukan
                multiLanguageFont = new Font("SansSerif", Font.PLAIN, 14);
            }
        } catch (FontFormatException | IOException e) {
            System.err.println("Error connecting to MongoDB in UI: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Failed to connect to database for health data.", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error loading font: " + e.getMessage());
            multiLanguageFont = new Font("SansSerif", Font.PLAIN, 14); // Fallback ke font default
        }
        initComponents();
        // Terapkan font ke komponen yang relevan setelah initComponents()
        applyFontToComponents();
        healthHistoryListModel = new DefaultListModel<>(); // Initialize as DefaultListModel<HealthData>
        jList1.setModel(healthHistoryListModel);
        loadHealthRecords();
        updateLanguage("Bahasa Indonesia"); // Set initial language
    }

    private void applyFontToComponents() {
        if (multiLanguageFont != null) {
            jLabel1.setFont(multiLanguageFont.deriveFont(Font.BOLD, 24f)); // Judul utama lebih besar dan tebal
            jLabel2.setFont(multiLanguageFont);
            jLabel3.setFont(multiLanguageFont);
            jLabel4.setFont(multiLanguageFont);
            jLabel5.setFont(multiLanguageFont);
            jLabel6.setFont(multiLanguageFont);
            jLabel7.setFont(multiLanguageFont);
            jComboBox1.setFont(multiLanguageFont);
            jList1.setFont(multiLanguageFont);
            jTextField1.setFont(multiLanguageFont);
            jTextField2.setFont(multiLanguageFont);
            jTextField3.setFont(multiLanguageFont);
            jTextField4.setFont(multiLanguageFont);
            buat.setFont(multiLanguageFont);
            simpan.setFont(multiLanguageFont);
            perbarui.setFont(multiLanguageFont);
            hapus.setFont(multiLanguageFont);
        }
    }

    // Data model for health records
    private static class HealthData {

        ObjectId id;
        String date;
        String bloodPressure;
        String oxygenLevel;
        String weight;
        String height;

        public HealthData(ObjectId id, String date, String bloodPressure, String oxygenLevel, String weight, String height) {
            this.id = id;
            this.date = date;
            this.bloodPressure = bloodPressure;
            this.oxygenLevel = oxygenLevel;
            this.weight = weight;
            this.height = height;
        }

        public ObjectId getId() { // Add getter for the id
            return id;
        }

        public String getDate() {
            return date;
        }

        public String getBloodPressure() {
            return bloodPressure;
        }

        public String getOxygenLevel() {
            return oxygenLevel;
        }

        public String getWeight() {
            return weight;
        }

        public String getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return date + " - BP: " + bloodPressure + ", O2: " + oxygenLevel + ", W: " + weight + ", H: " + height;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<HealthData>();
        jLabel3 = new javax.swing.JLabel();
        buat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        perbarui = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Pemantau Kesehatan");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bahasa Indonesia", "English", "Japan", "Korean" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Pilihan Bahasa");

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, 0, 185, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Riwayat");

        buat.setText("Buat Data Baru");
        buat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buat)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        perbarui.setText("Perbarui Data");
        perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perbaruiActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tekanan Darah:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Kadar Oksigen:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Berat Badan:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tinggi Badan:");

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(perbarui)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hapus)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(perbarui)
                    .addComponent(hapus)
                    .addComponent(simpan))
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String selectedLanguage = (String) jComboBox1.getSelectedItem();
        updateLanguage(selectedLanguage);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int selectedIndex = jList1.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data dari riwayat untuk dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            HealthData selectedHealthData = healthHistoryListModel.getElementAt(selectedIndex);
            ObjectId recordIdToDelete = selectedHealthData.getId(); // Get the ID

            // Delete the document from MongoDB based on its _id
            DeleteResult result = healthRecordsCollection.deleteOne(eq("_id", recordIdToDelete));

            if (result.getDeletedCount() > 0) {
                JOptionPane.showMessageDialog(this, "Data kesehatan berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                // Clear the text fields after successful deletion
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                loadHealthRecords(); // Refresh the list to reflect the deletion
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau tidak dapat dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data kesehatan: " + ex.getMessage(), "Error Database", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); // Print full stack trace for debugging
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perbaruiActionPerformed
        int selectedIndex = jList1.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data dari riwayat untuk diperbarui.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String bloodPressure = jTextField1.getText();
        String oxygenLevel = jTextField2.getText();
        String weight = jTextField3.getText();
        String height = jTextField4.getText();

        if (bloodPressure.isEmpty() || oxygenLevel.isEmpty() || weight.isEmpty() || height.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom data harus diisi untuk pembaruan.", "Pembaruan Gagal", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ensure currentUserId is not null before using it
        if (currentUserId == null) {
            JOptionPane.showMessageDialog(this, "Tidak ada pengguna yang login. Tidak dapat memperbarui data.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Get the HealthData object directly from the model
            HealthData selectedHealthData = healthHistoryListModel.getElementAt(selectedIndex);
            ObjectId recordIdToUpdate = selectedHealthData.getId(); // Use the ObjectId for update

            Document updatedDocument = new Document("bloodPressure", bloodPressure)
                    .append("oxygenLevel", oxygenLevel)
                    .append("weight", weight)
                    .append("height", height);

            healthRecordsCollection.updateOne(
                    eq("_id", recordIdToUpdate), // Query by _id instead of date string
                    new Document("$set", updatedDocument)
            );

            JOptionPane.showMessageDialog(this, "Data kesehatan berhasil diperbarui.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            loadHealthRecords(); // Refresh the list
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memperbarui data kesehatan.", "Error Database", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_perbaruiActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        if (!evt.getValueIsAdjusting()) {
            int selectedIndex = jList1.getSelectedIndex();
            if (selectedIndex != -1) {
                HealthData selectedHealthData = healthHistoryListModel.getElementAt(selectedIndex); // Get the HealthData object

                jTextField1.setText(selectedHealthData.getBloodPressure());
                jTextField2.setText(selectedHealthData.getOxygenLevel());
                jTextField3.setText(selectedHealthData.getWeight());
                jTextField4.setText(selectedHealthData.getHeight());
            } else {
                // If nothing is selected, clear text fields
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
            }
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        String bloodPressure = jTextField1.getText();
        String oxygenLevel = jTextField2.getText();
        String weight = jTextField3.getText();
        String height = jTextField4.getText();

        if (bloodPressure.isEmpty() || oxygenLevel.isEmpty() || weight.isEmpty() || height.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (currentUserId == null) {
            JOptionPane.showMessageDialog(this, "No user logged in. Cannot save data.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Date currentDate = new Date();
            Document newHealthRecord = new Document("userId", currentUserId)
                    .append("date", currentDate)
                    .append("bloodPressure", bloodPressure)
                    .append("oxygenLevel", oxygenLevel)
                    .append("weight", weight)
                    .append("height", height);

            healthRecordsCollection.insertOne(newHealthRecord);
            JOptionPane.showMessageDialog(this, "Data kesehatan berhasil disimpan.", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // Refresh the list after saving
            loadHealthRecords();
            // Clear input fields
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data kesehatan.", "Error Database", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void buatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buatActionPerformed
        // Buat Data Baru (Create New Data)
        jTextField1.setText(""); // Clear Blood Pressure
        jTextField2.setText(""); // Clear Oxygen Level
        jTextField3.setText(""); // Clear Weight
        jTextField4.setText(""); // Clear Height
        jList1.clearSelection(); // Deselect any history item
    }//GEN-LAST:event_buatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buat;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<HealthData> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton perbarui;
    private javax.swing.JButton simpan;
    // End of variables declaration//GEN-END:variables

    private void loadHealthRecords() {
        healthHistoryListModel.clear();
        if (currentUserId == null) {
            System.err.println("No user ID available to load health records.");
            return;
        }
        try {
            for (Document doc : healthRecordsCollection.find(eq("userId", currentUserId)).sort(new Document("date", 1))) {
                ObjectId id = doc.getObjectId("_id"); // Get the ObjectId
                Date recordDate = doc.getDate("date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Keep this for display

                String bloodPressure = doc.getString("bloodPressure");
                String oxygenLevel = doc.getString("oxygenLevel");
                String weight = doc.getString("weight");
                String height = doc.getString("height");

                // Create a HealthData object
                HealthData data = new HealthData(id, sdf.format(recordDate), bloodPressure, oxygenLevel, weight, height);

                // Add the HealthData object to the model. jList1 will implicitly call toString()
                healthHistoryListModel.addElement(data);
            }
        } catch (Exception e) {
            System.err.println("Error loading health records from MongoDB: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Failed to load health records.", "Error Database", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateLanguage(String language) {
        // This is a basic example. For many languages, use ResourceBundle.
        switch (language) {
            case "Bahasa Indonesia":
                jLabel1.setText("Pemantau Kesehatan");
                jLabel2.setText("Pilihan Bahasa");
                jLabel3.setText("Riwayat");
                buat.setText("Buat Data Baru");
                jLabel4.setText("Tekanan Darah:");
                jLabel5.setText("Kadar Oksigen:");
                jLabel6.setText("Berat Badan:");
                jLabel7.setText("Tinggi Badan:");
                simpan.setText("Simpan");
                perbarui.setText("Perbarui Data");
                hapus.setText("Hapus");
                break;
            case "English":
                jLabel1.setText("Health Monitor");
                jLabel2.setText("Language Option");
                jLabel3.setText("History");
                buat.setText("Create New Data");
                jLabel4.setText("Blood Pressure:");
                jLabel5.setText("Oxygen Level:");
                jLabel6.setText("Weight:");
                jLabel7.setText("Height:");
                simpan.setText("Save");
                perbarui.setText("Update Data");
                hapus.setText("Delete");
                break;
            case "Japan": // Assuming "Japan" means Japanese
                jLabel1.setText("健康トラッカー");
                jLabel2.setText("言語オプション");
                jLabel3.setText("履歴");
                buat.setText("新規データ作成");
                jLabel4.setText("血圧:");
                jLabel5.setText("酸素レベル:");
                jLabel6.setText("体重:");
                jLabel7.setText("身長:");
                simpan.setText("保存");
                perbarui.setText("データ更新");
                hapus.setText("削除");
                break;
            case "Korean":
                jLabel1.setText("건강 추적기");
                jLabel2.setText("언어 옵션");
                jLabel3.setText("기록");
                buat.setText("새 데이터 생성");
                jLabel4.setText("혈압:");
                jLabel5.setText("산소 농도:");
                jLabel6.setText("체중:");
                jLabel7.setText("신장:");
                simpan.setText("저장");
                perbarui.setText("데이터 업데이트");
                hapus.setText("삭제");
                break;
            case "Chinese":
                jLabel1.setText("健康追踪器");
                jLabel2.setText("语言选项");
                jLabel3.setText("历史记录");
                buat.setText("创建新数据");
                jLabel4.setText("血压:");
                jLabel5.setText("氧气水平:");
                jLabel6.setText("体重:");
                jLabel7.setText("身高:");
                simpan.setText("保存");
                perbarui.setText("更新数据");
                hapus.setText("删除");
                break;
            case "Russian":
                jLabel1.setText("Отслеживание здоровья");
                jLabel2.setText("Выбор языка");
                jLabel3.setText("История");
                buat.setText("Создать новую запись");
                jLabel4.setText("Артериальное давление:");
                jLabel5.setText("Уровень кислорода:");
                jLabel6.setText("Вес:");
                jLabel7.setText("Рост:");
                simpan.setText("Сохранить");
                perbarui.setText("Обновить данные");
                hapus.setText("Удалить");
                break;
        }
    }
}
