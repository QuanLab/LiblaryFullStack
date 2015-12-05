package interfaces.admin;

import resource.Constant;
import interfaces.login.Login;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public final class BookBorrowedReturn extends javax.swing.JFrame {

    private final Login login;
    private Vector bookRequestData;
    private Vector bookBorrowedData;

    public BookBorrowedReturn(Login login) throws ClassNotFoundException, InstantiationException {

        this.login = login;
        initComponents();
        this.setLocation(350, 50);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        tfIdBook = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfIdStudent = new javax.swing.JTextField();
        tfReturnDate = new javax.swing.JTextField();
        tfRequestDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScollPanel = new javax.swing.JScrollPane();
        tblBorrowed = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnChoMuon = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        btnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tfIdBook.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mã độc giả");

        tfIdStudent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfReturnDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfRequestDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã sách");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Ngày hẹn trả");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ngày mượn");

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRefresh.setText("Tải lại");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh(evt);
            }
        });

        tblBorrowed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sách", "Mã độc giả", "Ngày mượn", "Ngày hẹn trả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblBorrowed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBorrowedMouseClicked(evt);
            }
        });
        jScollPanel.setViewportView(tblBorrowed);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Sách đã mượn");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Yêu cầu mượn");

        btnChoMuon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnChoMuon.setText("Cho mượn");
        btnChoMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptRequestActionPerformed(evt);
            }
        });

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sách", "Mã độc giả", "Ngày mượn", "Ngày hẹn trả"
            }
        ));
        tblRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRequestMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblRequest);

        btnReturn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReturn.setText("Trả sách");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChoMuon))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScollPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnChoMuon, btnReturn});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnChoMuon, btnReturn});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfIdBook)
                            .addComponent(tfIdStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfRequestDate)
                            .addComponent(tfReturnDate, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfIdBook, tfIdStudent, tfRequestDate, tfReturnDate});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(tfIdBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRequestDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(tfIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBorrowedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBorrowedMouseClicked
        
        tblRequest.clearSelection();
        int rowSelected = tblBorrowed.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblBorrowed.getModel();
        String idBook = (String) model.getValueAt(rowSelected, 0);
        String idStudent = (String) model.getValueAt(rowSelected, 1);
        String dateBorrow = (String) model.getValueAt(rowSelected, 2);
        String dateReturn = (String) model.getValueAt(rowSelected, 3);

        tfIdBook.setText(idBook);
        tfIdStudent.setText(idStudent);
        tfRequestDate.setText(dateBorrow);
        tfReturnDate.setText(dateReturn);
    }//GEN-LAST:event_tblBorrowedMouseClicked

    
    private void tblRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRequestMouseClicked
        
        tblBorrowed.clearSelection();
        int rowSelected = tblRequest.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblRequest.getModel();
        
        String idBook = (String) model.getValueAt(rowSelected, 0);
        String idStudent = (String) model.getValueAt(rowSelected, 1);
        String dateBorrow = (String) model.getValueAt(rowSelected, 2);
        String dateReturn = (String) model.getValueAt(rowSelected, 3);

        tfIdBook.setText(idBook);
        tfIdStudent.setText(idStudent);
        tfRequestDate.setText(dateBorrow);
        tfReturnDate.setText(dateReturn);
    }//GEN-LAST:event_tblRequestMouseClicked

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        
        Vector request = new Vector();
        request.addElement(Constant.REQUEST_TABLE);
        request.addElement(Constant.BOOKS_STORE_TABLE);
        request.addElement(tfIdBook.getText().trim());
        request.addElement(tfIdStudent.getText().trim());
        login.sendRequest(request);
        
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnAcceptRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptRequestActionPerformed
        Vector request = new Vector();
        request.addElement(Constant.ACCEPT_REQUEST);
        request.addElement(Constant.BOOKS_STORE_TABLE);
        request.addElement(tfIdBook.getText().trim());
        request.addElement(tfIdStudent.getText().trim());
        login.sendRequest(request);
    }//GEN-LAST:event_btnAcceptRequestActionPerformed

    private void btnRefresh(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh
        loadBookRequestData();
        loadBookBorrowedData();
    }//GEN-LAST:event_btnRefresh

    private void loadBookRequestData() {

        Vector request = new Vector();
        request.addElement(Constant.LOAD);
        request.addElement(Constant.REQUEST_TABLE);

        login.sendRequest(request);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        bookRequestData = login.getBookRequestData();

        Vector cols = new Vector();

        for (int i = 0; i < tblRequest.getColumnCount(); i++) {
            cols.addElement(tblRequest.getModel().getColumnName(i));
        }

        //System.out.println("BOOK_STORE DATA\n" + bookStoreData);
        tblRequest.setModel(new DefaultTableModel(bookRequestData, cols));
    }

    private void loadBookBorrowedData() {

        Vector request = new Vector();
        request.addElement(Constant.LOAD);
        request.addElement(Constant.BORROWED_BOOK_TABLE);

        login.sendRequest(request);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        bookBorrowedData = login.getBookBorrowedData();

        Vector cols = new Vector();

        for (int i = 0; i < tblBorrowed.getColumnCount(); i++) {
            cols.addElement(tblBorrowed.getModel().getColumnName(i));
        }
        //System.out.println("BOOK_STORE DATA\n" + bookStoreData);
        tblBorrowed.setModel(new DefaultTableModel(bookBorrowedData, cols));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoMuon;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScollPanel;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblBorrowed;
    private javax.swing.JTable tblRequest;
    private javax.swing.JTextField tfIdBook;
    private javax.swing.JTextField tfIdStudent;
    private javax.swing.JTextField tfRequestDate;
    private javax.swing.JTextField tfReturnDate;
    // End of variables declaration//GEN-END:variables
}
