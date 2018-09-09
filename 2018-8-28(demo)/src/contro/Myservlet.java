package contro;

import dao.ProductDao;
import dao.PtypeDao;
import dao.ShopCarDao;
import dao.UsersDao;
import entity.Product;
import entity.ShopCar;
import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class Myservlet extends HttpServlet {
    PrintWriter out;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        out=response.getWriter();
        String action =  request.getParameter("action");
        try {
            // 利用反射获取方法
            Method method = getClass().getDeclaredMethod(action,   HttpServletRequest.class, HttpServletResponse.class);
            // 执行相应的方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private void selectType(HttpServletRequest request, HttpServletResponse response){
        PtypeDao dao=new PtypeDao();
        out.print(util.toJson(dao.getAll()));
    }
    private void selectProduct(HttpServletRequest request,HttpServletResponse response){
        ProductDao dao=new ProductDao();
        out.print(util.toJson(dao.getAlltop()));
    }
    private void selectUsers(HttpServletRequest request,HttpServletResponse response){
        UsersDao dao=new UsersDao();
        String account=request.getParameter("account");
        String pwd=request.getParameter("pwd");
        Users users=dao.getUserby(account);
        if(users==null){
            out.print("{\"code\":\"0\"}");
        }else{
            if(pwd.equals(users.getPassword())){
                out.print("{\"code\":\"1\",\"uname\":\""+users.getUname()+"\"}");
                HttpSession session = request.getSession();
                session.setAttribute("uid",users.getUid());
                session.setAttribute("uname",users.getUname());
            }
            else
                out.print("{\"code\":\"0\"}");
        }
    }
    private void addUsers(HttpServletRequest request,HttpServletResponse response){
        UsersDao dao=new UsersDao();
        //String uname, String phone, String password, String e_mail
        String uname=request.getParameter("uname");
        String phone=request.getParameter("phone");
        String pwd=request.getParameter("pwd");
        String e_mail=request.getParameter("e_mail");
        int code=dao.addUser(new Users(uname,phone,pwd,e_mail));
        if(code>0){
            out.print("{\"code\":\"1\",\"uname\":\""+uname+"\"}");
            HttpSession session = request.getSession();
            Users users=dao.getUser(uname);
            session.setAttribute("uid",users.getUid());
            session.setAttribute("uname",users.getUname());
        }
        else
            out.print("{\"code\":\"0\"}");
    }
    private void isRegister(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        if(session.getAttribute("uid")==null)
            out.print("{\"code\":\"0\"}");
        else {
            String uname= (String) session.getAttribute("uname");
            UsersDao dao=new UsersDao();
            Users u=dao.getUser(uname);
            out.print("{\"code\":\"1\",\"name\":\""+u.getUname()+"\"}");

        }
    }
    public void getProct_bytype(HttpServletRequest request,HttpServletResponse response){
        int ptid= Integer.parseInt(request.getParameter("ptid"));
        ProductDao dao=new ProductDao();
        out.print(util.toJson(dao.selectbyptid(ptid)));
    }
    public void getProct_byname(HttpServletRequest request,HttpServletResponse response){
        String name=request.getParameter("name");
        ProductDao dao=new ProductDao();
        out.print(util.toJson(dao.selectbyname(name)));
    }
    public void getShopCarcount(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        ShopCarDao dao=new ShopCarDao();
        if(session.getAttribute("uid") == null){
            out.print("{\"count\":\"0\"}");
        }
        else{
            int uid= (int) session.getAttribute("uid");
            out.print("{\"count\":\""+dao.getShopCarCount(uid)+"\"}");
        }
    }
    public void goShopCar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        if(request.getSession().getAttribute("uid")==null) {
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher("index.html").forward(request, response);
        }else
            request.getRequestDispatcher("cart.html").forward(request, response);
    }
    public void logout(HttpServletRequest request,HttpServletResponse response){
        try {
            request.getSession().invalidate();
            out.print("{\"code\":\"1\"}");
        }catch (Exception e){
            e.printStackTrace();
            out.print("{\"code\":\"0\"}");
        }
    }
}
