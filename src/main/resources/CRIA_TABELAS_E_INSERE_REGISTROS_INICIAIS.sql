CREATE TABLE funcionario (rowid bigint auto_increment, nm_funcionario VARCHAR(255));
INSERT INTO funcionario (nm_funcionario) VALUES ('João'), ('Maria'), ('José'), ('Joana');

CREATE TABLE agenda (rowid bigint auto_increment, nm_agenda VARCHAR(255), periodo_disponivel VARCHAR(255));
INSERT INTO agenda (nm_agenda, periodo_disponivel) VALUES ('Ultrassonografia abdominal','Manhã'), ('Endoscopia digestiva alta','Tarde'), ('Consulta de Gastroenterologista','Ambos');

CREATE TABLE compromisso (rowid bigint auto_increment, cd_funcionario bigint, cd_agenda bigint, data DATE, horario TIME);