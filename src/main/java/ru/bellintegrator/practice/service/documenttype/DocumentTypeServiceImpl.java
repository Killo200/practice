package ru.bellintegrator.practice.service.documenttype;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.document.DocumentTypeDao;
import ru.bellintegrator.practice.model.DocumentType;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.utils.BadDataException;
import ru.bellintegrator.practice.view.document.DocumentTypeView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeDao documentTypeDao;
    private final MapperFacade mapperFacade;

    public DocumentTypeServiceImpl(DocumentTypeDao documentTypeDao, MapperFacade mapperFacade) {
        this.documentTypeDao = documentTypeDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<DocumentTypeView> getDocs() {
        List<DocumentType> documentTypes = documentTypeDao.getDocs();
        return mapperFacade.mapAsList(documentTypes, DocumentTypeView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public DocumentTypeView getDocumentTypeById(Long id) {
        DocumentType documentType = documentTypeDao.getDocumentTypeById(id);
        if(documentType == null) {
            throw new BadDataException();
        }
        return mapperFacade.map(documentType, DocumentTypeView.class);
    }
}
