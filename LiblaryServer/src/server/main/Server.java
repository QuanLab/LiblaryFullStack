package server.main;

import server.connection.Constant;
import server.connection.ServerProcessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Server extends JFrame implements ActionListener {

    private final int port;
    private ServerSocket serverSock;

    ArrayList clientInputStream;
    ArrayList<String> users;
    ObjectOutputStream oustream;

    public Server(int port) {

        this.port = port;
        addButton();
        setSize(100, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {

            serverSock = new ServerSocket(port);
            System.out.println("Server ready!");

            while (true) {

                Socket clientSock = serverSock.accept();
                oustream = new ObjectOutputStream(clientSock.getOutputStream());
                new HandleClient(clientSock, oustream).start();
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public class HandleClient extends Thread {

        Socket socket;
        ObjectInputStream ois;
        ObjectOutputStream ous;

        HandleClient(Socket socket, ObjectOutputStream ous) {

            this.socket = socket;

            try {
                this.ous = ous;
                ois = new ObjectInputStream(socket.getInputStream());

            } catch (Exception e) {
                System.out.println("Canot start server!");
            }
        }

        @Override
        public void run() {

            Vector dataResponse;
            Vector dataReceived;

            try {
                while ((dataReceived = getRequestFromClient()) != null) {

                    System.out.println("Retrieve data from object received: " + dataReceived);

                    int request = (int) dataReceived.get(0);

                    if (request == Constant.LOGIN) {

                        System.out.println("LOGIN CATCH!");
                        String username = (String) dataReceived.get(1);
                        String password = (String) dataReceived.get(2);

                        dataResponse = ServerProcessor.authLogin(username, password);

                        dataResponse.add(0, Constant.LOGIN);
                        
                        sendResponseData(dataResponse);

                    } else if (request == Constant.LOAD) {

                        System.out.println("LOAD CATCH!!!");

                        dataResponse = ServerProcessor.loadData(dataReceived);
                        dataResponse.insertElementAt(Constant.LOAD, 0);
                        System.out.println("Loading " + dataReceived.get(1));
                        dataResponse.insertElementAt(dataReceived.get(1), 1);
                        sendResponseData(dataResponse);
                        //System.out.println("Sending load to client: " + dataResponse);
                        dataResponse.clear();

                    } else if (request == Constant.INSERT) {

                        System.out.println("INSERT CATCH!!!!!");

                        dataResponse = new Vector();
                        dataResponse.addElement(Constant.INSERT);

                        if (ServerProcessor.insertData(dataReceived) == Constant.SUCCESS) {
                            dataResponse.addElement(Constant.SUCCESS);
                        } else {
                            dataResponse.addElement(Constant.FAILED);
                        }
                        sendResponseData(dataResponse);

                    } else if (request == Constant.UPDATE) {

                        System.out.println("UPDATE CATCH!!!!!");

                        dataResponse = new Vector();
                        dataResponse.addElement(Constant.UPDATE);

                        if (ServerProcessor.updateData(dataReceived) == Constant.SUCCESS) {
                            dataResponse.addElement(Constant.SUCCESS);
                        } else {
                            dataResponse.addElement(Constant.FAILED);
                        }
                        sendResponseData(dataResponse);

                    } else if (request == Constant.DELETE) {

                        System.out.println("DELETE CATCH!!!!!");

                        dataResponse = new Vector();
                        dataResponse.addElement(Constant.DELETE);

                        int tableCheck = (int) dataReceived.get(1);

                        if (ServerProcessor.deleteData(dataReceived) == Constant.SUCCESS) {
                            dataResponse.addElement(Constant.SUCCESS);
                        } else {
                            dataResponse.addElement(Constant.FAILED);
                        }

                        sendResponseData(dataResponse);

                    } else if (request == Constant.REQUEST_BORROW) {

                        dataResponse = new Vector();
                        dataResponse.addElement(Constant.REQUEST_BORROW);
                        System.out.println("Borrow requesting catch!!");

                        if (ServerProcessor.requestBorrow(dataReceived) == Constant.SUCCESS) {
                            dataResponse.addElement(Constant.SUCCESS);
                        } else {
                            dataResponse.addElement(Constant.FAILED);
                        }

                    } else if (request == Constant.ACCEPT_REQUEST) {

                        dataResponse = new Vector();
                        dataResponse.addElement(Constant.ACCEPT_REQUEST);
                        System.out.println("ACCEPT_REQUEST requesting catch!!");

                        if (ServerProcessor.acceptRequestBorrow(dataReceived) == Constant.SUCCESS) {
                            dataResponse.addElement(Constant.SUCCESS);
                        } else {
                            dataResponse.addElement(Constant.FAILED);
                        }

                    } else if (request == Constant.RETURN) {

                        dataResponse = new Vector();
                        dataResponse.addElement(Constant.RETURN);
                        System.out.println("ACCEPT_REQUEST requesting catch!!");

                        if (ServerProcessor.returnBook(dataReceived) == Constant.SUCCESS) {
                            dataResponse.addElement(Constant.SUCCESS);
                        } else {
                            dataResponse.addElement(Constant.FAILED);
                        }

                    }else if (request == Constant.SEARCH) {

                        System.out.println("SEARCH requesting catch!!");

                        String keyword = (String) dataReceived.get(1);
                        int option = (int) dataReceived.get(2);
                        dataResponse = ServerProcessor.searchData(keyword, option);
                        dataResponse.add(0, Constant.SEARCH);
                        sendResponseData(dataResponse);
                    }
                }

            } catch (Exception e) {
                System.out.println("In run handle client: " + e.getMessage());
            }
        }

        public Vector getRequestFromClient() {

            Vector data = new Vector();
            try {
                data = (Vector) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);
            }
            return data;
        }

        public void sendResponseData(Vector data) {

            try {
                ous.writeObject(data);
                System.out.println("Sending to client: " + data);
                ous.flush();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void addButton() {

        JButton btnClose = new JButton("Close Server");
        this.add(btnClose);
        btnClose.addActionListener(this);
    }

    public static void main(String[] args) throws SQLException {

        Server server = new Server(1105);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public void sendToAll(Vector message) {

        Iterator it = clientInputStream.iterator();

        while (it.hasNext()) {

            try {
                
                ObjectOutputStream ous = (ObjectOutputStream) it.next();
                ous.writeObject(message);
                ous.flush();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
