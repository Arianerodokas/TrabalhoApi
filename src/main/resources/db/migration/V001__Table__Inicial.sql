Create Table Cliente(
idcliente int not null auto_increment primary key,
nomeCliente varchar (100)
);

insert into cliente(nomeCliente) values ('Jeff Bezos');

Create Table ContasApagar(
    idcontas int not null primary key auto_increment,
    data date,
    dataVencimento date,
    valor decimal(16,2),
    idcliente int not null

);

Alter table ContasApagar add constraint FK_ContasApagar_cliente foreign key (idcliente) REFERENCES cliente(idcliente);

insert into ContasApagar(data, dataVencimento, valor, idcliente) values ('2023/02/09', '2023/08/10', 190, 1);
insert into ContasApagar(data, dataVencimento, valor, idcliente) values ('2022/12/09', '2023/10/09', 200, 1);
insert into ContasApagar(data, dataVencimento, valor, idcliente) values ('2023/12/29', '2024/08/10', 300, 1);
