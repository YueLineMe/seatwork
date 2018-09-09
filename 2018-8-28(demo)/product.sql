use sys;
drop database if exists ProductDB;
create database ProductDB;
use ProductDB;
create table Ptype(									#商品类型
	ptid int primary key auto_increment,	
	pname varchar(20)
);
create table Product(								#商品
	pid int primary key auto_increment,				
    pname varchar(200),								#名字
    ptid int ,										#类型
    price decimal(19,2) check(price>0),				#价格
    photo varchar(100),								#商品图片名字
    remark varchar(200)	,							#备注
    state int default 0 ,							#是否上架（0上架，1下架）
    foreign key(ptid) references Ptype(ptid)
);
create table `Users`(								#用户
	uid int primary key auto_increment,
    uname varchar(20),								#名字
    phone varchar(11),								#手机号码
    `password` varchar(16),							#密码
    e_mail varchar(50),								#邮箱
    CONSTRAINT uq_uname UNIQUE (uname),
    constraint uq_phone unique (phone),
    constraint uq_e_mail unique (e_mail)
);
create table Site(									#地址
	sid int primary key auto_increment,
    uid int ,										#用户
    recipients varchar(20),							#收件人
    phone varchar(11),								#手机
    location varchar(200),							#地址
    state int ,										#是否删除 1删除
    foreign key(uid) references `Users`(uid)
);
create table `Order`(								#订单
	oid int primary key auto_increment,
    uid int ,										#用户
	orderprice decimal(19,2),						#订单总价
    sid int ,										#地址
    state int default 0,							#是否支付 0未支付,1支付
    foreign key(uid) references Users(uid),
    foreign key(sid) references Site(sid)
);
create table `ShopCar`(								#购物车
	sid int primary key auto_increment,
    pid int ,										#商品
    scount int ,									#数量
    uid int ,										#用户
    sumprice decimal(19,2),							#总价
    oid int ,										#隶属订单
    state int default 0,							#是否支付 0未支付,1支付
    foreign key(uid) references Users(uid),
    foreign key(pid) references Product(pid),
    foreign key(oid) references `Order`(oid)
);
#set FOREIGN_KEY_CHECKS=0; --忽略掉外键的方法，用完后只需要将0变成1即可
insert into Ptype values(0,'电脑'),(0,'手机'),(0,'食品'),(0,'日常');
insert into Product values 	(0,'Apple/苹果MacBook Pro笔记本电脑13.3英寸笔记本电脑带触控2018款官方正品',1,13388.00,'1.png','一台好电脑',0),
							(0,'Apple/苹果 Mac Mini MGEN2CH/A MGEQ2CH/A 主机 低中配定制 美版',1,3280.00,'2.png','一台好主机',0),
                            (0,'3期免息【当天发/保修2年】Apple/苹果 iPhone 8 全网通4G手机 官方旗舰店',2,4458.00,'3.png','一台好手机',0),
                            (0,'垃圾华为 nova 3 全面屏正品 杜鸡代言手机',2,2799.00,'4.png','一台好手机',0),
                            (0,'【现货发售】咨询购机享壕礼/中移动vivo NEX 旗舰版官方全新正品',2,4498.00,'5.png','一台好手机',0);
insert into `Users` values	(0,'YueLineMe','15278320521','123456','949861884@qq.com'),
							(0,'Dz','13977566666','123','949861886@qq.com');
insert into ShopCar values	(0,1,1,1,13388.00,null,0),
							(0,2,1,1,3280.00,null,0),
							(0,3,1,1,4458.00,null,0),
                            (0,1,2,1,26776.00,null,1),
                            (0,1,2,2,26776.00,null,0);
insert into Site values(0,1,'张三 ','15818876898','江西省赣州市什么路153号',0),(0,2,'李四','18777890986','广东省广州市天河区什么路121号',0);
select * from Product;
#添加商品至购物车
#select s.sid,count(*),p.price from ShopCar s right join Product p on s.pid=p.pid where s.pid=1 and s.uid=1 and s.state=0;		#判断count是否大于零
#update ShopCar set scount = scount+1 , sumprice = sumprice+13388 where sid=1;			#大于零则修改
#insert into ShopCar values	(0,1,1,1,13388.00,null,0);								#否则则修改(sid,pid,scount,uid,sumprice,oid,state)
#查询用户YueLineMe的购物车
#select * from ShopCar s where uid=2 and state=0;
#select s.sid,p.pname,p.price,s.scount,s.sumprice from ShopCar s join Product p on s.pid=p.pid where s.uid='YueLineMe' and s.state=0;
#模拟添加商品至订单
#insert into `Order` values(0,2,13388,1,0);
#select oid from `Order` where uid=2 and state=0;
#update ShopCar set state=1,oid=1 where sid in(1,2);
#update `Order` set state=1 where oid=1;
#select * from Product where pname like '%电脑%' and `state`=0;




