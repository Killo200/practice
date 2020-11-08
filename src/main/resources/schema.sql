CREATE TABLE IF NOT EXISTS Organization
(
    id        INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version   INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    name      VARCHAR(50)  NOT NULL COMMENT 'Название организации',
    full_name VARCHAR(250) NOT NULL COMMENT 'Полное название организации',
    inn       VARCHAR(15)  NOT NULL COMMENT 'ИНН',
    kpp       VARCHAR(15)  NOT NULL COMMENT 'КПП',
    address   VARCHAR(250) NOT NULL COMMENT 'Адрес организации',
    phone     VARCHAR(11)           COMMENT 'Номер телефона',
    is_active BOOL                  COMMENT 'Организация активна'
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Office
(
    id              INTEGER                 COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version         INTEGER      NOT NULL   COMMENT 'Служебное поле hibernate',
    name            VARCHAR(50)  NOT NULL   COMMENT 'Название офиса',
    address         VARCHAR(250) NOT NULL   COMMENT 'Адрес офиса',
    phone           VARCHAR(11)             COMMENT 'Номер телефона',
    is_active       BOOL                    COMMENT 'Офис активен',
    organization_id INTEGER      NOT NULL   COMMENT 'Организация владелец'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Person
(
    id             INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version        INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    first_name     VARCHAR(20) NOT NULL COMMENT 'Имя',
    second_name    VARCHAR(20)          COMMENT 'Фамилия',
    middle_name    VARCHAR(20)          COMMENT 'Отчество',
    position       VARCHAR(50) NOT NULL COMMENT 'Должность',
    phone          VARCHAR(11)          COMMENT 'Номер телефона',
    is_identified  BOOL                 COMMENT 'Человек идентифицирован',
    office_id      INTEGER     NOT NULL COMMENT 'Офис место работы',
    citizenship_id INTEGER     NOT NULL COMMENT 'Гражданство'
);
COMMENT ON TABLE Person IS 'Человек';

CREATE TABLE IF NOT EXISTS Doc_type
(
    id      INTEGER                     COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version INTEGER           NOT NULL  COMMENT 'Служебное поле hibernate',
    code    INTEGER           NOT NULL  COMMENT 'Уникальный код документа',
    name    VARCHAR(250)      NOT NULL  COMMENT 'Наименование документа'
);
COMMENT ON TABLE Doc_type IS 'Тип документа';

CREATE TABLE IF NOT EXISTS Document
(
    person_id        INTEGER                COMMENT 'Уникальный идентификатор документа человека' PRIMARY KEY,
    version          INTEGER     NOT NULL   COMMENT 'Служебное поле hibernate',
    document_number  VARCHAR(11) NOT NULL   COMMENT 'Номер документа',
    document_date    VARCHAR(10)            COMMENT 'Дата выдачи',
    doc_type_code_id INTEGER     NOT NULL   COMMENT 'Идентификатор типа документа'
);
COMMENT ON TABLE Document IS 'Документ';

CREATE TABLE IF NOT EXISTS Country
(
    id           INTEGER                COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version      INTEGER      NOT NULL  COMMENT 'Служебное поле hibernate',
    code_country INTEGER      NOT NULL  COMMENT 'Уникальный код страны',
    name         VARCHAR(250) NOT NULL  COMMENT 'Cтрана'
);
COMMENT ON TABLE Country IS 'Страна';


CREATE INDEX IX_Office_Organization_Id ON Office (organization_id);
ALTER TABLE Office
    ADD FOREIGN KEY (organization_id) REFERENCES Organization (id);

CREATE INDEX IX_Person_Office_Id ON Person (office_id);
ALTER TABLE Person
    ADD FOREIGN KEY (office_id) REFERENCES Office (id);

CREATE INDEX IX_Person_Citizenship_Id ON Person (citizenship_id);
ALTER TABLE Person
    ADD FOREIGN KEY (citizenship_id) REFERENCES Country (id);

CREATE UNIQUE INDEX UX_Document_Person_Id ON Document (person_id);
ALTER TABLE Document
    ADD FOREIGN KEY (person_id) REFERENCES Person (id);

CREATE INDEX IX_Document_Doc_Type_Code_Id ON Document (doc_type_code_id);
ALTER TABLE Document
    ADD FOREIGN KEY (doc_type_code_id) REFERENCES Doc_type (id);
