package dao;

import entity.ShopCar;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopCarDao {
    /**
     * 获得购物车的商品
     */
    public List<ShopCar> getAll(int uid) {
        List<ShopCar> list = new ArrayList<>();
        DButil db = new DButil();
        ShopCar sc = null;
        String sql = "select s.sid,p.pname,p.price,s.scount,s.sumprice,p.photo from ShopCar s join Product p on s.pid=p.pid where s.uid=? and s.state=0 order by s.sid desc";
        ResultSet rs = db.select(sql, uid);
        try {
            while (rs.next()) {
                BigDecimal big = new BigDecimal(rs.getDouble(3));
                big.setScale(2);
                sc = new ShopCar(rs.getInt(1), rs.getString(2), big, rs.getInt(4), rs.getBigDecimal(5), rs.getString(6));
                list.add(sc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return list;
    }

    public int getShopCarCount(int uid) {
        int count = 0;
        DButil db = new DButil();
        ShopCar sc = null;
        String sql = "select count(*) from ShopCar s join Product p on s.pid=p.pid where s.uid=? and s.state=0;";
        ResultSet rs = db.select(sql, uid);
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int del(int sid) {
        int result = 0;
        DButil db = new DButil();
        String sql = "delete from ShopCar where sid=?";
        result = db.update(sql, sid);
        db.close();
        return result;
    }

    public int add(int pid, int uid) {
        int result = 0;
        DButil db = new DButil();
        String sql = "select s.sid,count(*) from ShopCar s join Product p on s.pid=p.pid where s.pid=? and s.uid=? and s.state=0;";
        ResultSet rs = db.select(sql, pid, uid);
        try {
            int sid = 0;
            int count = 0;
            while (rs.next()) {
                sid = rs.getInt(1);
                count = rs.getInt(2);
            }
            rs = db.select("select price from Product where pid=?", pid);
            rs.next();
            BigDecimal price = rs.getBigDecimal(1);
            if (count > 0) {
                sql = "update ShopCar set scount =scount+ 1 , sumprice =sumprice + ? where sid=?";
                result = db.update(sql, price, sid);
            } else {
                sql = "insert into ShopCar values (0,?,1,?,?,null,0)";
                result = db.update(sql, pid, uid, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<ShopCar> getShopCarbysids(List<Integer> sids) {
        List<ShopCar> list = new ArrayList<>();
        DButil db = new DButil();
        ShopCar sc = null;
        String sql = "select s.sid,p.pname,p.price,s.scount,s.sumprice,p.photo from ShopCar s join Product p on s.pid=p.pid where s.sid in (";
        Object[] intsids = new Object[sids.size()];
        for (int i = 0; i < sids.size(); i++) {
            intsids[i] = sids.get(i);
            if (i == sids.size() - 1) {
                sql += "?)";
            } else
                sql += "?,";
        }
        ResultSet rs = db.selectby(sql, intsids);
        try {
            while (rs.next()) {
                BigDecimal big = new BigDecimal(rs.getDouble(3));
                big.setScale(2);
                sc = new ShopCar(rs.getInt(1), rs.getString(2), big, rs.getInt(4), rs.getBigDecimal(5), rs.getString(6));
                list.add(sc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return list;
    }

    public int updatecount(ShopCar sc) {
        int result = 0;
        DButil db = new DButil();
        String sql = "update ShopCar set scount=?,sumprice=? where sid=?";
        result = db.update(sql, sc.getScount(), sc.getSumprice(), sc.getSid());
        db.close();
        return result;
    }

    /**
     * 结算
     *
     * @param sid 地址的id
     */
    public int balance(List<Integer> list, int sid, BigDecimal sumprice, int uid) {
        int result = 0;
        DButil db = new DButil();
        Object[] intsids = new Object[list.size()+1];
        String sql = "update ShopCar  set state=1,oid=? where sid in (";
        db.update("insert into `Order` values(0,?,?,?,0)", uid, sumprice, sid);
        ResultSet rs=db.select("select oid from `Order` where uid=? and state=0",uid);
        int oid=0;
        try {
            while(rs.next()){
                oid=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        intsids[0]=oid;
        for (int i = 1; i < list.size()+1; i++) {
            intsids[i] = list.get(i-1);
            if (i == list.size()) {
                sql += "?)";
            } else
                sql += "?,";
        }
        db.update("update `Order` set state=1 where oid=?",oid);
        result = db.updateby(sql, intsids);
        return result;
    }

}
