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

@WebServlet("/logins")
public class Logins extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String user=req.getParameter("user");
        String pwd=req.getParameter("passwd");
        List<Blank> list = new ArrayList<Blank>();
        BlankServe blankServe=new BlankServeImp();
        int count=blankServe.user(user,pwd);
        if (count>0){
            out.println("true");
        }

       /* list=se.all();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getUser().equals(user)&&list.get(i).getPassword().equals(pwd)){
                      out.println("true");
              break;
            }
        }*/
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
