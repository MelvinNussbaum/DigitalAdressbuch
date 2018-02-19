create database adressbuch;

use adressbuch;

create table person ( 
id int not null auto_increment primary key,
vorname varchar(45),
nachname varchar(45),
geschlecht varchar(25),
telefonnummer varchar(45),
geburtstag varchar(45),
email varchar(45),
profilbild longblob,
notizen varchar(500)
);

insert into person
(vorname, nachname, geschlecht, telefonnummer, geburtstag, email, profilbild, notizen)
values 
('Albert', 'Einstein', 'männlich', '087 435 12 65', '14. März 1879', 'gravity.lover@gmail.com', 'D:\Users\zmeieb\Pictures\Projekt\Albert.jpg', 'Intelligent, schlau, verstorben');

explain person;

DELETE FROM person WHERE id = 2;

select*from person;

drop table person; 

create table adresse (
id int not null auto_increment primary key,
strasse varchar(70),
postleitzahl varchar(30),
ort varchar(50),
land varchar(50)
);

insert into adresse 
(strasse, postleitzahl, ort, land)
values
('Sesamstrasse 45', '8000', 'Zürich', 'Schweiz');

select*from adresse;


drop table adresse;

explain adresse;

create table termine (
id int not null auto_increment primary key,
startzeit varchar(45),
endzeit varchar(45),
terminname varchar(50),
relevanz varchar(20)
);

insert into termine 
(startzeit, endzeit, terminname, relevanz)
values
('2018-01-30 ' '09:41:00', '2018-01-30 ' '10:41:00', 'Sportpalastrede', 'EXTREM WICHTIG');

explain termine;

select*from termine;

drop table termine;

alter table person;

create table erinnerungen (
id int not null auto_increment primary key,
zeit varchar(45),
datum varchar(45),
erinnerungsname varchar(45)
);

drop table erinnerungen;