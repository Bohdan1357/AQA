INSERT INTO mantis_user_table (username, realname, email, password, enabled, protected, access_level, cookie_string)
VALUES ('john.doe', 'John Doe', 'reporter@gmail.com', MD5('reporterpass123'), 1, 0, 35, UUID());
