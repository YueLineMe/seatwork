package dao;

import com.sun.org.apache.xpath.internal.SourceTree;
import entity.Users;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {

    public List<Users> getAllUsers() {
        DButil db = new DButil();
        List<Users> list = new ArrayList<>();
        ResultSet rs = db.select("select * from Users");
        try {
            while (rs.next()) {
                list.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public Users getUserby(String account){
        Users u=new Users();
        DButil db = new DButil();
        String sql = "select * from `Users` where uname=? or phone=? or e_mail=? ";
        ResultSet rs = db.select(sql, account,account,account);
        try {
            while (rs.next()) {
                u = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public Users getUser(String account) {
        Users users = null;
        DButil db = new DButil();
        String sql = "select * from `Users` where uname=? ";
        ResultSet rs = db.select(sql, account);
        try {
            while (rs.next()) {
                users = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public int addUser(Users u) {
        DButil db = new DButil();
        String sql = "insert into `Users` values(?,?,?,?,?)";
        int result = db.update(sql, u.getUid(), u.getUname(), u.getPhone(), u.getPassword(), u.getE_mail());
        return result;
    }
}
