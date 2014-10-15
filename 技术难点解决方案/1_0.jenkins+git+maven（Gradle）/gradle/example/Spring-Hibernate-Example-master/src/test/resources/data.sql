create table if not exists admin_user(
  id int(11) auto_increment,
  name varchar(20) not null,
  password varchar(20) not null,
  email varchar(50) not null,
  created_at datetime,
  primary key id (id),
  index created_at (created_at)
);
