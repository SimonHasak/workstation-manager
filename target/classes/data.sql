INSERT INTO socket VALUES (1, 'room1');
INSERT INTO socket VALUES (2, 'room2');
INSERT INTO socket VALUES (3, 'room2');
INSERT INTO socket VALUES (4, 'room2');
INSERT INTO socket VALUES (5, 'room3');
INSERT INTO socket VALUES (6, 'room3');

INSERT INTO managers VALUES (1, 'Jozko Vajda');
INSERT INTO managers VALUES (2, 'Peter Ondras');
INSERT INTO managers VALUES (3, 'Peter Vajda');
INSERT INTO managers VALUES (4, 'Petronela Slivkova');
INSERT INTO managers VALUES (5, 'Simona Sokolovska');
INSERT INTO managers VALUES (6, 'Igor Romanovsky');

INSERT INTO computer VALUES (1, '220.78.168.0',   '00:0a:95:9d:68:16', 'computer1', 2);
INSERT INTO computer VALUES (2, '120.84.168.150', 'a5:01:77:e5:o9:17', 'computer2', 1);
INSERT INTO computer VALUES (3, '225.225.225.0',  '55:b7:95:9d:l5:36', 'computer3', 6);
INSERT INTO computer VALUES (4, '211.32.211.111', '65:0a:a1:8c:11:f1', 'computer4', 3);
INSERT INTO computer VALUES (5, '152.89.251.123', '77:e7:e8:9d:12:65', 'computer5', 4);
INSERT INTO computer VALUES (6, '220.78.168.5',   '24:6a:19:a4:d6:22', 'computer6', 5);

INSERT INTO computer_managers VALUES (1,1);
INSERT INTO computer_managers VALUES (1,6);
INSERT INTO computer_managers VALUES (1,2);
INSERT INTO computer_managers VALUES (2,1);
INSERT INTO computer_managers VALUES (2,2);
INSERT INTO computer_managers VALUES (1,3);
INSERT INTO computer_managers VALUES (3,3);
INSERT INTO computer_managers VALUES (3,2);
INSERT INTO computer_managers VALUES (4,4);
INSERT INTO computer_managers VALUES (5,1);
INSERT INTO computer_managers VALUES (5,3);
INSERT INTO computer_managers VALUES (5,4);
INSERT INTO computer_managers VALUES (5,6);
INSERT INTO computer_managers VALUES (6,2);
INSERT INTO computer_managers VALUES (6,6);