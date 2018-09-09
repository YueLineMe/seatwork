package entity;

public class Site {
    private int sid;
    private int uid;
    private String recipients;
    private String phone;
    private String locatoin;

    @Override
    public String toString() {
        return "Site{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", recipients='" + recipients + '\'' +
                ", phone='" + phone + '\'' +
                ", locatoin='" + locatoin + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocatoin() {
        return locatoin;
    }

    public void setLocatoin(String locatoin) {
        this.locatoin = locatoin;
    }

    public Site(){

    }

    public Site(int uid, String recipients, String phone, String locatoin) {
        this.uid = uid;
        this.recipients = recipients;
        this.phone = phone;
        this.locatoin = locatoin;
    }

    public Site(int sid, int uid, String recipients, String phone, String locatoin) {
        this.sid = sid;
        this.uid = uid;
        this.recipients = recipients;
        this.phone = phone;
        this.locatoin = locatoin;
    }
}
