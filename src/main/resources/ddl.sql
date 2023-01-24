create table if not exists users
(
    id            int primary key generated by default as identity,
    login         varchar(50)        not null,
    password      varchar(200)       not null,
    first_name    varchar(50)        not null,
    last_name     varchar(50)        not null,
    year_of_birth varchar(20)        not null,
    phone_number  varchar(50)        not null,
    email         varchar(50) unique not null,
    role_id       int                references role (id) on delete set null,
    is_project     boolean            not null,
    is_task       boolean            not null,
    department    varchar(50)        not null,
    post          varchar(50)        not null,
    creation      timestamp default now(),
    update        timestamp default now()
);


insert into users(login, password, first_name, last_name, year_of_birth, phone_number, email, is_project, is_task, department, post)
values ('ivan@ivan.ru', '22222', 'Ivan', 'Ivanov', '26/07/1987', '11111', 'ivan@ivan.ru', false,false,'SALES', 'DIRECTOR');

insert into users(login, password, first_name, last_name, year_of_birth, phone_number, email, role_id, department, post)
values ('ivan@ivan.ru', '22222', 'Ivan', 'Ivanov', '26/07/1987', '11111', 'ivan@ivan.ru', 'ADMIN', 'SALES', 'DIRECTOR');

create table if not exists company
(
    id                 int primary key generated by default as identity,
    name               varchar(50)        not null,
    description        varchar(2000)      not null,
    company_type       varchar(50)        not null,
    website            varchar(50) unique not null,
    address            varchar(50)        not null,
    phone_number       varchar(50)        not null,
    email              varchar(50)        not null,
    independent_search boolean            not null,
    users_id           int                references users (id) on delete set null,
    creation           timestamp default now(),
    update             timestamp default now()
);

create table role
(
    id          int primary key generated by default as identity,
    name        varchar(50)   not null,
    description varchar(2000) not null,
    custom      boolean       not null,
    isACTIVE    boolean       not null
);

create table if not exists type_company
(
    id          int primary key generated by default as identity,
    name        varchar(50)   not null,
    description varchar(2000) not null,
    custom      boolean       not null,
    company_id  int           references users (id) on delete set null
);

create table if not exists post
(
    id          int primary key generated by default as identity,
    users_id    int           references users (id) on delete set null,
    name        varchar(50)   not null,
    description varchar(2000) not null,
    custom      boolean       not null
);
create table if not exists department
(
    id          int primary key generated by default as identity,
    users_id    int           references users (id) on delete set null,
    name        varchar(50)   not null,
    description varchar(2000) not null,
    custom      boolean       not null

);

create table if not exists project
(
    id           int primary key generated by default as identity,
    project_name varchar(50)   not null,
    description  varchar(2000) not null,
    custom       boolean       not null,
    creation     timestamp default now(),
    update       timestamp default now(),
    users_id     int           references users (id) on delete set null,
    company_id   int           references company (id) on delete set null
);
create table if not exists task
(
    id          int primary key generated by default as identity,
    name        varchar(50)   not null,
    description varchar(5000) not null,
    creation    timestamp default now(),
    update      timestamp default now(),
    users_id    int           references users (id) on delete set null,
    company_id  int           references company (id) on delete set null
);

create table if not exists user_role
(
    users_id int references users (id) on delete set null,
    role_id  int references role (id) on delete set null

);