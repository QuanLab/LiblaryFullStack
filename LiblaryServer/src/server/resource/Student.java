package server.resource;


public class Student {

    private String name;
    private String id;
    private String address;
    private User user;

    public Student(String id, String name, String address) {
        this.name = name;
        this.id = id;
        this.address = address;

    }

    public Student(User user) {
        super();
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String mssv) {
        this.id = mssv;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public String getAdress() {
        return this.address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
