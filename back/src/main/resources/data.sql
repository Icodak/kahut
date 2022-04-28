-- Default accounts
INSERT INTO appuser(id, description, first_name, password, enabled) values
                                                                           (gen_random_uuid(), 'Admin account', 'ADMIN', 'pass', TRUE),
                                                                           (gen_random_uuid(), 'User account', 'USER', 'pass', TRUE);
