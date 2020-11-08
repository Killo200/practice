package ru.bellintegrator.practice.model;

import javax.persistence.*;

/**
 * Страны
 * */
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
