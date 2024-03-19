ALTER TABLE IF EXISTS drinking
    ADD CONSTRAINT uc_drinking_type UNIQUE (drinking_type);