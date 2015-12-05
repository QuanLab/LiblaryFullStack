package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Quan-PC
 */
public class Response extends Thread {

    private final ObjectInputStream ois;
    private ObjectOutputStream ous;
    private final Client client;

    private final int LOGIN_DONE = 0, LOGIN_FAILED = -1;

    public Response(Client client, ObjectInputStream ois) {
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
                        }else if(checkDone==LOGIN_FAILED){
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
