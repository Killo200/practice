package ru.bellintegrator.practice.model;

import javax.persistence.*;
/**
 * Тип документа
 */
@Entity
public class DocumentType {

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
     * Уникальный код документа
     */
    @Column(name = "code", nullable = false)
    private Integer code;

    /**
     * Наименование документа
     */
    @Column(name = "name", nullable = false, length = 250)
    private String name;
}
