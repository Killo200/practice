package ru.bellintegrator.practice.view.office;

/**
 * Вид отображения данных при запросе по ID
 * */
public class OfficeView {

    /**
     * Идентификатор
     */
    public Long id;

    /**
     * Название офиса
     */
    public String name;

    /**
     * Адрес офиса
     */
    public String address;

    /**
     * Телефон офиса
     */
    public String phone;

    @Override
    public String toString() {
        return "OfficeView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
