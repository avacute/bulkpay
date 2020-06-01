INSERT INTO users(id,username, password, email, location, is_enabled) VALUES(
    1, 'avasyn', '$2y$10$WrKmz0o5TERO7NDJ7BgpaenhZRhKlTTslh8uVqokwBPVjr8vXw6Pu',
    'avasyn@ava.com', 'Ikeja, Lagos', true);

INSERT INTO roles(role_id,role) VALUES(1, 'ADMIN');
INSERT INTO roles(role_id,role) VALUES(2, 'USER');
