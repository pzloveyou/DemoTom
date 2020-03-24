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
@WebServlet("/shouhuo")
public class zhifudind extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String shenf=req.getParameter("shenf");
        String shiqu=req.getParameter("shiqu");
        String xian=req.getParameter("xian");
        String dizhi=req.getParameter("dizhi");
        String phone=req.getParameter("phone");
        String bq=req.getParameter("bq");
        BlankServe se=new BlankServeImp();
        Blank bk=new Blank();
        bk.setShenf(shenf);
        bk.setShiqu(shiqu);
        bk.setXian(xian);
        bk.setDizhi(dizhi);
        bk.setPhone(phone);
        bk.setBq(bq);
        se.insertshouhuo(bk);
    }
}
