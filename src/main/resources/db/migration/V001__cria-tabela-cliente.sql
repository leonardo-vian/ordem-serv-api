CREATE TABLE cliente ( ID        bigint not null auto_increment
                      ,Nome      varchar(60) not null
                      ,Email     varchar(255) not null
                      ,Telefone  varchar(20) not null					
                      
                      ,primary key (ID)
);