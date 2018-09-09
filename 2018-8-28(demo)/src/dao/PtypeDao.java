package dao;

import contro.util;
import entity.Ptype;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PtypeDao {
    public List<Ptype> getAll() {
        List<Ptype> list = new ArrayList<>();
        DButil db = new DButil();
        ResultSet rs = db.select("select * from Ptype");
        Ptype type = new Ptype();
        try {
            while (rs.next()) {
                type = new Ptype(rs.getInt(1), rs.getString(2));
                list.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
