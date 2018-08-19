package contro;

import dao.BookDao;
import entity.Book;

import java.io.IOException;
import java.util.List;
import java.util.function.BinaryOperator;

public class BookContro extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String action=request.getParameter("action");
        BookDao dao=new BookDao();
        if(action==null){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else if(action.equals("selectId")){
            int Id= Integer.parseInt(request.getParameter("Id"));
            request.setAttribute("book_info",dao.getBookById(Id));
            request.getRequestDispatcher("book_info.jsp").forward(request,response);
        }
        else if(action.equals("prepare_add")){
            request.getRequestDispatcher("add_book.jsp").forward(request,response);
        }
        else if(action.equals("add")){
            int Id= Integer.parseInt(request.getParameter("Id"));
            String name = request.getParameter("name");
            double price= Double.parseDouble(request.getParameter("price"));
            String press = request.getParameter("press");
            String author = request.getParameter("author");
            dao.add(new Book(Id,name,price,author,press));
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else if(action.equals("del")){
            int Id= Integer.parseInt(request.getParameter("Id"));
            dao.delete(Id);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else if(action.equals("update")){
            int Id= Integer.parseInt(request.getParameter("Id"));
            String name = request.getParameter("name");
            double price= Double.parseDouble(request.getParameter("price"));
            String press = request.getParameter("press");
            String author = request.getParameter("author");
            dao.update(new Book(Id,name,price,author,press));
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else if(action.equals("selectName")){
            String name = request.getParameter("name");
            List<Book> books = dao.getBookByName(name);
            request.setAttribute("books", books);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
