CREATE TABLE hazard_category
(
    id       BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    category varchar not null
);

INSERT INTO hazard_category (category)
VALUES ('NON_HAZARDOUS'),
       ('CORROSIVE'),
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

INSERT INTO reagent (title, latex_formula, molar_weight, description, hazard_category, created_at,
                     updated_at)
VALUES ('Sodium Chloride', 'NaCl', 58.44, 'Common salt used in various chemical processes.', 1,
        NOW(), NOW()),
       ('Hydrochloric Acid', 'HCl', 36.46,
        'Strong acid used for pH adjustment and laboratory purposes.', 2, NOW(), NOW()),
       ('Sulfuric Acid', 'H_{2}SO_{4}', 98.08,
        'Strong acid used in various industrial applications.', 2, NOW(), NOW()),
       ('Potassium Permanganate', 'KMnO_{4}', 158.03, 'Oxidizing agent and disinfectant.',
        10, NOW(), NOW()),
       ('Ethanol', 'C_{2}H_{5}OH', 46.07, 'Common alcohol used as a solvent and disinfectant.',
        5, NOW(), NOW()),
       ('Acetone', 'C_{3}H_{6}O', 58.08, 'Solvent and laboratory reagent.', 5, NOW(),
        NOW()),
       ('Benzene', 'C_{6}H_{6}', 78.11, 'Aromatic solvent and precursor in chemical synthesis.',
        16, NOW(), NOW()),
       ('Glucose', 'C_{6}H_{12}O_{6}', 180.16, 'Simple sugar used in biology and biochemistry.',
        1, NOW(), NOW()),
       ('Ammonium Nitrate', 'NH_{4}NO_{3}', 80.04, 'Common fertilizer and explosive material.',
        4, NOW(), NOW()),
       ('Copper Sulfate', 'CuSO_{4}', 159.61, 'Copper salt used in agriculture and chemistry.',
        6, NOW(), NOW()),
       ('Nitric Acid', 'HNO_{3}', 63.01, 'Strong acid used in various industrial applications.',
        2, NOW(), NOW()),
       ('Phosphoric Acid', 'H_{3}PO_{4}', 97.99, 'Weak acid used in food and chemical industry.',
        2, NOW(), NOW()),
       ('Magnesium Sulfate', 'MgSO_{4}', 120.37, 'Magnesium salt used in medicine and agriculture.',
        1, NOW(), NOW()),
       ('Calcium Carbonate', 'CaCO_{3}', 100.09,
        'Common mineral used as a dietary supplement and in industry.', 1, NOW(), NOW()),
       ('Silver Nitrate', 'AgNO_{3}', 169.87, 'Silver salt used in photography and chemistry.',
        6, NOW(), NOW()),
       ('Acetic Acid', 'CH_{3}COOH', 60.05, 'Weak acid used in food, chemistry, and industry.',
        2, NOW(), NOW()),
       ('Sodium Hydroxide', 'NaOH', 40.00, 'Strong base used in various industrial applications.',
        2, NOW(), NOW()),
       ('Methanol', 'CH_{3}OH', 32.04, 'Simple alcohol used as a solvent and fuel.', 5,
        NOW(), NOW()),
       ('Ammonia', 'NH_{3}', 17.03, 'Gas used in refrigeration and chemical synthesis.',
        2, NOW(), NOW()),
       ('Chloroform', 'CHCl_{3}', 119.38, 'Organic solvent and anesthetic.', 6, NOW(),
        NOW()),
       ('Potassium Chloride', 'KCl', 74.55, 'Potassium salt used in medicine and agriculture.', 1,
        NOW(), NOW()),
       ('Sodium Bicarbonate', 'NaHCO_{3}', 84.01, 'Baking soda used in cooking and medicine.', 1,
        NOW(), NOW()),
       ('Zinc Sulfate', 'ZnSO_{4}', 161.47, 'Zinc salt used in medicine and agriculture.',
        6, NOW(), NOW()),
       ('Ferric Chloride', 'FeCl_{3}', 162.21, 'Iron salt used in water treatment and etching.',
        2, NOW(), NOW()),
       ('Barium Chloride', 'BaCl_{2}', 244.26, 'Barium salt used in laboratory and industry.',
        6, NOW(), NOW()),
       ('Lithium Hydroxide', 'LiOH', 23.95, 'Strong base used in batteries and chemical synthesis.',
        2, NOW(), NOW()),
       ('Stannous Chloride', 'SnCl_{2}', 189.60, 'Tin salt used in metallurgy and chemistry.',
        6, NOW(), NOW()),
       ('Sodium Phosphate', 'Na_{3}PO_{4}', 163.94, 'Phosphate salt used in chemistry and biology.',
        1, NOW(), NOW()),
       ('Potassium Iodide', 'KI', 166.00, 'Iodine salt used in medicine and photography.', 1,
        NOW(), NOW()),
       ('Mercuric Chloride', 'HgCl_{2}', 271.52, 'Mercury salt used in laboratory and medicine.',
        6, NOW(), NOW()),
       ('Cadmium Sulfate', 'CdSO_{4}', 208.47, 'Cadmium salt used in electroplating and pigments.',
        6, NOW(), NOW()),
       ('Nickel Chlorate', 'Ni(ClO_{3}){2}', 238.71,
        'Nickel salt used in chemistry and metallurgy.', 10, NOW(), NOW()),
       ('Lead Acetate', 'Pb(C{2}H_{3}O_{2}){2}', 325.29, 'Lead salt used in analytical chemistry.',
        6, NOW(), NOW()),
       ('Chromium Oxide', 'Cr{2}O_{3}', 151.99,
        'Chromium compound used as a pigment and in ceramics.', 6, NOW(), NOW()),
       ('Boric Acid', 'H_{3}BO_{3}', 61.83, 'Weak acid used in glassmaking and as an antiseptic.',
        1, NOW(), NOW()),
       ('Sodium Sulfite', 'Na_{2}SO_{3}', 126.04,
        'Sodium salt used in photography and food processing.', 1, NOW(), NOW()),
       ('Potassium Dichromate', 'K_{2}Cr_{2}O_{7}', 294.19, 'Oxidizing agent and chemical reagent.',
        10, NOW(), NOW()),
       ('Copper Nitrate', 'Cu(NO_{3}){2}', 187.56, 'Copper salt used in chemistry and metallurgy.',
        6, NOW(), NOW()),
       ('Zinc Nitrate', 'Zn(NO{3}){2}', 189.38, 'Zinc salt used in chemistry and electroplating.',
        6, NOW(), NOW()),
       ('Aluminum Sulfate', 'Al{2}(SO_{4}){3}', 342.15,
        'Aluminum salt used in water treatment and papermaking.', 6, NOW(), NOW()),
       ('Sodium Carbonate', 'Na{2}CO_{3}', 105.99,
        'Sodium salt used in cleaning and chemical synthesis.', 1, NOW(), NOW()),
       ('Magnesium Chloride', 'MgCl_{2}', 95.21, 'Magnesium salt used in chemistry and medicine.',
        1, NOW(), NOW()),
       ('Calcium Sulfate', 'CaSO_{4}', 136.14,
        'Calcium salt used in construction and food production.', 1, NOW(), NOW()),
       ('Iron(III) Sulfate', 'Fe_{2}(SO_{4}){3}', 399.88,
        'Iron salt used in water treatment and chemistry.', 6, NOW(), NOW()),
       ('Tin(II) Chloride', 'SnCl{2}', 189.36,
        'Tin salt used in metallurgy and chemical reduction.', 6, NOW(), NOW()),
       ('Manganese(II) Sulfate', 'MnSO_{4}', 151.00,
        'Manganese salt used in agriculture and chemistry.', 6, NOW(), NOW()),
       ('Cobalt(II) Nitrate', 'Co(NO_{3})_{2}', 182.94,
        'Cobalt salt used in chemistry and catalysts.', 6, NOW(), NOW());


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



