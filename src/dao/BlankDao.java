package dao;

import entity.Blank;

import javax.print.DocFlavor;
import java.util.List;

public interface BlankDao {
    /**
     * 前端
     * @param name
     * @param pwd
     * @return
     */
    //查询用户
    int user(String name,String pwd);
    //查询用户状态码
    int status(String account);
    //新增用户
    int userAdd(String name,String pwd);
    //查询用户名是否存在
    int selectName(String name);
    //搜素图片     根据路进
    List<Blank> listImg(String name);
    //搜素图片     根据图片id
    String[] listImg(int id);
    //查询所有    根据路进
    List<Blank>listAll(String name);
    //查询鞋子码数  根据id查询
    List<Blank>listSize(int id);
    //查出颜色
    List<Blank>listColor(int id);
    //新增购物车数据
    int trade(Blank blank);
    //
    int selectcount(Blank blank);
    //
    int updatecount(String name,String color, String userAccount,int shoe);
    //查询购物车数据
    List<Blank>listgwc(String userAccount);
    //删除购物车数据
    int deleteGwc(String img,String userAccount,String color,int shoe);
    //修改购物车页面鞋子数量
    int deleteid(String name,String color, String userAccount,int shoe);
    //

    //根据文本框内容模糊查询数据
    List<Blank>listxk(String name);
    /*  //查询多少钱到多少钱之间
      List<Blank>listxk(int price,int price2);*/
    //查询用户信息  根据账户
    List<Blank>userName(String account);
    //查询密码是否正确   根据账户
    String selectPwd(String account );
    //修改密码
    int updatePwd(String pwd,String account);
    //查询信息是否改变
    int selectAlter(Blank blank);
    //修改用户信息 根据账户
    int updateMessage(Blank blank);
    //查询用户收货地址有几个
    int selectAddress(String account);
    //新增收货地址
    int insertAddress(Blank blank);
    //查询收货地址 根据账号
    List<Blank>listAddress(String account);
    //修改收货地址   根据id
    int updateAddress(Blank blank);
    //删除收货地址    根据id
    int deleteAddress(int id);
    //搜索单个地址是否存在
    int listAddress(Blank blank);
    //修改默认地址    根据id
    int updateAddress(int b,int id);
    //根据购物车名称查询所有
    Blank listName(String name ,String account,String color,int shoe);
    //添加收藏
    int addCollect(Blank blank);
    //查询收藏
    List<Blank>listCollect(String account);
    //搜索该商品是否已收藏
    int selectCollect(String name,String account);
    //删除收藏
    int deleteCollect(int id,String account);
    //根据帐号查询所有订单号
    List<Blank> selectddhao(String user);
    //查询未支付的订单号
    List<Blank> selectwzf(String user);
    //查询待收货的订单号
    List<Blank> selectdsh(String user);
    //查询已收货的订单号
    List<Blank> selectysh(String user);
    //查询已支付的订单号
    List<Blank> selectyzf(String user);
    //根据查询对应的所有订单信息
     List<Blank> selectsum();
     //购物车商品数量
    int gwcCount(String account);
    /**
     *   后台
     *     查出所有用户+模糊查询+分页
     */
    List<Blank>allUser(String userName,int page,int pageMax);
    //查出总记录数
    int allUser(String userName);
    //修改用户状态  根据id
    int updateStatus(int status,int id);
    //删除用户 根据id
    int deleteUser(int id);
    //查出所有订单信息
    List<Blank> htselectdd(int page,int pagemax);
    //根据条件查询订单信息
    List<Blank> selecttj(Blank bk);
    //查询订单信息数量
    int selectcount();
    /**
     * 查询所有商品  上架数据
     * 查询品牌   品牌id
     * 查询类型  类型id
     * 查出库存  根据鞋子id 查出鞋子库存
     * 查出总数量 分页
     */
    List<Blank>listSpu(Blank blank,int page,int pageMax);
    String selectBrand(int id);
    String selectClassify(int id);
    int selectCount(int id);
    int countSpu(Blank blank);

    /**
     * 添加新的商品是的条件  也就是上架的条件
     * 第一个  品牌
     * 第二个  类型
     */
    List<Blank>listBrand();  //查询所有的品牌
    List<Blank>listClass();//查询所有的类型
    int deleteGwc(int id);
    int updateGwc(int count, int id);


    /**
     * 前端
     * @param blank
     * @return
     */
    //收货地址信息新增/查询
    int insertshouhuo(Blank blank);
    List<Blank> listshouhuo();
    //新增订单信息
    int insertDDxxi(Blank blank);
    int insertDDbiao(Blank blank);
    //新增完订单删除购物车数据
    int deletegwcs(String name,int shoe,String color);
    //支付成功修改为已支付
    int updateDD(String zhifzt,String ddhao,String user);
    //删除订单附表
    int deletedd(String ddhao);
    //删除订单主表
    int deletezdd(String ddhao);
    //查询库存
    Blank selectkucun(int size,String color,String title,int price);
    //库存计算
    int updatekucun(Blank blank);
}
