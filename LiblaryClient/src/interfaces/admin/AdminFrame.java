package interfaces.admin;

import interfaces.login.Login;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class AdminFrame extends javax.swing.JFrame {

    private BookBorrowedReturn borowReturn;
    private BookStore bookStore;
    private ManageAccount manageAccount;
    private Login login;

    public AdminFrame(Login login) {
        this.login = login;
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(350, 50);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mCategory = new javax.swing.JMenu();
        miBookStore = new javax.swing.JMenuItem();
        miManageAccount = new javax.swing.JMenuItem();
        miUser = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phầm mềm quản lý thư viện");
        setLocation(new java.awt.Point(400, 200));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book.PNG"))); // NOI18N
        jButton1.setText("Quản lý sách");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/users.PNG"))); // NOI18N
        jButton2.setText("Quản lý tài khoản");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/request.png"))); // NOI18N
        jButton3.setText("Yêu cầu mượn sách");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        jButton4.setText("Thoát");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/liblary.jpg"))); // NOI18N
        jLabel1.setLabelFor(this);

        mCategory.setMnemonic('f');
        mCategory.setText("Tùy chọn");

        miBookStore.setText("Quản lý sách");
        miBookStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBookStoreActionPerformed(evt);
            }
        });
        mCategory.add(miBookStore);

        miManageAccount.setText("Quản lý tài khoản");
        miManageAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miManageAccountActionPerformed(evt);
            }
        });
        mCategory.add(miManageAccount);

        miUser.setMnemonic('o');
        miUser.setText("Yêu cầu mượn sách");
        miUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUserActionPerformed(evt);
            }
        });
        mCategory.add(miUser);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Thoát");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        mCategory.add(exitMenuItem);

        menuBar.add(mCategory);

        jMenu1.setText("About");
        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void miUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUserActionPerformed

        try {
            //yeu cau muon sach
            borowReturn = new BookBorrowedReturn(login);

        } catch (ClassNotFoundException | InstantiationException ex) {
            Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miUserActionPerformed

    private void miBookStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBookStoreActionPerformed

        try {
            bookStore = new BookStore(login);

        } catch (ClassNotFoundException | InstantiationException ex) {
            Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miBookStoreActionPerformed

    private void miManageAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miManageAccountActionPerformed
        manageAccount = new ManageAccount(login);
    }//GEN-LAST:event_miManageAccountActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu mCategory;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miBookStore;
    private javax.swing.JMenuItem miManageAccount;
    private javax.swing.JMenuItem miUser;
    // End of variables declaration//GEN-END:variables

}
