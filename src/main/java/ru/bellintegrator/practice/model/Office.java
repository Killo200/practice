package ru.bellintegrator.practice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

/**
 * Оффис
 * */
@Getter
@Setter
@Entity(name = "Office")
public class Office {

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
     * Название офиса
     */
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    /**
     * Адрес офиса
     */
    @Column(name = "address", nullable = false, length = 250)
    private String address;

    /**
     * Номер телефона
     */
    @Column(name = "phone", length = 11)
    private String phone;

    /**
     * Активность офиса
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * Организация владелец
     */
    @ManyToOne(
        cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        },
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
