package servlet;

import BlankServe.BlankServe;
import BlankServe.imp.BlankServeImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/deleteGwc")
public class deleteGwc extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        BlankServe blankServe=new BlankServeImp();
        PrintWriter out=response.getWriter();
        String account=(String) request.getServletContext().getAttribute("user"); //获取账号
        String img=request.getParameter("img");
        int shoe=Integer.parseInt(request.getParameter("xiema"));//商品鞋码
        String color=request.getParameter("color");//商品颜色
        int count=blankServe.deleteGwc(img,account,color,shoe);
        if (count>0){
            out.print("true");
        }else{
            out.print("false");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
