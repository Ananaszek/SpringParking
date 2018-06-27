insert into User (id, login, userType) values (1, 'login1', 'DRIVER');
insert into User (id, login, userType) values (2, 'login2', 'VIP_DRIVER');
insert into User (id, login, userType) values (3, 'login3', 'DRIVER');
insert into User (id, login, userType) values (4, 'login4', 'PARKING_OWNER');
insert into User (id, login, userType) values (5, 'login5', 'PARKING_OPERATOR');

insert into UserPayment (id, dateFrom, dateTo, date, amount) values (1,'2018-06-25T19:30:33:256','2018-06-25T20:30:33:256', '2018-06-25',1,'DRIVER');
insert into UserPayment (id, dateFrom, dateTo, date, amount) values (2, null,null, null,0,'VIP_DRIVER');
insert into UserPayment (id, dateFrom, dateTo, date, amount) values (3,'2018-06-25T19:30:33:256','2018-06-25T21:30:33:256', '2018-06-25',1,'DRIVER');