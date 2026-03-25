package com.smhrd.malang.service.hashtags;

import com.smhrd.malang.entity.Hashtags;
import com.smhrd.malang.entity.Persona_tags;
import com.smhrd.malang.entity.Personas;
import com.smhrd.malang.repository.HashtagsRepository;
import com.smhrd.malang.repository.PersonaTagsRepository;
import com.smhrd.malang.repository.PersonasRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HashtagsService {

    private final HashtagsRepository hashtagsRepository;
    private final PersonaTagsRepository personaTagsRepository;
    private final PersonasRepository personasRepository;

    // 해시태그 저장
    public void saveHashtags(Hashtags hashtags){
        if(hashtagsRepository.existsByHashtagName(hashtags.getHashtagName())){
            throw new IllegalArgumentException("존재하는 해시태그입니다.");
        }
        hashtagsRepository.save(hashtags);
    }

    // 전체 해시 태그 조회
    public List<Hashtags> findAll(){
        List<Hashtags> list = hashtagsRepository.findAll();
        return list;
    }

    // 해시태그 삭제
    public void delete(Integer hashtagId){
        hashtagsRepository.deleteById(hashtagId);
    }

    // 해시태그 조합 저장
    @Transactional // 저장하다가 에러나면 취소해주는 라이브러리
    public void savePersonaTags(){

        }
    }

