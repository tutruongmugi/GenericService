package com.clone.instagram.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
