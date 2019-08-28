package com.syedu.hrm.service.impl;

import com.syedu.hrm.bean.Document;
import com.syedu.hrm.dao.DocumentMapper;
import com.syedu.hrm.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentImpl implements DocumentService {
   @Autowired
    private DocumentMapper documentMapper;

    @Override
    public void saveDocument(Document document) {
        documentMapper.save(document);
    }

    @Override
    public List<Document> findAllDocument() {
        List<Document> documents= documentMapper.findAll(null);
        return documents;
    }

    @Override
    public Document getDocumentById(int id) {
        Document document=documentMapper.getDocumentById(id);
        return document;
}

    @Override
    public void deleteDocumentById(int id) {
        documentMapper.deleteDocumentById(id);

    }

    @Override
    public List<Document> selectDocumentByTitle(String title) {

        return documentMapper.selectDocumentByTitle(title);
    }

    @Override
    public void updateDocumentById(Document document) {
        documentMapper.updateDocumentById(document);
    }
}
