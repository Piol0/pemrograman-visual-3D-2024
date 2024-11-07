/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugas5;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author safik
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    
    Connection conn;
    private DefaultTableModel modelKaryawan, modelProyek, modelTransaksi;
    
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        conn = koneksi.getConnection();
        
        JOptionPane.showMessageDialog(null, "Tekan Button Tips untuk mengetahui prosedur penggunaan aplikasi","INFO",JOptionPane.INFORMATION_MESSAGE);
        
        loadDataAndTables();
        checkButton();
        
        KeyListener keyListener = new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                checkButtonKaryawan();
                checkButtonProyek();
                checkButtonTransaksi();        
            }
        };
               
          
        t_idK.addKeyListener(keyListener);
        t_nama.addKeyListener(keyListener);
        t_departemen.addKeyListener(keyListener);
        t_jabatan.addKeyListener(keyListener);
        
        t_idP.addKeyListener(keyListener);
        t_nama_proyek.addKeyListener(keyListener);
        t_durasi.addKeyListener(keyListener);
        
        comboKaryawan.addKeyListener(keyListener);
        comboProyek.addKeyListener(keyListener);
        t_durasiP.addKeyListener(keyListener);
        
        addNumberKeyListener(t_idP);
        addNumberKeyListener(t_idK);
        addNumberKeyListener(t_durasi);
        addNumberKeyListener(t_durasiP);
        
        comboKaryawan.setSelectedItem(null);
        comboProyek.setSelectedItem(null);
        btn_delete_transaksi.setEnabled(false);
       
    }
    
    private void addNumberKeyListener(JTextField textField) {
    textField.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            if (!Character.isDigit(e.getKeyChar())) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Hanya boleh diisi dengan angka!", 
                        "Input Error", JOptionPane.ERROR_MESSAGE);

            }
        }
        
         
    });
      
    }
    
    private void loadDataAndTables(){
        tabelKaryawan();
        tabelProyek();
        tabelTransaksi();
        
        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadComboBoxKaryawan();
        loadComboBoxProyek();
    }
    
    private void checkButton(){
        checkButtonKaryawan();
        checkButtonProyek();
        checkButtonTransaksi();
    }
    
     private void checkButtonKaryawan() {
        boolean id_isi = !t_idK.getText().trim().isEmpty();
        boolean nama_isi = !t_nama.getText().trim().isEmpty();
        boolean departemen_isi = !t_departemen.getText().trim().isEmpty();
        boolean jabatan_isi = !t_jabatan.getText().trim().isEmpty();

  
        if (id_isi && !nama_isi && !departemen_isi && !jabatan_isi) {
            btn_delete_karyawan.setEnabled(true);
            btn_update_karyawan.setEnabled(false);
            btn_simpan_karyawan.setEnabled(false);
        } else if (id_isi && nama_isi && departemen_isi && jabatan_isi) {
            btn_delete_karyawan.setEnabled(false);
            btn_update_karyawan.setEnabled(true);
            btn_simpan_karyawan.setEnabled(false);
        } else if (!id_isi && nama_isi && departemen_isi && jabatan_isi) {
            btn_delete_karyawan.setEnabled(false);
            btn_update_karyawan.setEnabled(false);
            btn_simpan_karyawan.setEnabled(true);
        } else {
            btn_delete_karyawan.setEnabled(false);
            btn_update_karyawan.setEnabled(false);
            btn_simpan_karyawan.setEnabled(false);
        }
    }

    private void checkButtonProyek() {
        boolean ID_isi = !t_idP.getText().trim().isEmpty();
        boolean nama_proyek_isi = !t_nama_proyek.getText().trim().isEmpty();
        boolean durasi_isi = !t_durasi.getText().trim().isEmpty();

 
        if (ID_isi && !nama_proyek_isi && !durasi_isi ) {
            btn_delete_proyek.setEnabled(true);
            btn_update_proyek.setEnabled(false);
            btn_simpan_proyek.setEnabled(false);
        } else if (ID_isi && nama_proyek_isi && durasi_isi ) {
            btn_delete_proyek.setEnabled(false);
            btn_update_proyek.setEnabled(true);
            btn_simpan_proyek.setEnabled(false);
        } else if (!ID_isi && nama_proyek_isi && durasi_isi ) {
            btn_delete_proyek.setEnabled(false);
            btn_update_proyek.setEnabled(false);
            btn_simpan_proyek.setEnabled(true);
        } else {
            btn_delete_proyek.setEnabled(false);
            btn_update_proyek.setEnabled(false);
            btn_simpan_proyek.setEnabled(false);
        }
    }
    
    private void checkButtonTransaksi() {
        boolean IdK_isi = comboKaryawan.getSelectedItem() != null; 
        boolean idP_isi = comboProyek.getSelectedItem() != null; 
        boolean peran_isi = !t_durasiP.getText().trim().isEmpty(); 

        if (IdK_isi && idP_isi && !peran_isi) {
            btn_delete_transaksi.setEnabled(true);
            btn_update_transaksi.setEnabled(false);
            btn_simpan_transaksi.setEnabled(false);
        } else if (IdK_isi && idP_isi && peran_isi) {
            btn_delete_transaksi.setEnabled(false);
            btn_update_transaksi.setEnabled(true);
            btn_simpan_transaksi.setEnabled(true);
        } else {
            btn_delete_transaksi.setEnabled(false);
            btn_update_transaksi.setEnabled(false);
            btn_simpan_transaksi.setEnabled(false);
        }
    }
    
    private void tabelKaryawan(){
        modelKaryawan = new DefaultTableModel();
        tbl_karyawan.setModel(modelKaryawan);
        
        modelKaryawan.addColumn("ID");
        modelKaryawan.addColumn("Nama");
        modelKaryawan.addColumn("Jabatan");
        modelKaryawan.addColumn("Departemen");
    }
    private void tabelProyek(){
        modelProyek = new DefaultTableModel();
        tbl_proyek.setModel(modelProyek);
        
        modelProyek.addColumn("ID");
        modelProyek.addColumn("Nama Proyek");
        modelProyek.addColumn("Durasi");
    }
    private void tabelTransaksi(){
        modelTransaksi = new DefaultTableModel();
        tbl_transaksi.setModel(modelTransaksi);
        
        modelTransaksi.addColumn("Karyawan");
        modelTransaksi.addColumn("Proyek");
        modelTransaksi.addColumn("Durasi Pengerjaan");
    }
    
    private void loadDataKaryawan(){
        modelKaryawan.setRowCount(0);

      try {
          String sql = "SELECT * FROM karyawan";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             modelKaryawan.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama"),
             rs.getString("jabatan"),
             rs.getString("departemen")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    
    private void loadDataProyek() {
      modelProyek.setRowCount(0);

      try {
          String sql = "SELECT * FROM proyek ";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             modelProyek.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama_proyek"),
             String.format("%d Minggu",rs.getInt("durasi_pengerjaan"))
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    
    
    private void loadDataTransaksi(){
         modelTransaksi.setRowCount(0);
        try {
            String sql = "SELECT karyawan.nama AS nama_karyawan, proyek.nama_proyek, transaksi.durasi_pengerjaan  " +
                        "FROM transaksi " +
                        "JOIN karyawan ON transaksi.id_karyawan = karyawan.id " +
                        "JOIN proyek ON transaksi.id_proyek = proyek.id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Menambahkan baris ke dalam model tabel
                modelTransaksi.addRow(new Object[]{
                    rs.getString("nama_karyawan"),
                    rs.getString("nama_proyek"),
                    String.format("%d Minggu",rs.getInt("durasi_pengerjaan"))
            });
        }
        } catch (SQLException e) {
            System.out.println("Error loading Transaksi data: " + e.getMessage());
        }      
    }
    
    private void loadComboBoxKaryawan (){
         comboKaryawan.removeAllItems();
        try {
            String sql = "SELECT id, nama FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()) {
                String idNama = rs.getInt("id") + " - " + rs.getString("nama");
                comboKaryawan.addItem(idNama);
            }
        } catch (SQLException e) {
            System.out.println("Error loading Karyawan ComboBox: " + e.getMessage());
        }
    }
    
    private void loadComboBoxProyek(){
          comboProyek.removeAllItems();
        try {
            String sql = "SELECT id, nama_proyek FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String idNamaProyek = rs.getInt("id") + " - " + rs.getString("nama_proyek");
                comboProyek.addItem(idNamaProyek); 
            }
        } catch (SQLException e) {
            System.out.println("Error loading Proyek ComboBox: " + e.getMessage());
        }    
    }
    
  
    
    // ======================================Karyawan
        //Simpan Data
    private void saveDataKaryawan() {
      try{
         String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, t_nama.getText());
         ps.setString(2, t_jabatan.getText());
         ps.setString(3, t_departemen.getText());
         ps.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data saved successfully");
         //
         loadDataKaryawan();
         loadComboBoxKaryawan();
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
     }
    //End Simpan Data
    
      //Update Data
    private void updateDataKaryawan() {
      try {
          String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, t_nama.getText());
          ps.setString(2, t_jabatan.getText());
          ps.setString(3, t_departemen.getText());
          ps.setInt(4, Integer.parseInt(t_idK.getText()));
          
          if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this, "Data updated successfully");
            loadDataKaryawan();
            loadComboBoxKaryawan();
        } else {
            JOptionPane.showMessageDialog(this, "Data tidak ditemukan untuk ID tersebut!", "Update Error", JOptionPane.WARNING_MESSAGE);
        }
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
     }
    //End Simpan Data

    //Delete Data
    private void deleteDataKaryawan() {
     try  {
          String sql = "DELETE FROM karyawan WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(t_idK.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data deleted successfully");
          loadDataKaryawan();
          loadComboBoxKaryawan();
     } catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }
    //End Delete Data
    // =============================================Karyawan
    
    //===================================Proyek
    
      //Simpan Data
    private void saveDataProyek() {
      try{
         int Durasi = Integer.parseInt(t_durasi.getText());
         if (Durasi < 1) {
            JOptionPane.showMessageDialog(this, "Durasi Pengerjaan tidak boleh kurang dari 1!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
         }
         String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, t_nama_proyek.getText());
         ps.setInt(2, Durasi);
        
        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this, "Data saved successfully");
            
            loadDataProyek();
            loadComboBoxProyek();
            resetP();
        }
        
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       } 
     }
    //End Simpan Data
    
    //Update Data
    private void updateDataProyek() {
      try {
           int Durasi = Integer.parseInt(t_durasi.getText());
           if (Durasi < 1) {
               JOptionPane.showMessageDialog(this, "Durasi Pengerjaan tidak boleh kurang dari 1!", "Input Error", JOptionPane.WARNING_MESSAGE);
               return;
            }
          String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, t_nama_proyek.getText());
          ps.setInt(2, Durasi);
          ps.setInt(3, Integer.parseInt(t_idP.getText()));
          if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this, "Data updated successfully");
            loadDataProyek();
            loadComboBoxKaryawan();
            resetP();
        } else {
            JOptionPane.showMessageDialog(this, "Data dengan ID tersebut tidak ditemukan!", "Update Error", JOptionPane.WARNING_MESSAGE);
        }
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
     }
    //End Simpan Data

    //Delete Data
    private void deleteDataProyek() {
     try  {
          String sql = "DELETE FROM proyek WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(t_idP.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data deleted successfully");
          loadDataProyek();
          loadComboBoxProyek();
     } catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }
    //End Delete Data
    //===========================Proyek
    
    // ======================Transaksi
    private void saveDataTransaksi() {
        try {
            int durasi = Integer.parseInt(t_durasiP.getText());
            if (durasi < 1) {
                JOptionPane.showMessageDialog(this, "Durasi Pengerjaan tidak boleh kurang dari 1!", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, Integer.parseInt(((String) comboKaryawan.getSelectedItem()).split(" - ")[0].trim()));
            ps.setInt(2, Integer.parseInt(((String) comboProyek.getSelectedItem()).split(" - ")[0].trim()));
            ps.setInt(3, durasi);
            
            if(ps.executeUpdate() > 0){
               JOptionPane.showMessageDialog(this, "Data transaksi berhasil ditambahkan!");
               loadDataTransaksi();
               resetT();
            }
            
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(this, "Data transaksi dengan ID Karyawan dan ID Proyek ini sudah ada.", "Duplicate Entry Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error saat menambahkan data transaksi: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println("Error saat menambahkan data transaksi: " + e.getMessage());
        }
    }
    
    private void updateDataTransaksi() {
        
        try {
            int durasi = Integer.parseInt(t_durasiP.getText());
            if (durasi < 1) {
                JOptionPane.showMessageDialog(this, "Durasi Pengerjaan tidak boleh kurang dari 1!", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String sql = "UPDATE transaksi SET durasi_pengerjaan = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, durasi);
            ps.setInt(2, Integer.parseInt(comboKaryawan.getSelectedItem().toString().split(" - ")[0].trim()));
            ps.setInt(3, Integer.parseInt(comboProyek.getSelectedItem().toString().split(" - ")[0].trim()));
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil diupdate!");
                resetT();
            } else {
                JOptionPane.showMessageDialog(this, "Data transaksi tidak ditemukan!", "Update Data", JOptionPane.WARNING_MESSAGE);
            }
            loadDataTransaksi();
            
        } catch (SQLException e) {
            System.out.println("Error saat mengupdate data transaksi: " + e.getMessage());
        } 
    }
    
    private void deleteDataTransaksi() {
        try {
            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(((String) comboKaryawan.getSelectedItem()).split(" - ")[0].trim()));
            ps.setInt(2, Integer.parseInt(((String) comboProyek.getSelectedItem()).split(" - ")[0].trim()));

             if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil dihapus!");
            } else {
                JOptionPane.showMessageDialog(this, "Transaksi tidak ditemukan!", "Delete Data", JOptionPane.WARNING_MESSAGE);
            }

            loadDataTransaksi();
        } catch (SQLException e) {
            System.out.println("Error saat menghapus data transaksi: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error konversi ID: " + e.getMessage());
        }
    }
// ===================TRANSAKSI
    
    
    private void Exit(){
        int exit = JOptionPane.showConfirmDialog(null,"Keluar Program?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    private void resetK(){
        t_idK.setText("");
        t_nama.setText("");
        t_departemen.setText("");
        t_jabatan.setText("");
        
        btn_delete_karyawan.setEnabled(false);
        btn_update_karyawan.setEnabled(false);
        btn_simpan_karyawan.setEnabled(false);
    }
    
    private void resetP(){
        t_idP.setText("");
        t_nama_proyek.setText("");
        t_durasi.setText("");
        
        btn_delete_proyek.setEnabled(false);
        btn_update_proyek.setEnabled(false);
        btn_simpan_proyek.setEnabled(false);
    }
    
    private void resetT(){
        comboKaryawan.setSelectedItem(null);
        comboProyek.setSelectedItem(null);
        t_durasiP.setText("");
        
        btn_delete_transaksi.setEnabled(false);
        btn_update_transaksi.setEnabled(false);
        btn_simpan_transaksi.setEnabled(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Karyawan = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        t_idK = new javax.swing.JTextField();
        t_nama = new javax.swing.JTextField();
        t_jabatan = new javax.swing.JTextField();
        t_departemen = new javax.swing.JTextField();
        btn_simpan_karyawan = new javax.swing.JButton();
        btn_update_karyawan = new javax.swing.JButton();
        btn_delete_karyawan = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Exit = new javax.swing.JButton();
        reset1 = new javax.swing.JButton();
        Proyek = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Exit1 = new javax.swing.JButton();
        reset2 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        t_idP = new javax.swing.JTextField();
        t_nama_proyek = new javax.swing.JTextField();
        t_durasi = new javax.swing.JTextField();
        btn_simpan_proyek = new javax.swing.JButton();
        btn_update_proyek = new javax.swing.JButton();
        btn_delete_proyek = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        TransaksiProyek = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboKaryawan = new javax.swing.JComboBox<>();
        comboProyek = new javax.swing.JComboBox<>();
        t_durasiP = new javax.swing.JTextField();
        btn_simpan_transaksi = new javax.swing.JButton();
        btn_update_transaksi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btn_delete_transaksi = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(95, 111, 101));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setToolTipText("");

        Karyawan.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(95, 111, 101));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Karyawan");
        jPanel4.add(jLabel1);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\safik\\Downloads\\output-onlinepngtools (7).png")); // NOI18N
        jPanel4.add(jLabel14);

        Karyawan.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(201, 218, 191));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("ID");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Nama");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Jabatan");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Departemen");

        btn_simpan_karyawan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_simpan_karyawan.setText("Simpan");
        btn_simpan_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_karyawanActionPerformed(evt);
            }
        });

        btn_update_karyawan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_update_karyawan.setText("Update");
        btn_update_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_karyawanActionPerformed(evt);
            }
        });

        btn_delete_karyawan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_delete_karyawan.setText("Delete");
        btn_delete_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_karyawanActionPerformed(evt);
            }
        });

        tbl_karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_karyawan.setEnabled(false);
        jScrollPane4.setViewportView(tbl_karyawan);

        jButton6.setText("Tips");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel21.setText("Tekan tombol tips untuk");

        jLabel22.setText("Inforrmasi lebih lanjut");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btn_simpan_karyawan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_update_karyawan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_delete_karyawan))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t_idK, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(t_nama)
                            .addComponent(t_jabatan)
                            .addComponent(t_departemen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22))
                        .addGap(51, 51, 51))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(t_idK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(t_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(t_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(t_departemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan_karyawan)
                    .addComponent(btn_update_karyawan)
                    .addComponent(btn_delete_karyawan))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        Karyawan.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setBackground(new java.awt.Color(128, 141, 124));
        jPanel6.setPreferredSize(new java.awt.Dimension(515, 40));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Exit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jPanel6.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        reset1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reset1.setText("Reset");
        reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset1ActionPerformed(evt);
            }
        });
        jPanel6.add(reset1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        Karyawan.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Karyawan", Karyawan);

        Proyek.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(95, 111, 101));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Proyek");
        jPanel1.add(jLabel2);

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\safik\\Downloads\\output-onlinepngtools (5).png")); // NOI18N
        jPanel1.add(jLabel16);

        Proyek.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(128, 141, 124));
        jPanel3.setPreferredSize(new java.awt.Dimension(515, 40));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Exit1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Exit1.setText("Exit");
        Exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit1ActionPerformed(evt);
            }
        });
        jPanel3.add(Exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        reset2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reset2.setText("Reset");
        reset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset2ActionPerformed(evt);
            }
        });
        jPanel3.add(reset2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        Proyek.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel10.setBackground(new java.awt.Color(201, 218, 191));
        jPanel10.setPreferredSize(new java.awt.Dimension(578, 470));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("ID");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Nama Proyek");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Durasi Pengerjaan");

        btn_simpan_proyek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_simpan_proyek.setText("Simpan");
        btn_simpan_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_proyekActionPerformed(evt);
            }
        });

        btn_update_proyek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_update_proyek.setText("Update");
        btn_update_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_proyekActionPerformed(evt);
            }
        });

        btn_delete_proyek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_delete_proyek.setText("Delete");
        btn_delete_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_proyekActionPerformed(evt);
            }
        });

        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_proyek.setEnabled(false);
        jScrollPane1.setViewportView(tbl_proyek);

        jButton5.setText("Tips");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel19.setText("Tekan tombol tips untuk");

        jLabel20.setText("Inforrmasi lebih lanjut");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t_idP, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(t_nama_proyek)
                            .addComponent(t_durasi))
                        .addGap(170, 170, 170)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(btn_simpan_proyek)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_update_proyek)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_delete_proyek))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(t_idP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(t_nama_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(t_durasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan_proyek)
                    .addComponent(btn_update_proyek)
                    .addComponent(btn_delete_proyek))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        Proyek.add(jPanel10, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Proyek", Proyek);

        TransaksiProyek.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(95, 111, 101));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Transaksi Proyek");
        jPanel7.add(jLabel3);

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\safik\\Downloads\\output-onlinepngtools (8) (1).png")); // NOI18N
        jLabel15.setToolTipText("");
        jPanel7.add(jLabel15);

        TransaksiProyek.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(201, 218, 191));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Karyawan");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Durasi Pengerjaan");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Proyek");

        comboKaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboProyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_simpan_transaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_simpan_transaksi.setText("Simpan");
        btn_simpan_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_transaksiActionPerformed(evt);
            }
        });

        btn_update_transaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_update_transaksi.setText("Update");
        btn_update_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_transaksiActionPerformed(evt);
            }
        });

        jScrollPane2.setEnabled(false);

        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_transaksi.setEnabled(false);
        jScrollPane2.setViewportView(tbl_transaksi);

        jButton4.setText("Tips");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel17.setText("Tekan tombol tips untuk");

        jLabel18.setText("Inforrmasi lebih lanjut");

        btn_delete_transaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_delete_transaksi.setText("Delete");
        btn_delete_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_transaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboKaryawan, 0, 140, Short.MAX_VALUE)
                            .addComponent(comboProyek, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_durasiP))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jButton4))
                                .addGap(14, 14, 14))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btn_simpan_transaksi)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update_transaksi)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete_transaksi))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboProyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(t_durasiP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_update_transaksi)
                        .addComponent(btn_delete_transaksi))
                    .addComponent(btn_simpan_transaksi))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        TransaksiProyek.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(new java.awt.Color(128, 141, 124));
        jPanel9.setPreferredSize(new java.awt.Dimension(576, 45));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setText("Exit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        TransaksiProyek.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Transaksi Proyek", TransaksiProyek);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpan_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_karyawanActionPerformed
        // TODO add your handling code here:
        saveDataKaryawan();
        resetK();
        resetT();
    }//GEN-LAST:event_btn_simpan_karyawanActionPerformed

    private void btn_update_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_karyawanActionPerformed
        // TODO add your handling code here:
        updateDataKaryawan();
        resetK();
        resetT();
    }//GEN-LAST:event_btn_update_karyawanActionPerformed

    private void btn_delete_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_karyawanActionPerformed
        // TODO add your handling code here:
        deleteDataKaryawan();
        resetK();
        resetT();
    }//GEN-LAST:event_btn_delete_karyawanActionPerformed

    private void btn_simpan_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_proyekActionPerformed
        // TODO add your handling code here:
        saveDataProyek();
