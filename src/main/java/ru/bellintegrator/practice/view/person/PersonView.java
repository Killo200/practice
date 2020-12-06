package ru.bellintegrator.practice.view.person;

/**
 * Вид отображения данных при запросе по ID
 * */
public class PersonView {

    /**
     * Идентификатор
     */
    public Long id;

    /**
     * Имя
     */
    public String firstName;

    /**
     * Фамилия
     */
    public String secondName;

    /**
     * Отчество
     */
    public String middleName;

    /**
     * Должность
     */
    public String position;

    /**
     * Телефон
     */
    public String phone;

    /**
     * тип документа
     */
    public String docName;

    /**
     * номер документа
     */
    public String documentNumber;

    /**
     * дата выдачи документа
     */
    public String docDate;

    /**
     * Название страны
     */
    public String citizenshipName;

    /**
     * Код страны
     */
    public Integer citizenshipCode;

    /**
     * Человек идентифицирован
     */
    public Boolean isIdentified;
}