INSERT INTO reagent_usage (reagent_id, journal_id, reason, quantity, unit, created_at)
VALUES (1, 1, 6, 10, 1, '2023-01-01 12:00:00'),
       (2, 2, 2, 20, 2, '2023-02-01 14:30:00'),
       (3, 3, 3, 5, 3, '2023-03-01 10:45:00'),
       (4, 4, 4, 15, 4, '2023-04-01 08:15:00'),
       (5, 5, 5, 8, 5, '2023-05-01 16:20:00'),
       (6, 6, 6, 25, 6, '2023-06-01 11:30:00'),
       (7, 7, 7, 18, 7, '2023-07-01 09:15:00'),
       (8, 8, 8, 12, 8, '2023-08-01 13:45:00'),
       (9, 9, 9, 30, 9, '2023-09-01 07:00:00'),
       (10, 10, 10, 22, 10, '2023-10-01 17:00:00'),
       (11, 11, 11, 15, 11, '2023-11-01 14:30:00'),
       (12, 12, 12, 28, 12, '2023-12-01 10:15:00'),
       (13, 13, 13, 20, 13, '2024-01-01 09:45:00'),
       (14, 14, 14, 10, 14, '2024-02-01 08:00:00'),
       (15, 15, 15, 35, 15, '2024-03-01 16:30:00'),
       (16, 16, 16, 17, 16, '2024-04-01 11:00:00'),
       (17, 17, 6, 22, 17, '2024-05-01 10:30:00'),
       (18, 18, 2, 14, 18, '2024-06-01 14:45:00'),
       (19, 19, 3, 25, 19, '2024-07-01 09:00:00'),
       (20, 20, 4, 30, 20, '2024-08-01 16:15:00'),
       (21, 21, 5, 18, 1, '2024-09-01 12:30:00'),
       (22, 22, 6, 20, 2, '2024-10-01 10:45:00'),
       (23, 23, 7, 15, 3, '2024-11-01 14:00:00'),
       (24, 24, 8, 25, 4, '2024-12-01 09:15:00'),
       (25, 25, 9, 12, 5, '2025-01-01 16:30:00'),
       (26, 26, 10, 22, 6, '2025-02-01 11:00:00'),
       (27, 27, 11, 28, 7, '2025-03-01 10:30:00'),
       (28, 28, 12, 15, 8, '2025-04-01 14:45:00'),
       (29, 29, 13, 20, 9, '2025-05-01 09:00:00'),
       (30, 30, 14, 10, 14, '2025-06-01 16:15:00'),
       (31, 31, 15, 17, 15, '2025-07-01 11:30:00'),
       (32, 32, 16, 22, 16, '2025-08-01 10:15:00'),
       (33, 33, 6, 14, 17, '2025-09-01 13:45:00'),
       (34, 34, 2, 25, 18, '2025-10-01 07:00:00'),
       (35, 35, 3, 30, 19, '2025-11-01 17:00:00'),
       (36, 36, 4, 15, 11, '2025-12-01 14:30:00'),
       (37, 37, 5, 28, 12, '2026-01-01 10:15:00'),
       (38, 38, 6, 20, 13, '2026-02-01 09:45:00'),
       (39, 39, 7, 25, 14, '2026-03-01 08:00:00'),
       (40, 40, 8, 12, 15, '2026-04-01 16:30:00'),
       (41, 41, 9, 17, 16, '2026-05-01 11:00:00'),
       (42, 42, 10, 22, 17, '2026-06-01 10:30:00'),
       (43, 43, 11, 14, 18, '2026-07-01 14:45:00'),
       (44, 44, 12, 25, 19, '2026-08-01 09:00:00'),
       (45, 45, 13, 30, 20, '2026-09-01 17:00:00'),
       (46, 46, 5, 18, 1, '2026-10-01 12:30:00'),
       (47, 47, 6, 20, 2, '2026-11-01 10:45:00'),
       (47, 47, 6, 20, 2, '2026-11-01 10:45:00')

