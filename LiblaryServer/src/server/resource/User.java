package server.resource;


public class User{
    
    Student student;
    private String idUser;
    private String userName;
    private String userPass;
    private String userType;
    
    
    public User(String idUser, String userName, String userPass, String userType) {
        super();
        this.idUser = this.student.getId();
        this.userName = userName;
        this.userPass = userPass;
        this.userType = userType;
    }
    
    public User(){
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getUserType() {
        return userType;
    }
}
