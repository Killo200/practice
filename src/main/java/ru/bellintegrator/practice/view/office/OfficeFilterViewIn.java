package ru.bellintegrator.practice.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Вид входящих данных по фильтру
 * */
@ApiModel(description = "Список офисов по фильтру")
public class OfficeFilterViewIn {

    /**
     * Идентификатор организации которой принадлежит офис
     */
    @NotEmpty
    @ApiModelProperty(value = "Идентификатор организации", example = "1")
    public Long organizationId;

    /**
     * Название офиса
     * */
    @Size(max = 50)
    @ApiModelProperty(value = "Название офиса", example = "Газпром МСК")
    public String name;

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

    @Override
    public String toString() {
        return "OfficeFilterViewIn{" +
                "organizationId=" + organizationId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
