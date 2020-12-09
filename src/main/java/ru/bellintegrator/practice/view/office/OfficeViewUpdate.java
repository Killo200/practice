package ru.bellintegrator.practice.view.office;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeViewUpdate {

    /**
     * Идентификатор
     */
    @NotNull
    @ApiModelProperty(value = "Идентификатор офиса", example = "1")
    public Long id;

    /**
     * Название офиса
     * */
    @Size(max = 50)
    @NotEmpty
    @ApiModelProperty(value = "Название офиса", example = "Газпром МСК")
    public String name;

    /**
     * Адрес офиса
     */
    @Size(max = 250)
    @NotEmpty
    @ApiModelProperty(value = "Адрес организации", example = "ул. Наметкина, 16")
    public String address;

    /**
     * Телефон офиса
     */
    @Size(max = 11)
    @ApiModelProperty(value = "Номер телефона", example = "84957193001")
    public String phone;

    /**
     * Активность офиса
     */
    @ApiModelProperty(value = "Активность офиса", example = "true")
    public boolean isActive;
}
