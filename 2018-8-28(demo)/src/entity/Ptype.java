package entity;

public class Ptype {
    private int ptid;
    private String pname;
    public Ptype(){

    }

    @Override
    public String toString() {
        return "Ptype{" +
                "ptid=" + ptid +
                ", pname='" + pname + '\'' +
                '}';
    }

    public int getPtid() {
        return ptid;
    }

    public void setPtid(int ptid) {
        this.ptid = ptid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Ptype(int ptid, String pname) {
        this.ptid = ptid;
        this.pname = pname;
    }
}
