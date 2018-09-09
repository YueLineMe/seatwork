package dao;

import entity.Product;
import entity.ShopCar;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    /**
     * 获得所有上架商品
     */
    public List<Product> getAlltop() {
        DButil db = new DButil();
        List<Product> list = new ArrayList<>();
        ResultSet rs = db.select("select * from Product where `state`=0");
        Product p = null;
        try {
            while (rs.next()) {
                BigDecimal big=new BigDecimal(rs.getDouble(4));
                big.setScale(2);
                p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),big, rs.getString(5), rs.getString(6), rs.getInt(7));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return list;
    }

    public List<Product> getAll() {
        DButil db = new DButil();
        List<Product> list = new ArrayList<>();
        ResultSet rs = db.select("select * from Product ");
        Product p = null;
        try {
            while (rs.next()) {
                BigDecimal big=new BigDecimal(rs.getDouble(4));
                big.setScale(2);
                p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),big, rs.getString(5), rs.getString(6), rs.getInt(7));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return list;
    }

    public int del(int pid) {
        int result = 0;
        DButil db = new DButil();
        result = db.update("update Product set state=1 where pid=?", pid);
        return result;
    }

    public int chagedel(int pid) {
        int result = 0;
        DButil db = new DButil();
        result = db.update("update Product set state=0 where pid=?", pid);
        return result;
    }

    public List<Product> selectbyname(String name) {
        DButil db = new DButil();
        List<Product> list = new ArrayList<>();
        ResultSet rs = db.select("select * from Product where pname like ? and `state`=0", "%" + name + "%");
        Product p = null;
        try {
            while (rs.next()) {
                BigDecimal big=new BigDecimal(rs.getDouble(4));
                big.setScale(2);
                p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),big, rs.getString(5), rs.getString(6), rs.getInt(7));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return list;
    }
    public List<Product> selectbyptid(int ptid){
        DButil db = new DButil();
        List<Product> list = new ArrayList<>();
        ResultSet rs = db.select("select * from Product where ptid = ? and `state`=0", ptid );
        Product p = null;
        try {
            while (rs.next()) {
                BigDecimal big=new BigDecimal(rs.getDouble(4));
                big.setScale(2);
                p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),big, rs.getString(5), rs.getString(6), rs.getInt(7));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return list;
    }
}
