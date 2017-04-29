package com.whatdy.service;

import com.whatdy.enums.ResultEnum;
import com.whatdy.exception.GirlException;
import com.whatdy.model.Girl;
import com.whatdy.repository.GirlRespository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//业务逻辑
@Service
public class GirlService {
    @Autowired
    private GirlRespository girlRespository;

    @Transactional//事务
    public void insertTwo(){
        Girl girlA = new Girl(new ObjectId(),"A",18);
        girlRespository.save(girlA);

        Girl girlB = new Girl(new ObjectId(),"C",19);
        girlRespository.save(girlB);
    }
    //获取用户 Age
    public Integer getAge(ObjectId objectId) throws Exception {
        Girl girl = girlRespository.findOne(objectId);
        Integer age = girl.getAge();
        if (age<10) {
            //你还在上小学
            throw  new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age>10 && age<16) {
            //你可能在读初中
            throw  new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        //如果>16岁,价钱
        //....
        return age;
    }
    //获取一个 Girl
    public Girl findOne(ObjectId objectId) {
        Girl girl = girlRespository.findOne(objectId);
        return  girl;
    }
    //获取 Girl 集合
    public List<Girl> getGirlList(){
        return  new ArrayList<Girl>(girlRespository.findAll());
    }
    //删除一个 Girl
    public void delete(ObjectId objectId){
        girlRespository.delete(objectId);
    }
}
