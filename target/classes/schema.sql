CREATE TABLE socket (
  id BIGINT NOT NULL,
  room VARCHAR(20)
);

CREATE TABLE managers (
  id BIGINT NOT NULL,
  name VARCHAR(20)
);

CREATE TABLE computer (
  id BIGINT NOT NULL,
  ip_address VARCHAR(20),
  mac_address VARCHAR(20),
  host_name VARCHAR(20),
  socket_id BIGINT REFERENCES socket (id) ON DELETE CASCADE
);

CREATE TABLE computer_managers
(
  computer_id BIGINT NOT NULL,
  managers_id BIGINT NOT NULL,
CONSTRAINT PK_computer_managers PRIMARY KEY
(
  computer_id,
  managers_id
),
FOREIGN KEY (computer_id) REFERENCES computer (id),
FOREIGN KEY (managers_id) REFERENCES managers (id)
)