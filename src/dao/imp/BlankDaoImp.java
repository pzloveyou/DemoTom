package dao.imp;

import dao.BaseDao;
import dao.BlankDao;
import entity.Blank;
import entity.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
public class BlankDaoImp extends BaseDao implements BlankDao {
    public int user(String name, String pwd) {
        String sql = "SELECT COUNT(*) FROM user WHERE account=? AND Pwd=?";
        Object[] param = {name, pwd};
        ResultSet rs = super.exceuteQuery(sql, param);
        int count = 0;
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int status(String account) {
        String sql="SELECT `status` FROM `user` WHERE account=?";
        Object[]param={account};
        ResultSet rs=null;
        int count=-1;
        try {
            rs=super.exceuteQuery(sql,param);
            while (rs.next()){
                count=rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int userAdd(String name, String pwd) {
        String sql = "insert into user(account,Pwd) values(?,?) ";
        Object[] params = {name, pwd};
        int count = 0;
        try {
            count = super.exceuteUpdate(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int selectName(String name) {
        String sql = "SELECT COUNT(*) FROM user WHERE account=? ";
        Object[] param = {name};
        ResultSet rs = super.exceuteQuery(sql, param);
        int count = 0;
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }


    @Override
    public List<Blank> listImg(String name) {
        String sql = "SELECT name FROM img WHERE imgId in(SELECT imgId FROM img WHERE  name=?)";
        ResultSet rs = null;
        List<Blank> list = new ArrayList<Blank>();
        Object[] param = {name};
        rs = super.exceuteQuery(sql, param);
        try {
            while (rs.next()) {
                Blank blank = new Blank();
                blank.setImgName(rs.getString(1));
                list.add(blank);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String[] listImg(int id) {
        String sql = "SELECT name FROM img WHERE imgId=?";
        ResultSet rs = null;
        String[] imgName = null;
        List<Blank> list = new ArrayList<Blank>();
        Object[] param = {id};
        rs = super.exceuteQuery(sql, param);
        try {
            while (rs.next()) {
                Blank blank = new Blank();
                blank.setImgName(rs.getString(1));
                list.add(blank);
            }
            imgName = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                imgName[i] = list.get(i).getImgName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgName;
    }

    @Override
    public List<Blank> listAll(String name) {
        String sql = "SELECT * FROM spu WHERE imgId =(SELECT imgId FROM img WHERE name=?) and state=1";
        ResultSet rs = null;
        List<Blank> list = new ArrayList<Blank>();
        Object[] param = {name};
        rs = super.exceuteQuery(sql, param);
        try {
            while (rs.next()) {
                Blank blank = new Blank();
                blank.setId(rs.getInt(1));
                blank.setBrandid(rs.getInt(2));
                blank.setClassifyid(rs.getInt(3));
                blank.setSex(rs.getString(4));
                blank.setTitle(rs.getString(5));
                blank.setOriginalPrice(rs.getInt(6));
                blank.setPrice(rs.getInt(7));
                blank.setImgId(rs.getInt(8));
                list.add(blank);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Blank> listSize(int id) {
        String sql = "SELECT COUNT(size),size,sum(count) FROM shoe WHERE spuId=? GROUP BY size,count HAVING count(size)>0";
        ResultSet rs = null;
        List<Blank> list = new ArrayList<Blank>();
        Object[] param = {id};
        rs = super.exceuteQuery(sql, param);
        try {
            while (rs.next()) {
                Blank blank = new Blank();
                blank.setSize(rs.getInt(2));
                blank.setKucun(rs.getInt(3));
                list.add(blank);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Blank> listColor(int id) {
        String sql = "SELECT count(color),color  FROM  color WHERE colorId in(SELECT colorId FROM shoe  WHERE spuId =?)   GROUP BY color HAVING count(color)>0";
        ResultSet rs = null;
        List<Blank> list = new ArrayList<Blank>();
        Object[] param = {id};
        rs = super.exceuteQuery(sql, param);
        try {
            while (rs.next()) {
                Blank blank = new Blank();
                blank.setColor(rs.getString(2));
              /*  for (int i=0;i<list.size();i++){
                    if (list.get(i).getColor()!=blank.getColor()){

                    }else {
                        continue;
                    }
                }*/
                list.add(blank);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int trade(Blank blank) {
        String sql = "INSERT into gwc(tradeimg,tradeName,tradecolor,tradeshoe,tradeprice,tradecount,userAccount)VALUES(?,?,?,?,?,?,?)";
        Object[] params = {blank.getTradeImg(), blank.getTradeName(), blank.getTradeColor(), blank.getTradeShoe(), blank.getTradePrice(), blank.getTradeCount(), blank.getAccount()};
        int counts = 0;
        try {
            counts = super.exceuteUpdate(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return counts;
    }

    @Override
    public int selectcount(Blank blanks) {
        String sql = "select count(*) from gwc where tradeName=? and tradecolor=? and tradeshoe=? and userAccount=?";
        Object[] param = {blanks.getTradeName(),blanks.getTradeColor(),blanks.getTradeShoe(),blanks.getAccount()};
        ResultSet rs = null;
       int sum=0;
        rs = super.exceuteQuery(sql, param);
        try {
            rs.next();
            sum=rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    @Override
    public int updatecount(String name,String color, String userAccount,int shoe) {
        String sql = "\n" +
                "update gwc set tradecount=tradecount+1 where tradecolor=? and tradeshoe=? and userAccount=? and tradeName=?";
        Object[] params = {color,shoe, userAccount,name};
        int bk = 0;
        try {
            bk = super.exceuteUpdate(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bk;
    }


    @Override
    public List<Blank> listgwc(String userAccount) {
        String sql = "  SELECT tradeName,tradeprice,tradeimg,tradeshoe,tradecolor,tradeprice,tradecount from gwc \n" +
                "where userAccount=? GROUP BY tradeName,tradeprice,tradeimg,tradeshoe,tradecolor,tradeprice,tradecount";
        Object[] param = {userAccount};
        ResultSet rs = null;
        List<Blank> list = new ArrayList<Blank>();
        rs = super.exceuteQuery(sql, param);
        try {
            while (rs.next()) {
                Blank blank = new Blank();
                blank.setTradeName(rs.getString(1));
                blank.setTradePrice(rs.getInt(2));
                blank.setTradeImg(rs.getString(3));
                blank.setTradeShoe(rs.getInt(4));
                blank.setTradeColor(rs.getString(5));
                blank.setTradePrice(rs.getInt(6));
                blank.setTradeCounts(rs.getInt(7));
                list.add(blank);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public int deleteGwc(String img, String userAccount,String color,int shoe) {
        String sql = "DELETE FROM gwc WHERE tradeimg=? and userAccount=? and tradecolor=? and tradeshoe=?";
        Object[] param = {img, userAccount,color,shoe};
        int count = 0;
        try {
            count = super.exceuteUpdate(sql, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int deleteid(String name,String color, String userAccount,int shoe) {
        String sql = "\n" +
                "update gwc set tradecount=tradecount-1 where tradecolor=? and tradeshoe=? and userAccount=? and tradeName=?";
        Object[] params = {color,shoe, userAccount,name};
        int bk = 0;
        try {
            bk = super.exceuteUpdate(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bk;
    }



    @Override
    public int deleteGwc(int id) {
        String sql="DELETE FROM gwc WHERE tradeid=?";
        Object[] param={id};
        int count=0;
        try {
            count=super.exceuteUpdate(sql,param);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateGwc(int count, int id) {
        String sql="UPDATE gwc SET tradecount=?   where tradeid=?";
        Object[] param={count,id};
        int sum=0;
        try {
            sum=super.exceuteUpdate(sql,param);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sum;
}

    @Override
    public List<Blank> listxk(String name) {
        String sql = "SELECT * FROM spu  WHERE title LIKE ? and state=1";
        Object[] param = {"%" + name + "%"};
        ResultSet rs = null;
        List<Blank> list = new ArrayList<Blank>();
        rs = super.exceuteQuery(sql, param);
        try {
            while (rs.next()) {
                Blank blank = new Blank();
                blank.setId(rs.getInt(1));
                blank.setBrandid(rs.getInt(2));
                blank.setClassifyid(rs.getInt(3));
                blank.setSex(rs.getString(4));
                blank.setTitle(rs.getString(5));
                blank.setOriginalPrice(rs.getInt(6));
                blank.setPrice(rs.getInt(7));
                blank.setImgId(rs.getInt(8));

                list.add(blank);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Blank> userName(String name) {
        String sql = "SELECT * FROM  user  WHERE account=?";
        Object[] param = {name};
        List<Blank> list = new ArrayList<Blank>();
        ResultSet rs = null;
        rs = super.exceuteQuery(sql, param);
        Blank blank = new Blank();
        try {
            while (rs.next()) {
                blank.setUserId(rs.getInt(1));
                blank.setAccount(rs.getString(2));
                blank.setPwd(rs.getString(3));
                blank.setUserName(rs.getString(4));
                blank.setUserSex(rs.getString(5));
                blank.setBirthday(rs.getString(6));
                blank.setAddress(rs.getString(7));
                list.add(blank);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String selectPwd(String name) {
        String sql = "select Pwd FROM `user` WHERE account=?";
        Object[] param = {name};
        ResultSet rs = null;
        String pwd = null;
        try {
            rs = super.exceuteQuery(sql, param);
            while (rs.next()) {
                pwd = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pwd;
    }


    @Override
    public int updatePwd(String pwd, String account) {
        String sql = "UPDATE `user` SET Pwd=?  WHERE account=?";
        Object[] param = {pwd, account};
        int count = super.exceuteUpdate(sql, param);
        return count;
    }

    @Override
    public int selectAlter(Blank blank) {
        String sql = "SELECT COUNT(1) FROM `user` WHERE userName=? AND sex=? AND birthday=? AND address=?  AND account=?";
        Object[] param = {blank.getUserName(), blank.getSex(), blank.getBirthday(), blank.getAddress(), blank.getAccount()};
        ResultSet rs = null;
        int count = 0;
        try {
            rs = super.exceuteQuery(sql, param);
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateMessage(Blank blank) {
        String sql = "UPDATE `user` SET userName=? , sex=? , birthday=? , address=? WHERE account=?";
        Object[] param = {blank.getUserName(), blank.getSex(), blank.getBirthday(), blank.getAddress(), blank.getAccount()};
        int count = super.exceuteUpdate(sql, param);
        return count;
    }

    @Override
    public int selectAddress(String account) {
        String sql = "SELECT COUNT(1) FROM directoryinquiries WHERE userAccount=?";
        Object[] param = {account};
        ResultSet rs = super.exceuteQuery(sql, param);
        int count = 0;
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int insertAddress(Blank blank) {
        String sql = "INSERT into directoryinquiries(recipients,phone,province,city,area,detailed,defaultValue,userAccount)VALUES(?,?,?,?,?,?,?,?);";
        Object[] param = {blank.getRecipients(), blank.getPhone(), blank.getProvince(), blank.getCity(), blank.getArea(), blank.getDetailed(), blank.getDefaultValue(), blank.getAccount()};
        int count = super.exceuteUpdate(sql, param);
        return count;
    }

    @Override
    public List<Blank> listAddress(String account) {
        String sql = "SELECT * FROM `directoryinquiries` WHERE userAccount=? ORDER BY defaultValue";
        Object[] param = {account};
        List<Blank> list = new ArrayList<Blank>();
        ResultSet rs = super.exceuteQuery(sql, param);
        try {
            while (rs.next()) {
                Blank blank = new Blank();
                blank.setId(rs.getInt(1));
                blank.setRecipients(rs.getString(2));
                blank.setPhone(rs.getString(3));
                blank.setProvince(rs.getString(4));
                blank.setCity(rs.getString(5));
                blank.setArea(rs.getString(6));
                blank.setDetailed(rs.getString(7));
                blank.setDefaultValue(rs.getInt(8));
                blank.setAccount(rs.getString(9));
                list.add(blank);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int updateAddress(Blank blank) {
        String sql = "UPDATE directoryinquiries SET recipients=?,phone=?,province=?,city=?,area=?,detailed=?,defaultValue=? WHERE id=?";
        Object[] param = {blank.getRecipients(), blank.getPhone(), blank.getProvince(), blank.getCity(), blank.getArea(), blank.getDetailed(), blank.getDefaultValue(), blank.getId()};
        int count = super.exceuteUpdate(sql, param);
        return count;
    }

    @Override
    public int deleteAddress(int id) {
        String sql = "DELETE FROM directoryinquiries WHERE id=?";
        Object[] param = {id};
        int count = super.exceuteUpdate(sql, param);
        return count;
    }

    @Override
    public int listAddress(Blank blank) {
        String sql = "SELECT count(1) FROM `directoryinquiries` WHERE recipients=? AND phone=? AND province=? AND city=? AND area=? AND detailed=? AND defaultValue=? AND userAccount=? AND id=? ";
        Object[] param = {blank.getRecipients(), blank.getPhone(), blank.getProvince(), blank.getCity(), blank.getArea(), blank.getDetailed(), blank.getDefaultValue(), blank.getAccount(), blank.getId()};
        int count = 0;
        ResultSet rs = super.exceuteQuery(sql, param);
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateAddress(int b, int id) {
        String sql = "UPDATE directoryinquiries SET defaultValue=? WHERE id=?";
        Object[] param = {b, id};
        int count = super.exceuteUpdate(sql, param);
        return count;
    }


    public Blank listName(String name,String account,String color,int shoe) {
        String sql = "SELECT tradeimg,tradeName,tradeprice,tradeshoe,tradecolor,count(tradecount) from gwc  where tradeName=? and userAccount=? and tradecolor=? and tradeshoe=? GROUP BY tradeprice,tradeshoe,tradecolor,tradeimg";
        Object[] params = {name,account,color,shoe};
        List<Blank> list = null;
        Blank bk = new Blank();
        try {
            ResultSet rs = super.exceuteQuery(sql, params);
            rs.next();
            bk.setTradeImg(rs.getString(1));
            bk.setTradeName(rs.getString(2));
            bk.setTradePrice(rs.getInt(3));
            bk.setTradeShoe(rs.getInt(4));
            bk.setTradeColor(rs.getString(5));
            bk.setTradeCounts(rs.getInt(6));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bk;
    }

    @Override
    public int addCollect(Blank blank) {
        String sql="INSERT INTO collect(src,title,originalPrice,Price,userAccount) VALUES(?,?,?,?,?)";
        Object[]param={blank.getImgName(),blank.getTitle(),blank.getOriginalPrice(),blank.getPrice(),blank.getAccount()};
        int count=super.exceuteUpdate(sql,param);
        return count;
    }

    @Override
    public List<Blank> listCollect(String account) {
        String sql="select * from collect where userAccount=?";
        Object[]param={account};
        List<Blank>list=new ArrayList<Blank>();
        ResultSet rs=null;
        try{
            rs=super.exceuteQuery(sql,param);
            while (rs.next()){
                Blank blank=new Blank();
                blank.setId(rs.getInt(1));
                blank.setImgName(rs.getString(2));
                blank.setTitle(rs.getString(3));
                blank.setOriginalPrice(rs.getInt(4));
                blank.setPrice(rs.getInt(5));
                blank.setAccount(rs.getString(6));
                list.add(blank);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int selectCollect(String name, String account) {
        String sql="select COUNT(1) from collect WHERE src=? AND userAccount=?";
        Object[]param={name,account};
        ResultSet rs=super.exceuteQuery(sql,param);
        int count=0;
        try {
            while (rs.next()){
                count=rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int deleteCollect(int id,String account) {
        String sql="DELETE FROM collect WHERE id=? AND userAccount=?";
        Object[]param={id,account};
        int count=super.exceuteUpdate(sql,param);
        return count;
    }

    @Override
    public List<Blank> selectddhao(String user) {
        String sql="select ddhao,zhifzt,price,countm,ddname from zhubiao where userAccount=?";
        Object[] params={user};
        List<Blank> list=new ArrayList<Blank>();
        try{
            ResultSet rs=super.exceuteQuery(sql,params);
            while (rs.next()){
                Blank bk=new Blank();
                bk.setDdhao(rs.getString(1));
                bk.setZt(rs.getString(2));
                bk.setPrice(rs.getInt(3));
                bk.setCount(rs.getInt(4));
                bk.setDdname(rs.getString(5));
                list.add(bk);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Blank> selectwzf(String user) {
        String sql="select ddhao,zhifzt,price,countm,ddname from zhubiao where userAccount=? and zhifzt='未支付'";
        Object[] params={user};
        List<Blank> list=new ArrayList<Blank>();
        try{
            ResultSet rs=super.exceuteQuery(sql,params);
            while (rs.next()){
                Blank bk=new Blank();
                bk.setDdhao(rs.getString(1));
                bk.setZt(rs.getString(2));
                bk.setPrice(rs.getInt(3));
                bk.setCount(rs.getInt(4));
                bk.setDdname(rs.getString(5));
                list.add(bk);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Blank> selectdsh(String user) {
        String sql="select ddhao,zhifzt,price,countm,ddname from zhubiao where userAccount=? and zhifzt='待收货'";
        Object[] params={user};
        List<Blank> list=new ArrayList<Blank>();
        try{
            ResultSet rs=super.exceuteQuery(sql,params);
            while (rs.next()){
                Blank bk=new Blank();
                bk.setDdhao(rs.getString(1));
                bk.setZt(rs.getString(2));
                bk.setPrice(rs.getInt(3));
                bk.setCount(rs.getInt(4));
                bk.setDdname(rs.getString(5));
                list.add(bk);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Blank> selectysh(String user) {
        String sql="select ddhao,zhifzt,price,countm,ddname from zhubiao where userAccount=? and zhifzt='已收货'";
        Object[] params={user};
        List<Blank> list=new ArrayList<Blank>();
        try{
            ResultSet rs=super.exceuteQuery(sql,params);
            while (rs.next()){
                Blank bk=new Blank();
                bk.setDdhao(rs.getString(1));
                bk.setZt(rs.getString(2));
                bk.setPrice(rs.getInt(3));
                bk.setCount(rs.getInt(4));
                bk.setDdname(rs.getString(5));
                list.add(bk);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Blank> selectyzf(String user) {
        String sql="select ddhao,zhifzt,price,countm,ddname from zhubiao where userAccount=? and zhifzt='已支付'";
        Object[] params={user};
        List<Blank> list=new ArrayList<Blank>();
        try{
            ResultSet rs=super.exceuteQuery(sql,params);
            while (rs.next()){
                Blank bk=new Blank();
                bk.setDdhao(rs.getString(1));
                bk.setZt(rs.getString(2));
                bk.setPrice(rs.getInt(3));
                bk.setCount(rs.getInt(4));
                bk.setDdname(rs.getString(5));
                list.add(bk);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public List<Blank> selectsum(){
        String sql="select ddhao,name,prices,shoe,yanse,shulian,img from fubiao";
        List<Blank> list=new ArrayList<Blank>();
        try{
            ResultSet rs=super.exceuteQuery(sql,null);
            while (rs.next()){
                Blank bk=new Blank();
                bk.setDdhao(rs.getString(1));
                bk.setName(rs.getString(2));
                bk.setDdprice(rs.getInt(3));
                bk.setTradeShoe(rs.getInt(4));
                bk.setColor(rs.getString(5));
                bk.setTradeCounts(rs.getInt(6));
                bk.setTradeImg(rs.getString(7));
                list.add(bk);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int gwcCount(String account) {
        String sql="select sum(tradecount) from gwc where userAccount=?";
        int cm=0;
        Object[] params={account};
        try{
            ResultSet rs=super.exceuteQuery(sql,params);
            rs.next();
             cm=rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cm;
    }


    @Override
    public int allUser(String userName) {
        String sql="SELECT count(1) FROM `user` where userName like ?";
        Object[]param={"%"+userName+"%"};
        ResultSet rs=null;
        int sum=-1;
        try {
            rs=super.exceuteQuery(sql,param);
            while (rs.next()){
                sum=rs.getInt(1);
            }
        }catch (Exception e){
        }
        return sum;
    }

    @Override
    public List<Blank> allUser(String userName,int page,int pageMax) {
        String sql="SELECT * FROM `user` where userName like ? ORDER BY id limit ?,?";
        Object[]param={"%"+userName+"%",(page-1)*pageMax,pageMax};
        ResultSet rs=null;
        List<Blank>list=new ArrayList<Blank>();
        try {
            rs=super.exceuteQuery(sql,param);
            while (rs.next()){
                Blank blank=new Blank();
                blank.setId(rs.getInt(1));
                blank.setAccount(rs.getString(2));
                blank.setPwd(rs.getString(3));
                blank.setUserName(rs.getString(4));
                blank.setUserSex(rs.getString(5));
                blank.setBirthday(rs.getString(6));
                blank.setAddress(rs.getString(7));
                blank.setStatus(rs.getInt(8));
                list.add(blank);
            }
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public int updateStatus(int status,int id) {
        String sql="UPDATE `user` SET status=? WHERE id=?";
        Object[]param={status,id};
        int count=super.exceuteUpdate(sql,param);
        return count;
    }

    @Override
    public int deleteUser(int id) {
        String sql="DELETE FROM user WHERE id=?";
        Object[]param={id};
        int count=super.exceuteUpdate(sql,param);
        return count;
    }

    @Override
    public List<Blank> htselectdd(int page,int pagemax) {
        String sql="select * from zhubiao limit ?,?";
        Object[] params={page,pagemax};
        List<Blank> list = new ArrayList<Blank>();
        try{
            ResultSet resultSet = super.exceuteQuery(sql,params);
            while (resultSet.next()){
                Blank bk=new Blank();
                bk.setId(resultSet.getInt(1));
                bk.setDdhao(resultSet.getString(2));
                bk.setPrice(resultSet.getInt(3));
                bk.setName(resultSet.getString(4));
                bk.setDizhi(resultSet.getString(5));
                bk.setZt(resultSet.getString(6));
                bk.setPhones(resultSet.getString(7));
                bk.setAccount(resultSet.getString(8));
                bk.setCount(resultSet.getInt(9));
                bk.setTime(resultSet.getString(10));
                bk.setFkmoney(resultSet.getString(11));
                list.add(bk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Blank> selecttj(Blank bk) {
        String sql="select * from zhubiao where id in(select id FROM zhubiao where id>=(select id from zhubiao where time=? ORDER BY id asc LIMIT 1) and id<=(select id from zhubiao where time=? ORDER BY id desc LIMIT 1)\n" +
                ") or  zhifzt=? or \n" +
                " fkmoney=? or\n" +
                " ddhao=? ";
        return null;
    }

    @Override
    public int selectcount() {
        String sql="select count(*) from zhubiao";
        ResultSet rs=super.exceuteQuery(sql,null);
        int count= 0;
        try {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Blank> listSpu(Blank blank,int page,int pageMax) {/**//*,*/
        String sql="select * FROM spu WHERE  id LIKE ? AND title LIKE ? AND brandid in(SELECT id FROM brand WHERE brandName LIKE ?)AND classifyid in(SELECT id FROM classify WHERE classifyName LIKE ?) AND price between ? and ? limit ?,?";
        Object []param={"%"+blank.getId()+"%","%"+blank.getTitle()+"%","%"+blank.getBrandName()+"%","%"+blank.getClassification()+"%",blank.getPrice(),blank.getOriginalPrice(),page,pageMax};
        List<Blank>list=new ArrayList<Blank>();
        ResultSet rs=null;
        try{
            rs=super.exceuteQuery(sql,param);
            while (rs.next()){
                Blank blank2 = new Blank();
                blank2.setId(rs.getInt(1));
                blank2.setBrandid(rs.getInt(2));
                blank2.setClassifyid(rs.getInt(3));
                blank2.setSex(rs.getString(4));
                blank2.setTitle(rs.getString(5));
                blank2.setOriginalPrice(rs.getInt(6));
                blank2.setPrice(rs.getInt(7));
                blank2.setImgId(rs.getInt(8));
                blank2.setStatus(rs.getInt(9));
                list.add(blank2);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String selectBrand(int id) {
        String sql="select brandName FROM brand WHERE id=?";
        Object[]param={id};
        String brandName="";
        ResultSet rs=null;
        try{
            rs=super.exceuteQuery(sql,param);
            while (rs.next()){
                brandName=rs.getString(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return brandName;
    }

    @Override
    public String selectClassify(int id) {
        String sql="select classifyName FROM classify WHERE id=?";
        Object[]param={id};
        String classifyName="";
        ResultSet rs=null;
        try{
            rs=super.exceuteQuery(sql,param);
            while (rs.next()){
                classifyName=rs.getString(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return classifyName;
    }

    @Override
    public int selectCount(int id) {
        String sql="select sum(count) FROM shoe WHERE spuid=?";
        Object[]param={id};
        int count=-1;
        ResultSet rs=null;
        try{
            rs=super.exceuteQuery(sql,param);
            while (rs.next()){
                count=rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int countSpu(Blank blank) {
        String sql="select count(1) from spu";
        return 0;
    }

    @Override
    public List<Blank> listBrand() {
        String  sql="select * FROM brand";
        ResultSet rs=null;
        List<Blank>list=new ArrayList<Blank>();
        try{
            rs=super.exceuteQuery(sql,null);
            while (rs.next()){
                Blank blank=new Blank();
                blank.setBrandid(rs.getInt(1));
                blank.setBrandName(rs.getString(2));
                list.add(blank);
            }
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public List<Blank> listClass() {
        String  sql="select * FROM classify";
        ResultSet rs=null;
        List<Blank>list=new ArrayList<Blank>();
        try{
            rs=super.exceuteQuery(sql,null);
            while (rs.next()){
                Blank blank=new Blank();
                blank.setClassifyid(rs.getInt(1));
                blank.setClassification(rs.getString(2));
                list.add(blank);
            }
        }catch (Exception e){

        }
        return list;
    }
        @Override
        public int insertshouhuo(Blank blank) {
            String sql="insert into shouhuodizhi(shenf,shiqu,xian,dizhi,phone,bq) value(?,?,?,?,?,?)";
            Object []params={blank.getShenf(),blank.getShiqu(),blank.getXian(),blank.getDizhi(),blank.getPhone(),blank.getBq()};
            int count=-1;
            try{
                count=super.exceuteUpdate(sql,params);
            }catch (Exception e){
                e.printStackTrace();
            }
            return count;
        }


        public List<Blank> listshouhuo() {
            String sql="select shenf,shiqu,xian,dizhi,phone,bq from shouhuodizhi";
            List<Blank> list = new ArrayList<Blank>();
            try {
                ResultSet rs = super.exceuteQuery(sql, null);
                while (rs.next()) {
                    Blank bk = new Blank();
                    bk.setShenf(rs.getString(1));
                    bk.setShiqu(rs.getString(2));
                    bk.setXian(rs.getString(3));
                    bk.setDizhi(rs.getString(4));
                    bk.setPhone(rs.getString(5));
                    bk.setBq(rs.getString(6));
                    list.add(bk);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return list;
        }

        @Override
        public int insertDDxxi(Blank blank) {
            String sql="insert into zhubiao(ddhao,price,ddname,dizhi,zhifzt,phone,userAccount,countm,time,fkmoney) value(?,?,?,?,?,?,?,?,?,?);";
            Object[] params={blank.getDdhao(),blank.getDdprice(),blank.getDdname(),blank.getDdzhi(),
                    blank.getZt(),blank.getPhones(),blank.getAccount(),blank.getCount(),blank.getTime(),blank.getFkmoney()};
            int count=0;
            try{
                count=super.exceuteUpdate(sql,params);
            }catch (Exception e){
                e.printStackTrace();
            }
            return count;
        }

        @Override
        public int insertDDbiao(Blank blank) {
            String sql="insert into fubiao(ddhao,name,prices,shoe,yanse,shulian,img) value(?,?,?,?,?,?,?);";
            Object[] params={blank.getDdhao(),blank.getTradeName(),blank.getTradePrice(),blank.getTradeShoe(),blank.getTradeColor(),blank.getTradeCounts(),blank.getTradeImg()};
            int count=0;
            try{
                count=super.exceuteUpdate(sql,params);
            }catch (Exception e){
                e.printStackTrace();
            }
            return count;
        }

        @Override
        public int deletegwcs(String name,int shoe,String color) {
            String sql="delete from gwc where tradeName=? and tradeshoe=? and tradecolor=?";
            Object []params={name,shoe,color};
            int count=0;
            try{
                count=super.exceuteUpdate(sql,params);
            }catch (Exception e){
                e.printStackTrace();
            }
            return count;
        }
        @Override
    public int updateDD(String zhifzt,String ddhao,String user) {
        String sql="update zhubiao set zhifzt=? where ddhao=? and userAccount=?";
        Object[] params={zhifzt,ddhao,user};
        int cout=0;
        try{
            cout=super.exceuteUpdate(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cout;
    }

    @Override
    public int deletedd(String ddhao) {
        String sql="delete from fubiao where ddhao=?";
        Object[] params={ddhao};
        int count=0;
        try{
            count=super.exceuteUpdate(sql,params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int deletezdd(String ddhao) {
        String sql="delete from zhubiao where ddhao=?";
        Object[] params={ddhao};
        int count=0;
        try{
            count=super.exceuteUpdate(sql,params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Blank selectkucun(int size, String color, String title, int price) {
        String sql="select count,size,colorId,spuId from shoe where size=? and colorId=(select colorId from color where color=?) and spuId\n" +
                "=(select id from spu where title=? and price=?)";
        Object[] params={size,color, title,price};
        int sum=0;
        Blank bk=new Blank();
        try{
            ResultSet rs=super.exceuteQuery(sql,params);
            while (rs.next()){
                bk.setTradeCounts(rs.getInt(1));
                bk.setTradeShoe(rs.getInt(2));
                bk.setTradeColor(rs.getString(3));
                bk.setTradeId(rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bk;
    }
    public int updatekucun(Blank blank){
        String sql="update shoe set count=? where size=? and colorId=? and spuId=?";
        Object[] params={blank.getTradeCounts(),blank.getTradeShoe(),blank.getTradeColor(),blank.getTradeId()};
        int count=0;
        try{
            count=super.exceuteUpdate(sql,params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
