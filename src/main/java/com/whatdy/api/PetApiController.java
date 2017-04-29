package com.whatdy.api;

import com.whatdy.model.Pet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class PetApiController implements PetApi{

    @Override
    public ResponseEntity<Void> addPet(@ApiParam(value = "Pet object that needs to be added to the store", required = true) @RequestBody Pet body) {

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
