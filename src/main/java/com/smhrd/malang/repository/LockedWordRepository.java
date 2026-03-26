package com.smhrd.malang.repository;

import com.smhrd.malang.domain.LockedWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LockedWordRepository extends JpaRepository<LockedWord, Integer> {

    // 특정 사용자 기준으로 보호 단어 조회
    List<LockedWord> findByUserId(Integer userId);

    // 특정 단어가 이미 존재하는지 확인
    Optional<LockedWord> findByUserIdAndWord(Integer userId, String word);
}