package com.example.boardPage.repository;

import com.example.boardPage.dto.ProfileDTO;
import com.example.boardPage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<User, Long> {//Long = Entity 기본 키 타입
    Optional<ProfileDTO> findByProfileDto(String username); //id로 할지 !!
}
