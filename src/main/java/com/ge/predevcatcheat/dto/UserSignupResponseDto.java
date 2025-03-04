package com.ge.predevcatcheat.dto;

import com.ge.predevcatcheat.entity.*;
import lombok.*;

@Getter
public class UserSignupResponseDto {

    private final String nickname;
    private final String userName;
    private final String role;
    private final String token;

    @Builder
    public UserSignupResponseDto(Users user, String token) {
        this.nickname = user.getNickname();
        this.userName = user.getUserName();
        this.role = user.getRole().name();
        this.token = token;
    }

}
