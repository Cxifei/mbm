#创建数据库
create database mbm
  character set utf8
  default collate utf8_general_ci;

#创建表
drop table if exists item;
create table item (
  id          bigint primary key auto_increment
  comment '商品ID',
  title       varchar(100) not null
  comment '商品名称',
  sell_point  varchar(500) comment '商品卖点',
  price       bigint       not null
  comment '商品价格，单位：分',
  num         bigint       not null
  comment '库存量',
  image       varchar(200) comment '商品图片',
  code        varchar(50) comment '商品编码',
  category_id bigint       not null
  comment '商品类型',
  status      varchar(5)         default '正常'
  comment '商品状态（正常，下架，删除）',
  created     timestamp          default current_timestamp
  comment '创建时间',
  updated     timestamp          default current_timestamp
  on update current_timestamp
  comment '修改时间'
)
  engine = InnoDB
  default charset = utf8
  comment ='商品表';


drop table if exists mbm.item_category;
create table mbm.item_category (
  id         bigint primary key auto_increment
  comment '类型ID',
  parent_id  bigint      not null
  comment '父类型ID',
  name       varchar(20) not null
  comment '类型名称',
  status     varchar(5)         default '正常'
  comment '状态（正常，删除）',
  sort_order int comment '排列序号',
  is_parent  tinyint(1)         default 1
  comment '是否是父类，1为true，0为false',
  created    timestamp          default current_timestamp
  comment '创建时间',
  updated    timestamp          default current_timestamp
  on update current_timestamp
  comment '修改时间'
)
  engine = InnoDB
  default charset = utf8
  comment ='商品类型';


drop table if exists mbm.item_desc;
create table mbm.item_desc (
  id        bigint primary key auto_increment
  comment 'ID',
  item_id   bigint not null
  comment '商品ID',
  item_desc text comment '商品描述',
  created   timestamp          default current_timestamp
  comment '创建时间',
  updated   timestamp          default current_timestamp
  on update current_timestamp
  comment '修改时间'
)
  engine = InnoDB
  default charset = utf8
  comment ='商品描述';


drop table if exists mbm.item_param;
create table mbm.item_param (
  id               bigint primary key auto_increment
  comment 'ID',
  item_category_id bigint not null
  comment '类型ID',
  data_param       text comment '规格参数数据，json格式的数据',
  created          timestamp          default current_timestamp
  comment '创建时间',
  updated          timestamp          default current_timestamp
  on update current_timestamp
  comment '修改时间'
)
  engine = InnoDB
  default charset = utf8
  comment ='商品规格和商品类型';


drop table if exists mbm.item_param_info;
create table mbm.item_param_info (
  id        bigint primary key auto_increment
  comment 'ID',
  item_id   bigint not null
  comment '商品ID',
  data_info text comment '具体规格，json格式的数据',
  created   timestamp          default current_timestamp
  comment '创建时间',
  updated   timestamp          default current_timestamp
  on update current_timestamp
  comment '修改时间'
)
  engine = InnoDB
  default charset = utf8
  comment ='商品规格和商品';