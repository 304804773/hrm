package com.syedu.hrm.dao;

import com.syedu.hrm.base.BaseMapper;
import com.syedu.hrm.bean.Document;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * DocumentMapper 数据访问类
 * @author zht
 * @email 304804773@qq.com
 * @date 2019-07-29 16:45:51
 * @version 1.0
 */
@Mapper
public interface DocumentMapper extends BaseMapper {


    Document getDocumentById(int id);

    void deleteDocumentById(int id);

    List<Document> selectDocumentByTitle(String title);

    void updateDocumentById(Document document);
}