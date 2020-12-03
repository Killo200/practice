package ru.bellintegrator.practice.service.documenttype;

import ru.bellintegrator.practice.view.document.DocumentTypeView;

import java.util.List;

/**
 * Сервис типа документов
 */
public interface DocumentTypeService {

    /**
     * Получение списка кодов стран (гражданства)
     */
    List<DocumentTypeView> getDocs ();
}
