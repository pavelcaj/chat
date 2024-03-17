create table message (
                                id bigint not null auto_increment,
                                type varchar(255) not null,
                                content varchar (255) not null,
                                sender varchar (255) not null,
                                primary key (id)
) engine=InnoDB

GO

alter table message
    add constraint FKtpkopyby8qwu1noj4n4t3yuig
        foreign key (user_id)
            references users (id)
    GO