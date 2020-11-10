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
 * Тип документа
 */
@Getter
@Setter
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
