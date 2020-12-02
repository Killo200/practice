package ru.bellintegrator.practice.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Вид отображения данных по фильтру
 * */
public class OrganizationFilterViewOut {

    /**
     * Идентификатор
     */
    public String id;

    /**
     * Название организации
     */
    public String name;

    /**
     * Активность организации
     */
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
