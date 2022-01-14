set search_path = bonsaiSpring;
drop schema if exists bonsaiSpring CASCADE;
create schema bonsaiSpring;

create table bonsai (id_bonsai uuid, id_owner uuid, name varchar, species varchar, acquisition_date varchar, acquisition_age int, status varchar);
alter table bonsai add constraint PK_bonsai PRIMARY KEY(id_bonsai);


create table watering (id_watering uuid, date_watering timestamp, id_bonsai uuid);
alter table watering add constraint PK_watering PRIMARY KEY(id_watering);
alter table watering add constraint FK_watering FOREIGN KEY(id_bonsai) REFERENCES bonsai(id_bonsai);

create table pruning(id_pruning uuid, id_bonsai uuid, date_last_prunning timestamp);
alter table pruning add constraint PK_pruning PRIMARY KEY (id_pruning);
alter table pruning add constraint FK_pruning_bonsai FOREIGN KEY(id_bonsai) REFERENCES bonsai(id_bonsai);

create table repotting(id_repotting uuid, id_bonsai uuid, date_last_repotting timestamp);
alter table repotting add constraint PK_repotting PRIMARY KEY(id_repotting);
alter table repotting add constraint FK_repotting_bonsai FOREIGN KEY(id_bonsai) REFERENCES bonsai(id_bonsai);

create table owner(id_owner uuid, name varchar, id_bonsai uuid);
alter table owner add constraint PK_owner primary key(id_owner);
alter table owner add constraint FK_owner_bonsai foreign key(id_bonsai) references bonsai(id_bonsai);


create table users(id_user uuid, username varchar, enabled boolean, password varchar);
create table authority(id uuid, authority varchar);