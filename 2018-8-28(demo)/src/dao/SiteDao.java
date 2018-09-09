package dao;

import entity.Site;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SiteDao {
    public List<Site> getAll(int uid) {
        List<Site> list = new ArrayList<>();
        Site site = null;
        DButil db = new DButil();
        ResultSet rs = db.select("select * from Site where uid=? and state=0", uid);
        try {
            while (rs.next()) {
                site = new Site(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(site);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int add(Site s) {
        int result = 0;
        DButil db = new DButil();
        result = db.update("insert into Site values(0,?,?,?,?,0)", s.getUid(), s.getRecipients(), s.getPhone(), s.getLocatoin());
        db.close();
        return result;
    }
    public int del(int sid){
        int result=0;
        DButil db = new DButil();
        result = db.update("update Site set state=1 where sid=?", sid);
        db.close();
        return result;
    }
}
