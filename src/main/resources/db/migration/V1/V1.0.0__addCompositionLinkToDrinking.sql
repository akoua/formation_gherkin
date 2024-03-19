ALTER TABLE IF EXISTS composition
    ADD COLUMN drinking_id BIGINT;

ALTER TABLE IF EXISTS composition
    ADD CONSTRAINT fk_composition_on_drinking FOREIGN KEY (drinking_id) REFERENCES drinking (drinking_id);
