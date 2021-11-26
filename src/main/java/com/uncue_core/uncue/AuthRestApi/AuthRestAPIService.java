package com.uncue_core.uncue.AuthRestApi;

import com.uncue_core.uncue.ApplicationLevel;
import com.uncue_core.uncue.Security.jwt.CustomUserDetails;
import com.uncue_core.uncue.Security.jwt.JwtProvider;
import com.uncue_core.uncue.Security.jwt.JwtResponse;
import com.uncue_core.uncue.Security.service.UserInfo;
import com.uncue_core.uncue.constants.DisplayMessage;
import com.uncue_core.uncue.dto.LoginForm;
import com.uncue_core.uncue.dto.ReturningMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




@Service
public class AuthRestAPIService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserInfo userInfo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    ApplicationLevel applicationLevel;

    public ResponseEntity<?> authenticateUser(LoginForm loginRequest, String type) {

        /**
         * updated By Abhishek Date=18-03-2020 here restricting users who have mobile
         * application version older than 1.1.0
         */
        // System.out.println(loginRequest.getVersion());
        // if((type.equals("Mobile") && loginRequest.getVersion()==null)
        // ||type.equals("Mobile") && loginRequest.getVersion().startsWith("1.0")) {
        // return ResponseEntity.ok(new ReturningMessage("Please upgrade new app from
        // Google Play Store, this version is not supported.", "", true));
        // }
        // if(type.equals("Mobile") && loginRequest.getVersion().startsWith("1.0")) {
        // return ResponseEntity.ok(new ReturningMessage("Please upgrade new app from
        // Google Play Store, this version is not supported.", "", true));
        // }

        // authenticate the user with database using username and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

        if (authentication == null) {
            System.out.println("Fail");
            return ResponseEntity.ok(new ReturningMessage(DisplayMessage.LoginAuthFail, "", true));
        }

        // get authenticated data from Authentication
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        /**
         * Here we are using this if conditin for mobile compatibilty previous version
         * of mobile should not affect by this line of code if townshipId=0 means
         * request is coming from previousmobile versions
         */
        // if (loginRequest.getTownshipId() != 0) {
        // // here setting the townshipid to userdetails which came from client
        // userDetails.getResidentDetails().setTownshipId(loginRequest.getTownshipId());
        // /**
        // * here we are calling a query and getting the usertype i.e resident is admin
        // or
        // * user and based on that we are setting that to the userdetails
        // */
        // userDetails.getResidentDetails().setUserType(townshipAccessPermissionRepository
        // .checkUserOrAdmin(userDetails.getResidentDetails().getResidentId(),
        // loginRequest.getTownshipId()));
        // }
        // /**
        // * UpdatedBy Abhishek Date=7-01-2020 Description=Added one variable to
        // * addressDetailsDto, Sending DistressPermission
        // */
        // AddressDetailDto addressDetailsDto = residentDetailRepository.getAddress(
        // userDetails.getResidentDetails().getResidentId(),
        // userDetails.getResidentDetails().getUserName(),
        // userDetails.getResidentDetails().getTownshipId());

        /**
         * here we are checking whether request is coming from web or mobile and
         * restricting the access based on type
         */
        // if (type.equals("Web")) {
        // /**
        // * here we are checking the resident is having permission for web in
        // * townshipAccessPermission Table If he doesnt have any permsission error msg
        // * will dispaly
        // */
        // if
        // (townshipAccessPermissionRepository.checkPermisssion(userDetails.getResidentDetails().getResidentId(),
        // loginRequest.getTownshipId()) == 0) {
        // return ResponseEntity.ok(new
        // ReturningMessage(DisplayMessage.RESTRICTACCESSWEB, "", true));
        // }
        //
        // }
        /**
         * Updated By abhishek Date:-22-02-2020
         *
         * This c0ondition is used to check from which version request is coming if
         * request is coming from 1.0.8 or below version then this condition will
         * execute means it will not check in townshipAccessPermission table
         *
         * here we are desciding that from which version request is coming i.e based on
         * townshipId 1.0.8 or below version have townshipId 0
         */
        // else if (type.equals("Mobile") &&
        // userDetails.getResidentDetails().getMobileAppAccess() == 1
        // && loginRequest.getTownshipId() == 0) {
        //
        // }
        /**
         * Updated By abhishek Date:-22-02-2020
         *
         * This condition is used to check from which version request is coming if
         * request is coming from 1.0.9 or above version then this condition will
         * execute means it will not check in townshipAccessPermission table
         *
         * here we are desciding that from which version request is coming i.e based on
         * townshipId 1.0.9 or above version have townshipId greater that 0
         */
        // else if (type.equals("Mobile") && loginRequest.getTownshipId() != 0) {
        // /**
        // * Updated By abhishek
        // * Date:-22-02-2020
        // *
        // * Here we are checking is that resident have permission for that township if
        // * dosnt have permission it will return error msg
        // */
        // if (townshipAccessPermissionRepository.checkPermisssionMobile(
        // userDetails.getResidentDetails().getResidentId(),
        // loginRequest.getTownshipId()) == 0) {
        // return ResponseEntity.ok(new
        // ReturningMessage(DisplayMessage.RESTRICTACCESSMOBILE, "", true));
        // }
        // } else {
        // return ResponseEntity.ok(new ReturningMessage(DisplayMessage.LoginAuthFail,
        // "", true));
        // }
//        System.out.println(userDetails.getUsers().getAuthorized());
//        if(userDetails.getUsers().getAuthorized().equals(ConstantStrings.FALSE)) {
//            return ResponseEntity.ok(new ReturningMessage(DisplayMessage.NOTAUTHORIZED, "", true));
//        }
        // check user is already loggedIn or not
//*		if (applicationLevel.LoggedInUsersList.get(userDetails.getUsername()) == null) {

        // put authentication object into Securitycontext for accessing user details for
        // further requests
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // generate jwt token by passing authentication object
        String jwt = jwtProvider.generateJwtToken(authentication);

        // if user is authenticated then put this user into Logged In user list of
        // ApplicationLevel class
        System.out.println("userDetails.getUsername()"+userDetails.getUsername());
        applicationLevel.LoggedInUsersList.put(jwt,jwt);

        /**
         * updated By Abhishek Date:-21-02-2020
         *
         * Here we are using this if conditin for mobile compatibilty previous version
         * of mobile should not affect by this line of code if townshipId=0 means
         * request is coming from previous mobile versions in that from client side
         * townshipId 0 will come that means no need to add it into the map
         */
        // if (loginRequest.getTownshipId() != 0) {
        // // if user is authenticated then put this users residentId and townshipid
        // into
        // // Logged In user Id list of
        // // ApplicationLevel class
        // applicationLevel.LoggedinUsersId.put(userDetails.getResidentDetails().getResidentId(),
        // userDetails.getResidentDetails().getTownshipId());
        // }
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsers(),
                userDetails.getUsername() + "  " + DisplayMessage.LoginSuccess, userDetails.getAuthorities()));

