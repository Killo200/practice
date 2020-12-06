package ru.bellintegrator.practice.dao.persondoc;

import ru.bellintegrator.practice.model.Document;

/**
 * DAO для работы с документами человека
 */
public interface PersonDocDao {

    /**
     * Получение документа по ID человека
     */
    Document getDocumentById(Long id);
}
