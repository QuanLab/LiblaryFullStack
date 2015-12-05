package client;

import interfaces.login.Login;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JOptionPane;


public class Client {

    private final String host;
    private final int port;
    private Socket client;

    private static Login login;

    private ObjectInputStream ois;
    private ObjectOutputStream ous;

    public Client(String host, int port) {

        this.host = host;
        this.port = port;
        this.connect();
    }

    public static void main(String[] args) {
        Client myClient = new Client("localhost", 1105);
    }

    private void connect() {

        try {

            client = new Socket(host, port);
            System.out.println("Socket has established");

            ous = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());

            new DataResponse(this, ois).start();

        } catch (IOException e) {
            System.out.println("Cannot connect to server!");
        }
    }

    public class DataResponse extends Thread {

        private final ObjectInputStream ois;
        private ObjectOutputStream ous;
        private final Client client;

        private final int LOGIN_DONE = 0, LOGIN_FAILED = -1;

        public DataResponse(Client client, ObjectInputStream ois) {
            this.ois = ois;
            this.client = client;
        }

        @Override
        public void run() {

            try {

                Vector dataReceive;
                String responseCheck;

                while ((dataReceive = getDataFromServer()) != null) {

                    System.out.println(dataReceive);

                    responseCheck = (String) dataReceive.get(0);
                    
                    System.out.println(responseCheck);

                    switch (responseCheck) {

                        case "LOGIN":
                            int checkDone = (int) dataReceive.get(1);

                            if (checkDone == LOGIN_DONE) {

                                String userType = (String) dataReceive.get(2);

                                if (userType.equals("admin")) {
                                } else {
                                }
                            } else if (checkDone == LOGIN_FAILED) {
                                JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hặc mật khẩu!");
                            }

                            break;
                        case "LOAD":

                            break;
                        case "UPDATE":

                            break;
                        default:
                        //do somthing in the future......
                    }
                }

            } catch (Exception ex) {
                System.out.println(ex);
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

        public void sendRequestToServer(Vector data) {

            try {
                ous.writeObject(data);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void sendRequest(Vector data) {
        try {
            ous.writeObject(data);
            ous.flush();
        } catch (IOException e) {
        }
    }

    public Vector getDataReceived() {

        Vector data = new Vector();
        try {
            data = (Vector) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        return data;
    }

    public static Login getLogin() {
        return login;
    }
    
    public ObjectOutputStream getObjecOutputStream(){
        return ous;
    }
}
