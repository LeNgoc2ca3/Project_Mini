package com.java4.ngoclbph26472.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDTO {
    private Long id;
    private String username;
    private String password;
    private Integer role;

}
