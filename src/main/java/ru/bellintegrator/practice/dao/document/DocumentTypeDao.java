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

    /**
     * Получение типа документа по ID
     */
    DocumentType getDocumentTypeById(Long id);

    /**
     * Получение типа документа по коду
     */
    DocumentType getDocumentTypeByCode(Integer code);

    /**
     * Получение типа документа по имени
     */
    DocumentType getDocumentTypeByName(String name);
}