//*		} else {
//*			if (jwtProvider.validateJwtToken(applicationLevel.LoggedInUsersList.get(userDetails.getUsername()))) {
//*				return ResponseEntity.ok(new ReturningMessage(DisplayMessage.UserAlreadyLoggedIn, "100", true));
//*			} else {

        // remove Expired token from already logged in user list
//*				applicationLevel.LoggedInUsersList.remove(userDetails.getUsername());
        // remove Expired resident from already logged in user list
//*				applicationLevel.LoggedinUsersId.remove(userDetails.getUsers().getUserid());
        // put authentication object into Securitycontext for accessing user details for
        // further requests
//*				SecurityContextHolder.getContext().setAuthentication(authentication);

        // generate jwt token by passing authentication object
//*				String jwt = jwtProvider.generateJwtToken(authentication);

        // if user is authenticated then put this user into Logged In user list of
        // ApplicationLevel class
//*				applicationLevel.LoggedInUsersList.put(userDetails.getUsername(), jwt);

        /**
         * Updated By abhishek Date:-22-02-2020
         *
         * Here we are using this if conditin for mobile compatibilty previous version
         * of mobile should not affect by this line of code if townshipId=0 means
         * request is coming from previous mobile versions in that from client side
         * townshipId 0 will come that means no need to add it into the map
         */
        // if (loginRequest.getTownshipId() != 0) {
        // // if user is authenticated then put this users residentId and townshipid
        // into
        // // Logged In user Id list of
        // // ApplicationLevel class
        // applicationLevel.LoggedinUsersId.put(userDetails.getResidentDetails().getResidentId(),
        // userDetails.getResidentDetails().getTownshipId());
        // }
//*				return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsers(),
//*						userDetails.getUsername() + "  " + DisplayMessage.LoginSuccess, userDetails.getAuthorities()));

//*			}
//*		}
    }

    public ResponseEntity<?> replaceUser(LoginForm loginRequest, String type) {

        // authenticate the user with database using username and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

        // get authenticated data from Authentication
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        // remove Expired token from already logged in user list
        applicationLevel.LoggedInUsersList.remove(userDetails.getUsername());

        // remove Expired residentId from already logged in userid list
        applicationLevel.LoggedinUsersId.remove(userDetails.getUsers().getEmployeeid());

        // call authenticateUser method to relogin the user
        return this.authenticateUser(loginRequest, type);
    }

    public ReturningMessage logout() {

        System.out.println("get logger size after"+applicationLevel.LoggedInUsersList.size());
        applicationLevel.LoggedinUsersId.remove(userInfo.getLoggedInUser().getUsers().getEmployeeid());
        applicationLevel.LoggedInUsersList.remove(applicationLevel.tokenKey);
        if (applicationLevel.LoggedInUsersList.get(userInfo.getLoggedInUser().getUsername()) == null) {
            return new ReturningMessage(DisplayMessage.SuccessfulLogout, "", false);
        } else {
            return new ReturningMessage(DisplayMessage.LogoutFailed, "", true);
        }
    }

}
