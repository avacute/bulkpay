package io.opeleh.bulkpay.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.opeleh.bulkpay.service.BulkPayUserDetailsService;
import io.opeleh.bulkpay.util.GenerateJWT;

@Component
public class JWTRequestFilter extends OncePerRequestFilter{

    @Autowired
    GenerateJWT generateJWT;

    @Autowired
    BulkPayUserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException { 
        
        // declare and set username to null
        String username = null;
        //declare and set jwt to null
        String jwt = null;

        final String authorisationHeader = request.getHeader("Authorization");

        if(authorisationHeader != null && authorisationHeader.startsWith("Bearer ")){
            // get the value of jwt from authorisationHeader using substring of 7
            jwt = authorisationHeader.substring(7);

            //get username form jwt user the method from GenerateToken
            username = generateJWT.getUsernameFromToken(jwt);

        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
           
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
           
           if(generateJWT.validateToken(jwt, userDetails)){

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                
                usernamePasswordAuthenticationToken
                .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

           }

        }

        filterChain.doFilter(request,response);

		
	}
    
    
}