-- You can use this file to load seed data into the database using SQL statements
CREATE OR REPLACE VIEW v_user_role AS select user.username as username, user.password as password, role.role as role from ((user_has_role join user on ((user_has_role.User_id = user.id))) join role on ((role.id = user_has_role.Role_id)));
insert into entidad (id, name, description) values (1, 'Baja California', 'Entidad de B.C.');
insert into municipio (id, name, description) values (1, 'Tijuana', 'Municipio de Tijuana');
insert into municipio (id, name, description) values (2, 'Mexicali', 'Municipio de Mexicali');
insert into gabinete (name, description) values ('RDD', 'Tijuana');
insert into gabinete (name, description) values ('IDDT', 'Tecate');
insert into gabinete (name, description) values ('IDD', 'Mexicali');
insert into puesto (id, name, description) values (1, 'Capturista', 'El lacky');
insert into personal (id, lastname, maternallastname, name, puesto,gabinete) values (1, 'Sela', 'Muñoz', 'Ari', 1,1);
insert into unidadmedica (id, name, description, municipio, code) values (1, 'Hospital General', 'Hospital General de Tijuana',1, 0);
insert into unidadmedica (id, name, description,municipio, code) values (2, 'PACS 1', 'Unidad movil de Tijuana 1',2, 1);
insert into paciente (id, lastName, maternalLastName, name, dateofBirth, phoneNumber,phoneNumberMovil, aceptamensajes,address, sex, seguroPopular, dateCreated, timeCreated, ageMenstruation, ageFirstChild, BreastFeedChild, yearsSinceSurgery, typeofsurgery, ageMenopause, ageMenopauseHormones, dateLastMG, observations, municipio, entidad, entidadNacimiento, unidadmedica) values (1, 'Perez', 'Mendoza', 'Ari', '1980-02-16', '123456','6642865641','1', 'Calle del rosario #13190', 'M', '0', '2013-02-11', '12:00:00', 0, 0, 0, 0,'ninguna', 0, 0, '2012-01-01', 'None', 1, 1, 1,1);
insert into department (id,description) values (1,'Radiologia');
insert into department (id,description) values (2,'Oncologia');
insert into modality (id,description,name,department) values (1,"MASTOGRAFIAS","MM",1)
insert into modality (id,description,name,department) values (2,"ULTRASONIDO", "US",1)
insert into modality (id,description,name,department) values (3,"MODALIDAD ONCO 1","ONCO1",2)
insert into modality (id,description,name,department) values (4,"MODALIDAD ONCO 2", "ONCO2",2)
insert into study (id,name,notes,modality) value (1,'TAM. INVITACION ORGANIZADA','Tiene que llevar su comprobante',1);
insert into study (id,name,notes,modality) value (2,'TAM. DERIVADA POR PERSONAL DE SALUD','Vengase bien preparada por favor',1);
insert into study (id,name,notes,modality) value (3,'TAM. ESPONTANEA (DE LA MUJER)','Vengase bien preparada por favor',1);
insert into study (id,name,notes,modality) value (4,'DIAG. SINTOMATOLOGIA CLINICA','Tiene que llevar su comprobante',1);
insert into study (id,name,notes,modality) value (5,'DIAG. CONTROL PATOLOGIA BENIGNA','Vengase bien preparada por favor',1);
insert into study (id,name,notes,modality) value (6,'DIAG. CONTROL PATOLOGIA MALIGNA','Vengase bien preparada por favor',1);
insert into study (id,name,notes,modality) value (7,'ULTRASONIDO RADIO','favor de tomar agua',2);
insert into study (id,name,notes,modality) value (9,'oncologia tipo A','favor de tomar agua',3);
insert into study (id,name,notes,modality) value (8,'oncologia tipo B','favor de tomar agua',4);
insert into statuscita (id,description) values (1,'Pendiente');
insert into statuscita (id,description) values (2,'Atendida');
insert into systemsettings (id,messagesenabled,confirmMessageEnabled) values (1,0,0);
insert into user (username, password, name, fName, mName, municipio,entidad, enabled, gabinete) values ('admin', 'YEr9AHbeWymox3oz/OKqOhjkzOr75H2sQz/ZQ2OwhRc=', 'admin', 'admin', '', 1,1, 1,1);
insert into role (role, description) values ('Admin', 'Administrador');
insert into role (role, description) values ('Tech', 'Tecnico');
insert into role (role, description) values ('Doctor', 'Doctor');
insert into user_has_role (User_id, Role_id) values (1,1);
insert into tiporesultado (id,description,name) values (1,'BIRADS 0 INSEGURO','B0');
insert into motivoInadecuada (id,description,name) values (1,'TOMADA ADECUADAMENTE','ADECUADA');
insert into resultadoImagen (id,adequate,dateNotified,dateInterpreted,daterealized,signs,gabineteinter,MotivoInadecuada,paciente,personalrealizado,personalinter,study,TipoResultado) values (1,1,'2013-03-31','2013-03-31','2013-03-29','Ninguna',1,1,1,1,1,1,1);
insert into hallazgos (id,name,side,resultadoImagen) values (1,'nada','IZQ',1);
insert into motivoReferencia (id, name, description) values (1, 'mot1', 'motivo 1');
insert into motivoReferencia (id, name, description) values (2, 'mot2', 'motivo 2');
