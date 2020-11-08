package ru.bellintegrator.practice.model;


import javax.persistence.*;

/**
 * Оффис
 * */
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
