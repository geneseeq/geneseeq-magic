package com.geneseeq.service.mongodb.impl;

import com.geneseeq.model.BaseOrder;
import com.geneseeq.service.mongodb.BaseOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class BaseOrderDaoImpl implements BaseOrderDao{
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param baseOrder
     */
    @Override
    public void saveBaseOrder(BaseOrder baseOrder) {
        mongoTemplate.save(baseOrder);
    }
}
