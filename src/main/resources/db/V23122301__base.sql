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
    latex_formula   VARCHAR   NOT NULL,
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

INSERT INTO journal (title, text, created_at, updated_at)
VALUES ('Journal 1', 'Research on compound A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 2', 'Analysis of B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 3', 'Synthesis of novel catalyst C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 4', 'Evaluation of antioxidant D', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 5', 'Study of protein interactions E', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 6', 'Development of new polymer F', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 7', 'Investigation of enzyme G', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 8', 'Characterization of metal complex H', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 9', 'Examination of crystal structure I', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 10', 'Testing of new formulation J', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 11', 'Exploration of organic synthesis K', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 12', 'Quantitative analysis of compound L', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 13', 'Structural study of molecule M', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 14', 'Pharmacological properties of N', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 15', 'Biochemical pathways of O', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 16', 'Thermal stability study of P', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 17', 'Electrochemical behavior of Q', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 18', 'Molecular dynamics of R', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 19', 'Chemical kinetics of S', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 20', 'Toxicological assessment of T', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 21', 'Environmental impact of U', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 22', 'Biological activity of V', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 23', 'Nanoparticle synthesis W', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 24', 'Photocatalytic efficiency of X', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 25', 'Mechanistic insights of Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 26', 'Compositional analysis of Z', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 27', 'Thermodynamic properties of AA', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 28', 'Kinetic modeling of BB', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 29', 'Spectroscopic analysis of CC', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 30', 'Material properties of DD', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 31', 'Catalytic efficiency of EE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 32', 'Biodegradability study of FF', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 33', 'Chromatographic separation of GG', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 34', 'Molecular cloning of HH', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 35', 'Radiochemical techniques in II', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 36', 'Analytical methods for JJ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 37', 'Synthesis and properties of KK', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 38', 'Biocompatibility of LL', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 39', 'Quantum chemical studies of MM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 40', 'Nanotechnology in NN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 41', 'Advanced materials in OO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 42', 'Molecular engineering of PP', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 43', 'Electrolyte analysis in QQ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 44', 'Polymer science research RR', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 45', 'Computational modeling SS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 46', 'Neurochemical studies TT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Journal 47', 'Final review of project ZZ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO reagent (title, latex_formula, molar_weight, description, hazard_category, created_at, updated_at)
VALUES
    ('Sodium Chloride', 'NaCl', 58.44, 'Common salt used in various chemical processes.', 'Non-hazardous', NOW(), NOW()),
    ('Hydrochloric Acid', 'HCl', 36.46, 'Strong acid used for pH adjustment and laboratory purposes.', 'Corrosive', NOW(), NOW()),
    ('Sulfuric Acid', 'H_{2}SO_{4}', 98.08, 'Strong acid used in various industrial applications.', 'Corrosive', NOW(), NOW()),
    ('Potassium Permanganate', 'KMnO_{4}', 158.03, 'Oxidizing agent and disinfectant.', 'Oxidizer', NOW(), NOW()),
    ('Ethanol', 'C_{2}H_{5}OH', 46.07, 'Common alcohol used as a solvent and disinfectant.', 'Flammable', NOW(), NOW()),
    ('Acetone', 'C_{3}H_{6}O', 58.08, 'Solvent and laboratory reagent.', 'Flammable', NOW(), NOW()),
    ('Benzene', 'C_{6}H_{6}', 78.11, 'Aromatic solvent and precursor in chemical synthesis.', 'Carcinogenic', NOW(), NOW()),
    ('Glucose', 'C_{6}H_{12}O_{6}', 180.16, 'Simple sugar used in biology and biochemistry.', 'Non-hazardous', NOW(), NOW()),
    ('Ammonium Nitrate', 'NH_{4}NO_{3}', 80.04, 'Common fertilizer and explosive material.', 'Explosive', NOW(), NOW()),
    ('Copper Sulfate', 'CuSO_{4}', 159.61, 'Copper salt used in agriculture and chemistry.', 'Harmful', NOW(), NOW()),
    ('Nitric Acid', 'HNO_{3}', 63.01, 'Strong acid used in various industrial applications.', 'Corrosive', NOW(), NOW()),
    ('Phosphoric Acid', 'H_{3}PO_{4}', 97.99, 'Weak acid used in food and chemical industry.', 'Corrosive', NOW(), NOW()),
    ('Magnesium Sulfate', 'MgSO_{4}', 120.37, 'Magnesium salt used in medicine and agriculture.', 'Non-hazardous', NOW(), NOW()),
    ('Calcium Carbonate', 'CaCO_{3}', 100.09, 'Common mineral used as a dietary supplement and in industry.', 'Non-hazardous', NOW(), NOW()),
    ('Silver Nitrate', 'AgNO_{3}', 169.87, 'Silver salt used in photography and chemistry.', 'Harmful', NOW(), NOW()),
    ('Acetic Acid', 'CH_{3}COOH', 60.05, 'Weak acid used in food, chemistry, and industry.', 'Corrosive', NOW(), NOW()),
    ('Sodium Hydroxide', 'NaOH', 40.00, 'Strong base used in various industrial applications.', 'Corrosive', NOW(), NOW()),
    ('Methanol', 'CH_{3}OH', 32.04, 'Simple alcohol used as a solvent and fuel.', 'Flammable', NOW(), NOW()),
    ('Ammonia', 'NH_{3}', 17.03, 'Gas used in refrigeration and chemical synthesis.', 'Corrosive', NOW(), NOW()),
    ('Chloroform', 'CHCl_{3}', 119.38, 'Organic solvent and anesthetic.', 'Harmful', NOW(), NOW()),
    ('Potassium Chloride', 'KCl', 74.55, 'Potassium salt used in medicine and agriculture.', 'Non-hazardous', NOW(), NOW()),
    ('Sodium Bicarbonate', 'NaHCO_{3}', 84.01, 'Baking soda used in cooking and medicine.', 'Non-hazardous', NOW(), NOW()),
    ('Zinc Sulfate', 'ZnSO_{4}', 161.47, 'Zinc salt used in medicine and agriculture.', 'Harmful', NOW(), NOW()),
    ('Ferric Chloride', 'FeCl_{3}', 162.21, 'Iron salt used in water treatment and etching.', 'Corrosive', NOW(), NOW()),
    ('Barium Chloride', 'BaCl_{2}', 244.26, 'Barium salt used in laboratory and industry.', 'Harmful', NOW(), NOW()),
    ('Lithium Hydroxide', 'LiOH', 23.95, 'Strong base used in batteries and chemical synthesis.', 'Corrosive', NOW(), NOW()),
    ('Stannous Chloride', 'SnCl_{2}', 189.60, 'Tin salt used in metallurgy and chemistry.', 'Harmful', NOW(), NOW()),
    ('Sodium Phosphate', 'Na_{3}PO_{4}', 163.94, 'Phosphate salt used in chemistry and biology.', 'Non-hazardous', NOW(), NOW()),
    ('Potassium Iodide', 'KI', 166.00, 'Iodine salt used in medicine and photography.', 'Non-hazardous', NOW(), NOW()),
    ('Mercuric Chloride', 'HgCl_{2}', 271.52, 'Mercury salt used in laboratory and medicine.', 'Harmful', NOW(), NOW()),
    ('Cadmium Sulfate', 'CdSO_{4}', 208.47, 'Cadmium salt used in electroplating and pigments.', 'Harmful', NOW(), NOW()),
    ('Nickel Chlorate', 'Ni(ClO_{3}){2}', 238.71, 'Nickel salt used in chemistry and metallurgy.', 'Oxidizer', NOW(), NOW()),
    ('Lead Acetate', 'Pb(C{2}H_{3}O_{2}){2}', 325.29, 'Lead salt used in analytical chemistry.', 'Harmful', NOW(), NOW()),
    ('Chromium Oxide', 'Cr{2}O_{3}', 151.99, 'Chromium compound used as a pigment and in ceramics.', 'Harmful', NOW(), NOW()),
    ('Boric Acid', 'H_{3}BO_{3}', 61.83, 'Weak acid used in glassmaking and as an antiseptic.', 'Non-hazardous', NOW(), NOW()),
    ('Sodium Sulfite', 'Na_{2}SO_{3}', 126.04, 'Sodium salt used in photography and food processing.', 'Non-hazardous', NOW(), NOW()),
    ('Potassium Dichromate', 'K_{2}Cr_{2}O_{7}', 294.19, 'Oxidizing agent and chemical reagent.', 'Oxidizer', NOW(), NOW()),
    ('Copper Nitrate', 'Cu(NO_{3}){2}', 187.56, 'Copper salt used in chemistry and metallurgy.', 'Harmful', NOW(), NOW()),
    ('Zinc Nitrate', 'Zn(NO{3}){2}', 189.38, 'Zinc salt used in chemistry and electroplating.', 'Harmful', NOW(), NOW()),
    ('Aluminum Sulfate', 'Al{2}(SO_{4}){3}', 342.15, 'Aluminum salt used in water treatment and papermaking.', 'Harmful', NOW(), NOW()),
    ('Sodium Carbonate', 'Na{2}CO_{3}', 105.99, 'Sodium salt used in cleaning and chemical synthesis.', 'Non-hazardous', NOW(), NOW()),
    ('Magnesium Chloride', 'MgCl_{2}', 95.21, 'Magnesium salt used in chemistry and medicine.', 'Non-hazardous', NOW(), NOW()),
    ('Calcium Sulfate', 'CaSO_{4}', 136.14, 'Calcium salt used in construction and food production.', 'Non-hazardous', NOW(), NOW()),
    ('Iron(III) Sulfate', 'Fe_{2}(SO_{4}){3}', 399.88, 'Iron salt used in water treatment and chemistry.', 'Harmful', NOW(), NOW()),
    ('Tin(II) Chloride', 'SnCl{2}', 189.36, 'Tin salt used in metallurgy and chemical reduction.', 'Harmful', NOW(), NOW()),
    ('Manganese(II) Sulfate', 'MnSO_{4}', 151.00, 'Manganese salt used in agriculture and chemistry.', 'Harmful', NOW(), NOW()),
    ('Cobalt(II) Nitrate', 'Co(NO_{3})_{2}', 182.94, 'Cobalt salt used in chemistry and catalysts.', 'Harmful', NOW(), NOW());

-- Generate 50 random reagent usage records
INSERT INTO reagent_usage (reagent_id, journal_id, reason, quantity, unit, created_at)
SELECT
    ROUND(RAND() * 46) + 1, -- Random reagent_id between 1 and 47
    ROUND(RAND() * 46) + 1, -- Random journal_id between 1 and 47
    (SELECT reason FROM usage_reason ORDER BY RAND() LIMIT 1), -- Random reason from the predefined list
    ROUND(RAND() * 100), -- Random quantity between 0 and 100
    (SELECT unit FROM unit ORDER BY RAND() LIMIT 1), -- Random unit from the predefined list
    NOW() - INTERVAL FLOOR(RAND() * 365) DAY -- Random creation date within the last year
LIMIT 147;
