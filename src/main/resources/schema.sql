CREATE TABLE IF NOT EXISTS Organization (
    id          INTEGER                       COMMENT 'Уникальный идентификатор' PRIMARY KEY  AUTO_INCREMENT,
    version     INTEGER DEFAULT 0   NOT NULL  COMMENT 'Служебное поле hibernate',
    name        VARCHAR(50)         NOT NULL  COMMENT 'Название организации',
	full_name   VARCHAR(250)        NOT NULL  COMMENT 'Полное название организации',
    inn         VARCHAR (15)        NOT NULL  COMMENT 'ИНН',
    kpp         VARCHAR (15)        NOT NULL  COMMENT 'КПП',
	address     VARCHAR(250)        NOT NULL  COMMENT 'Адрес организации',
	phone       VARCHAR(11)                   COMMENT 'Номер телефона',
    is_active   BOOL DEFAULT TRUE             COMMENT 'Организация активна'
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Office (
    id              INTEGER                         COMMENT 'Уникальный идентификатор'  PRIMARY KEY  AUTO_INCREMENT,
    version         INTEGER DEFAULT 0   NOT NULL    COMMENT 'Служебное поле hibernate',
    name            VARCHAR(50)         NOT NULL    COMMENT 'Название офиса',
    address         VARCHAR(250)        NOT NULL    COMMENT 'Адрес офиса',
    phone           VARCHAR(11)                 	COMMENT 'Номер телефона',
    is_active       BOOL DEFAULT TRUE               COMMENT 'Офис активен',
    organization_id INTEGER             NOT NULL    COMMENT 'Организация владелец'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Person (
    id              INTEGER                         COMMENT 'Уникальный идентификатор'  PRIMARY KEY  AUTO_INCREMENT,
    version         INTEGER DEFAULT 0   NOT NULL    COMMENT 'Служебное поле hibernate',
    first_name      VARCHAR(20)         NOT NULL    COMMENT 'Имя',
	second_name     VARCHAR(20)                     COMMENT 'Фамилия',
	middle_name     VARCHAR(50)                     COMMENT 'Отчество',
	position        VARCHAR(50)         NOT NULL    COMMENT 'Должность',
	phone           VARCHAR(11)                     COMMENT 'Номер телефона',
	is_identified   BOOL DEFAULT TRUE               COMMENT 'Человек идентифицирован',
    office_id       INTEGER             NOT NULL    COMMENT 'Офис место работы',
    citizenship_id  INTEGER             NOT NULL    COMMENT 'Гражданство'
);
COMMENT ON TABLE Person IS 'Человек';

CREATE TABLE IF NOT EXISTS Doc_type (
    id              INTEGER                         COMMENT 'Уникальный идентификатор'  PRIMARY KEY  AUTO_INCREMENT,
    version         INTEGER DEFAULT 0   NOT NULL    COMMENT 'Служебное поле hibernate',
    code            INTEGER             NOT NULL    COMMENT 'Уникальный код документа',
    name            VARCHAR(250)        NOT NULL    COMMENT 'Наименование документа'
);
COMMENT ON TABLE Person IS 'Тип документа';

CREATE TABLE IF NOT EXISTS Document (
    id                  INTEGER                     COMMENT 'Уникальный идентификатор'  PRIMARY KEY  AUTO_INCREMENT,
    version             INTEGER DEFAULT 0  NOT NULL COMMENT 'Служебное поле hibernate',
    document_number     INTEGER            NOT NULL COMMENT 'Номер документа',
	document_date       DATE                        COMMENT 'Дата выдачи',
    person_id           INTEGER            NOT NULL COMMENT 'Уникальный идентификатор пользователя',
    doc_type_code_id    INTEGER            NOT NULL COMMENT 'Идентификатор типа документа'
);
COMMENT ON TABLE Person IS 'Документ';

CREATE TABLE IF NOT EXISTS Country (
    id                  INTEGER                     COMMENT 'Уникальный идентификатор'  PRIMARY KEY  AUTO_INCREMENT,
    version             INTEGER DEFAULT 0  NOT NULL COMMENT 'Служебное поле hibernate',
    code_country        INTEGER            NOT NULL COMMENT 'Уникальный код страны',
	name                VARCHAR(250)       NOT NULL COMMENT 'страна'
);
COMMENT ON TABLE Person IS 'Страна';


CREATE INDEX IX_Office_Organization_Id ON Office (organization_id);
ALTER TABLE Office ADD FOREIGN KEY (organization_id) REFERENCES Organization(id);

CREATE INDEX IX_Person_Office_Id ON Person(office_id);
ALTER TABLE Person ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Person_Citizenship_Id ON Person(citizenship_id);
ALTER TABLE Person ADD FOREIGN KEY (citizenship_id) REFERENCES Country(id);

CREATE UNIQUE INDEX UX_Document_Person_Id ON Document(person_id);
ALTER TABLE Document ADD FOREIGN KEY (person_id) REFERENCES Person(id);

CREATE INDEX IX_Document_Doc_Type_Code_Id ON Document(doc_type_code_id);
ALTER TABLE Document ADD FOREIGN KEY (doc_type_code_id) REFERENCES Doc_type(id);


CREATE INDEX IX_Organization_Name ON Organization(name);
CREATE UNIQUE INDEX UX_Organization_Ful_Name ON Organization(full_name);
CREATE UNIQUE INDEX UX_Organization_Inn ON Organization(inn);
CREATE UNIQUE INDEX UX_Organization_Kpp ON Organization(kpp);
CREATE INDEX IX_Organization_Address ON Organization(address);
CREATE INDEX IX_Organization_Phone ON Organization(phone);
CREATE INDEX IX_Organization_Is_Active ON Organization(is_active);

CREATE INDEX IX_Office_Name ON Office(name);
CREATE INDEX IX_Office_Address ON Office(address);
CREATE INDEX IX_Office_Phone ON Office(phone);
CREATE INDEX IX_Office_Is_Active ON Office(is_active);

CREATE INDEX IX_Person_First_Name ON Person(first_name);
CREATE INDEX IX_Person_Second_Name ON Person(second_name);
CREATE INDEX IX_Person_Middle_Name ON Person(middle_name);
CREATE INDEX IX_Person_Position ON Person(position);
CREATE INDEX IX_Person_Phone ON Person(phone);
CREATE INDEX IX_Person_Is_Identified ON Person(is_identified);

CREATE UNIQUE INDEX UX_Doc_Type_Code ON Doc_type(code);
CREATE INDEX IX_Doc_Type_Name ON Doc_type(name);

CREATE UNIQUE INDEX UX_Document_Document_Number ON Document(document_number);
CREATE INDEX IX_Document_Document_Date ON Document(document_date);

CREATE UNIQUE INDEX UX_Country_Code_Country ON Country(code_country);
CREATE INDEX IX_Country_Name ON Country(name);