package ru.bellintegrator.practice.view.person;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * Вид входящих данных для обновления сведений о человеке
 * */
public class PersonViewUpdate {

    /**
     * Идентификатор
     */
    @NotNull
    @ApiModelProperty(value = "Идентификатор человека", example = "1")
    public Long id;

    /**
     * Идентификатор офиса в котором работает человек
     */
    @ApiModelProperty(value = "Идентификатор офиса", example = "1")
    public Long officeId;

    /**
     * Имя
     */
    @Size(max = 20)
    @NotEmpty
    @ApiModelProperty(value = "Имя", example = "Святогор")
    public String firstName;

    /**
     * Фамилия
     */
    @Size(max = 20)
    @ApiModelProperty(value = "Фамилия", example = "Брауншвейн")
    public String secondName;

    /**
     * Отчество
     */
    @Size(max = 20)
    @ApiModelProperty(value = "Отчество", example = "Семенович")
    public String middleName;

    /**
     * Должность
     */
    @Size(max = 50)
    @NotEmpty
    @ApiModelProperty(value = "Должность", example = "Контролер")
    public String position;

    /**
     * Номер телефона
     */
    @Size(max = 11)
    @ApiModelProperty(value = "Номер телефона", example = "84957193001")
    public String phone;

    /**
     * тип документа
     */
    @Size(max = 250)
    @ApiModelProperty(value = "Название документа", example = "Паспорт гражданина Российской Федерации")
    public String documentName;

    /**
     * номер документа
     */
    @Size(max = 11)
    @ApiModelProperty(value = "Номер документа", example = "213JP4569")
    public String documentNumber;

    /**
     * дата выдачи документа
     */
    @Size(max = 10)
    @ApiModelProperty(value = "Дата выдачи документа", example = "2020-12-06")
    public String documentDate;

    /**
     * Код страны
     */
    @ApiModelProperty(value = "Код гражданства", example = "112")
    public Integer citizenshipCode;

    /**
     * Человек идентифицирован
     */
    @ApiModelProperty(value = "Человек идентифицирован", example = "true")
    public Boolean isIdentified;
}
