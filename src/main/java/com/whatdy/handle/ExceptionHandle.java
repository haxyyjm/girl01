package com.whatdy.handle;

import com.whatdy.aspact.HttpAspact;
import com.whatdy.enums.ResultEnum;
import com.whatdy.exception.GirlException;
import com.whatdy.model.Result;
import com.whatdy.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//异常捕获类
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspact.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            logger.error("[系统异常]{}",e);
            ResultEnum error = ResultEnum.UNKNOWN_ERROR;
            return  ResultUtil.error(error.getCode(),error.getMsg());
        }
    }
}
