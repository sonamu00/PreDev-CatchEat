package com.ge.predevcatcheat.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.*;

@Entity
@Table(name = "users")
@Check(
        constraints = """
        (email IS NOT NULL AND password IS NOT NULL) OR  
        (phone_number IS NOT NULL AND password IS NOT NULL) OR  
        (sns_provider IS NOT NULL AND sns_id IS NOT NULL)
    """
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    private String password; // 일반 로그인 시 필요 (SNS 로그인 사용자는 NULL)

    private String email; // 일반 로그인 시 ID 역할

    @Column(name = "phone_number")
    private String phoneNumber; // 전화번호 로그인 시 ID 역할

    @Column(nullable = false, unique = true)
    private String nickname; // 사용자 닉네임

    @Column(nullable = false)
    private String userName; // 사용자 이름

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role = UserRole.USER; // 기본값 USER

    @Enumerated(EnumType.STRING)
    private SnsProvider snsProvider; // SNS 로그인 타입

    @Column(unique = true)
    private String snsId; // SNS 로그인 사용자 ID

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt; // 등록일자

    @UpdateTimestamp
    private LocalDateTime updatedAt; // 수정일자

    @Builder
    public Users(String password, String email, String phoneNumber, String nickname, String userName,
                UserRole role, SnsProvider snsProvider, String snsId) {
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.userName = userName;
        this.role = role;
        this.snsProvider = snsProvider;
        this.snsId = snsId;
    }

}
