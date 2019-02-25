    create table university (
       university_id bigint not null auto_increment,
        country varchar(255),
        name varchar(255),
        primary key (university_id)
        add constraint foreign key (university_id) references university (university_id)
    )

    create table student (
       student_id bigint not null auto_increment,
        name_view varchar(255),
        specialization varchar(255),
        university_id bigint,
        primary key (student_id)
    )






insert into university
value (1, 'Ukraine', 'Taras Shevchenko National University ');

insert into university
value (2, 'Ukraine', 'National Technical University ');



insert into student
values(1,'Inna Hrechana', 'Physics of Functional Materials', 1);

insert into student
values(2,'Viktor Zabolotnyi', 'Telecommunication systems and networks', 2);

insert into student
values(3,'Albert Simonyan', 'Molecular Physicsth', 1);