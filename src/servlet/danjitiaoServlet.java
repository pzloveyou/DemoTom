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
import java.util.List;

@WebServlet("/img")
public class danjitiaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        BlankServe blankServe=new BlankServeImp();
        //路进
        String src=request.getParameter("src");
        //查询全部
        List<Blank>listAll=blankServe.listAll(src);
        //查询图片
        List<Blank>list= blankServe.listImg(src);
        //查询鞋码
        int shoeId=listAll.get(0).getId();
        List<Blank>listSize=blankServe.listSize(shoeId);
        System.out.println(listSize.size());
        request.setAttribute("listSize",listSize);
        //查询颜色
        int colorId=listAll.get(0).getId();  //根据鞋子找出鞋子颜色
        List<Blank>listColor=blankServe.listColor(colorId);
        request.setAttribute("listColor",listColor);
        PrintWriter out=response.getWriter();
        request.setAttribute("list",list);
        request.setAttribute("listAll",listAll);
        String user=(String)request.getServletContext().getAttribute("user");
        int count=blankServe.gwcCount(user);
        request.getServletContext().setAttribute("count",count);
       /* out.print(list);*/
        request.getRequestDispatcher("jieshao.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
