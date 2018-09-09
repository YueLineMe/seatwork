package entity;

import java.math.BigDecimal;

public class ShopCar {
    private int sid;
    private String name;
    private BigDecimal price;
    private int scount;
    private BigDecimal sumprice;
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ShopCar(){

    }

    public ShopCar(int sid, String name, BigDecimal price, int scount, BigDecimal sumprice, String photo) {
        this.sid = sid;
        this.name = name;
        this.price = price;
        this.scount = scount;
        this.sumprice = sumprice;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", scount=" + scount +
                ", sumprice=" + sumprice +
                ", photo='" + photo + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getScount() {
        return scount;
    }

    public void setScount(int scount) {
        this.scount = scount;
    }

    public BigDecimal getSumprice() {
        return sumprice;
    }

    public void setSumprice(BigDecimal sumprice) {
        this.sumprice = sumprice;
    }



    public ShopCar(int sid, String name, BigDecimal price, int scount, BigDecimal sumprice) {
        this.sid = sid;
        this.name = name;
        this.price = price;
        this.scount = scount;
        this.sumprice = sumprice;
    }
}
