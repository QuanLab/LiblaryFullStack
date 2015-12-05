package server.main;

//package com.liblary.server;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//import java.util.Vector;
//
//public class HandleClientw extends Thread {
//
//    Socket socket;
//    ObjectInputStream ois;
//    ObjectOutputStream ous;
//    
//    private final int LOGIN_DONE = 0, LOGIN_FAILED = -1;
//
//    HandleClientw(Socket socket, ObjectOutputStream ous) {
//
//        this.socket = socket;
//
//        try {
//
//            this.ous = ous;
//            ois = new ObjectInputStream(socket.getInputStream());
//
//        } catch (Exception e) {
//            System.out.println("Canot start server!");
//        }
//    }
//
//    @Override
//    public void run() {
//
//        Vector dataResponse = new Vector();
//        Vector dataReceived;
//
//        try {
//            while ((dataReceived = getRequestMessage()) != null) {
//                System.out.println(dataReceived);
//                String request = (String) dataReceived.get(0);
//
//                if (request.equals("LOGIN")) {
//
//                    System.out.println("LOGIN CATCH!");
//                    String username = (String) dataReceived.get(1);
//                    String password = (String) dataReceived.get(2);
//                    String checkType;
//                    checkType = AuthenticationLogin.authLogin(username, password);
//
//                    System.out.println(checkType);
//
//                    if (checkType.equals("admin")) {
//                        dataResponse.addElement("LOGIN");
//                        dataResponse.addElement(LOGIN_DONE);
//                        dataResponse.addElement(checkType);
//                        sendResponseData(dataResponse);
//                        System.out.println(dataResponse);
//
//                    } else if (checkType.equals("client")) {
//
//                        dataResponse.addElement("LOGIN");
//                        dataResponse.addElement(LOGIN_DONE);
//                        dataResponse.addElement(checkType);
//                        sendResponseData(dataResponse);
//                        System.out.println(dataResponse);
//                    } else if (checkType == null) {
//                        dataResponse.addElement("LOGIN");
//                        dataResponse.addElement(LOGIN_FAILED);
//                    }
//
//                } else if (request.equals("LOAD_BOOK")) {
//
//                    dataResponse.add(ois);
//                    sendResponseData(dataResponse);
//                }
//
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public Vector getRequestMessage() {
//
//        Vector data = new Vector();
//        try {
//            data = (Vector) ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println(e);
//        }
//        return data;
//    }
//
//    public void sendResponseData(Vector data) {
//
//        try {
//            ous.writeObject(data);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//}
