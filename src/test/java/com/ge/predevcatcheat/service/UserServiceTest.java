package com.ge.predevcatcheat.service;

import com.ge.predevcatcheat.dto.*;
import com.ge.predevcatcheat.entity.*;
import com.ge.predevcatcheat.repository.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    // To do: 비밀번호 암호화 로직 추가
    
    // To do: 회원가입 유효성검증 로직 추가
    
    @Test
    @DisplayName("이메일 회원가입 성공")
    void registerUserSuccess() {
        // given
        UserSignupRequestDto userSignupRequestDto = UserSignupRequestDto.builder()
                .email("test@example.com")
                .password("password123")
                .nickname("테스트닉네임")
                .userName("테스트이름")
                .role(UserRole.USER)
                .build();

        // when
        when(userRepository.existsByEmail(userSignupRequestDto.getEmail())).thenReturn(false);
        when(userRepository.existsByUserName(userSignupRequestDto.getUserName())).thenReturn(false);

        // then
        Users user = userSignupRequestDto.toEntity();
        assertNotNull(user);
        assertEquals("test@example.com", user.getEmail());
        assertEquals("테스트닉네임", user.getNickname());
        assertEquals("테스트이름", user.getUserName());
        assertEquals("password123", user.getPassword());

    }
}