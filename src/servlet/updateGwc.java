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

@WebServlet("/updateGwc")
public class updateGwc extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        BlankServe blankServe=new BlankServeImp();
        PrintWriter out=response.getWriter();
        String account =(String) request.getServletContext().getAttribute("user");//获取用户名
        String name=request.getParameter("name");
        String color=request.getParameter("color");
        int xiema=Integer.parseInt(request.getParameter("xiema"));
        BlankServe se=new BlankServeImp();
        int counts=se.deleteid(name,color,account,xiema);
        if (counts>0){
            out.print("true");
        }else {
            out.print("false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
