package com.example.boardPage.repository;

import com.example.boardPage.dto.User;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //이메일 중복 방지
    boolean existsByEmail (String email);

    //이름 중복 방지
    boolean existsByUsername (String username);

    //이메일로 회원 찾기
    User findByEmail (String email);
}
