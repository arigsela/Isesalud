-- You can use this file to load seed data into the database using SQL statements
insert into entidad (id, name, description) values (1, 'Baja California', 'LOLZ');
insert into municipio (id, name, description) values (1, 'Tijuana', 'Tierra Natal');
insert into puesto (id, name, description) values (1, 'Capturista', 'El lacky');
insert into personal (id, lastname, maternallastname, name, puesto) values (1, 'Sela', 'Muñoz', 'Ari', 1);
insert into unidadmedica (id, name, description, code) values (1, 'Hosptial General', 'Some place', 0);
insert into unidadmedica (id, name, description, code) values (2, 'Centro', 'Some place', 1);
insert into paciente (id, lastName, maternalLastName, name, dateofBirth, phoneNumber,phoneNumberMovil, address, sex, seguroPopular, dateCreated, timeCreated, ageMenstruation, ageFirstChild, BreastFeedChild, yearsSinceSurgery, ageMenopause, ageMenopauseHormones, dateLastMG, observations, municipio, entidad, unidadmedica) values (1, 'Perez', 'Mendoza', 'Ari', '1980-02-16', '123456','6641223322', 'Calle bleh', 'M', '0', '2013-02-11', '12:00:00', 0, 0, 0, 0, 0, 0, '2012-01-01', 'None', 1, 1, 1);
insert into tipocita (id,description) values (1,'Radiologia')
insert into tipocita (id,description) values (2,'Oncologia')
insert into tipoestudiocita (id,name,notes,tipocita) value (1,'mastografia tipo A','Tiene que llevar su comprobante',1)
insert into tipoestudiocita (id,name,notes,tipocita) value (2,'mastografia tipo B','Vengase bien preparada por favor',1)
insert into tipoestudiocita (id,name,notes,tipocita) value (3,'oncologia tipo A','favor de tomar agua',2)
insert into statuscita (id,description) values (1,'Pendiente')
insert into cita (id,date,time,statusCita,tipoEstudioCita,paciente) values (1,'2013-03-10','12:00:00',1,1,1)