//        resetP();
        resetT();
    }//GEN-LAST:event_btn_simpan_proyekActionPerformed

    private void btn_update_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_proyekActionPerformed
        // TODO add your handling code here:
        updateDataProyek();
//        resetP();
        resetT();
    }//GEN-LAST:event_btn_update_proyekActionPerformed

    private void btn_delete_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_proyekActionPerformed
        // TODO add your handling code here:
        deleteDataProyek();
        resetP();
        resetT();
    }//GEN-LAST:event_btn_delete_proyekActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        Exit();
    }//GEN-LAST:event_ExitActionPerformed

    private void Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit1ActionPerformed
        // TODO add your handling code here:
        Exit();
    }//GEN-LAST:event_Exit1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Exit();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset1ActionPerformed
        // TODO add your handling code here:
       resetK();
    }//GEN-LAST:event_reset1ActionPerformed

    private void reset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset2ActionPerformed
        // TODO add your handling code here:
       resetP();
    }//GEN-LAST:event_reset2ActionPerformed

    private void btn_simpan_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_transaksiActionPerformed
        // TODO add your handling code here:
        saveDataTransaksi();
//        resetT();
    }//GEN-LAST:event_btn_simpan_transaksiActionPerformed

    private void btn_update_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_transaksiActionPerformed
        // TODO add your handling code here:
        updateDataTransaksi();
