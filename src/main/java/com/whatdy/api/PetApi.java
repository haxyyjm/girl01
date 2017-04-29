package com.whatdy.api;

import com.whatdy.model.Pet;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "pet", description = "the pet API")
public interface PetApi {
    @ApiOperation(value = "Add a new pet to the store", notes = "", response = Void.class, authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write:pets", description = "modify perts in  you accounts"),
                    @AuthorizationScope(scope = "read:pets", description = "read your pets")
            })

    }, tags = {"pet"})
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input", response = Void.class),
    })
    @PostMapping(value = "/pet",
            produces = {"application/xml", "application/json"},
            consumes = {"application/xml", "application/json"}
    )
    ResponseEntity<Void> addPet(@ApiParam(value = "Pet object that needs to be added to the store", required = true) @RequestBody Pet body);
}
