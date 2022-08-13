
create database FoodManagement
create table tblRoles(
    roleID nvarchar(5) PRIMARY KEY,
    roleName nvarchar(10) NOT NULL,
	status bit not null,
)

create table tblUsers(
    userID nvarchar(20) PRIMARY KEY,
    fullName nvarchar(30) NOT NULL,
    password nvarchar(20) NOT NULL,
    roleID nvarchar(5) FOREIGN KEY REFERENCES tblRoles(roleID), 
    address nvarchar(50) NOT NULL,
    birthday date NULL,
    phone nvarchar(10) NOT NULL,
    email nvarchar(30) NOT NULL,
    status bit NOT NULL,
)

create table tblOrder(
    orderID nvarchar(10) PRIMARY KEY,
    orderDate date NOT NULL,
    total money NOT NULl,
    userID nvarchar(20) FOREIGN KEY REFERENCES tblUsers(userID),
    status bit NOT NULL,
)

create table tblCategory(
    categoryID nvarchar(10) PRIMARY KEY,
    categoryName nvarchar(20) NOT NULL,
	status bit not null
)

create table tblProducts(
    productID nvarchar(10) PRIMARY KEY,
    productName nvarchar(20) NOT NULL,
    image nvarchar(150),
    price money NOT NULL,
    quantity int NOT NULL,
    categoryID nvarchar(10) FOREIGN KEY REFERENCES tblCategory(categoryID),
    importDate date NOT NULL,
    usingDate date NOT NULL,
	status bit not null
)


create table tblOrderDetail(
    detailID int PRIMARY KEY,
    price money NOT NULL,
    quantity int NOT NULL,
    orderID nvarchar(10) FOREIGN KEY REFERENCES tblOrder(orderID),
    productID nvarchar(10)FOREIGN KEY REFERENCES tblProducts(productID),
	status bit not null
)
INSERT INTO dbo.tblCategory values('f1','vegetable',1)
INSERT INTO dbo.tblCategory values('f2','meat',1)
INSERT INTO dbo.tblCategory values('f3','fish',1)

INSERT INTO dbo.tblRoles values('AD','ADMIN',1)
INSERT INTO dbo.tblRoles values('US','USER',1)

INSERT INTO dbo.tblUsers values('afpt','ADMIN','1','AD','ABC','2001/5/5','046756','a@email',1)
INSERT INTO dbo.tblUsers values('dfpt','DUY','1','US','CDS','2001/2/7','044836','d@email',1)
INSERT INTO dbo.tblUsers values('cfpt','ADMIN','1','AD','ABC','2001/5/5','046756','c@email',0)

INSERT INTO dbo.tblProducts values('p1','rau muong','https://hongngochospital.vn/wp-content/uploads/2013/11/rau-muong.jpg','50','4','f1','2022/1/1','2022/8/9',1)
INSERT INTO dbo.tblProducts values('p2','bi do','http://yeuamthuc.org/wp-content/uploads/2015/10/bi-do-bi-ngo.jpg','60','10','f1','2022/3/3','2022/9/9',1)
INSERT INTO dbo.tblProducts values('p3','tom','https://coopfoodnq.vn/wp-content/uploads/2020/11/TOM-SU.jpg','100','4','f3','2022/4/2','2022/10/4',1)
INSERT INTO dbo.tblProducts values('p4','thit bo','https://photo-cms-kienthuc.zadn.vn/zoom/800/Uploaded/hongngan/2020_03_11/a/1_JJRA.jpg','150','5','f2','2022/3/2','2022/8/8',1)
INSERT INTO dbo.tblProducts values('p5','thit ga','https://cdn.statically.io/img/gachaybo.com/f=auto/wp-content/uploads/2019/07/thit-ga-co-tanh-khong-3.jpg','120','32','f2','2022/2/8','2022/9/9',0)

INSERT INTO dbo.tblOrder VALUES (N'dfpt_1','2021-03-13',50,N'dfpt',1)
INSERT INTO dbo.tblOrder VALUES (N'afpt_1','2021-04-13',100,N'afpt',1)




