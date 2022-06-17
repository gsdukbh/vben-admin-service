# 用户表
create table vben_sys_user
(
    uid                   int(11)      not null auto_increment,
    username              varchar(200) not null unique,
    password              varchar(200) not null,
    email                 varchar(200),
    phone                 varchar(200),
    salt                  varchar(200) not null,
    nickname              varchar(200),
    avatar                varchar(200),
    enabled               bool         not null default 1,
    accountNonExpired     bool         not null default 1,
    credentialsNonExpired bool         not null default 1,
    accountNonLocked      bool         not null default 1,
    createTime            datetime     not null default current_timestamp,
    updateTime            datetime     not null default current_timestamp,
    index username (username, email, phone),
    primary key (uid)
);
# 用户角色表
create table vben_sys_user_role
(
    uid        int(11)  not null,
    rid        int(11)  not null,
    createTime datetime not null default current_timestamp,
    updateTime datetime not null default current_timestamp,
    primary key (uid, rid)
);

# 角色表
create table vben_sys_role
(
    rid         int(11)      not null auto_increment,
    name        varchar(200) not null unique,
    value       varchar(200) not null,
    description varchar(200),
    createTime  datetime     not null default current_timestamp,
    updateTime  datetime     not null default current_timestamp,
    primary key (rid)
);
