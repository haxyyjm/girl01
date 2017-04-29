package com.whatdy.service;

import com.whatdy.model.Girl;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 业务逻辑测试
 */
@RunWith(SpringRunner.class)//底层使用Junit
@SpringBootTest //启动整个Spring工程
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;
    @Test
    public void findOne() throws Exception {
        Girl girl = girlService.findOne(new ObjectId("58f2e3bc95b650673ccad966"));
        Assert.assertEquals(new Integer(21),girl.getAge());
        //Assert.assertEquals(new Integer(22),girl.getAge()); //断言失败
    }
}