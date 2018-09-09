package entity;

public class Users {
    private int uid;
    private String uname;
    private String phone;
    private String password;
    private String e_mail;

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", e_mail='" + e_mail + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Users(){

    }
    public Users(String uname,String password){
        this.uname = uname;
        this.password = password;
    }
    public Users(int uid, String uname, String phone, String password, String e_mail) {
        this.uid = uid;
        this.uname = uname;
        this.phone = phone;
        this.password = password;
        this.e_mail = e_mail;
    }

    public Users(String uname, String phone, String password, String e_mail) {
        this.uname = uname;
        this.phone = phone;
        this.password = password;
        this.e_mail = e_mail;
    }
}
