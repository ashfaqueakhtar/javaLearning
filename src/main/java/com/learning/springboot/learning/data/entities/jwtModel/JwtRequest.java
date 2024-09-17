package com.learning.springboot.learning.data.entities.jwtModel;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtRequest {
    private String Email;
    private String Password;
}
