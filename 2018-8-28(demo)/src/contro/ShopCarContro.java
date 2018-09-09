package contro;

import dao.ShopCarDao;
import entity.ShopCar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShopCarContro extends HttpServlet {
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
    ShopCarDao dao=new ShopCarDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public void addShopCar(HttpServletRequest request, HttpServletResponse response){
        int pid= Integer.parseInt(request.getParameter("pid"));
        int code=dao.add(pid,(int)request.getSession().getAttribute("uid"));
        if(code>0){
            out.print("{\"code\":\"1\"}");
        }
        else
            out.print("{\"code\":\"0\"}");
    }

    public void getAll(HttpServletRequest request, HttpServletResponse response){
        out.print(util.toJson(dao.getAll((int)request.getSession().getAttribute("uid"))));
    }
    public void del(HttpServletRequest request, HttpServletResponse response){
        int sid= Integer.parseInt(request.getParameter("sid"));
        int code=dao.del(sid);
        if(sid>0){
            out.print("{\"code\":\"1\"}");
        }
        else
            out.print("{\"code\":\"0\"}");
    }
    public void updatecount(HttpServletRequest request, HttpServletResponse response){
        int sid= Integer.parseInt(request.getParameter("sid"));
        int count= Integer.parseInt(request.getParameter("count"));
        BigDecimal sumprice=new BigDecimal(request.getParameter("sumprice"));
        sumprice.setScale(2);
        ShopCar sc=new ShopCar();
        sc.setSid(sid);
        sc.setScount(count);
        sc.setSumprice(sumprice);
        int result=dao.updatecount(sc);
        if(result > 0 ){
            out.print("{\"code\":\"1\"}");
        }else
            out.print("{\"code\":\"0\"}");
    }
    public void goOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getSession().setAttribute("sumprice", request.getParameter("sumprice"));
            String[] list= request.getParameterValues("sids");
            List<Integer> lint=new ArrayList<>();
            for(int i=0;i<list.length;i++){
                lint.add(Integer.parseInt(list[i]));
            }
            request.getSession().setAttribute("sids",lint);
            out.print("{\"code\":\"1\"}");
        }catch (Exception e){
            out.print("{\"code\":\"0\"}");
            e.printStackTrace();
        }
    }
}
