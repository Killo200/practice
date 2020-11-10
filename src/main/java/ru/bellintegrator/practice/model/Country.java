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
 * Страны
 * */
@Getter
@Setter
@Entity
public class Country {

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
     * Код страны
     */
    @Column(name = "code_country", nullable = false)
    private Integer codeCountry;

    /**
     * Название страны
     */
    @Column(name = "name", nullable = false, length = 250)
    private String name;
}
