package ru.bellintegrator.practice.view.office;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Вид отображения данных при запросе по ID
 * */
public class OfficeView {

    /**
     * Идентификатор
     */
    public Long id;

    /**
     * Название офиса
     */
    public String name;

    /**
     * Адрес офиса
     */
    public String address;

    /**
     * Телефон офиса
     */
    public String phone;

    @Override
    public String toString() {
        return "OfficeView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