-- ЭЭ малой ты куда погнал?! У тебя журналов всего!! 47!!!1
--        (48, 48, 16, 15, 12, '2026-12-01 11:30:00'),
--        (49, 49, 6, 25, 13, '2027-01-01 10:15:00'),
--        (50, 50, 5, 30, 14, '2027-02-01 09:45:00'),
--        (51, 51, 15, 17, 15, '2027-03-01 08:00:00'),
--        (52, 52, 11, 22, 16, '2027-04-01 16:30:00'),
--        (53, 53, 12, 28, 17, '2027-05-01 11:00:00'),
--        (54, 54, 13, 15, 11, '2027-06-01 10:30:00'),
--        (55, 55, 14, 20, 12, '2027-07-01 13:45:00'),
--        (56, 56, 15, 25, 13, '2027-08-01 09:00:00'),
--        (57, 57, 10, 30, 14, '2027-09-01 17:00:00'),
--        (58, 58, 11, 18, 1, '2027-10-01 12:30:00'),
--        (59, 59, 12, 20, 2, '2027-11-01 10:45:00'),
--        (60, 60, 13, 15, 3, '2027-12-01 09:15:00'),
--        (61, 61, 8, 25, 4, '2028-01-01 16:30:00'),
--        (62, 62, 9, 12, 5, '2028-02-01 11:00:00'),
--        (63, 63, 10, 17, 6, '2028-03-01 10:30:00'),
--        (64, 64, 11, 22, 7, '2028-04-01 14:45:00'),
--        (65, 65, 12, 14, 8, '2028-05-01 09:00:00'),
--        (66, 66, 13, 25, 9, '2028-06-01 17:00:00'),
--        (67, 67, 14, 30, 10, '2028-07-01 12:30:00'),
--        (67, 67, 14, 30, 10, '2028-07-01 12:30:00'),
--        (68, 68, 15, 22, 15, '2028-08-01 11:00:00'),
--        (69, 69, 10, 18, 16, '2028-09-01 10:30:00'),
--        (70, 70, 11, 25, 17, '2028-10-01 14:45:00'),
--        (71, 71, 12, 30, 11, '2028-11-01 09:00:00'),
--        (72, 72, 13, 15, 12, '2028-12-01 16:30:00'),
--        (73, 73, 8, 20, 13, '2029-01-01 11:00:00'),
--        (74, 74, 9, 25, 14, '2029-02-01 10:30:00'),
--        (75, 75, 10, 28, 11, '2029-03-01 13:45:00'),
--        (76, 76, 11, 22, 12, '2029-04-01 09:00:00'),
--        (77, 77, 12, 20, 13, '2029-05-01 17:00:00'),
--        (78, 78, 13, 15, 14, '2029-06-01 12:30:00'),
--        (79, 79, 14, 25, 11, '2029-07-01 10:45:00'),
--        (80, 80, 15, 30, 12, '2029-08-01 09:15:00'),
--        (81, 81, 16, 18, 13, '2029-09-01 16:30:00'),
--        (82, 82, 6, 22, 14, '2029-10-01 11:00:00'),
--        (83, 83, 2, 14, 15, '2029-11-01 10:30:00'),
--        (84, 84, 3, 25, 16, '2029-12-01 14:45:00'),
--        (85, 85, 4, 30, 17, '2030-01-01 09:00:00'),
--        (86, 86, 5, 18, 18, '2030-02-01 17:00:00'),
--        (87, 87, 6, 20, 19, '2030-03-01 12:30:00'),
--        (87, 87, 6, 20, 19, '2030-03-01 12:30:00'),
--        (88, 88, 15, 22, 15, '2030-04-01 11:00:00'),
--        (89, 89, 10, 18, 16, '2030-05-01 10:30:00'),
--        (90, 90, 11, 25, 17, '2030-06-01 14:45:00'),
--        (91, 91, 12, 30, 11, '2030-07-01 09:00:00'),
--        (92, 92, 13, 15, 12, '2030-08-01 16:30:00'),
--        (93, 93, 8, 20, 13, '2030-09-01 11:00:00'),
--        (94, 94, 9, 25, 14, '2030-10-01 10:30:00'),
--        (95, 95, 10, 28, 11, '2030-11-01 13:45:00'),
--        (96, 96, 11, 22, 12, '2030-12-01 09:00:00'),
--        (97, 97, 12, 20, 13, '2031-01-01 17:00:00'),
--        (98, 98, 13, 15, 14, '2031-02-01 12:30:00'),
--        (99, 99, 14, 25, 11, '2031-03-01 10:45:00'),
--        (100, 100, 15, 30, 12, '2031-04-01 09:15:00');
