ALTER TABLE IF EXISTS composition
    DROP COLUMN drinking_id;

ALTER TABLE IF EXISTS composition
    DROP CONSTRAINT fk_composition_on_drinking;
