package ru.bellintegrator.practice.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Список организаций по фильтру")
public class OrganizationFilterViewIn {

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название организации", example = "Газпром")
    public String name;

    @Size(max = 15)
    @ApiModelProperty(value = "ИНН", example = "7736050003")
    public String inn;

    @ApiModelProperty(value = "Активность организации", example = "true")
    public boolean isActive;

    @Override
    public String toString() {
        return "OrganizationFilterView{" +
                ", name='" + name + '\'' +
                ", inn='" + inn + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
