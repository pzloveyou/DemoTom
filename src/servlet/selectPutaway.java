package servlet;

import BlankServe.BlankServe;
import BlankServe.imp.BlankServeImp;
import entity.Blank;
import entity.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
@WebServlet("/selectPutaway")
public class selectPutaway extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        BlankServe blankServe = new BlankServeImp();
        String bh=request.getParameter("id");//商品编码
        String title=request.getParameter("title");//商品标题
        String brand=request.getParameter("brand");//商品品牌
        String classify=request.getParameter("classify");//商品类型
        String jg=request.getParameter("price");//价格1 范围
        String jg2=request.getParameter("price2");
        int id=-1;
        int price=-1;
        int price2=-1;
        if (bh==""||bh==null){
            id=0;
        }else {
            id=Integer.parseInt(bh);
        }

        if (jg==""||jg==null){
         price=0;
        }else {
            price=Integer.parseInt(jg);
        }
        if (jg2==""||jg2==null) {
            price2 = 999999999;
        }else {
            price2=Integer.parseInt(jg2);
        }
        if (title==null){
            title="";
        }
        if (brand==null){
            brand="";
        }
        if (classify==null){
            classify="";
        }


        Blank blank=new Blank();
        blank.setId(id);
        blank.setTitle(title);
        blank.setBrandName(brand);
        blank.setClassification(classify);
        blank.setPrice(price);
        blank.setOriginalPrice(price2);
        List<Blank>list=blankServe.listSpu(blank);
        //分页
        Page pages=new Page();
        int pageMax=10;  //每页显示数量
        String a=request.getParameter("page");//当前页数
        int page=-1;
        if (a==null){
            page=1;
        }else {
            int b=Integer.parseInt(a);
            if (b<=0){
                b=1;
            }
            page=b;
        }
      /*  pages.setConutSum();*/


        List<String>listBrand=new ArrayList<String>();
        List<String>listClassify=new ArrayList<String>();
        List<Integer>listCount=new ArrayList<Integer>();
        for (int i=0;i<list.size();i++){
            listBrand.add(blankServe.selectBrand(list.get(i).getBrandid()));
            listClassify.add(blankServe.selectClassify(list.get(i).getClassifyid()));
            listCount.add(blankServe.selectCount(list.get(i).getId()));
        }
        request.setAttribute("list",list);
        request.setAttribute("listBrand",listBrand);//品牌
        request.setAttribute("listClassify",listClassify);//类型
        request.setAttribute("listCount",listCount);//数量
        request.getRequestDispatcher("html/upload.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
