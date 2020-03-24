package servlet;

import BlankServe.BlankServe;
import BlankServe.imp.BlankServeImp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
@WebServlet("/jsonName")
public class jsonName extends HttpServlet {
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("html/text;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            String account =(String) req.getServletContext().getAttribute("user");//获取用户名
            BlankServe se=new BlankServeImp();
            List<Blank> list =new ArrayList<Blank>();
            String zji=req.getParameter("zji");
            req.setAttribute("zji",zji);
            String namejson=req.getParameter("jsons");
            String jsoncolor=req.getParameter("colors");
            String jsonshoe=req.getParameter("shoes");
            JSONArray ar = JSON.parseArray(namejson);  //将传过来的json格式数组字符串转换为jsonArry数组对象
            JSONArray co=JSON.parseArray(jsoncolor);
            JSONArray sh=JSON.parseArray(jsonshoe);
            for (int i = 0; i < ar.size(); i++) {
                String name = ar.getString(i);    //循环取出每个jsonarry的值
                String color=co.getString(i);
                int shoe=sh.getInteger(i);
                Blank bk = new Blank();
                bk = se.listName(name,account,color,shoe);
                list.add(bk);
            }
            List<Blank> list1 =new ArrayList<Blank>();
            list1=se.listAddress(account);
          /*  String shouhuo="";
            if (list1.size()==0){
                shouhuo="点击添加";
            }else{
                String shenf=list1.get(list1.size()-1).getShenf();
                String shiqu=list1.get(list1.size()-1).getShiqu();
                String xian=list1.get(list1.size()-1).getXian();
                String dizhi=list1.get(list1.size()-1).getDizhi();
                shouhuo=shenf+"-"+shiqu+"-"+xian+"-"+dizhi;
            }
            System.out.println(shouhuo);*/
            int count=se.gwcCount(account);
            req.getServletContext().setAttribute("count",count);
            req.setAttribute("list", list);
            req.setAttribute("list1",list1);

            req.getRequestDispatcher("zhifufangshi.jsp").forward(req,resp);
//        for(int i=0;i<ar.size();i++){
//            JSONObject array = ar.getJSONObject(i);
//            System.out.println(array.getString("键值"));   //当是键值对时候，使用这个方法
//        }
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
