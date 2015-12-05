package interfaces.user;

import resource.Constant;
import datetime.MyDateTime;
import interfaces.login.Login;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.write.DateTime;

public final class UserFrame extends javax.swing.JFrame {

    private Vector vectorRequest;
    private final Login login;
    private Vector bookStoreData;
    private Vector studentBorrowedData;
    
    private Vector dataSearchBookStore;

    private ChangePass changePass;

    public UserFrame(Login login) {

        this.login = login;
        initComponents();
        setLocation(350, 50);
        lbName.setText(login.getIdUser());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        tfSearch = new javax.swing.JTextField();
        cbSearch = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStudentBorred = new javax.swing.JTable();
        btnRequest = new javax.swing.JButton();
        lbName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfIdBook = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfBookName = new javax.swing.JTextField();
        tfDateReturn = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miChangePass = new javax.swing.JMenuItem();
        milLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblBook.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Tác giả", "Năm xuất bản"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBook);

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tfSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả", "Mã sách", "Tên sách", "Tên tác giả", "Năm xuất bản" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Sách đã mượn");

        tblStudentBorred.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblStudentBorred.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Tác giả", "Năm xuất bản"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblStudentBorred);

        btnRequest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRequest.setText("Gửi yêu cầu mượn");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        lbName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(255, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Xin chào:");

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRefresh.setText("Tải lại");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tfIdBook.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ngày hẹn trả");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tên sách");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã sách");

        tfBookName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfDateReturn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfDateReturn.setText("11-05-2016");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfDateReturn, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addComponent(tfBookName)
                    .addComponent(tfIdBook)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDateReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenu1.setText("Tùy chọn");

        miChangePass.setText("Đổi mật khẩu");
        miChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miChangePassActionPerformed(evt);
            }
        });
        jMenu1.add(miChangePass);

        milLogout.setText("Thoát");
        milLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                milLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(milLogout);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnRequest, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnSearch))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnRequest, btnSearch});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(87, 87, 87))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnRefresh, btnRequest, btnSearch});

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void tblBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookMouseClicked

        int rowSelected = tblBook.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblBook.getModel();
        String idBook = (String) model.getValueAt(rowSelected, 0);
        String bookName = (String) model.getValueAt(rowSelected, 1);

        tfIdBook.setText(idBook);
        tfBookName.setText(bookName);

    }//GEN-LAST:event_tblBookMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        Vector request = new Vector();
        request.addElement(Constant.SEARCH);
        
//      request.addElement(Constant.BOOKS_STORE_TABLE);
        
        request.addElement(tfSearch.getText().trim());
        
        int option = cbSearch.getSelectedIndex();
        
        if(option == 0){
            request.addElement(Constant.OPTION_ALL);
        } else if(option == 1){
            request.addElement(Constant.OPTION_ID_BOOK);
        }else if(option == 2){
            request.addElement(Constant.OPTION_BOOK_NAME);
        }else if(option == 3){
            request.addElement(Constant.OPTION_AUTHOR);
        }else if(option == 4){
            request.addElement(Constant.OPTION_DATE);
        }
        
        login.sendRequest(request);
        
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        dataSearchBookStore = login.getDataSearchBookStore();

        Vector cols = new Vector();

        for (int i = 0; i < tblBook.getColumnCount(); i++) {
            cols.addElement(tblBook.getModel().getColumnName(i));
        }

        //System.out.println("BOOK_STORE DATA\n" + bookStoreData);
        tblBook.setModel(new DefaultTableModel( dataSearchBookStore, cols));
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed

        int option = JOptionPane.showConfirmDialog(null, "Xác nhận mượn" + tfIdBook.getText(),
                "Xác nhận", JOptionPane.YES_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            
            while(tfDateReturn.getText().trim()==null||tfDateReturn.getText().trim().equals("")){
               
                tfDateReturn.setText(MyDateTime.setDateTime(11, 05, 2016));
                
            }
            vectorRequest = new Vector();
            vectorRequest.addElement(Constant.REQUEST_BORROW);

            vectorRequest.addElement(login.getIdUser());
            vectorRequest.addElement(tfIdBook.getText());
            vectorRequest.addElement(tfDateReturn.getText());

            login.sendRequest(vectorRequest);
        }
    }//GEN-LAST:event_btnRequestActionPerformed

    private void miChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miChangePassActionPerformed

        try {
            changePass = new ChangePass(login);
        } catch (ClassNotFoundException | InstantiationException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_miChangePassActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadBookStoreData();
        loadStudentBorrowedData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void milLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_milLogoutActionPerformed
        System.exit(0);
    }//GEN-LAST:event_milLogoutActionPerformed

    public void loadBookStoreData() {

        Vector request = new Vector();
        request.addElement(Constant.LOAD);
        request.addElement(Constant.BOOKS_STORE_TABLE);
        request.addElement(login.getIdUser());
        System.out.println("Sending request.......");
        login.sendRequest(request);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        bookStoreData = login.getBookStoreData();

        Vector cols = new Vector();

        for (int i = 0; i < tblBook.getColumnCount(); i++) {
            cols.addElement(tblBook.getModel().getColumnName(i));
        }

        System.out.println("BOOK_STORE DATA\n" + bookStoreData);

        tblBook.setModel(new DefaultTableModel(bookStoreData, cols));
    }

    private void loadStudentBorrowedData() {

        Vector request = new Vector();
        request.addElement(Constant.LOAD);
        request.addElement(Constant.STUDENT_BORROWED);
        request.addElement(login.getIdUser());

        login.sendRequest(request);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }

        studentBorrowedData = login.getStudentBorrowedData();

        Vector cols = new Vector();
        
        for (int i = 0; i < tblStudentBorred.getColumnCount(); i++) {
            cols.addElement(tblStudentBorred.getModel().getColumnName(i));
        }

        System.out.println("BOOK_BORROWED DATA\n" + studentBorrowedData);
        tblStudentBorred.setModel(new DefaultTableModel(studentBorrowedData, cols));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbName;
    private javax.swing.JMenuItem miChangePass;
    private javax.swing.JMenuItem milLogout;
    private javax.swing.JTable tblBook;
    private javax.swing.JTable tblStudentBorred;
    private javax.swing.JTextField tfBookName;
    private javax.swing.JTextField tfDateReturn;
    private javax.swing.JTextField tfIdBook;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
