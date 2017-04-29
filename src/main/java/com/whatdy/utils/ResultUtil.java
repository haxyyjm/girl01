package com.whatdy.utils;


import com.whatdy.enums.ResultEnum;
import com.whatdy.model.Result;
//结果操作工具类
public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        ResultEnum resultEnum = ResultEnum.SUCCESS;
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(object);
        return  result;
    }
    public static Result success(){
        return  success(null);
    }
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return  result;
    }
}
