package ru.bellintegrator.practice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;


/**
 * Организация
 * */
@Getter
@Setter
@Entity(name = "Organization")
public class Organization {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Название организации
     */
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    /**
     * Полное название организации
     */
    @Column(name = "full_name", nullable = false, length = 250)
    private String fullName;

    /**
     * ИНН
     */
    @Column(name = "inn", nullable = false, length = 15)
    private String inn; //возможно надо написать как ФИНАЛ

    /**
     * КПП
     */
    @Column(name = "kpp", nullable = false, length = 15)
    private String kpp; //возможно надо написать как ФИНАЛ

    /**
     * Адрес организации
     */
    @Column(name = "address", nullable = false, length = 250)
    private String address;

    /**
     * Номер телефона
     */
    @Column(name = "phone", length = 11)
    private String phone;

    /**
     * Активность организации
     */
    @Column(name = "is_active")
    private Boolean isActive;
}
