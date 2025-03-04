package com.ge.predevcatcheat.repository;

import com.ge.predevcatcheat.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    // 이메일로 가입한 사용자 조회
    Optional<Users> findByEmail(String email);

}
