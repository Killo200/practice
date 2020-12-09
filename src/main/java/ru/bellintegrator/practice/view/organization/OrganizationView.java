package ru.bellintegrator.practice.view.organization;

/**
 * Вид отображения данных при запросе по ID
 * */
public class OrganizationView {

    /**
     * Идентификатор
     */
    public Long id;

    /**
     * Название организации
     */
    public String name;

    /**
     * Полное название организации
     */
    public String fullName;

    /**
     * ИНН
     */
    public String inn;

    /**
     * КПП
     */
    public String kpp;

    /**
     * Адрес организации
     */
    public String address;

    /**
     * Номер телефона
     */
    public String phone;

    /**
     * Активность организации
     */
    public boolean isActive;
}
