package com.whatdy.api;

import com.whatdy.model.Girl;
import com.whatdy.model.Result;
import com.whatdy.repository.GirlRespository;
import com.whatdy.service.GirlService;
import com.whatdy.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Api GirlController
 * REST 风格
 * @author zyl
 * todo http://localhost:8080/swagger-ui.html#/
 */
@Api(value = "girl",description ="Girl Api")
@RestController
@RequestMapping("/girls")
@EnableSwagger2
public class GirlApiController {

    @Autowired
    protected GirlRespository girlRespository;

    @Autowired
    protected GirlService girlService;

    //get all
    @ApiOperation(value = "获取全部(方式一)")
    @GetMapping(value = "/")
    public Iterable findAll(){
        return  girlRespository.findAll();
    }
    @ApiOperation(value = "获取全部(方式二)")
    @GetMapping(value = "/getGirlList")
    public Result getGirlList(){
        List<Girl> data = girlService.getGirlList();
        return ResultUtil.success(data);
    }
    /**
     * 获取 Girl 详细信息
     * @param objectId Girl 的 ObjectId
     * @return Girl 实体
     */
    @ApiOperation(value = "获取 Girl 详细信息", notes="根据url的 ObjectId 来获取 Girl 详细信息")
    @GetMapping(value = "/{objectId}")
    public Result findOne(@PathVariable ObjectId objectId ){
        Girl data = girlService.findOne(objectId);
        return ResultUtil.success(data);
    }

    /**
     * 删除一个 Girl的信息
     * @param objectId  Girl 的 ObjectId
     */
    @ApiOperation(value = "删除 Girl 的信息",notes="根据 Girl 的ObjectId删除这个Girl的信息")
    @DeleteMapping(value = "/{objectId}")
    public Result destroy(@PathVariable("objectId")ObjectId objectId){
        girlService.delete(objectId);
        return ResultUtil.success();
    }
    /**
     * 修改 Girl 的基本信息
     * 需要把form表单的enctype属性设置为 application/x- www-form-urlencoded
     * @todo 127.0.0.1:8080/girls/5885d0569f62d8f917a93847
     * @param objectId Girl 的 ObjectId
     * @param girl Girl 实体
     * @param bindingResult Girl 实体
     * @return
     */
    @ApiOperation(value = "更新 Girl 的详细信息", notes="根据url的 ObjectId 来指定更新对象，并根据传过来的 Girl 信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "girl", value = "Girl 详细实体", required = true, dataType = "Girl")
    })
    @PutMapping(value = "/{objectId}")
    public Result update(@PathVariable ObjectId objectId,@RequestBody @Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            return ResultUtil.error(1,fieldError.getDefaultMessage());
        }
        Girl u = girlService.findOne(objectId);
        u.setAge(girl.getAge());
        u.setCupSize(girl.getCupSize());
        Girl data = girlRespository.save(u);
        return ResultUtil.success(data);
    }

    /**
     * 添加一个 Girl
     * @param girl Girl 实体
     * @param bindingResult 异常存储
     * @return
     */
    @ApiOperation(value = "创建用户" , notes="根据 Girl 对象创建用户")
    @ApiImplicitParam(name = "girl", value = "用户详细实体 Girl", required = true, dataType = "Girl")
    @PostMapping(value = "/")
    @ResponseBody
    public Result store(@RequestBody @Valid Girl girl, BindingResult bindingResult){//这两个参数会自动生成
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            return ResultUtil.error(1,fieldError.getDefaultMessage());
        }
        girl.setId(new ObjectId());//自动生成 mongodb 的_id
        Girl data = girlRespository.save(girl);
        return ResultUtil.success(data);
    }

    /**
     * 获取Girl的年龄
     * @param objectId  Girl 的 objectId
     * @return Integer Girl的年龄
     * @throws Exception
     */
    @ApiOperation(value = "获取Girl的年龄",notes = "根据Girl的ObjectId获取Girl的Age")
    @GetMapping(value = "getAge/{objectId}")
    public Result getAge(@PathVariable("objectId") ObjectId objectId) throws Exception {
        Integer age = girlService.getAge(objectId);
        return  ResultUtil.success(age);
    }
}
