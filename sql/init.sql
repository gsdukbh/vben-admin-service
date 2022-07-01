# 用户表
create table vben_sys_user
(
    uid                     int(11)      not null auto_increment,
    username                varchar(200) not null unique,
    password                varchar(200) not null,
    email                   varchar(200),
    phone                   varchar(200),
    salt                    varchar(200) not null,
    nickname                varchar(200),
    real_name               varchar(200),
    avatar                  varchar(200),
    home_path               varchar(200),
    dept_id                 int(11),
    description             varchar(400),
    enabled                 bool         not null default 1,
    account_non_expired     bool         not null default 1,
    credentials_non_expired bool         not null default 1,
    account_non_locked      bool         not null default 1,
    create_time             datetime     not null default current_timestamp,
    update_time             datetime     not null default current_timestamp,
    index username_email_phone_index (username, email, phone),
    primary key (uid)
);
# 用户角色表
create table vben_sys_user_role
(
    uid         int(11)  not null,
    rid         int(11)  not null,
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp,
    primary key (uid, rid)
);

# 角色表
create table vben_sys_role
(
    rid         int(11)      not null auto_increment,
    name        varchar(200) not null,
    value       varchar(200) not null unique,
    description varchar(200),
    create_time datetime     not null default current_timestamp,
    update_time datetime     not null default current_timestamp,
    primary key (rid)
);

# 默认用户
insert into vben_sys_user(username, password, salt, nickname, avatar)
values ('vben', '$2a$10$QzpKOwpJYX9Wyr9nc711ceJwI5mywTYDTiJnjs5eNwsrDCzErMzZu', 'vben', 'vben', '');

insert into vben_sys_role(name, value, description)
values ('admin', 'ROLE_ADMIN', '管理员');
insert into vben_sys_role(name, value, description)
values ('user', 'ROLE_USER', '用户');

insert into vben_sys_user_role(rid, uid)
values ((SELECT uid from vben_sys_user WHERE username = 'vben'),
        (SELECT rid from vben_sys_role WHERE value = 'ROLE_ADMIN'));

create table vben_sys_dept
(
    id          int(11) primary key not null auto_increment,
    dept_name   varchar(255)        not null,
    remark      varchar(255),
    parent_id   int(11)             not null default 0,
    order_no    int,
    create_time datetime            not null default current_timestamp,
    update_time datetime            not null default current_timestamp
);

create table vben_sys_menu
(
    id                int(11) primary key not null auto_increment,
    name              varchar(255)        not null,
    path              varchar(255)        not null comment '导航路径',
    component         varchar(255)        not null comment '组件路径',
    redirect          varchar(255),
    title             varchar(255),
    icon              varchar(255),
    order_no          int(11) comment '排序,越小越靠前',
    status            int(3) comment '启用',
    type              int(3) comment '类型',
    hide_menu         bool                not null default false comment '隐藏菜单',
    parent_id         int(11)             not null default 0 comment '父目录',
    affix             bool                not null default false comment '固定标签',
    carry_aram        bool                not null default false comment '如果该路由会携带参数，且需要在tab页上面显示。则需要设置为true',
    frame_src         varchar(255) comment '',
    hide_tab          bool                not null default false comment '当前路由不再标签页显示',
    hide_breadcrumb   bool                not null default false,
    ignore_keep_alive bool                not null default true comment '忽略keep alive 缓存',
    create_time       datetime            not null default current_timestamp,
    update_time       datetime            not null default current_timestamp
);
create table vben_sys_role_menu
(
    rid         int(11)  not null comment 'vben_sys_role 表 id',
    mid         int(11)  not null comment 'vben_sys_menu 表 id',
    value       text comment '留作验证',
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp,
    primary key (rid, mid)
);

