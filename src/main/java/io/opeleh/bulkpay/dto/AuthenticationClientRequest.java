package io.opeleh.bulkpay.dto;

public class AuthenticationClientRequest {

    private String client_id;
    private String client_secret;

    public AuthenticationClientRequest(String client_id, String client_secret) {
        this.client_id = client_id;
        this.client_secret = client_secret;
    }

    public AuthenticationClientRequest() {
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    @Override
    public String toString() {
        return "AuthenticationClientRequest [client_id=" + client_id + ", client_secret=" + client_secret + "]";
    }

    

}