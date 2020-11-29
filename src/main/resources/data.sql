INSERT INTO Country (id, version, code_country, name)
VALUES (1, 0, 643, 'Россия');

INSERT INTO Country (id, version, code_country, name)
VALUES (2, 0, 112, 'Беларусь');

INSERT INTO Country (id, version, code_country, name)
VALUES (3, 0, 276, 'Германия');

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES (1, 0, 'Газпром', 'ПАО Газпром', '7736050003', '997250001', 'ул. Наметкина, 16', '84957193001', true);

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES (2, 0, 'Тинькофф', 'TCS Group Holding PLC Annual', '156844852', '4025685548', '1-й Волоколамский проезд, д. 10, стр. 1', '84956455909', true);

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES (3, 0, 'Яндекс', 'ООО "Яндекс"', '7736207543', '770401001', 'ул. Льва Толстого, 16', '84957397000', true);

INSERT INTO Office (id, version, name, address, phone, organization_id , is_active)
VALUES (1, 0, 'Газпром МСК', 'ул. Наметкина, 16', '84957193001', 1, true);

INSERT INTO Office (id, version, name, address, phone, organization_id , is_active)
VALUES (2, 0, 'Газпром СПБ', 'Конногвардейский бульвар, д. 17, литера А', '88127405570', 1, false);

INSERT INTO Office (id, version, name, address, phone, organization_id , is_active)
VALUES (3, 0, 'Газпром НСК', 'ул. Советская, 77', '83832419701', 1, true);

INSERT INTO Office (id, version, name, address, phone, organization_id , is_active)
VALUES (4, 0, 'Тинькофф МСК', '1-й Волоколамский проезд, д. 10, стр. 1', '84956455909', 2, true);

INSERT INTO Office (id, version, name, address, phone, organization_id , is_active)
VALUES (5, 0, 'Яндекс Центральный', 'ул. Льва Толстого, 16', '84957397000', 3, true);

INSERT INTO Office (id, version, name, address, phone, organization_id , is_active)
VALUES (6, 0, 'Яндекс Москва-Сити', '1-й Красногвардейский проезд, д. 19', null, 3, false);

INSERT INTO Person (id, version, first_name, second_name, middle_name, position, phone, office_id, citizenship_id, is_identified)
VALUES (1, 0, 'Алексей', 'Миллер', 'Борисович', 'Председатель Правления ОАО «Газпром»', '84957193001', 1, 1, true);

INSERT INTO Person (id, version, first_name, second_name, middle_name, position, phone, office_id, citizenship_id, is_identified)
VALUES (2, 0, 'Алексей', 'Миллер', 'Петрович', 'Дворник', null , 2, 2, true);

INSERT INTO Person (id, version, first_name, second_name, middle_name, position, phone, office_id, citizenship_id, is_identified)
VALUES (3, 0, 'Иван', 'Рофлов', 'Рофлович', 'Программист 1С', '89566663656', 4, 1, true);

INSERT INTO Person (id, version, first_name, second_name, middle_name, position, phone, office_id, citizenship_id, is_identified)
VALUES (4, 0, 'Иван', 'Иванов', 'Иванович', 'Junior Java Developer', '89566663657', 6, 3, true);

INSERT INTO Doc_type (id, version, code, name)
VALUES (1, 0, 21, 'Паспорт гражданина Российской Федерации');

INSERT INTO Doc_type (id, version, code, name)
VALUES (2, 0, 10, 'Паспорт иностранного гражданина');

INSERT INTO Doc_type (id, version, code, name)
VALUES (3, 0, 15, 'Разрешение на временное проживание в Российской Федерации');

INSERT INTO Doc_type (id, version, code, name)
VALUES (4, 0, 24, 'Удостоверение личности военнослужащего Российской Федерации');

INSERT INTO Doc_type (id, version, code, name)
VALUES (5, 0, 91, 'Иные документы');


INSERT INTO Document (document_number, document_date, doc_type_code_id, person_id, version)
VALUES ('9864588885', '2005-10-24', 1, 1, 0);

INSERT INTO Document (document_number, document_date, doc_type_code_id, person_id, version)
VALUES ('355458', null , 2, 2, 0);

INSERT INTO Document (document_number, document_date, doc_type_code_id, person_id, version)
VALUES ('55558558', '2000-08-04' , 4, 3, 0);

INSERT INTO Document (document_number, document_date, doc_type_code_id, person_id, version)
VALUES ('55558559', '2000-08-04' , 5, 4, 0);


