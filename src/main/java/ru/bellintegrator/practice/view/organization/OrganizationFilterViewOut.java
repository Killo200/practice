package ru.bellintegrator.practice.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Вид отображения данных по фильтру
 * */
@ApiModel(description = "Список организаций по фильтру")
public class OrganizationFilterViewOut {

    /**
     * Идентификатор
     */
    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    /**
     * Название организации
     */
    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название организации", example = "Газпром")
    public String name;

    /**
     * Активность организации
     */
    @ApiModelProperty(value = "Активность организации", example = "true")
    public boolean isActive;

    @Override
    public String toString() {
        return "OrganizationFilterView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
