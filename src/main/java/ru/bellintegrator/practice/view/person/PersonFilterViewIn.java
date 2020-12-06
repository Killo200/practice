package ru.bellintegrator.practice.view.person;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Вид входящих данных по человеку
 * */
public class PersonFilterViewIn {

    /**
     * Идентификатор офиса в котором работает человек
     */
    @NotNull
    @ApiModelProperty(value = "Идентификатор офиса", example = "1")
    public Long officeId;

    /**
     * Имя
     */
    @Size(max = 20)
    @ApiModelProperty(value = "Имя", example = "Алексей")
    public String firstName;

    /**
     * Фамилия
     */
    @Size(max = 20)
    @ApiModelProperty(value = "Фамилия", example = "Миллер")
    public String secondName;

    /**
     * Отчество
     */
    @Size(max = 20)
    @ApiModelProperty(value = "Отчесто", example = "Борисович")
    public String middleName;

    /**
     * Должность
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Должность", example = "Председатель Правления ОАО «Газпром»")
    public String position;

    /**
     * Код документа
     */
    @ApiModelProperty(value = "Код документа", example = "21")
    public Integer docCode;

    /**
     * Код страны
     */
    @ApiModelProperty(value = "Код страны", example = "643")
    public Integer citizenshipCode;
}
