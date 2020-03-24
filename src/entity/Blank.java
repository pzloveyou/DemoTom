package entity;

public class Blank {
    private int id;//单个商品iid
    private int brandid;//品牌id
    private int classifyid;//类型id
    private String color;//颜色
    private String sex;//性别
    private int imgId;//图片id
    private String imgName;//图片名称（路径）
    private String title;//标题
    private String brandName;//品牌名
    private String classification;//类型名
    private int price;//价格
    private int originalPrice;//原价
    private int shoeId;//鞋子id
    private int size;//鞋子码数
    private int count;//鞋子数量
    private int colorId;//鞋子颜色Id
    private String name;//用户名
    private int userId;//用户id
    private  int kucun;  //库存


    private String account;//用户账号
    private String pwd;//用户密码
    private String userName;//用户名字
    private String userSex;//用户性别
    private String birthday;//生日日期
    private String address;//家庭地址
    private int tradeId;//购物车数据id
    private String tradeImg;//购物车图片路径
    private String tradeName;//购物车商品名称
    private String tradeColor;//购物车商品颜色
    private int tradeShoe;//购物车商品鞋码
    private int tradePrice;//购物车商品价格
    private int tradeCount;//购物车商品数量
    private int tradeCounts;//商品总数量

    private String recipients;//收货人
    private String province;//收货省份
    private String city;//收货城市
    private String area;//收货区域
    private String detailed;//详细收货地址
    private int defaultValue;//地址是否默认   0默认 1不默认
    private int status;//状态码

    private int ids;   //收货地址信息id
    private String shenf;  //省
    private String shiqu;   //市
    private String xian;  //县
    private String dizhi; //详细地址
    private String phone;  //电话号码
    private String bq;     //地址标签


    private String ddhao;  //订单号
    private int ddprice; //订单金额
    private String ddname; //订单名称
    private String  ddzhi;  //订单地址
    private String zt;     //订单状态
    private String phones; //订单电话
    private String time;  //下单时间
    private String fkmoney; //付款方式

    public String getFkmoney() {
        return fkmoney;
    }

    public void setFkmoney(String fkmoney) {
        this.fkmoney = fkmoney;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getKucun() {
        return kucun;
    }

    public void setKucun(int kucun) {
        this.kucun = kucun;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getDdhao() {
        return ddhao;
    }

    public void setDdhao(String ddhao) {
        this.ddhao = ddhao;
    }

    public int getDdprice() {
        return ddprice;
    }

    public void setDdprice(int ddprice) {
        this.ddprice = ddprice;
    }

    public String getDdname() {
        return ddname;
    }

    public void setDdname(String ddname) {
        this.ddname = ddname;
    }

    public String getDdzhi() {
        return ddzhi;
    }

    public void setDdzhi(String ddzhi) {
        this.ddzhi = ddzhi;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getShenf() {
        return shenf;
    }

    public void setShenf(String shenf) {
        this.shenf = shenf;
    }

    public String getShiqu() {
        return shiqu;
    }

    public void setShiqu(String shiqu) {
        this.shiqu = shiqu;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBq() {
        return bq;
    }

    public void setBq(String bq) {
        this.bq = bq;
    }

    public int getTradeCounts() {
        return tradeCounts;
    }

    public void setTradeCounts(int tradeCounts) {
        this.tradeCounts = tradeCounts;
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public String getTradeImg() {
        return tradeImg;
    }

    public void setTradeImg(String tradeImg) {
        this.tradeImg = tradeImg;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTradeColor() {
        return tradeColor;
    }

    public void setTradeColor(String tradeColor) {
        this.tradeColor = tradeColor;
    }

    public int getTradeShoe() {
        return tradeShoe;
    }

    public void setTradeShoe(int tradeShoe) {
        this.tradeShoe = tradeShoe;
    }

    public int getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(int tradePrice) {
        this.tradePrice = tradePrice;
    }

    public int getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(int tradeCount) {
        this.tradeCount = tradeCount;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public int getShoeId() {
        return shoeId;
    }

    public void setShoeId(int shoeId) {
        this.shoeId = shoeId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

  public int getOriginalPrice() {
        return originalPrice;
}

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public int getClassifyid() {
        return classifyid;
    }

    public void setClassifyid(int classifyid) {
        this.classifyid = classifyid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
