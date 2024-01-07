/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

/**
 *
 * @author M. Salman Muliya 2110010012
 */
import java.sql.*;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class frm3 extends javax.swing.JFrame {

    /**
     * Creates new form frm3
     */
    public Statement st;
    public ResultSet rs;
    Connection kon = Config.classKoneksi.BukaKoneksi();
    public frm3() {
        initComponents();
        Bersih();
        TampilData();        
    }
    private void Bersih(){
               
        tno.setText("");
        t1.setText("");
        t2.setText("");        
        t3.setText(""); 
        t4.setText(""); 
        
        dTanggal1.setEnabled(false);        
        tno.setEnabled(false);
        t1.setEnabled(false);
        t2.setEnabled(false);
        t3.setEnabled(false);
        t4.setEnabled(false);
        

        
        bCari1.setEnabled(false);
        bTambah.setEnabled(true);
        bUbah.setEnabled(false);
        bHapus.setEnabled(false);
        bBatal.setEnabled(false);
        bSimpan.setEnabled(false);
        bKeluar.setEnabled(true);
        
        tbl1.setEnabled(true);
        dCari.setEnabled(true);
        bCari.setEnabled(true);
        bRefresh.setEnabled(true);
        
    }
    
   private void TampilData(){
        try {
            st = kon.createStatement();
            String sql = "SELECT * FROM pendaftaran";
            rs = st.executeQuery(sql);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("No Pendaftaran");
            model.addColumn("Tanggal");
            model.addColumn("NIK");
            model.addColumn("Nama Calon Siswa");
            model.addColumn("Kode");
            model.addColumn("Jenis Pendaftaran");
            
            int no = 1;   
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object[] data = {                    
                    no++,
                    rs.getString("nopendaftaran"),
                    rs.getString("tanggal"),                    
                    rs.getString("nik"),
                    rs.getString("nama"),
                    rs.getString("kode"),
                    rs.getString("jenispendaftaran")
                };    
                model.addRow(data);
                tbl1.setModel(model);
            }
        } catch (Exception e) {
        }
    }
    private void CariDataCalon(){
        try {
            st = kon.createStatement();
            String sql = "SELECT * FROM calon WHERE nik = '"+t1.getText()+"'";
            rs = st.executeQuery(sql);                                    
            if (rs.next()) {
                t1.setText(rs.getString("nik"));  
                t2.setText(rs.getString("nama"));                  
                t3.requestFocus();
                
            } else {
                JOptionPane.showMessageDialog(null, "Maaf nik calon siswa tidak ditemukan","Validasi",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (Exception e) {
        }
    }
    
    private void CariDataJenis(){
        try {
            st = kon.createStatement();
            String sql = "SELECT * FROM jenispendaftaran WHERE kode = '"+t3.getText()+"'";
            rs = st.executeQuery(sql);                                    
            if (rs.next()) {
                t3.setText(rs.getString("kode"));  
                t4.setText(rs.getString("nama"));                  
                bSimpan.requestFocus();
                
            } else {
                JOptionPane.showMessageDialog(null, "Maaf kode jenis pendaftaran tidak ditemukan","Validasi",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (Exception e) {
        }
    }
    
    private void CariData(){
        try {
            st = kon.createStatement();
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(dCari.getDate()));           
            String sql = "SELECT * FROM pendaftaran WHERE tanggal = '"+tanggal+"%'";
            rs = st.executeQuery(sql);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("No Pendaftaran");
            model.addColumn("Tanggal");
            model.addColumn("NIK");
            model.addColumn("Nama Calon Siswa");
            model.addColumn("Kode");
            model.addColumn("Jenis Pendaftaran");
            
            int no = 1;   
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object[] data = {                    
                    no++,
                    rs.getString("nopendaftaran"),
                    rs.getString("tanggal"),                    
                    rs.getString("nik"),
                    rs.getString("nama"),
                    rs.getString("kode"),
                    rs.getString("jenispendaftaran")
                };    
                model.addRow(data);
                tbl1.setModel(model);
            }
        } catch (Exception e) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dTanggal1 = new com.toedter.calendar.JDateChooser();
        t1 = new javax.swing.JTextField();
        bCari1 = new javax.swing.JButton();
        t2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        t3 = new javax.swing.JTextField();
        bTambah = new javax.swing.JButton();
        bUbah = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        bKeluar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        dCari = new com.toedter.calendar.JDateChooser();
        bCari = new javax.swing.JButton();
        bRefresh = new javax.swing.JButton();
        bCetak = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tno = new javax.swing.JTextField();
        bCari2 = new javax.swing.JButton();
        t4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("PENDAFTARAN SISWA BARU");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tanggal");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("NIK");

        jLabel4.setText("Nama Calon Siswa");

        dTanggal1.setDateFormatString("d MMM, yyyy");

        bCari1.setText("Cari Calon Siswa");
        bCari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCari1ActionPerformed(evt);
            }
        });

        t2.setEnabled(false);

        jLabel6.setText("Kode Jenis Pendaftaran");

        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bUbah.setText("Ubah");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bBatal.setText("Batal");
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        bSimpan.setText("Simpan");
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        bKeluar.setText("Keluar");
        bKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKeluarActionPerformed(evt);
            }
        });

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "No Pendaftaran", "Tanggal", "NIK", "Nama Calon Siswa", "Kode", "Jenis Pendaftaran"
            }
        ));
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl1);

        jLabel7.setText("Cari Tanggal");

        dCari.setDateFormatString("d MMM, yyyy");

        bCari.setText("Cari Data");
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        bRefresh.setText("Refresh");
        bRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshActionPerformed(evt);
            }
        });

        bCetak.setText("Cetak");
        bCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCetakActionPerformed(evt);
            }
        });

        jLabel5.setText("No Pendaftaran");

        bCari2.setText("Cari Jenis Pendaftaran");
        bCari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCari2ActionPerformed(evt);
            }
        });

        t4.setEnabled(false);

        jLabel8.setText("Jenis Pendaftaran");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addComponent(dCari, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bCari)
                        .addGap(18, 18, 18)
                        .addComponent(bRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCetak))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(bTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bBatal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bKeluar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)
                        .addComponent(jLabel8))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bCari2))
                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(125, 125, 125))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dTanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tno, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bCari1)))
                    .addGap(93, 93, 93)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dTanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCari1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(bCari2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bUbah)
                    .addComponent(bHapus)
                    .addComponent(bBatal)
                    .addComponent(bSimpan)
                    .addComponent(bKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bCari)
                        .addComponent(bRefresh)
                        .addComponent(bCetak))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCari1ActionPerformed
        // TODO add your handling code here:
        CariDataCalon();
        
    }//GEN-LAST:event_bCari1ActionPerformed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        dTanggal1.setEnabled(true);               
        tno.setEnabled(true);
        t1.setEnabled(true);
        t2.setEnabled(false);        
        t3.setEnabled(true); 
        t4.setEnabled(false); 
        dTanggal1.requestFocus();
        
        bCari1.setEnabled(true);
        bTambah.setEnabled(true);        
        bUbah.setEnabled(false);
        bHapus.setEnabled(false);
        bBatal.setEnabled(true);
        bSimpan.setEnabled(true);
        bKeluar.setEnabled(false);
        
        tbl1.setEnabled(false);
        dCari.setEnabled(false);
        bCari.setEnabled(false);
        bRefresh.setEnabled(false);
    }//GEN-LAST:event_bTambahActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        // TODO add your handling code here:
        dTanggal1.setEnabled(true);        
        tno.setEnabled(true);
        t1.setEnabled(true);
        t2.setEnabled(false);        
        t3.setEnabled(true);        
        dTanggal1.requestFocus();
        
        bCari1.setEnabled(true);
        bTambah.setEnabled(false);
        bUbah.setEnabled(true);
        bHapus.setEnabled(false);
        bBatal.setEnabled(true);
        bSimpan.setEnabled(true);
        bKeluar.setEnabled(false);
        
        tbl1.setEnabled(false);
        dCari.setEnabled(false);
        bCari.setEnabled(false);
        bRefresh.setEnabled(false);
    }//GEN-LAST:event_bUbahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
         if (tno.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Mohon pilih data yang ingin dihapus terlebih dahulu");
        } else {
            int jawab = JOptionPane.showConfirmDialog(null, "Apakah yakin data pendaftaran ini akan dihapus?","Konfirmasi",JOptionPane.YES_NO_OPTION);
            if (jawab==0) {
                try {
                   
                    st = kon.createStatement();
                    String hapus = "DELETE FROM pendaftaran WHERE nopendaftaran='"+tno.getText()+"'";
                    st.execute(hapus);
                    JOptionPane.showMessageDialog(null, "Data pendaftaran berhasil dihapus");
                    Bersih();
                    TampilData();                                                
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_bHapusActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        // TODO add your handling code here:
        Bersih();
        TampilData();
    }//GEN-LAST:event_bBatalActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        int jawab = JOptionPane.showConfirmDialog(null, "Apakah yakin menyimpan data?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (jawab==0) {
            try {
                st = kon.createStatement(); 
                Date cektanggal;
                cektanggal = dTanggal1.getDate();
                if (cektanggal == null || tno.getText().equals("") || t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")|| t4.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Data tidak boleh kosong","Validasi",JOptionPane.ERROR_MESSAGE);
                    return;                
                }            
                if (bTambah.isEnabled()) {
                    //cek                    
                    String ceksurat = "SELECT * FROM pendaftaran WHERE nopendaftaran='"+tno.getText()+"'";
                    rs = st.executeQuery(ceksurat);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Maaf no surat sudah ada");                    
                    } else {
                        //insert    
                        String tampilan = "yyyy-MM-dd";
                        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
                        String tanggal = String.valueOf(fm.format(dTanggal1.getDate()));
                        
                        String sql = "INSERT INTO pendaftaran (tanggal,nopendaftaran,nik,nama,kode,jenispendaftaran) VALUES ('"+tanggal+                                 
                                "','"+tno.getText()+
                                "','"+t1.getText()+  
                                "','"+t2.getText()+  
                                "','"+t3.getText()+  
                                 "','"+t4.getText()+"')";
                         st.executeUpdate(sql);
                        
                        JOptionPane.showMessageDialog(null, "Berhasil menambah data");
                        Bersih();
                        TampilData();
                    }

                } else if (bUbah.isEnabled()) {
                     //update                    
                     String tampilan = "yyyy-MM-dd";
                     SimpleDateFormat fm = new SimpleDateFormat(tampilan);
                     String tanggal = String.valueOf(fm.format(dTanggal1.getDate()));
                        
                     String sql = "UPDATE pendaftaran SET tanggal = '"+tanggal+                                                    
                            "', kode = '"+t3.getText()+
                             "', jenispendaftaran = '"+t4.getText()+
                            "' WHERE nopendaftaran = '"+tno.getText()+"'";
                    st.executeUpdate(sql);
                    
                    JOptionPane.showMessageDialog(null, "Berhasil mengubah data");
                    Bersih();
                    TampilData();

                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_bSimpanActionPerformed

    private void bKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bKeluarActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        // TODO add your handling code here:
        try {
                DefaultTableModel model = (DefaultTableModel)tbl1.getModel();
                int index = tbl1.getSelectedRow();
                Date date = new SimpleDateFormat("yyyy-mm-dd").parse((String)model.getValueAt(index,1));
                dTanggal1.setDate(date);
            } catch (Exception e) {
            }
         tno.setText(tbl1.getValueAt(tbl1.getSelectedRow(),2).toString());
        if (!tno.getText().equals("")) {
            tno.setText(tbl1.getValueAt(tbl1.getSelectedRow(),1).toString());            
            t1.setText(tbl1.getValueAt(tbl1.getSelectedRow(),3).toString());
            t3.setText(tbl1.getValueAt(tbl1.getSelectedRow(),4).toString());            
            CariDataCalon();

            bCari1.setEnabled(false);
            bTambah.setEnabled(false);
            bUbah.setEnabled(true);
            bHapus.setEnabled(true);
            bBatal.setEnabled(true);
            bSimpan.setEnabled(false);
            bKeluar.setEnabled(false);   
        }
    }//GEN-LAST:event_tbl1MouseClicked

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        // TODO add your handling code here:
        CariData();
    }//GEN-LAST:event_bCariActionPerformed

    private void bRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshActionPerformed
        // TODO add your handling code here:
        Bersih();
        TampilData();
    }//GEN-LAST:event_bRefreshActionPerformed

    private void bCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetakActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Laporan Pendaftaran Siswa Baru");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try{
            tbl1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Gagal mencetak %s%n", e.getMessage());
        }
    }//GEN-LAST:event_bCetakActionPerformed

    private void bCari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCari2ActionPerformed
        // TODO add your handling code here:
        CariDataJenis();
    }//GEN-LAST:event_bCari2ActionPerformed

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
            java.util.logging.Logger.getLogger(frm3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bCari1;
    private javax.swing.JButton bCari2;
    private javax.swing.JButton bCetak;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bKeluar;
    private javax.swing.JButton bRefresh;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bUbah;
    private com.toedter.calendar.JDateChooser dCari;
    private com.toedter.calendar.JDateChooser dTanggal1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField tno;
    // End of variables declaration//GEN-END:variables
}
