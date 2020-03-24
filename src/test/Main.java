package test;

import BlankServe.BlankServe;
import BlankServe.imp.BlankServeImp;
import entity.Blank;
import entity.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BlankServe blankServe = new BlankServeImp();
        BlankServe se = new BlankServeImp();
//           List<Blank> list = se.listgwc();
//        for (Blank nm:list
//             ) {
//            System.out.println(nm.getTradeName()+nm.getTradeColor()+nm.getTradeCounts()+nm.getTradeImg()+nm.getTradePrice()+nm.getTradeShoe());
//        }
//        int m=se.selectid("耐克增高运动鞋");
//        System.out.println(m);
//        int n=se.deleteid(m);
//        int n=se.deleteGwc("images/耐克增高运动鞋1.jpg");
//        if (n>0){
//            System.out.println(1);
//        }else{
//            System.out.println(0);
//        }
//        Blank bk = new Blank();
//          bk=se.listName("彪马(SRT)板鞋(白色)");
//        System.out.println(bk.getTradeName()+bk.getTradePrice()+bk.getTradeShoe()+bk.getTradeCounts()+bk.getTradeColor());
//       list=se.listshouhuo();
//        System.out.println(list.get(list.size()-1).getShenf());
//        Blank nm=new Blank();
//        nm.setDdhao("2323424344");
//        nm.setDdprice(345);
//        nm.setDdname("ggggg");
//        nm.setDdzhi("hhhhh");
//        nm.setZt("未支付");
//        nm.setPhones("123456789");
//        nm.setAccount("pzy123");
//        nm.setCount(2);
//        nm.setTime("2020-3-17 16:11");
//        int cb=se.insertDDxxi(nm);
//        System.out.println(cb);
//        Blank nms=new Blank();
//        nms.setDdhao("2323424344");
//        nms.setTradeName("dfg");
//        nms.setTradePrice(33);
//        nms.setTradeShoe(34);
//        nms.setTradeColor("hss");
//        nms.setTradeCounts(21);
//        if (cb>0) {
//            int cu = se.insertDDbiao(nms);
//            System.out.println(cu);
//        }
//        Blank kl = new Blank();
//        int sm=se.status("zyc");
//        System.out.println(sm);
//        List<Blank> list = null;
//                list=se.listSize(1);
//        System.out.println(list.get(0).getSize());
//        list=se.listColor(1);
//        System.out.println(list.size());
//        list = se.listAll("images/彪马小白鞋1.jpg");
//        int d = list.get(0).getId();
//        System.out.println(d);
//        List<Blank> list1 = se.listSize(list.get(0).getId());
//        int g = 0;
//        for (int i = 0; i < list1.size(); i++) {
//            //System.out.println(list1.get(i).getKucun());
//            g += list1.get(i).getKucun();
//        }
//        list=se.listgwc("zyc");
//        for (Blank blank:list){
//            System.out.println(blank.getTradeName());
//        }
//        List<Blank> list1=new ArrayList<Blank>();
//        list1=se.selectsum("pzy123");
//        for (Blank bk:list1){
//            System.out.println(bk.getName());
//        }
//        List<Blank> list=new ArrayList<Blank>();
//        list=se.selectsum();
//        for (Blank bk:list) {
//            System.out.println(bk.getName());
//        }
//        List<Blank> list1=new ArrayList<Blank>();
//        list1=se.selectyzf("pzy123");
//        for (Blank bk:list1){
//            System.out.println(bk.getDdhao());
//        }
//        System.out.println("哈哈哈哈");
        List<Blank> bk=new ArrayList<Blank>();
        Page page=new Page();
        Page page1=se.selectpage(1,5);
        bk=page1.getList();
        for (Blank bks:bk){
            System.out.println(bks.getId()+bks.getTime());
        }
    }
}
