/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugas3;

//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author safik
 */
public class spp extends javax.swing.JFrame {

    /**
     * Creates new form spp
     */
    
     
     
     private DefaultTableModel tableModel;
    
    public spp() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        tableModel = new DefaultTableModel(new String[]{"Bulan Lunas", "Status"}, 0);
        tabelData.setModel(tableModel);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelatas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelbawah = new javax.swing.JPanel();
        reset = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        pTengah = new javax.swing.JPanel();
        pInformasi = new javax.swing.JPanel();
        pNama = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        pSPP = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        spp = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        januari = new javax.swing.JCheckBox();
        desember = new javax.swing.JCheckBox();
        februari = new javax.swing.JCheckBox();
        maret = new javax.swing.JCheckBox();
        april = new javax.swing.JCheckBox();
        mei = new javax.swing.JCheckBox();
        juni = new javax.swing.JCheckBox();
        juli = new javax.swing.JCheckBox();
        agustus = new javax.swing.JCheckBox();
        september = new javax.swing.JCheckBox();
        oktober = new javax.swing.JCheckBox();
        november = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        bayar = new javax.swing.JButton();
        riwayat = new javax.swing.JButton();
        ttl = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelatas.setBackground(new java.awt.Color(17, 45, 78));
        panelatas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 153, 255)));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugas3/smpn1.png"))); // NOI18N
        panelatas.add(jLabel2);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pembayaran SPP SMPN 1 KEBOMAS");
        jLabel1.setToolTipText("");
        panelatas.add(jLabel1);

        getContentPane().add(panelatas, java.awt.BorderLayout.PAGE_START);

        panelbawah.setBackground(new java.awt.Color(204, 204, 204));
        panelbawah.setPreferredSize(new java.awt.Dimension(300, 30));
        panelbawah.setLayout(new java.awt.GridLayout(1, 0));

        reset.setBackground(new java.awt.Color(0, 102, 204));
        reset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        panelbawah.add(reset);

        exit.setBackground(new java.awt.Color(0, 102, 204));
        exit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        panelbawah.add(exit);

        getContentPane().add(panelbawah, java.awt.BorderLayout.PAGE_END);

        pTengah.setBackground(new java.awt.Color(63, 114, 175));
        pTengah.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(130, 168, 212)));

        pInformasi.setBackground(new java.awt.Color(219, 226, 239));
        pInformasi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(125, 155, 212), 3));
        pInformasi.setToolTipText("");
        pInformasi.setPreferredSize(new java.awt.Dimension(700, 271));
        pInformasi.setLayout(new java.awt.GridLayout(1, 2));

        pNama.setBackground(new java.awt.Color(219, 226, 239));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Nama              :");

        javax.swing.GroupLayout pNamaLayout = new javax.swing.GroupLayout(pNama);
        pNama.setLayout(pNamaLayout);
        pNamaLayout.setHorizontalGroup(
            pNamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNamaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pNamaLayout.setVerticalGroup(
            pNamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNamaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pNamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pInformasi.add(pNama);

        pSPP.setBackground(new java.awt.Color(219, 226, 239));
        pSPP.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("SPP/Perbulan  :");

        javax.swing.GroupLayout pSPPLayout = new javax.swing.GroupLayout(pSPP);
        pSPP.setLayout(pSPPLayout);
        pSPPLayout.setHorizontalGroup(
            pSPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSPPLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(spp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        pSPPLayout.setVerticalGroup(
            pSPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSPPLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pSPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pInformasi.add(pSPP);

        jPanel1.setBackground(new java.awt.Color(219, 226, 239));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 141, 199), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(104, 136, 196));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Bulan :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        januari.setText("Januari");
        jPanel2.add(januari, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        desember.setText("Desember");
        jPanel2.add(desember, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        februari.setText("Februari");
        jPanel2.add(februari, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        maret.setText("Maret");
        jPanel2.add(maret, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        april.setText("April");
        jPanel2.add(april, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        mei.setText("Mei");
        jPanel2.add(mei, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        juni.setText("Juni");
        jPanel2.add(juni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        juli.setText("Juli");
        jPanel2.add(juli, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        agustus.setText("Agustus");
        jPanel2.add(agustus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        september.setText("September");
        jPanel2.add(september, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        oktober.setText("Oktober");
        jPanel2.add(oktober, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        november.setText("November");
        jPanel2.add(november, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 310, 180));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("Status   :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 50, -1));

        status.setEditable(false);
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 140, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel8.setText("Total    :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 50, -1));

        total.setEditable(false);
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 140, -1));

        bayar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bayar.setText("Bayar");
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });
        jPanel1.add(bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));

        riwayat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        riwayat.setText("Tampilkan Riwayat");
        riwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                riwayatActionPerformed(evt);
            }
        });
        jPanel1.add(riwayat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, -1));

        ttl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ttl.setText("Total");
        ttl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttlActionPerformed(evt);
            }
        });
        jPanel1.add(ttl, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        tabelData.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        tabelData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabelData.setForeground(new java.awt.Color(0, 51, 51));
        tabelData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Bulan Lunas", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelData);

        javax.swing.GroupLayout pTengahLayout = new javax.swing.GroupLayout(pTengah);
        pTengah.setLayout(pTengahLayout);
        pTengahLayout.setHorizontalGroup(
            pTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTengahLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pInformasi, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pTengahLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pTengahLayout.setVerticalGroup(
            pTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTengahLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(pInformasi, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pTengah, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
//      private void sppValid() {
//        try {
//            double Jumlahspp = Double.parseDouble(spp.getText());
//            
//            if (Jumlahspp < 0){
//                 JOptionPane.showMessageDialog(this, "Jumlah SPP tidak boleh mines!", "Error", JOptionPane.ERROR_MESSAGE); 
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "dilarang menginput selain angka!", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    
    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
      if (nama.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", "Error", 
                JOptionPane.ERROR_MESSAGE);
        } else if (spp.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Masukkan jumlah spp terlebih dahulu", "Error", 
                JOptionPane.ERROR_MESSAGE);
        } else if (!(januari.isSelected() || desember.isSelected() || februari.isSelected() || 
          maret.isSelected() || april.isSelected() || mei.isSelected() || 
          juni.isSelected() || juli.isSelected() || agustus.isSelected() || 
          september.isSelected() || oktober.isSelected() || november.isSelected())) {
         JOptionPane.showMessageDialog(this, "Pilih setidaknya satu bulan yang harus dibayar.", 
                 "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
       int Spp;
        try {
            Spp = Integer.parseInt(spp.getText());
            if (Spp < 0) {
                JOptionPane.showMessageDialog(this, "Jumlah SPP tidak boleh mines!",
                        "Error", JOptionPane.ERROR_MESSAGE); 
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "dilarang input selain angka!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    
        
//        String namaInput = nama.getText();
        int jumlahspp = Integer.parseInt(spp.getText());

//        StringBuilder bulanLunas = new StringBuilder();
        int jumlahBulanDipilih = 0;
         tableModel.setRowCount(0);
        
        if (januari.isSelected()) {
            jumlahBulanDipilih++;
//            bulanLunas.append("Januari, ");
            String StatusPembayaran = "Lunas";
            tableModel.addRow(new Object[]{"Januari", StatusPembayaran});
            januari.setEnabled(false);
        }
        if (februari.isSelected()) {
            jumlahBulanDipilih++;
//            bulanLunas.append("Februari, ");
            String StatusPembayaran = "Lunas";
            tableModel.addRow(new Object[]{"Februari", StatusPembayaran});
            februari.setEnabled(false);
        } 
        if (maret.isSelected()) {
            jumlahBulanDipilih++;
//            bulanLunas.append("Maret, ");
              String StatusPembayaran = "Lunas";
            tableModel.addRow(new Object[]{"Maret", StatusPembayaran});
            maret.setEnabled(false);
        }
        if (april.isSelected()) {
            jumlahBulanDipilih++;
//            bulanLunas.append("April, ");
              String StatusPembayaran = "Lunas";
            tableModel.addRow(new Object[]{"April", StatusPembayaran});
            april.setEnabled(false);
        }
        if (mei.isSelected()) {
            jumlahBulanDipilih++;
//            bulanLunas.append("Mei, ");
             String StatusPembayaran = "Lunas";
            tableModel.addRow(new Object[]{"Mei", StatusPembayaran});
            mei.setEnabled(false);
        }
        if (juni.isSelected()) {
            jumlahBulanDipilih++;
//            bulanLunas.append("Juni, ");
             String StatusPembayaran = "Lunas";
            tableModel.addRow(new Object[]{"Juni", StatusPembayaran});
            juni.setEnabled(false);
        }
        if (juli.isSelected()) {
            jumlahBulanDipilih++;
//            bulanLunas.append("Juli, ");
            String StatusPembayaran = "Lunas";
            tableModel.addRow(new Object[]{"Juli", StatusPembayaran});
            juli.setEnabled(false);
        }
        if (agustus.isSelected()) {
            jumlahBulanDipilih++;
//            bulanLunas.append("Agustus, ");
            String StatusPembayaran = "Lunas";
            tableModel.addRow(new Object[]{"Agustus", StatusPembayaran});
            agustus.setEnabled(false);
        }
        if (september.isSelected()) {
            jumlahBulanDipilih++;
//            bulanLunas.append("September, ");
             String StatusPembayaran = "Lunas";
            tableModel.addRow(new Object[]{"September", StatusPembayaran});
            september.setEnabled(false);
        }
        if (oktober.isSelected()) {
            jumlahBulanDipilih++;
//            bulanLunas.append("Oktober, ");
             String StatusPembayaran = "Lunas";
            tableModel.addRow(new Object[]{"Oktober", StatusPembayaran});
            oktober.setEnabled(false);
        }
        if (november.isSelected()) {
            jumlahBulanDipilih++;
//            bulanLunas.append("November, ");
            String StatusPembayaran = "Lunas";
            tableModel.addRow(new Object[]{"November", StatusPembayaran});
            november.setEnabled(false);
        }
         if (desember.isSelected()) {
            jumlahBulanDipilih++;
//            bulanLunas.append("Desember, ");
             String StatusPembayaran = "Lunas";
            tableModel.addRow(new Object[]{"Desember", StatusPembayaran});
            desember.setEnabled(false);
        } 
         
         
        
        int totalPembayaran = jumlahBulanDipilih * jumlahspp; 
        String statusPembayaran ="";

        if (jumlahBulanDipilih == 12) {
            statusPembayaran = "Lunas";
        } else {
            statusPembayaran = "Menunggak";
        }
        
       
//        tableModel.addRow(new Object[]{namaInput, bulanLunas.toString(), statusPembayaran});

        
        total.setText(String.valueOf(totalPembayaran));
        status.setText(statusPembayaran);
        
        nama.setEditable(false);
        spp.setEditable(false);
        
        
    }//GEN-LAST:event_bayarActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        januari.setSelected(false);
        januari.setEnabled(true);

        desember.setSelected(false);
        desember.setEnabled(true);

        februari.setSelected(false);
        februari.setEnabled(true);

        maret.setSelected(false);
        maret.setEnabled(true);

        april.setSelected(false);
        april.setEnabled(true);

        mei.setSelected(false);
        mei.setEnabled(true);

        juni.setSelected(false);
        juni.setEnabled(true);

        juli.setSelected(false);
        juli.setEnabled(true);

        agustus.setSelected(false);
        agustus.setEnabled(true);

        september.setSelected(false);
        september.setEnabled(true);

        oktober.setSelected(false);
        oktober.setEnabled(true);

        november.setSelected(false);
        november.setEnabled(true);
        
        nama.setText("");
        nama.setEditable(true);
        spp.setText("");
        spp.setEditable(true);
        total.setText("");
        status.setText("");

        
        tableModel.setRowCount(0); 
    }//GEN-LAST:event_resetActionPerformed

    private void riwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_riwayatActionPerformed
        // TODO add your handling code here:
        StringBuilder riwayatPembayaran = new StringBuilder("=== Riwayat Pembayaran ===\n\n");
        riwayatPembayaran.append("Nama: ").append(nama.getText()).append("\n");
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
//        
        String bulanBayar = tableModel.getValueAt(i, 0).toString();
        String jumlahSPP = total.getText();
        String statusBayar = tableModel.getValueAt(i, 1).toString();
        
          
            riwayatPembayaran.append("\nBulan Lunas: ").append(bulanBayar)
                    .append("\nTotal SPP: ").append(jumlahSPP)
                    .append("\nStatus: ").append(statusBayar)
                    .append("\n----------------------\n");
        

        }
        JTextArea textArea = new JTextArea(riwayatPembayaran.toString());
        textArea.setEditable(false);          
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));


        JOptionPane.showMessageDialog(null, scrollPane, "Riwayat Pembayaran", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_riwayatActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        int exit = JOptionPane.showConfirmDialog(null,"Akhiri Program?","Exit",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void ttlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttlActionPerformed
        // TODO add your handling code here:
        if (spp.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Masukkan jumlah spp terlebih dahulu", "Error", 
                JOptionPane.ERROR_MESSAGE);
        } 
        int jumlahspp = Integer.parseInt(spp.getText());
         int jumlahBulanDipilih = 0;
         int totalPembayaran = 0;
        
        if (januari.isSelected()) {
            jumlahBulanDipilih++;
          
        }
        if (februari.isSelected()) {
            jumlahBulanDipilih++;
        } 
        if (maret.isSelected()) {
            jumlahBulanDipilih++;     
        }
        if (april.isSelected()) {
            jumlahBulanDipilih++;     
        }
        if (mei.isSelected()) {
            jumlahBulanDipilih++; 
        }
        if (juni.isSelected()) {
            jumlahBulanDipilih++;
        }
        if (juli.isSelected()) {
            jumlahBulanDipilih++;  
        }
        if (agustus.isSelected()) {
            jumlahBulanDipilih++;  
        }
        if (september.isSelected()) {
            jumlahBulanDipilih++;  
        }
        if (oktober.isSelected()) {
            jumlahBulanDipilih++; 
        }
        if (november.isSelected()) {
            jumlahBulanDipilih++;   
        }
         if (desember.isSelected()) {
            jumlahBulanDipilih++;  
         }
            
          totalPembayaran = jumlahBulanDipilih * jumlahspp;
          
          total.setText(String.valueOf(totalPembayaran));
    }//GEN-LAST:event_ttlActionPerformed

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
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new spp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox agustus;
    private javax.swing.JCheckBox april;
    private javax.swing.JButton bayar;
    private javax.swing.JCheckBox desember;
    private javax.swing.JButton exit;
    private javax.swing.JCheckBox februari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox januari;
    private javax.swing.JCheckBox juli;
    private javax.swing.JCheckBox juni;
    private javax.swing.JCheckBox maret;
    private javax.swing.JCheckBox mei;
    private javax.swing.JTextField nama;
    private javax.swing.JCheckBox november;
    private javax.swing.JCheckBox oktober;
    private javax.swing.JPanel pInformasi;
    private javax.swing.JPanel pNama;
    private javax.swing.JPanel pSPP;
    private javax.swing.JPanel pTengah;
    private javax.swing.JPanel panelatas;
    private javax.swing.JPanel panelbawah;
    private javax.swing.JButton reset;
    private javax.swing.JButton riwayat;
    private javax.swing.JCheckBox september;
    private javax.swing.JTextField spp;
    private javax.swing.JTextField status;
    private javax.swing.JTable tabelData;
    private javax.swing.JTextField total;
    private javax.swing.JButton ttl;
    // End of variables declaration//GEN-END:variables
}