//        resetT();
    }//GEN-LAST:event_btn_update_transaksiActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       JOptionPane.showMessageDialog(this, "1. Untuk menginput data baru, silakan pilih Karyawan, Proyek, dan isi kolom Peran.\n\n" +
                "2. Untuk memperbarui data, pastikan semua kolom Karyawan, Proyek, dan Peran terisi.\n\n" +
                "3. Jika ingin menghapus data, cukup pilih kolom Karyawan dan Proyek.");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "1. Untuk menginput data baru, silakan isi kolom Nama Proyek dan Durasi Pengerjaan.\n\n" +
                "2. Untuk memperbarui data, pastikan semua kolom ID, Nama Proyek, dan Durasi Pengerjaan terisi.\n\n" +
                "3. Jika ingin menghapus data, cukup isi kolom ID saja.");

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(this, "1. Untuk menginput data baru, silakan isi kolom Nama, Jabatan, dan Departemen.\n\n" +
                "2. Untuk memperbarui data, pastikan semua kolom ID, Nama, Jabatan, dan Departemen terisi.\n\n" +
                "3. Jika ingin menghapus data, cukup isi kolom ID saja.");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_delete_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_transaksiActionPerformed
        // TODO add your handling code here:
        deleteDataTransaksi();
        resetT();
    }//GEN-LAST:event_btn_delete_transaksiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        resetT();
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton Exit1;
    private javax.swing.JPanel Karyawan;
    private javax.swing.JPanel Proyek;
    private javax.swing.JPanel TransaksiProyek;
    private javax.swing.JButton btn_delete_karyawan;
    private javax.swing.JButton btn_delete_proyek;
    private javax.swing.JButton btn_delete_transaksi;
    private javax.swing.JButton btn_simpan_karyawan;
    private javax.swing.JButton btn_simpan_proyek;
    private javax.swing.JButton btn_simpan_transaksi;
    private javax.swing.JButton btn_update_karyawan;
    private javax.swing.JButton btn_update_proyek;
    private javax.swing.JButton btn_update_transaksi;
    private javax.swing.JComboBox<String> comboKaryawan;
    private javax.swing.JComboBox<String> comboProyek;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton reset1;
    private javax.swing.JButton reset2;
    private javax.swing.JTextField t_departemen;
    private javax.swing.JTextField t_durasi;
    private javax.swing.JTextField t_durasiP;
    private javax.swing.JTextField t_idK;
    private javax.swing.JTextField t_idP;
    private javax.swing.JTextField t_jabatan;
    private javax.swing.JTextField t_nama;
    private javax.swing.JTextField t_nama_proyek;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    // End of variables declaration//GEN-END:variables
}
