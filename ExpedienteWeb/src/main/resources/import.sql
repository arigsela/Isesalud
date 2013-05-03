-- You can use this file to load seed data into the database using SQL statements
CREATE OR REPLACE VIEW v_user_role AS select user.username as username, user.password as password, role.role as role from ((user_has_role join user on ((user_has_role.User_id = user.id))) join role on ((role.id = user_has_role.Role_id)));
insert into entidad (id, name, description) values (1, 'Baja California', 'Entidad de B.C.');
insert into gabinete (id,description,name) values (1,'ATRAS DEL HOSPITAL EXCEL','RDD');
insert into municipio (id, name, description) values (1, 'Tijuana', 'Municipio de Tijuana');
insert into municipio (id, name, description) values (2, 'Mexicali', 'Municipio de Mexicali');
insert into puesto (id, name, description) values (1, 'Capturista', 'El lacky');
insert into personal (id, lastname, maternallastname, name, puesto,gabinete) values (1, 'Sela', 'Muñoz', 'Ari', 1,1);
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
insert into systemsettings (id,messagesenabled) values (1,0);
insert into user (username, password, name, fName, mName, municipio, enabled, gabinete) values ('admin', 'YEr9AHbeWymox3oz/OKqOhjkzOr75H2sQz/ZQ2OwhRc=', 'admin', 'admin', '', 1, 1,1);
insert into role (role, description) values ('Admin', 'Administrador');
insert into role (role, description) values ('Tech', 'Tecnico');
insert into role (role, description) values ('Doctor', 'Doctor');
insert into user_has_role (User_id, Role_id) values (1,1);
insert into tiporesultado (id,description,name) values (1,'BIRADS 0 INSEGURO','B0');
insert into motivoReferencia (id, name, description) values (1, 'mot1', 'motivo 1');
insert into motivoReferencia (id, name, description) values (2, 'mot2', 'motivo 2');