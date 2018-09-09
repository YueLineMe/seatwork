package entity;

import java.math.BigDecimal;

public class Product {
    private int pid ;
    private String name;
    private int ptid;
    private BigDecimal price;
    private String photo;
    private String remark;
    private int state;
    public Product(){

    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", ptid=" + ptid +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                '}';
    }

    public Product(int pid, String name, int ptid, BigDecimal price, String photo, String remark, int state) {
        this.pid = pid;
        this.name = name;
        this.ptid = ptid;
        this.price = price;
        this.photo = photo;
        this.remark = remark;
        this.state = state;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPtid() {
        return ptid;
    }

    public void setPtid(int ptid) {
        this.ptid = ptid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
