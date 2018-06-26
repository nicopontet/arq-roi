
package com.roiplanner.dto;


public class TokenDTO {
    String token;
    String tokenKremlin;

    public TokenDTO(String token, String tokenKremlin) {
        this.token = token;
        this.tokenKremlin = tokenKremlin;
    }

    public TokenDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenKremlin() {
        return tokenKremlin;
    }

    public void setTokenKremlin(String tokenKremlin) {
        this.tokenKremlin = tokenKremlin;
    }
    
    
}
