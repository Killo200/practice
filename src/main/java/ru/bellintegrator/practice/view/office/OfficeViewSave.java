package ru.bellintegrator.practice.view.office;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeViewSave {

    /**
     * Идентификатор организации которой принадлежит офис
     */
    @NotNull
    @ApiModelProperty(value = "Идентификатор организации", example = "1")
    public Long organizationId;

    /**
     * Название офиса
     * */
    @Size(max = 50)
    @ApiModelProperty(value = "Название офиса", example = "Газпром МСК")
    public String name;

    /**
     * Адрес офиса
     */
    @Size(max = 250)
    @ApiModelProperty(value = "Адрес организации", example = "ул. Наметкина, 16")
    public String address;

    /**
     * Номер телефона
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
