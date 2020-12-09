package ru.bellintegrator.practice.view.person;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Вид входящих данных для сохранения сведений о человеке
 * */
public class PersonViewSave {

    /**
     * Идентификатор офиса в котором работает человек
     */
    @NotNull
    @ApiModelProperty(value = "Идентификатор офиса", example = "2")
    public Long officeId;

    /**
     * Имя
     */
    @Size(max = 20)
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String firstName;

    /**
     * Фамилия
     */
    @Size(max = 20)
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    /**
     * Отчество
     */
    @Size(max = 20)
    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    /**
     * Должность
     */
    @Size(max = 50)
    @NotEmpty
    @ApiModelProperty(value = "Должность", example = "Слесарь")
    public String position;

    /**
     * Номер телефона
     */
    @Size(max = 11)
    @ApiModelProperty(value = "Номер телефона", example = "84957193001")
    public String phone;

    /**
     * Код документа
     */
    @ApiModelProperty(value = "Код документа", example = "21")
    public Integer docCode;

    /**
     * тип документа
     */
    @Size(max = 250)
    @ApiModelProperty(value = "Название документа", example = "Паспорт гражданина Российской Федерации")
    public String docName;

    /**
     * номер документа
     */
    @Size(max = 11)
    @ApiModelProperty(value = "Номер документа", example = "123JP4567")
    public String documentNumber;

    /**
     * дата выдачи документа
     */
    @Size(max = 10)
    @ApiModelProperty(value = "Дата выдачи документа", example = "2005-10-24")
    public String docDate;

    /**
     * Код страны
     */
    @ApiModelProperty(value = "Код гражданства", example = "643")
    public Integer citizenshipCode;

    /**
     * Человек идентифицирован
     */
    @ApiModelProperty(value = "Человек идентифицирован", example = "true")
    public Boolean isIdentified;
}
