package ru.bellintegrator.practice.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Вид отображения данных при запросе по ID
 * */
@ApiModel(description = "Организация")
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
