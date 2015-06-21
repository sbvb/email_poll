show tables;

// create persons
INSERT INTO tb_person (name,email,tel,comment,image,hash,password,timezone,creation_dt) 
VALUES ("sbVB Name of test","sbvillasboas@gmail.com","sbVB tel test","sbVB comment","/folder/image.png","sbVB hash","testpwd","-3",now());
INSERT INTO tb_person (name,email,tel,comment,image,hash,password,timezone,creation_dt) 
VALUES ("voting person 1","email 1","tel 1","comment person 1","/folder/image_person_1.png","person 1 hash","pwd1","-3",now());
INSERT INTO tb_person (name,email,tel,comment,image,hash,password,timezone,creation_dt) 
VALUES ("voting person 2","email 2","tel 2","comment person 2","/folder/image_person_2.png","person 2 hash","pwd2","-3",now());
INSERT INTO tb_person (name,email,tel,comment,image,hash,password,timezone,creation_dt) 
VALUES ("voting person 3","email 3","tel 3","comment person 3","/folder/image_person_3.png","person 3 hash","pwd3","-3",now());

delete from tb_person;
delete from tb_person where id=2;
select * from tb_person;

// create group
INSERT INTO tb_group (name,description,hash,creation_dt,tb_person_id) 
VALUES ("group name","group description","group hash",now(),(SELECT id FROM tb_person WHERE name = "sbVB Name of test"));

// create poll
INSERT INTO tb_poll (title,options,hash,creation_dt,tb_group_id) 
VALUES ("poll name","option 1\noption2\noption 3\noption 4","poll hash",now(),(SELECT id FROM tb_group WHERE name = "group name"));

// some votes
INSERT INTO tb_vote (value,comment,vote_dt,tb_person_id,tb_poll_id) 
VALUES ("1","comment 1",now(),(SELECT id FROM tb_person WHERE name = "voting person 1"),(SELECT id FROM tb_poll WHERE title = "poll name"));

select * from tb_person where tb_poll_id = (select id from tb_poll where title="poll name");











INSERT INTO tb_group_item_sell (group_name) VALUES ("almoço");
INSERT INTO tb_group_item_sell (group_name) VALUES ("lanche");
show tables;
show columns from tb_group_item_sell;
select * from tb_group_item_sell;

INSERT INTO tb_type_item_sell (type_name) VALUES ("prato principal");
INSERT INTO tb_type_item_sell (type_name) VALUES ("sobremesa");
INSERT INTO tb_type_item_sell (type_name) VALUES ("acompanhamento");
INSERT INTO tb_type_item_sell (type_name) VALUES ("suco");
show tables;
show columns from tb_type_item_sell;
select * from tb_type_item_sell;

INSERT INTO tb_item_sell (name, table_type_item_sell_fk, price) SELECT "carne de soja",    tb_type_item_sell.id, 20 FROM tb_type_item_sell WHERE tb_type_item_sell.type_name = "prato principal";
INSERT INTO tb_item_sell (name, table_type_item_sell_fk, price) SELECT "grão de bico",     tb_type_item_sell.id, 21 FROM tb_type_item_sell WHERE tb_type_item_sell.type_name = "prato principal";
INSERT INTO tb_item_sell (name, table_type_item_sell_fk, price) SELECT "salada de fruta",  tb_type_item_sell.id, 22 FROM tb_type_item_sell WHERE tb_type_item_sell.type_name = "sobremesa";
INSERT INTO tb_item_sell (name, table_type_item_sell_fk, price) SELECT "suco de laranja",  tb_type_item_sell.id, 23 FROM tb_type_item_sell WHERE tb_type_item_sell.type_name = "suco";
INSERT INTO tb_item_sell (name, table_type_item_sell_fk, price) SELECT "arroz com feijão", tb_type_item_sell.id, 24 FROM tb_type_item_sell WHERE tb_type_item_sell.type_name = "acompanhamento";
INSERT INTO tb_item_sell (name, table_type_item_sell_fk, price) SELECT "purê de batata",   tb_type_item_sell.id, 25 FROM tb_type_item_sell WHERE tb_type_item_sell.type_name = "acompanhamento";
show tables;
show columns from tb_item_sell;
select * from tb_item_sell;


INSERT INTO tb_Groups_of_Items (type_item_sell_FK, Groups_sell_FK)
VALUES(
	(SELECT id FROM tb_group_item_sell WHERE group_name = "almoço"),
	(SELECT id FROM tb_type_item_sell WHERE type_name = "prato principal")
);
INSERT INTO tb_Groups_of_Items (type_item_sell_FK, Groups_sell_FK)
VALUES(
	(SELECT id FROM tb_group_item_sell WHERE group_name = "almoço"),
	(SELECT id FROM tb_type_item_sell WHERE type_name = "acompanhamento")
);
INSERT INTO tb_Groups_of_Items (type_item_sell_FK, Groups_sell_FK)
VALUES(
	(SELECT id FROM tb_group_item_sell WHERE group_name = "almoço"),
	(SELECT id FROM tb_type_item_sell WHERE type_name = "sobremesa")
);
INSERT INTO tb_Groups_of_Items (type_item_sell_FK, Groups_sell_FK)
VALUES(
	(SELECT id FROM tb_group_item_sell WHERE group_name = "almoço"),
	(SELECT id FROM tb_type_item_sell WHERE type_name = "suco")
);
INSERT INTO tb_Groups_of_Items (type_item_sell_FK, Groups_sell_FK)
VALUES(
	(SELECT id FROM tb_group_item_sell WHERE group_name = "lanche"),
	(SELECT id FROM tb_type_item_sell WHERE type_name = "sobremesa")
);
INSERT INTO tb_Groups_of_Items (type_item_sell_FK, Groups_sell_FK)
VALUES(
	(SELECT id FROM tb_group_item_sell WHERE group_name = "boquinha"),
	(SELECT id FROM tb_type_item_sell WHERE type_name = "acompnahamento")
);
INSERT INTO tb_Groups_of_Items (type_item_sell_FK, Groups_sell_FK)
VALUES(
	(SELECT id FROM tb_group_item_sell WHERE group_name = "boquinha"),
	(SELECT id FROM tb_type_item_sell WHERE type_name = "suco")
);
show tables;
show columns from tb_type_item_sell;
select * from tb_Groups_of_Items;

INSERT INTO tb_Sell (sell_date_time, table_Sell_group_FK) VALUES (('1991-01-01 00:00:00.000'), (SELECT id FROM tb_group_item_sell WHERE group_name = "Almoço"));
INSERT INTO tb_Sell (sell_date_time, table_Sell_group_FK) VALUES (('1991-01-01 12:34:56.789'), (SELECT id FROM tb_group_item_sell WHERE group_name = "Almoço"));
INSERT INTO tb_Sell (sell_date_time, table_Sell_group_FK) VALUES (('1991-01-01 11:22:33.444'), (SELECT id FROM tb_group_item_sell WHERE group_name = "Almoço"));
INSERT INTO tb_Sell (sell_date_time, table_Sell_group_FK) VALUES (('1991-01-01 22:33:59.999'), (SELECT id FROM tb_group_item_sell WHERE group_name = "Almoço"));
INSERT INTO tb_Sell (sell_date_time, table_Sell_group_FK) VALUES (('1992-13-07 10:10:10.100'), (SELECT id FROM tb_group_item_sell WHERE group_name = "lanche"));
show tables;
show columns from tb_Sell;
select * from tb_Sell;

INSERT INTO tb_type_of_sold_item (sell_fk, type_item_sell_fk) VALUES ();
show tables;
show columns from tb_Sell;
select * from tb_Sell;