CREATE TABLE hazard_category
(
    id       BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    category varchar not null
);

INSERT INTO hazard_category (category)
VALUES ('CORROSIVE'),
       ('ENVIRONMENTAL_HAZARD'),
       ('EXPLOSIVE'),
       ('FLAMMABLE'),
       ('HARMFUL'),
       ('HEALTH_HAZARD'),
       ('INERT'),
       ('IRRITANT'),
       ('OXIDIZING'),
       ('TOXIC'),
       ('RADIOACTIVE'),
       ('BIOHAZARD'),
       ('GAS_UNDER_PRESSURE'),
       ('ACUTE_TOXICITY'),
       ('CARCINOGENIC'),
       ('TERATOGENIC'),
       ('MUTAGENIC');


CREATE TABLE usage_reason
(
    id     BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    reason VARCHAR not null
);

INSERT INTO usage_reason (reason)
VALUES ('IMPORTED'),
       ('SYNTHESIZED'),
       ('USED_FOR_SYNTHESIS'),
       ('NOT_REGISTERED'),
       ('USED_FOR_ANALYSIS'),
       ('EXPIRED'),
       ('DAMAGED'),
       ('LOST'),
       ('STOLEN'),
       ('USED_FOR_TESTING'),
       ('USED_FOR_TEACHING'),
       ('RETURNED'),
       ('DISPOSED'),
       ('SAMPLE_TAKEN'),
       ('ACCIDENTAL_SPILL'),
       ('QUALITY_CHECK');


create table unit
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    unit VARCHAR NOT NULL
);

INSERT INTO unit (unit)
VALUES ('MOLE'),
       ('GRAM'),
       ('KILOGRAM'),
       ('LITER'),
       ('MILLILITER'),
       ('MICROLITER'),
       ('NANOLITER'),
       ('MILLIMOLE'),
       ('MICROMOLE'),
       ('NANOMOLE'),
       ('MOLAR'),
       ('MILLIGRAM'),
       ('MICROGRAM'),
       ('NANOGRAM'),
       ('PPM'),
       ('PPB'),
       ('PPT'),
       ('MOL_PER_LITER'),
       ('G_PER_LITER'),
       ('KG_PER_LITER');


CREATE TABLE journal
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title      VARCHAR   NOT NULL,
    text       VARCHAR,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);



CREATE TABLE reagent
(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title           VARCHAR   NOT NULL,
    latex_formula   VARCHAR,
    molar_weight    NUMERIC   NOT NULL,
    description     VARCHAR   NOT NULL,
    hazard_category BIGINT    NOT NULL REFERENCES hazard_category,
    created_at      TIMESTAMP NOT NULL,
    updated_at      TIMESTAMP
);


CREATE TABLE reagent_usage
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    reagent_id BIGINT    NOT NULL REFERENCES reagent,
    journal_id BIGINT    NOT NULL REFERENCES journal,

    reason     BIGINT    NOT NULL REFERENCES usage_reason,
    quantity   NUMERIC   NOT NULL,
    unit       BIGINT    NOT NULL REFERENCES unit,
    created_at TIMESTAMP NOT NULL
);
