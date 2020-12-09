package ru.bellintegrator.practice.controller.documenttype;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.service.documenttype.DocumentTypeService;
import ru.bellintegrator.practice.view.document.DocumentTypeView;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер обработки запросов к типу документов
 **/

@Api(value = "DocumentTypeController", description = "Управление информацией о типах документов")
@RestController
@RequestMapping(value = "/api/docs", produces = APPLICATION_JSON_VALUE)
public class DocumentTypeController {

    private final DocumentTypeService documentTypeService;

    @Autowired
    public DocumentTypeController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    /**
     * Запрос на получение типов документов
     */
    @ApiOperation(value = "Получить все типы документов", httpMethod = "GET")
    @GetMapping
    public List<DocumentTypeView> getDocs () {
        return documentTypeService.getDocs();
    }


    @GetMapping("/{id}")
    public DocumentTypeView getDocumentTypeById(@Valid @PathVariable Long id) {
        return documentTypeService.getDocumentTypeById(id);
    }
}
