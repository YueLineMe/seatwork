package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DButil {
    private String url;
    private String user;
    private String password;
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;

    //�����������ҽ�������
    public void getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");          //8.0�汾��
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("��������ʧ��");
        }


        try {
            url="jdbc:mysql://localhost:3306/ProductDB?useSSL=false&serverTimezone=UTC";
            user="root";
            password="opqw12358jq";
            conn=DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getconn() {
    	return conn;
    }
    //�ͷ���Դ
    public void close(){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    
    //��ѯ�ķ���  
    public ResultSet select(String sql,Object... obj){
        //select * from student where s_age=1 and s_name="��";
        this.getConn();

        try {
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(int i=0;i<obj.length;i++){
            try {
                ps.setObject(i+1, obj[i]);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("��������ʧ��");
            }
        }
        try {
            rs=ps.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println("��ѯʧ��");
        }


        return rs;
    }


    //�޸ĵķ���
    public int update(String sql,Object...obj){
        this.getConn();
        try {
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("����ʧ��");
        }
        for(int i=0;i<obj.length;i++){
            try {
                ps.setObject(i+1, obj[i]);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("��������ʧ��");
            }
        }
        int a=0;
        try {
            a = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("ִ��sql���ʧ��");
        }


        return a;

    }
    public ResultSet selectby(String sql,Object [] obj){
        //select * from student where s_age=1 and s_name="��";
        this.getConn();

        try {
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(int i=0;i<obj.length;i++){
            try {
                ps.setObject(i+1, obj[i]);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("��������ʧ��");
            }
        }
        try {
            rs=ps.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println("��ѯʧ��");
        }


        return rs;
    }


    //�޸ĵķ���
    public int updateby(String sql,Object[]obj){
        this.getConn();
        try {
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("����ʧ��");
        }
        for(int i=0;i<obj.length;i++){
            try {
                ps.setObject(i+1, obj[i]);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("��������ʧ��");
            }
        }
        int a=0;
        try {
            a = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("ִ��sql���ʧ��");
        }


        return a;

    }
}
