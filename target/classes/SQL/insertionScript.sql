INSERT into bonsai(id_bonsai,name,species,acquisition_date,acquisition_age,status)VALUES('37d8db86-4168-11ec-ba1c-0242ac130002','Grindset','Sigma Bonsai','Tomorrow','777','Unknown')ON CONFLICT DO NOTHING;
INSERT INTO bonsai(id_bonsai,name,species,acquisition_date,acquisition_age,status)VALUES('37d8db37-4168-11ec-ba1c-0242ac130002','incel','Beta Bonsai','1992','21','Dead')ON CONFLICT DO NOTHING;
INSERT INTO watering(id_watering, date_watering, id_bonsai)VALUES('62ef5dd3-8b65-4148-8414-08e9f95ce974','2021-11-11 15:40:01','37d8db37-4168-11ec-ba1c-0242ac130002');
INSERT INTO watering(id_watering, date_watering, id_bonsai)VALUES('62ef5dd3-8b65-4148-8414-08e9f95ce975','2019-11-11 15:40:01','37d8db37-4168-11ec-ba1c-0242ac130002');
INSERT INTO watering(id_watering, date_watering, id_bonsai)VALUES('62ef5dd3-8b65-4148-8414-08e9f95ce976','2022-11-11 15:40:01','37d8db37-4168-11ec-ba1c-0242ac130002');
INSERT INTO watering(id_watering, date_watering, id_bonsai)VALUES('62ef5dd3-8b65-4148-8414-08e9f95ce978','2021-12-11 15:40:01','37d8db86-4168-11ec-ba1c-0242ac130002');
INSERT INTO owner(id_owner, name,id_bonsai)VALUES('672380fc-a1d8-420e-895a-4782d8d6a502','Artengo','37d8db37-4168-11ec-ba1c-0242ac130002');
INSERT INTO owner(id_owner, name,id_bonsai)VALUES('672380fc-a1d8-420e-895a-4782d8d6a507','Trishula','37d8db86-4168-11ec-ba1c-0242ac130002');

INSERT INTO users(id_user, username, enabled)VALUES('4d08c6a2-b80e-4aa1-8522-9bd5309b1753','Alderiate', 'true');
INSERT INTO authority(id, authority)VALUES('49c15d7d-8ebf-4453-bcad-974f7791187c','ADMIN')