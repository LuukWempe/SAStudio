insert into STATIONS values(1,'Zoetermeerseweg 9, 1246AX','Zoetermeer 9','TRUE');
insert into STATIONS values(2,'Zoetermeerselaan 13, 5432FS','Zoetermeer 13','TRUE');
insert into STATIONS values(3,'Zoetermeersestraat 17, 7826ID','Zoetermeer 17','TRUE');
insert into STATIONS values(4,'Papendrecht','Papendrecht','TRUE');
insert into STATIONS values(5,'Rotterdam','Europoort','TRUE');

insert into IED values(1,'104','10.47.97.11','Gateway',5,'10kV');
insert into IED values(2,'104','10.129.97.10','Gateway',4,'10kV');
insert into IED values(3,'104','10.134.97.10','Gateway',3,'10kV');
insert into IED values(4,'104','10.75.97.10','Gateway',2,'10kV');
insert into IED values(5,'104','10.47.97.11','Gateway',1,'10kV');
insert into IED values(6,'104','10.47.97.12','Station Controller',1,'10kV');
insert into IED values(7,'104','10.47.97.13','HMI',1,'10kV');
insert into IED values(8,'103','10.47.97.14','IO-Box',1,'10kV');
insert into IED values(9,'104','10.47.97.16','Switch 1',1,'10kV');
insert into IED values(10,'104','10.47.97.17','Switch 2',1,'10kV');

insert into IEDSIGNALS values(1,'SW','DI5',1,2,'DI3',3,4,'-',0,0,'-',0,0,'I',1,'X14',0,2,1,'2s',1,'Hulpspanning Motor',5);
insert into IEDSIGNALS values(2,'SW','DI6',2,3,'DI4',2,5,'-',0,0,'-',0,0,'J',0,'X12',1,3,4,'10s',1,'VS Veer',5);
insert into IEDSIGNALS values(3,'SW','DI6',1,6,'DI2',1,5,'-',0,0,'-',0,0,'J',0,'X11',0,3,4,'0s',1,'SF6 Alarm',5);
insert into IEDSIGNALS values(4,'SW','DI6',5,6,'DI7',3,4,'-',0,0,'-',0,0,'J',0,'X9',1,3,4,'0s',1,'Handmatige Blokkering',5);
insert into IEDSIGNALS values(5,'SW','DI6',1,2,'DI2',1,2,'-',0,0,'-',0,0,'J',1,'X5',0,3,4,'4s',1,'Verzamelmelding Tripspoel',5);
insert into IEDSIGNALS values(6,'SW','DI6',4,2,'DI3',1,6,'-',0,0,'-',0,0,'J',0,'X6',1,3,4,'0s',1,'VS Veer',5);
insert into IEDSIGNALS values(7,'SW','DI6',1,3,'DI1',3,5,'-',0,0,'-',0,0,'J',0,'X7',0,3,4,'6s',1,'VS Veer',5);
insert into IEDSIGNALS values(8,'SW','DI6',7,2,'DI10',2,5,'-',0,0,'-',0,0,'J',1,'X3',0,3,4,'0s',1,'VS Veer',5);