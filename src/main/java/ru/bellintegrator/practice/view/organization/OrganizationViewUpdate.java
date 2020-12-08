package ru.bellintegrator.practice.view.organization;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Вид входящих данных для обновления сведений об организации
 * */
public class OrganizationViewUpdate {

    /**
     * Идентификатор
     */

    @ApiModelProperty(value = "Уникальный идентификатор", example = "1")
    public Long id;

    /**
     * Название организации
     */
    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название организации", example = "Газпром")
    public String name;

    /**
     * Полное название организации
     */
    @Size(max = 250)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название организации", example = "Газпром")
    public String fullName;

    /**
     * ИНН
     */
    @Size(max = 15)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "ИНН", example = "7736050003")
    public String inn;

    /**
     * КПП
     */
    @Size(max = 15)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "КПП", example = "997250001")
    public String kpp;

    /**
     * Адрес организации
     */
    @Size(max = 250)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Адрес организации", example = "ул. Наметкина, 16")
    public String address;

    /**
     * Номер телефона
     */
    @Size(max = 11)
    @ApiModelProperty(value = "Номер телефона", example = "84957193001")
    public String phone;

    /**
     * Активность организации
     */
    @ApiModelProperty(value = "Активность организации", example = "true")
    public boolean isActive;
}
