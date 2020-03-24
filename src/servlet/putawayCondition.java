package servlet;

import BlankServe.BlankServe;
import BlankServe.imp.BlankServeImp;
import entity.Blank;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/putawayCondition")
public class putawayCondition extends HttpServlet {  //上架条件   品牌 类型的下拉框值
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("html/text;charset=UTF-8");
        PrintWriter out = response.getWriter();
        BlankServe blankServe = new BlankServeImp();
        List<Blank>listBrand=new ArrayList<Blank>();
        List<Blank>listClassify=new ArrayList<Blank>();
        listBrand=blankServe.listBrand();
        listClassify=blankServe.listClass();
        request.setAttribute("listBrand",listBrand);
        request.setAttribute("listClassify",listClassify);
        request.getRequestDispatcher("html/upload2.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
