package io.opeleh.bulkpay.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.opeleh.bulkpay.dto.AuthenticationBasicRequest;
import io.opeleh.bulkpay.dto.AuthenticationResponse;
import io.opeleh.bulkpay.service.BulkPayUserDetailsService;
import io.opeleh.bulkpay.util.GenerateJWT;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class APIResources {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    BulkPayUserDetailsService userDetailService;

    @Autowired
    GenerateJWT generateJWT;


    @RequestMapping("/")
    public String test(){
        return "hmmm";
    }

   @PostMapping(value="/api/auth/token")
   public ResponseEntity <?> postMethodName(@RequestBody AuthenticationBasicRequest auth_request) throws Exception {
       try{
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(auth_request.getUsername(), auth_request.getPassword())
            );

       }catch(BadCredentialsException e){
            throw new Exception("Username or Password invalid ", e);
       }

      final UserDetails usersDetails = userDetailService.loadUserByUsername(auth_request.getUsername());
      final String jwt = generateJWT.generateToken(usersDetails);
      final Date jwtExpiry = generateJWT.getExpirationDateFromToken(jwt);
    
      return ResponseEntity.ok(new AuthenticationResponse(jwt,jwtExpiry));
       
   }
    
}