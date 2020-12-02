package ru.bellintegrator.practice.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Вид отображения данных по фильтру
 * */
public class OfficeFilterViewOut {

    /**
     * Идентификатор
     */
    public String id;

    /**
     * Название офиса
     */
    public String name;

    /**
     * Активность офиса
     */
    public boolean isActive;
}
