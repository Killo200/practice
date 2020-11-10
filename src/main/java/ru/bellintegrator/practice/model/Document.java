package ru.bellintegrator.practice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * Документ
 * */
@Getter
@Setter
@Entity
public class Document {

    /**
     * Идентификатор
     */
    @Id
    @Column(name = "person_id")
    private Long person_id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Номер документа
     * */
    @Column(name = "document_number", nullable = false, length = 11)
    private String documentNumber;

    /**
     * Дата выдачи
     * */
    @Column(name = "document_date", length = 10)
    private String documentDate;

    /**
     * Идентификатор типа документа
     * */
    @ManyToOne(
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "doc_type_code_id")
    private DocumentType documentType;

    /**
     * Документ привязан к человеку
     */
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Person person;
}
