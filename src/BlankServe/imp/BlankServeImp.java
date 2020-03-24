package BlankServe.imp;

import BlankServe.BlankServe;
import dao.BlankDao;
import dao.imp.BlankDaoImp;
import entity.Blank;
import entity.Page;

import java.util.List;
@SuppressWarnings("all")
public class BlankServeImp implements BlankServe {
    BlankDao blankDao=new BlankDaoImp();

    @Override
    public int user(String name, String pwd) {
        return blankDao.user(name,pwd);
    }

    @Override
    public int status(String account) {
        return blankDao.status(account);
    }

    @Override
    public int userAdd(String name,String pwd) {
        return blankDao.userAdd(name, pwd);
    }

    @Override
    public int selectName(String name) {
        return blankDao.selectName(name);
    }

    @Override
    public List<Blank> listImg(String name) {
        List<Blank>list=blankDao.listImg(name);
        return list;
    }

    @Override
    public String[] listImg(int id) {
        return blankDao.listImg(id);
    }

    @Override
    public List<Blank> listAll(String name) {
        List<Blank>list=blankDao.listAll(name);
        return list;
    }

    @Override
    public List<Blank> listSize(int id) {
        List<Blank>list=blankDao.listSize(id);
        return list;
    }

    @Override
    public List<Blank> listColor(int id) {
        List<Blank>list=blankDao.listColor(id);
        return list;
    }

    @Override
    public int trade(Blank blank) {
        return blankDao.trade(blank);
    }

    @Override
    public int selectcount(Blank blank) {
        return blankDao.selectcount(blank);
    }

    @Override
    public int updatecount(String name,String color, String userAccount,int shoe) {
        return blankDao.updatecount(name,color,userAccount,shoe);
    }

    @Override
    public List<Blank> listgwc(String userAccount) {
        return blankDao.listgwc(userAccount);
    }


    @Override
    public int deleteGwc(String img, String userAccount,String color,int shoe) {
        return blankDao.deleteGwc(img,userAccount,color,shoe);
    }


    @Override
    public int deleteid(String name,String color, String userAccount,int shoe) {
        return blankDao.deleteid(name,color,userAccount,shoe);
    }


    @Override
    public List<Blank> listxk(String name) {
        return blankDao.listxk(name);
    }

    @Override
    public List<Blank> userName(String name) {
        return blankDao.userName(name);
    }

    @Override
    public String selectPwd(String name) {
        return blankDao.selectPwd(name);
    }

    @Override
    public int updatePwd(String pwd,String account) {
        return blankDao.updatePwd(pwd,account);
    }

    @Override
    public int selectAlter(Blank blank) {
        return blankDao.selectAlter(blank);
    }

    @Override
    public int updateMessage(Blank blank) {
        return blankDao.updateMessage(blank);
    }

    @Override
    public int selectAddress(String account) {
        return blankDao.selectAddress(account);
    }

    @Override
    public int insertAddress(Blank blank) {
        return blankDao.insertAddress(blank);
    }

    @Override
    public List<Blank> listAddress(String account) {
        return blankDao.listAddress(account);
    }

    @Override
    public int updateAddress(Blank blank) {
        return blankDao.updateAddress(blank);
    }

    @Override
    public int deleteAddress(int id) {
        return blankDao.deleteAddress(id);
    }

    @Override
    public int listAddress(Blank blank) {
        return blankDao.listAddress(blank);
    }

    @Override
    public int updateAddress(int b, int id) {
        return blankDao.updateAddress(b,id);
    }

    @Override
    public Blank listName(String name,String account,String color,int shoe) {
        return blankDao.listName(name,account,color,shoe);
    }

    @Override
    public int addCollect(Blank blank) {
        return blankDao.addCollect(blank);
    }

    @Override
    public List<Blank> listCollect(String account) {
        return blankDao.listCollect(account);
    }

    @Override
    public int selectCollect(String name, String account) {
        return blankDao.selectCollect(name,account);
    }

    @Override
    public int deleteCollect(int id,String account) {
        return blankDao.deleteCollect(id,account);
    }

