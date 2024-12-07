package com.example.boardPage.repository;

import com.example.boardPage.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUserId(Long id);

    //이메일 중복 방지
    boolean existsByEmail (String email);

    //이름 중복 방지
    boolean existsByUsername (String username);

}
