package com.whatdy.model;


import io.swagger.annotations.ApiModelProperty;
import org.bson.types.ObjectId;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;

public class Girl {

    @ApiModelProperty(hidden = true)
    private ObjectId id;

    private String cupSize;
    @Min(value = 18,message = "未成年少女禁止入内")
    private Integer age;

    public Girl() {
    }

    public Girl(ObjectId _id, String cupSize, Integer age) {
        this.id = _id;
        this.cupSize = cupSize;
        this.age = age;
    }

    public String getId() {
        return id.toString();
    }
    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
