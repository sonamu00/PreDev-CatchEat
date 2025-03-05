package com.ge.predevcatcheat.repository;

import com.ge.predevcatcheat.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    // 이메일 존재 여부
    boolean existsByEmail(String email);

    // 닉네임 존재 여부
    boolean existsByUserName(String userName);

}
