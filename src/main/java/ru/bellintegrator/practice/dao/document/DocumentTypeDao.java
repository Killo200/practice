package ru.bellintegrator.practice.dao.document;

import ru.bellintegrator.practice.model.DocumentType;

import java.util.List;

/**
 * DAO для работы с типами документов
 */
public interface DocumentTypeDao {

    /**
     * Получение списка типов документов
     */
    List<DocumentType> getDocs();
}
