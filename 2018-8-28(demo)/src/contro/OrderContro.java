package contro;

import dao.ShopCarDao;
import dao.SiteDao;
import entity.ShopCar;
import entity.Site;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderContro extends HttpServlet {
    PrintWriter out;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        out = response.getWriter();
        String action = request.getParameter("action");
        try {
            // 利用反射获取方法
            Method method = getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 执行相应的方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void getOrder(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Integer> sids = (List<Integer>) request.getSession().getAttribute("sids");
            BigDecimal sumprice = BigDecimal.valueOf(Integer.parseInt( (String)request.getSession().getAttribute("sumprice")));
            ShopCarDao dao = new ShopCarDao();
            out.print(util.toJson(dao.getShopCarbysids(sids)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getSite(HttpServletRequest request, HttpServletResponse response) {
        List<Site> list=new ArrayList<>();
        SiteDao dao=new SiteDao();
        list=dao.getAll((Integer) request.getSession().getAttribute("uid"));
        out.print(util.toJson(list));
    }
    public void addSite(HttpServletRequest request, HttpServletResponse response){
        SiteDao dao=new SiteDao();
        String recipients=request.getParameter("recipients");
        String phone=request.getParameter("phone");
        String locatoin=request.getParameter("locatoin");
        int uid= (int) request.getSession().getAttribute("uid");
        int result=dao.add(new Site(uid,recipients,phone,locatoin));
        if(result>0){
            out.print("{\"code\":\"1\"}");
        }else
            out.print("{\"code\":\"0\"}");
    }
    public void balance(HttpServletRequest request, HttpServletResponse response){
        try {
            ShopCarDao dao = new ShopCarDao();
            int sid = Integer.parseInt(request.getParameter("sid"));
            BigDecimal sumprice = BigDecimal.valueOf(Integer.parseInt(request.getParameter("sumprice")));
            int result = dao.balance((List<Integer>) request.getSession().getAttribute("sids"), sid, sumprice, (int) request.getSession().getAttribute("uid"));
            if (result > 0) {
                out.print("{\"code\":\"1\"}");
            } else
                out.print("{\"code\":\"0\"}");
        }catch (Exception e){
            out.print("{\"code\":\"0\"}");
            e.printStackTrace();
        }
    }
    public void delsite(HttpServletRequest request, HttpServletResponse response){
        int sid= Integer.parseInt(request.getParameter("sid"));
        SiteDao dao=new SiteDao();
        int result=dao.del(sid);
        if (result > 0) {
            out.print("{\"code\":\"1\"}");
        } else
            out.print("{\"code\":\"0\"}");
    }
}
