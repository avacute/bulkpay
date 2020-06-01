package io.opeleh.bulkpay.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import io.opeleh.bulkpay.model.User;
import io.opeleh.bulkpay.model.UsersDetails;
import io.opeleh.bulkpay.repository.UserJparepository;


@Service
public class BulkPayUserDetailsService implements UserDetailsService {

    @Autowired
    UserJparepository userJparepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        // Get User details by username
        Optional <User> userData = userJparepository.findByUsername(username);

        //throw UserNotFoundexception
        if(!userData.isPresent()){
            System.out.println(username + " Not found " + HttpStatus.NOT_FOUND);
            userData.orElseThrow (() -> new UsernameNotFoundException("user not found"));
        }

        return userData.map(UsersDetails::new).get();
    }

}