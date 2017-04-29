package com.whatdy.repository;

import com.whatdy.model.Girl;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * 数据访问层,相当于 DAO层
 */
@Repository
public interface GirlRespository extends MongoRepository<Girl, ObjectId> {

    /**
     * 命名规则,为:使用数据库里面的字段例如 id 则使用  findById
     * @param username
     * @return
     */
//    Girl findByUsername(String username);
}
