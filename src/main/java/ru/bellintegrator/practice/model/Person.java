package ru.bellintegrator.practice.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * Человек
 * */
@Entity(name = "Person")
public class Person {

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
     * Имя
     */
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "second_name", length = 20)
    private String secondName;

    /**
     * Отчество
     */
    @Column(name = "middle_name", length = 20)
    private String middleName;

    /**
     * Должность
     * */
    @Column(name = "position", nullable = false, length = 50)
    private String position;

    /**
     * Номер телефона
     */
    @Column(name = "phone", length = 11)
    private String phone;

    /**
     * Человек идентифицирован
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    /**
     * Документ человека
     */
    @OneToOne(
            mappedBy = "person",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = false
    )
    private Document document;

    /**
     * Офис место работы
     * */
    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "office_id")
    private Office office;

    /**
     * Гражданство
     * */
    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "citizenship_id")
    private Country country;
}
