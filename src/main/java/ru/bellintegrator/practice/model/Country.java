package ru.bellintegrator.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(Integer codeCountry) {
        this.codeCountry = codeCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
