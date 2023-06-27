Create Table cliente(
id int not null auto_increment primary key,
nomecliente varchar (100)
);

insert into cliente(nomecliente) values ('Jeff Bezos');

Create Table contasapagar(
    id int not null primary key auto_increment,
    data date,
    datavencimento date,
    valor decimal(16,2),
    idcliente int not null

);

Alter table contasapagar add constraint FK_ContasApagar_cliente foreign key (idcliente) REFERENCES cliente(id);

insert into contasapagar(data, datavencimento, valor, idcliente) values ('2023/02/09', '2023/08/10', 190, 1);
insert into contasapagar(data, datavencimento, valor, idcliente) values ('2022/12/09', '2023/10/09', 200, 1);
insert into contasapagar(data, datavencimento, valor, idcliente) values ('2023/12/29', '2024/08/10', 300, 1);
