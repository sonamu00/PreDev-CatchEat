package com.ge.predevcatcheat.dto;

import com.ge.predevcatcheat.entity.*;
import lombok.*;

@Getter
@NoArgsConstructor
public class UserSignupRequestDto {
    private String email;
    private String phoneNumber;
    private String password;
    private String nickname;
    private String userName;
    private UserRole role;
    private SnsProvider snsProvider;
    private String snsId;

    public Users toEntity() {
        return Users.builder()
                .email(email)
                .phoneNumber(phoneNumber)
                .password(password)
                .nickname(nickname)
                .userName(userName)
                .role(UserRole.USER)
                .build();
    }

}
