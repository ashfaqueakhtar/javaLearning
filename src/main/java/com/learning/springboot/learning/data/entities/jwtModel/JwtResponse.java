package com.learning.springboot.learning.data.entities.jwtModel;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {
    private String jwtToken;
    private String userName;
}
