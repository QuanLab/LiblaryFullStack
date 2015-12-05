package server.connection;

/**
 *
 * @author Quan-PC
 */
public class Constant {

     //request confirm
    public static final int 
            LOGIN = 3, 
            LOAD = 0, 
            UPDATE = 1, 
            INSERT = 2, 
            DELETE = 11, 
            REQUEST_BORROW = 4,
            ACCEPT_REQUEST = 6,
            RETURN = 12,
            SEARCH = 5;
            
    
    //use for insert
    public static final int 
            TABLE_USER = 4,
            BOOKS_STORE_TABLE = 5, 
            TABLE_BORROW = 6, 
            STUDENT = 7,
            BORROWED_BOOK_TABLE = 8,
            REQUEST_TABLE = 9,
            STUDENT_BORROWED = 10,
            ACCOUNT_TABLE = 11;
    
    public static final int 
            OPTION_ALL = 0,
            OPTION_ID_BOOK = 1, 
            OPTION_BOOK_NAME = 2, 
            OPTION_AUTHOR = 3,
            OPTION_DATE = 4;
    
    //result for request
    public static final int 
            SUCCESS = 0, 
            FAILED = -1;  //result of request

    public static final int 
            ADMIN = 1, 
            CLIENT = 0,
            ANONYMOUS = -1;
}