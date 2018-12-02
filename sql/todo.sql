use demo
create table todo(
  id int not null primary key auto_increment ,
  name varchar(50) not null,
  detail varchar(1000) not null,
  created_at datetime default now(),
  finished_at datetime,
  state varchar(20),
  memo varchar(200)
);

insert into todo(name, detail, created_at, finished_at, state, memo)
values ("管理系统", "这个系统要有很多的功能模块", default ,"2018/12/10", "未完成", "没什么好说的，我只要结果"),
        ("HTML5渲染页面", "这只是一个测试而已", default , "2018/12/05", "未完成", "结果啊");


select * from todo;