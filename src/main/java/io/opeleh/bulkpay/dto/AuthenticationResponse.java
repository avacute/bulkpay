package io.opeleh.bulkpay.dto;

import java.util.Date;

public class AuthenticationResponse {

    private String jwt;
    private Date expiry;

    public AuthenticationResponse(String jwt, Date expiry) {
        this.jwt = jwt;
        this.expiry = expiry;
    }

    public AuthenticationResponse() {
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "AuthenticationResponse [expiry=" + expiry + ", jwt=" + jwt + "]";
    }

    

}