    @Override
    public List<Blank> selectddhao(String user) {
        return blankDao.selectddhao(user);
    }

    @Override
    public List<Blank> selectwzf(String user) {
        return blankDao.selectwzf(user);
    }

    @Override
    public List<Blank> selectdsh(String user) {
        return blankDao.selectdsh(user);
    }

    @Override
    public List<Blank> selectysh(String user) {
        return blankDao.selectysh(user);
    }

    @Override
    public List<Blank> selectyzf(String user) {
        return blankDao.selectyzf(user);
    }


    @Override
    public List<Blank> selectsum() {
        return blankDao.selectsum();
    }

    @Override
    public int gwcCount(String account) {
        return blankDao.gwcCount(account);
    }


    @Override
    public List<Blank> allUser(String userName,int page,int pageMax) {
        return blankDao.allUser(userName,page,pageMax);
    }

    @Override
    public Page page(String userName,int page, int pageMax) {
        Page page1=new Page();
        page1.setPage(page);//当前页数
        page1.setPageMax(pageMax);//每页显示数量
        int sum=blankDao.allUser(userName);
        page1.setConutSum(sum);//总记录数
        int count=sum%pageMax==0?sum/pageMax:sum/pageMax+1;
        page1.setPageSum(count);//总页数
        page1.setList(blankDao.allUser(userName,page,pageMax));
        return page1;
    }

    @Override
    public int updateStatus(int status, int id) {
        return blankDao.updateStatus(status,id);
    }

    @Override
    public int deleteUser(int id) {
        return blankDao.deleteUser(id);
    }

    @Override
    public Page selectpage(int page, int pagemax) {
        Page page1 = new Page();
        page1.setPage(page);
        int count=blankDao.selectcount();
        page1.setConutSum(count);
        int pagecount=count%pagemax==0?count/pagemax:count/pagemax+1;
        page1.setPageSum(pagecount);
        page1.setList(blankDao.htselectdd((page-1)*pagemax,pagemax));
        return page1;
    }

    @Override
    public List<Blank> listSpu(Blank blank) {
        /* return blankDao.listSpu(blank);*/
        return null;
    }

    @Override
    public String selectBrand(int id) {
        return blankDao.selectBrand(id);
    }

    @Override
    public String selectClassify(int id) {
        return blankDao.selectClassify(id);
    }

    @Override
    public int selectCount(int id) {
        return blankDao.selectCount(id);
    }

    @Override
    public List<Blank> listBrand() {
        return blankDao.listBrand();
    }

    @Override
    public List<Blank> listClass() {
        return blankDao.listClass();
    }

    @Override
    public int deleteGwc(int id) {
        return blankDao.deleteGwc(id);
    }

    @Override
    public int updateGwc(int count, int id) {
        return blankDao.updateGwc(count, id);
    }

    @Override
    public int insertshouhuo(Blank blank) {
        return blankDao.insertshouhuo(blank);
    }

    @Override
    public List<Blank> listshouhuo() {
        return blankDao.listshouhuo();
    }

    @Override
    public int insertDDxxi(Blank blank) {
        return blankDao.insertDDxxi(blank);
    }

    @Override
    public int insertDDbiao(Blank blank) {
        return blankDao.insertDDbiao(blank);
    }

    @Override
    public int deletegwcs(String name,int shoe,String color) {
        return blankDao.deletegwcs(name,shoe,color);
    }

    @Override
    public int updateDD(String zhifzt,String ddhao,String user) {
        return blankDao.updateDD(zhifzt, ddhao,user);
    }

    @Override
    public int deletedd(String ddhao) {
        return blankDao.deletedd(ddhao);
    }

    @Override
    public int deletezdd(String ddhao) {
        return blankDao.deletezdd(ddhao);
    }

    @Override
    public Blank selectkucun(int size, String color, String title, int price) {
        return blankDao.selectkucun(size,color,title,price);
    }

    @Override
    public int updatekucun(Blank blank) {
        return blankDao.updatekucun(blank);
    }

}
