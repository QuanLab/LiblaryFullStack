package interfaces.login;

import interfaces.admin.AdminFrame;
import interfaces.user.UserFrame;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import resource.Constant;

public class Login extends javax.swing.JFrame {

    private String idUser;
    private String username;
    private String password;

    private Vector bookStoreData;
    private Vector manageAccountData;
    private Vector bookRequestData;
    private Vector bookBorrowedData;
    private Vector studentBorrowedData;

    private Vector dataSearchBookStore;

    private AdminFrame admin;
    private UserFrame userFrame;

    //client variable
    private final String host;
    private final int port;
    private Socket client;

    private ObjectInputStream ois;
    private ObjectOutputStream ous;

    private static Login login;

    public Login(String host, int port) {

        this.host = host;
        this.port = port;
        this.connect();
        initComponents();
        setLocation(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

        login = new Login("localhost", 1105);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLogin.setText("Đăng nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tên đăng nhập");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mật khẩu");

        tfUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogin)
                        .addGap(33, 33, 33)
                        .addComponent(btnExit)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(tfUsername))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExit, btnLogin});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnLogin))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        username = tfUsername.getText().trim();
        password = new String(tfPassword.getPassword());

        Vector dataSend = new Vector();
        dataSend.addElement(Constant.LOGIN);
        dataSend.addElement(username);
        dataSend.addElement(password);

        try {
            System.out.println("Sending: " + dataSend);
            ous.writeObject(dataSend);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void connect() {

        try {
            client = new Socket(host, port);
            System.out.println("Socket has established");

            ous = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());

        } catch (IOException e) {
            System.out.println("Cannot connect to server!");
        }
        new DataResponse().start();
    }

    public class DataResponse extends Thread {

        @Override
        public void run() {

            try {

                Vector dataReceive;

                while ((dataReceive = getDataFromServer()) != null) {

                    System.out.println("Client nhan du lieu:" + dataReceive);

                    int responseCheck = (int) dataReceive.get(0);

                    System.out.println(responseCheck);

                    switch (responseCheck) {

                        case Constant.LOGIN:

                            int checkDone = (int) dataReceive.get(1);

                            if (checkDone == Constant.SUCCESS) {

                                int userType = (int) dataReceive.get(2);
                                    idUser = (String) dataReceive.get(3);
                                if (userType == Constant.ADMIN) {
                                    
                                    admin = new AdminFrame(login);
                                    login.setVisible(false);
                                    dataReceive.clear();

                                } else if (userType == Constant.CLIENT) {
                                    
                                    userFrame = new UserFrame(login);
                                    login.setVisible(false);
                                    dataReceive.clear();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hặc mật khẩu!");
                            }

                            break;

                        case Constant.LOAD:

                            System.out.println("LOAD IS OK");
                            int checkTable = (int) dataReceive.get(1);

                            if (checkTable == Constant.BOOKS_STORE_TABLE) {

                                bookStoreData = dataReceive;
                                bookStoreData.removeElementAt(0);
                                bookStoreData.removeElementAt(0);
                                //System.out.println("Client nhan duoc BOOKS_STORE_TABLE2:" + bookStoreData);
                            } else if (checkTable == Constant.BORROWED_BOOK_TABLE) {

                                bookBorrowedData = dataReceive;
                                bookBorrowedData.removeElementAt(0);
                                bookBorrowedData.removeElementAt(0);
                                //System.out.println("Client nhan duoc book_borrowed2:" + bookBorrowedData);
                            } else if (checkTable == Constant.TABLE_USER) {

                                manageAccountData = dataReceive;
//                                System.out.println("Client nhan duoc TABLE_USER:" + manageAccountData);
                                manageAccountData.removeElementAt(0);
                                manageAccountData.removeElementAt(0);

                            } else if (checkTable == Constant.STUDENT_BORROWED) {

                                studentBorrowedData = dataReceive;
//                                System.out.println("Client nhan duoc STUDENT_BORROWED:" + studentBorrowedData);
                                studentBorrowedData.removeElementAt(0);
                                studentBorrowedData.removeElementAt(0);
                            } else if (checkTable == Constant.REQUEST_TABLE) {

                                bookRequestData = dataReceive;
//                                System.out.println("Client nhan duoc REQUEST_TABLE:" + bookRequestData);
                                bookRequestData.removeElementAt(0);
                                bookRequestData.removeElementAt(0);
                            }
                            break;

                        case Constant.UPDATE:

                            System.out.println("UPDATE RESPONSE CATCH!!");

                            if ((int) dataReceive.get(1) == Constant.SUCCESS) {

                                JOptionPane.showMessageDialog(null, "Sucesses Update!");
                            } else {

                                JOptionPane.showMessageDialog(null, "Update failed!");
                            }
                            break;

                        case Constant.REQUEST_BORROW:

                            System.out.println("BORROW RESPONSE CATCH!!");

                            if ((int) dataReceive.get(1) == Constant.SUCCESS) {

                                JOptionPane.showMessageDialog(null, "Sucesses Update!");
                            } else {

                                JOptionPane.showMessageDialog(null, "Update failed!");
                            }
                            break;
                        case Constant.ACCEPT_REQUEST:

                            System.out.println("ACCEPT_REQUEST RESPONSE CATCH!!");

                            if ((int) dataReceive.get(1) == Constant.SUCCESS) {

                                JOptionPane.showMessageDialog(null, "Sucesses Update!");
                            } else {

                                JOptionPane.showMessageDialog(null, "Update failed!");
                            }
                            break;
                        
                         case Constant.RETURN:

                            System.out.println("UPDATE RESPONSE CATCH!!");

                            if ((int) dataReceive.get(1) == Constant.SUCCESS) {

                                JOptionPane.showMessageDialog(null, "Sucesses Update!");
                            } else {

                                JOptionPane.showMessageDialog(null, "Update failed!");
                            }
                            break;

                        case Constant.INSERT:

                            System.out.println("INSERT RESPONSE CATCH!!");

                            if ((int) dataReceive.get(1) == Constant.SUCCESS) {
                                JOptionPane.showMessageDialog(null, "Insert Sucesses!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Insert failed!");
                            }
                            break;

                        case Constant.DELETE:

                            System.out.println("DELETE RESPONSE CATCH!!");

                            if ((int) dataReceive.get(1) == Constant.SUCCESS) {
                                JOptionPane.showMessageDialog(null, "DELETE Sucesses!");
                            } else {
                                JOptionPane.showMessageDialog(null, "DELETE failed!");
                            }
                            break;

                        case Constant.SEARCH:

                            System.out.println("SEARCH catch!");

                            dataSearchBookStore = dataReceive;
                            dataSearchBookStore.removeElementAt(0);
                            break;

                        default:
                            System.out.println("Do nothing on handle client!");
                    }
                }

            } catch (Exception ex) {
                System.out.println("In data response " + ex);
            }
        }

        public Vector getDataFromServer() {

            Vector data = null;
            try {
                data = (Vector) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);
            }
            return data;
        }
    }

    public void sendRequest(Vector data) {

        try {
            ous.writeObject(data);
            ous.flush();

        } catch (IOException e) {
        }
    }

    public Vector getBookStoreData() {
        return bookStoreData;
    }

    public Vector getBookRequestData() {
        return bookRequestData;
    }

    public Vector getBookBorrowedData() {
        return bookBorrowedData;
    }

    public Vector getManageAccountData() {
        return manageAccountData;
    }

    public String getUserName() {
        return username;
    }

    public int getPasswordHash() {
        return password.hashCode();
    }

    public String getIdUser() {
        return idUser;
    }

    public AdminFrame getAdminFrame() {
        return admin;
    }

    public UserFrame getUserFrame() {
        return userFrame;
    }

    public Vector getDataSearchBookStore() {
        return dataSearchBookStore;
    }

    public Vector getStudentBorrowedData() {
        return studentBorrowedData;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
