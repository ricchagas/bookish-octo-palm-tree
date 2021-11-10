create table endereco(
  id_endereco numeric,
  cep  varchar(9),
  logradouro    varchar(100),
  numero    varchar(10),
  cidade    varchar(20),
  uf    varchar(2),
  constraint pk_endereco primary key ( id_endereco )
);
create table cliente(
  id_cliente  numeric,
  id_endereco numeric,
  nome    varchar(50),
  cpf     varchar(14),
  data_nascimento date,
  constraint pk_cliente primary key ( id_cliente ),
  constraint fk_cli_endereco foreign key ( id_endereco ) references endereco ( id_endereco )
);

insert into endereco values(10, '04188-988', 'AV Brasil', '10', 'POA', 'SP' );
insert into endereco values(20, '42344-453', 'AV Central', '10', 'Ananindeua', 'RN');
insert into endereco values(30, '45152-534', 'AV Sapopemba', '30', 'Sai Paulo', 'SP');
insert into endereco values(40, '65643-453', 'AV Brasil', '5', 'Rio de Janeiro', 'RJ');

insert into cliente values(1, 10, 'Xuxa', '123354457-88',  to_date( '17-11-1981' , 'dd-mm-yyyy' ));
insert into cliente values(2, 20, 'Angelica', '98954343-88',  to_date( '12-10-1979' , 'dd-mm-yyyy' ));
insert into cliente values(3, 30, 'Eliana', '333443434-88',  to_date( '17-01-1985' , 'dd-mm-yyyy' ));
insert into cliente values(4, 40, 'Mara Maravilha', '23443234234-88',  to_date( '03-04-1990' , 'dd-mm-yyyy' ));

