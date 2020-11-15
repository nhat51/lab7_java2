Create table books(
    bookID int PRIMARY KEY,
    bookName varchar(50),
    author varchar(50),
    price double,
    qty int
);
create table users(
    UserName varchar(50) primary key,
    password varchar(30),
    email varchar(100),
    role int
);
create table customers(
    UserName varchar(50) primary key,
    CustomerName varchar(50),
    phone varchar(11),
    address varchar(50),
    levels varchar(30),
    CONSTRAINT foreign key (UserName) references users(UserName)
);
create table orders(
    orderID int primary key,
    CustomerID int,
    bookID int,
    amount int,
    totalPrice double,
    Constraint foreign key (CustomerID) references customers(CustomerID),
    Constraint foreign key (bookID) references books(bookID)
);
create table order_details(
    orderID int,
    CustomerID int,
    CustomerName varchar(50),
    address varchar(50),
    bookID int,
    bookName varchar(50),
    date timestamp,
    qty int,
    totalPrice double,
    constraint foreign key (orderID) references orders(orderID),
    constraint foreign key (bookID) references books(bookID)
 );