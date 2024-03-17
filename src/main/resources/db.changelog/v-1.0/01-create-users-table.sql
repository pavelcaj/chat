create table user (
                       id bigint not null auto_increment,
                       username varchar(255) not null,
                       primary key (id)
) engine=InnoDB

GO

alter table user
    add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username)
    GO