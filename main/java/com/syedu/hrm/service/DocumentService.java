package com.syedu.hrm.service;

import com.syedu.hrm.bean.Document;

import java.util.List;

public interface DocumentService {
    void saveDocument(Document document);

    List<Document> findAllDocument();

    Document getDocumentById(int id);

    void deleteDocumentById(int id);

    List<Document> selectDocumentByTitle(String title);

    void updateDocumentById(Document document);
}
