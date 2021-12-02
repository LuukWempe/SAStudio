insert into STATIONS values(1,'Zoetermeerseweg 9, 1246AX','Zoetermeer 9','TRUE');
insert into STATIONS values(2,'Zoetermeerselaan 13, 5432FS','Zoetermeer 13','TRUE');
insert into STATIONS values(3,'Zoetermeersestraat 17, 7826ID','Zoetermeer 17','TRUE');
insert into STATIONS values(4,'Papendrecht','Papendrecht','TRUE');
insert into STATIONS values(5,'Rotterdam','Europoort','TRUE');

insert into IED values(1,'10.47.97.11','Gateway',5);
insert into IED values(2,'10.129.97.10','Gateway',4);
insert into IED values(3,'10.134.97.10','Gateway',3);
insert into IED values(4,'10.75.97.10','Gateway',2);
insert into IED values(5,'10.47.97.11','Gateway',1);
insert into IED values(6,'10.47.97.12','Station Controller',1);
insert into IED values(7,'10.47.97.13','HMI',1);
insert into IED values(8,'10.47.97.14','IO-Box',1);
insert into IED values(9,'10.47.97.16','Switch 1',1);
insert into IED values(10,'10.47.97.17','Switch 2',1);

insert into IEDSIGNALS values(1,'SW','DI5',1,2,'DI3',3,4,'-',0,0,'-',0,0,'I',0,'X14',0,2,1,'2s',1,'Hulpspanning Motor',5);
insert into IEDSIGNALS values(2,'SW','DI6',1,2,'DI4',2,5,'-',0,0,'-',0,0,'J',0,'X11',0,3,4,'10s',1,'VS Veer',5);
--insert into IEDSIGNALS values(2,152182442,5,'Communication Error');
--insert into IEDSIGNALS values(3,364896126,5,'Connection Esablished');
--insert into IEDSIGNALS values(4,932571568,5,'No Short Circuit');