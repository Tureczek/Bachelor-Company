-- insert into companies (company_name, cvr, logo_link, webpage_link) values ('testfirm', 12345678, 'dd', 'dd');

insert into bachelor.companies (company_id, company_name, created_date, cvr, logo_link, webpage_link) values ('531dde80-923f-494b-8a05-54cbf8f36996', 'MeeW', (NOW() - interval '6 years'), 38455958, 'dd', 'dd');

--- DEPARTMENTS __
INSERT INTO bachelor.departments (department_id, department_name, email, fk_address, p_number, fk_company) VALUES ('ba83536d-1675-4175-b77e-2e9204ce285f', 'MeeW STUDIOS ApS - København', 'Hello@meew.dk', 'f65226f8-dda5-4f98-8a36-2226f4dc28af', 1022233552, '531dde80-923f-494b-8a05-54cbf8f36996');
INSERT INTO bachelor.departments (department_id, department_name, email, fk_address, p_number, fk_company) VALUES ('ad65f0ee-92b9-4e07-8589-fea046faf5a4', 'MeeW ApS - Odense', 'Hello@meew.dk', 'f65226f8-dda5-4f98-8a36-2226f4dc28af', 1024341727, '531dde80-923f-494b-8a05-54cbf8f36996');
INSERT INTO bachelor.departments (department_id, department_name, email, fk_address, p_number, fk_company) VALUES ('c13170ea-7e9e-4195-8e34-cc14c6843d2b', 'MeeW STUDIOS ApS - Hedensted', 'Hello@meew.dk', 'f65226f8-dda5-4f98-8a36-2226f4dc28af', 1028017207, '531dde80-923f-494b-8a05-54cbf8f36996');
INSERT INTO bachelor.departments (department_id, department_name, email, fk_address, p_number, fk_company) VALUES ('80535168-4e10-4335-b56b-f8509f459990', 'MeeW STUDIOS ApS - Aarhus', 'Hello@meew.dk', 'f65226f8-dda5-4f98-8a36-2226f4dc28af', 1028628052, '531dde80-923f-494b-8a05-54cbf8f36996');

-- Fields --

INSERT INTO bachelor.fields (code, name) VALUES (0001, 'Event');
INSERT INTO bachelor.fields (code, name) VALUES (007, 'Agent');
INSERT INTO bachelor.fields (code, name) VALUES (016, 'IT');
INSERT INTO bachelor.fields (field_id, code, name) VALUES ('f3da7f2e-c2a3-4269-b56b-266604b6beac', 582900, 'Anden udgivelse af software');

--- JUNCTION TABLE ---

INSERT INTO bachelor.business_fields (company_id, field_id) VALUES ('531dde80-923f-494b-8a05-54cbf8f36996', 'f3da7f2e-c2a3-4269-b56b-266604b6beac')


--- ANNOUNCEMENTS ---

INSERT INTO bachelor.announcements (description, fk_department, title) VALUES ('Ny ledelse i salgs afdelingen. Dette gør at vi nu er endnu bedre ved vores medarbejdere!',
'ba83536d-1675-4175-b77e-2e9204ce285f', 'DER SKER NOGET VILDT!');
