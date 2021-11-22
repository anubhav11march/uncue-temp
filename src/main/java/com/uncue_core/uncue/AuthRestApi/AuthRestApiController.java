package com.uncue_core.uncue.AuthRestApi;

import com.uncue_core.uncue.AuthRestApi.AuthRestAPIService;
import com.uncue_core.uncue.constants.DisplayMessage;
import com.uncue_core.uncue.dto.LoginForm;
import com.uncue_core.uncue.dto.ReturningMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("${signinBaseUrl}")
public class AuthRestApiController {
    @Autowired
    AuthRestAPIService authRestAPIService;
    @PostMapping("${signinUrl}")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest, @PathVariable String type)
             {
        System.out.println("Inside Controller");

        System.out.println(loginRequest.getUpdateversion());

        /**
         * @author Ganesh wagadure
         * @description checking application version comming from client side is
         *              application version is latest version or not .if not force to
         *              install new version
         */

        String updateVersionVariable = loginRequest.getUpdateversion();

        System.out.println(type.equals("Mobile"));

        if (type.equals("Mobile")) {

            if(updateVersionVariable==null){
                return ResponseEntity.ok(new ReturningMessage(DisplayMessage.UPDATEVERSIONCHECKING, "", true));
            }

            else{

                System.out.println(updateVersionVariable.equals("force"));

                if (updateVersionVariable.equals("force")) {

                }
                else{
                    return ResponseEntity.ok(new ReturningMessage(DisplayMessage.UPDATEVERSIONCHECKING, "", true));
                }
            }
        }
        return authRestAPIService.authenticateUser(loginRequest, type);
    }
}
