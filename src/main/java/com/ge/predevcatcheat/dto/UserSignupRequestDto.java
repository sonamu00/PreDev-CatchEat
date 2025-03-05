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

    @Builder
    public UserSignupRequestDto(String email, String phoneNumber, String password, String nickname,
                                String userName, UserRole role, SnsProvider snsProvider, String snsId) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nickname = nickname;
        this.userName = userName;
        this.role = role;
        this.snsProvider = snsProvider;
        this.snsId = snsId;
    }

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
