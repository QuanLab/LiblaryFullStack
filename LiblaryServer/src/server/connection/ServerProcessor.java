package server.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ServerProcessor {

    public ServerProcessor() {

    }

    public static Vector authLogin(String username, String password) {

        Vector data = new Vector();
        
        try {
            DBConnection.connectDB();
            ResultSet resultSet;
            PreparedStatement pst;

            String sql = "SELECT * FROM user_data WHERE user_name =? AND user_pass =?;";

            pst = DBConnection.conn.prepareStatement(sql);

            pst.setString(1, username);
            pst.setString(2, password);

            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                
                data.addElement(Constant.SUCCESS);
                String userType = resultSet.getString("user_type");
                String idUser = resultSet.getString("idUser");

                if (userType.equals("admin")) {
                    data.addElement(Constant.ADMIN);
                    data.addElement(idUser);
                    return data;
                } else if (userType.equals("client")) {
                    data.addElement(Constant.CLIENT);
                    data.addElement(idUser);
                    return data;
                }
            }
            DBConnection.closeConnection();
        } catch (SQLException e) {
            System.out.println("In authentical login" + e);
        }
        data.addElement(Constant.FAILED);
        return data;
    }

    public static Vector loadData(Vector dataReceived) {

        try {
            DBConnection.connectDB();
            Vector data = new Vector();
            String sql;
            PreparedStatement pst;
            ResultSet resultSet;

            int tableName = (int) dataReceived.get(1);

            if (tableName == Constant.BOOKS_STORE_TABLE) {

                sql = "SELECT * FROM book;";
                resultSet = DBConnection.conn.prepareStatement(sql).executeQuery();

                while (resultSet.next()) {
                    Vector book = new Vector();
                    book.addElement(resultSet.getString("idbook"));
                    book.addElement(resultSet.getString("book_name"));
                    book.addElement(resultSet.getString("author"));
                    book.addElement(resultSet.getString("date_publish"));
                    data.addElement(book);
                }
                return data;

            } else if (tableName == Constant.TABLE_USER) {

                sql = "SELECT * FROM user_data;";

                pst = DBConnection.conn.prepareStatement(sql);
                resultSet = pst.executeQuery();

                while (resultSet.next()) {
                    Vector book = new Vector();
                    book.addElement(resultSet.getString("idUser"));
                    book.addElement(resultSet.getString("user_name"));
                    book.addElement(resultSet.getString("user_pass"));
                    book.addElement(resultSet.getString("user_type"));
                    data.addElement(book);
                }
                return data;
            } else if (tableName == Constant.STUDENT_BORROWED) {

                String idUser = (String) dataReceived.get(2);

                sql = "SELECT book.idbook, book_name, author, date_publish "
                        + "FROM book, book_borrowed "
                        + "WHERE idStudent = ? AND "
                        + "book.idbook = book_borrowed.idbook;";

                pst = DBConnection.conn.prepareStatement(sql);
                pst.setString(1, idUser);

                resultSet = pst.executeQuery();

                while (resultSet.next()) {
                    Vector book = new Vector();
                    book.addElement(resultSet.getString("idbook"));
                    book.addElement(resultSet.getString("book_name"));
                    book.addElement(resultSet.getString("author"));
                    book.addElement(resultSet.getString("date_publish"));
                    data.addElement(book);
                }
                return data;
            } else if (tableName == Constant.BORROWED_BOOK_TABLE) {

                sql = "SELECT * FROM book_borrowed;";

                pst = DBConnection.conn.prepareStatement(sql);
                resultSet = pst.executeQuery();

                while (resultSet.next()) {
                    Vector book = new Vector();
                    book.addElement(resultSet.getString("idbook"));
                    book.addElement(resultSet.getString("idStudent"));
                    book.addElement(resultSet.getString("date_borrow"));
                    book.addElement(resultSet.getString("date_return"));
                    data.addElement(book);
                }
                System.out.println("In book borrowed" + data);
                return data;
            } else if (tableName == Constant.REQUEST_TABLE) {

                sql = "SELECT * FROM book_request;";

                pst = DBConnection.conn.prepareStatement(sql);
                resultSet = pst.executeQuery();

                while (resultSet.next()) {
                    Vector book = new Vector();
                    book.addElement(resultSet.getString("idbook"));
                    book.addElement(resultSet.getString("idStudent"));
                    book.addElement(resultSet.getString("date_borrow"));
                    book.addElement(resultSet.getString("date_return"));
                    data.addElement(book);
                }

                System.out.println("IN BOOK book_request" + data);
                return data;
            }
        } catch (SQLException ex) {
            System.out.println("IN BOOK book_request " + ex);
        }
        return null;
    }

    public static int updateData(Vector vectorData) {

        DBConnection.connectDB();
        String sql;
        PreparedStatement pst;
        int tableCheck = (int) vectorData.get(1);

        if (tableCheck == Constant.BOOKS_STORE_TABLE) {

            try {
                sql = "UPDATE book SET book_name =?, author =?, date_publish =? WHERE idbook =?;";

                pst = DBConnection.conn.prepareStatement(sql);
                pst.setString(1, (String) vectorData.get(3));
                pst.setString(2, (String) vectorData.get(4));
                pst.setString(3, (String) vectorData.get(5));
                pst.setString(4, (String) vectorData.get(2));
                pst.executeUpdate();

                return Constant.SUCCESS;

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else if (tableCheck == Constant.ACCOUNT_TABLE) {

            try {
                sql = "UPDATE user_data SET user_name = ?, user_pass = ?, user_type = ? WHERE idUser = ?;";

                pst = DBConnection.conn.prepareStatement(sql);

                pst.setString(1, (String) vectorData.get(3));
                pst.setString(2, (String) vectorData.get(4));
                pst.setString(3, (String) vectorData.get(5));
                pst.setString(4, (String) vectorData.get(2));
                pst.executeUpdate();
                System.out.println("UPDATE SUCESS");
                return Constant.SUCCESS;

            } catch (SQLException ex) {
                System.out.println("In update usetdata SP" + ex);
            }
        }

        return Constant.FAILED;
    }

    public static int insertData(Vector vectorData) {

        DBConnection.connectDB();
        String sql;
        PreparedStatement pst;
        int tableCheck = (int) vectorData.get(1);

        if (tableCheck == Constant.BOOKS_STORE_TABLE) {

            try {
                sql = "INSERT INTO book VALUE (?, ?, ?, ?);";
                pst = DBConnection.conn.prepareStatement(sql);

                pst.setString(1, (String) vectorData.get(2));
                pst.setString(2, (String) vectorData.get(3));
                pst.setString(3, (String) vectorData.get(4));
                pst.setString(4, (String) vectorData.get(5));
                pst.executeUpdate();
                return Constant.SUCCESS;

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else if (tableCheck == Constant.ACCOUNT_TABLE) {

            try {

                sql = "INSERT INTO user_data VALUE (?, ?, ?, ?)";
                pst = DBConnection.conn.prepareStatement(sql);

                pst.setString(1, (String) vectorData.get(2));
                pst.setString(2, (String) vectorData.get(3));
                pst.setString(3, (String) vectorData.get(4));
                pst.setString(4, (String) vectorData.get(5));
                pst.executeUpdate();
                return Constant.SUCCESS;

            } catch (SQLException ex) {
                System.out.println("In SP insert: " + ex);
            }
        }
        return Constant.FAILED;
    }

    public static int deleteData(Vector vectorData) {

        try {
            int table = (int) vectorData.get(1);
            String id = (String) vectorData.get(2);
            String idPrimaryKey = null, tableName = null;
            DBConnection.connectDB();

            if (table == Constant.BOOKS_STORE_TABLE) {
                tableName = "book";
                idPrimaryKey = "idbook";
            } else if (table == Constant.TABLE_USER) {
                tableName = "user_data";
                idPrimaryKey = "idUser";
            } else if (table == Constant.BORROWED_BOOK_TABLE) {
                idPrimaryKey = "";
            }

            String sql = "DELETE FROM " + tableName + " WHERE " + idPrimaryKey + " = ?;";
            PreparedStatement pst = DBConnection.conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.executeUpdate();

            return Constant.SUCCESS;

        } catch (SQLException ex) {
            System.out.println("In delete SP" + ex);
        }

        return Constant.FAILED;
    }

    public static int requestBorrow(Vector data) {

        String idBook = (String) data.get(1);
        String idStudent = (String) data.get(2);
        String dateReturn = (String) data.get(3);

        try {
            DBConnection.connectDB();
            String sql = "INSERT INTO book_request(idBook, idStudent, date_borrow, date_return) "
                    + "VALUE (? ,? ,? ,? );";

            PreparedStatement pst = DBConnection.conn.prepareStatement(sql);

            pst.setString(1, idBook);
            pst.setString(2, idStudent);
            pst.setString(3, datetime.MyDateTime.getDateTime());
            pst.setString(4, dateReturn);

            pst.executeUpdate();

            return Constant.SUCCESS;

        } catch (SQLException ex) {
            System.out.println("In SP requesting to borrow" + ex);
        }
        return Constant.FAILED;
    }

    public static int acceptRequestBorrow(Vector dataReceive) {

        String idBook = (String) dataReceive.get(1);
        String idStudent = (String) dataReceive.get(2);
        String dateBorrow = (String) dataReceive.get(3);
        String dateReturn = (String) dataReceive.get(4);

        try {

            DBConnection.connectDB();

            String sql = "INSERT INTO book_borrowed(idBook, idStudent, date_borrow, date_return) "
                    + "VALUE (? ,? ,? ,? );";

            PreparedStatement pst = DBConnection.conn.prepareStatement(sql);

            pst.setString(1, idBook);
            pst.setString(2, idStudent);
            pst.setString(3, dateBorrow);
            pst.setString(4, dateReturn);

            pst.executeUpdate();

            String sqlDel = "DELETE FROM book_request WHERE idbook = ? and idStudent = ?";

            pst = DBConnection.conn.prepareStatement(sqlDel);
            pst.setString(1, idBook);
            pst.setString(2, idStudent);

            pst.executeUpdate();

            return Constant.SUCCESS;

        } catch (SQLException ex) {
            System.out.println("In SP requesting to borrow" + ex);
        }
        return Constant.FAILED;
    }

    public static int returnBook(Vector data) {

        String idBook = (String) data.get(1);
        String idStudent = (String) data.get(2);

        try {

            DBConnection.connectDB();

            String sql = "DELETE FROM book_borrowed WHERE idbook = ? AND idStudent =?;";

            PreparedStatement pst = DBConnection.conn.prepareStatement(sql);

            pst.setString(1, idBook);
            pst.setString(2, idStudent);

            pst.executeUpdate();
            
            return Constant.SUCCESS;

        } catch (SQLException ex) {
            System.out.println("In SP return book to borrow "  + ex);
        }
        return Constant.FAILED;
    }

    
    public static Vector searchData(String keyword, int option) {
    //Search data on table book
        try {
            DBConnection.connectDB();

            Vector data = new Vector();
            PreparedStatement pst;

            String sql;
            ResultSet resultSet;

            switch (option) {
                case Constant.OPTION_ALL:
                    sql = "SELECT * FROM book;";
                    pst = DBConnection.conn.prepareStatement(sql);
                    resultSet = pst.executeQuery();

                    while (resultSet.next()) {

                        Vector book = new Vector();
                        book.addElement(resultSet.getString("idbook"));
                        book.addElement(resultSet.getString("book_name"));
                        book.addElement(resultSet.getString("author"));
                        book.addElement(resultSet.getString("date_publish"));

                        if ((book.toString().toLowerCase()).contains(keyword.toLowerCase())) {
                            data.addElement(book);
                        }
                    }
                    break;

                case Constant.OPTION_ID_BOOK:
                    sql = "SELECT * FROM book WHERE idbook LIKE ?;";
                    pst = DBConnection.conn.prepareStatement(sql);
                    pst.setString(1, "%" + keyword + "%");
                    resultSet = pst.executeQuery();

                    while (resultSet.next()) {

                        Vector book = new Vector();
                        book.addElement(resultSet.getString("idbook"));
                        book.addElement(resultSet.getString("book_name"));
                        book.addElement(resultSet.getString("author"));
                        book.addElement(resultSet.getString("date_publish"));

                        if ((book.toString().toLowerCase()).contains(keyword.toLowerCase())) {
                            data.addElement(book);
                        }
                    }
                    break;
                case Constant.OPTION_BOOK_NAME:
                    sql = "SELECT * FROM book WHERE book_name LIKE ?;";
                    pst = DBConnection.conn.prepareStatement(sql);
                    pst.setString(1, "%" + keyword + "%");
                    resultSet = pst.executeQuery();

                    while (resultSet.next()) {

                        Vector book = new Vector();
                        book.addElement(resultSet.getString("idbook"));
                        book.addElement(resultSet.getString("book_name"));
                        book.addElement(resultSet.getString("author"));
                        book.addElement(resultSet.getString("date_publish"));

                        if ((book.toString().toLowerCase()).contains(keyword.toLowerCase())) {
                            data.addElement(book);
                        }
                    }
                    break;

                case Constant.OPTION_AUTHOR:
                    sql = "SELECT * FROM book WHERE author LIKE ?;";
                    pst = DBConnection.conn.prepareStatement(sql);
                    pst.setString(1, "%" + keyword + "%");
                    resultSet = pst.executeQuery();

                    while (resultSet.next()) {

                        Vector book = new Vector();
                        book.addElement(resultSet.getString("idbook"));
                        book.addElement(resultSet.getString("book_name"));
                        book.addElement(resultSet.getString("author"));
                        book.addElement(resultSet.getString("date_publish"));

                        if ((book.toString().toLowerCase()).contains(keyword.toLowerCase())) {
                            data.addElement(book);
                        }
                    }
                    break;

                case Constant.OPTION_DATE:
                    sql = "SELECT * FROM book WHERE date_publish LIKE ?;";
                    pst = DBConnection.conn.prepareStatement(sql);
                    pst.setString(1, "%" + keyword + "%");
                    resultSet = pst.executeQuery();

                    while (resultSet.next()) {

                        Vector book = new Vector();
                        book.addElement(resultSet.getString("idbook"));
                        book.addElement(resultSet.getString("book_name"));
                        book.addElement(resultSet.getString("author"));
                        book.addElement(resultSet.getString("date_publish"));

                        if ((book.toString().toLowerCase()).contains(keyword.toLowerCase())) {
                            data.addElement(book);
                        }
                    }
                    break;

                default:
                    System.out.println("Do nothing in search");
            }
            return data;

        } catch (SQLException ex) {
            System.out.println("In ServerProcessor search server" + ex);
        }
        return null;
    }
}
