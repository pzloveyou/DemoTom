package servlet.houtai;

import BlankServe.BlankServe;
import BlankServe.imp.BlankServeImp;
import dao.BlankDao;
import dao.imp.BlankDaoImp;
import entity.Blank;
import entity.Page;

import javax.jws.Oneway;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/htselectdd")
public class SelectDD extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        List<Blank> list = new ArrayList<Blank>();
        BlankServe se = new BlankServeImp();
        Page page=new Page();
        String a=req.getParameter("page"); //当前页数
        BlankDao bk=new BlankDaoImp();
        int sum=bk.selectcount();
        if (a==null){
           page.setPage(1);
        }else if (a!=null){
            int b=Integer.parseInt(a);
            if (b<=0) {
                b = 1;
                page.setPage(b);
            }else if(b==sum){
                page.setPage(sum);
            }else {
                page.setPage(b);
            }
        }
        System.out.println(page.getPage());
        page=se.selectpage(page.getPage(),5);
        list=page.getList();
        req.setAttribute("pagemax",page.getPageSum());
        req.setAttribute("page",page.getPage());
        req.setAttribute("pagecount",page.getConutSum());
        req.setAttribute("list",list);
        req.getRequestDispatcher("html/order-list.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          this.doGet(req, resp);
    }
}
