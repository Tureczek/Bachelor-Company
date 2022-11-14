insert into companies (company_name, cvr, logo_link, webpage_link) values ('testfirm', 12345678, 'dd', 'dd');

insert into bachelor.companies (company_name, cvr, logo_link, webpage_link) values ('MeeW', 38455958, 'dd', 'dd');



--- DEPARTMENTS __
INSERT INTO departments (department_name, fk_address, p_number, fk_company) VALUES ('MeeW STUDIOS ApS - København', 'f65226f8-dda5-4f98-8a36-2226f4dc28af', 1022233552, 'e88216ed-3f1f-4ce0-9c2f-2e25efbabb35');
INSERT INTO departments (department_name, fk_address, p_number, fk_company) VALUES ('MeeW ApS - Odense', 'f65226f8-dda5-4f98-8a36-2226f4dc28af', 1024341727, 'e88216ed-3f1f-4ce0-9c2f-2e25efbabb35');
INSERT INTO departments (department_name, fk_address, p_number, fk_company) VALUES ('MeeW STUDIOS ApS - Hedensted', 'f65226f8-dda5-4f98-8a36-2226f4dc28af', 1028017207, 'e88216ed-3f1f-4ce0-9c2f-2e25efbabb35');
INSERT INTO departments (department_name, fk_address, p_number, fk_company) VALUES ('MeeW STUDIOS ApS - Aarhus', 'f65226f8-dda5-4f98-8a36-2226f4dc28af', 1028628052, 'e88216ed-3f1f-4ce0-9c2f-2e25efbabb35');



--- SCORE --
INSERT INTO bachelor.scores(coworker_score, facilities_score, flexibility_score, fringe_benefits_score,
                            management_score, pension_score, salary_score, workhour_score, workload_score, review_count, fk_company)
VALUES (4,2,4,2,2,1,1,5,2,3, 'e88216ed-3f1f-4ce0-9c2f-2e25efbabb35');

INSERT INTO bachelor.scores(coworker_score, facilities_score, flexibility_score, fringe_benefits_score,
                            management_score, pension_score, review_count, salary_score, workhour_score, workload_score, fk_company)
VALUES (9,4,5,4,5,6,7,3,9,8, '5de07453-812c-4c3f-b371-24acf8942d3a');



INSERT INTO fields (code, name) VALUES (0001, 'Event');
INSERT INTO fields (code, name) VALUES (007, 'Agent');
INSERT INTO fields (code, name) VALUES (016, 'IT');

--- JUNCTION TABLE ---

INSERT INTO business_fields (company_id, field_id) VALUES ('e88216ed-3f1f-4ce0-9c2f-2e25efbabb35', 'b037ecb6-503d-4513-b947-8652e81c72a9')





--- ANNOUNCEMENTS ---

    INSERT INTO announcements (description, fk_department, title) VALUES ('Ny ledelse i salgs afdelingen. Dette gør at vi nu er endnu bedre ved vores medarbejdere!',
    '272fd693-2446-4acf-8104-fc69af22cd68', 'DER SKER NOGET VILDT!');



WITH company AS (
    SELECT company_id AS c_id FROM companies c WHERE company_name = 'testfirm3'
), department AS (
    SELECT department_name FROM departments d WHERE d.fk_company = c_id)
SELECT department_name FROM departments d2  WHERE department_name IN (SELECT department_name FROM department)
GROUP BY department_name;


WITH company AS (SELECT company_id, company_name  FROM companies c WHERE company_name = 'testfirm3')
SELECT department_id, company_id, company_name  FROM departments AS dep, company WHERE dep.fk_company = company.company_id;










SELECT * FROM bachelor.scores;
SELECT * FROM companies c;
SELECT * FROM fields f;
SELECT * FROM business_fields bf;

select * from companies, fields, business_fields bf  WHERE bf.field_id = 'd264fbfc-e5db-4ae7-b031-e9e3152d956a';