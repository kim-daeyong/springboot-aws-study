package com.example.study.springaws.service.posts;

import com.example.study.springaws.domain.posts.PostsRepository;
import com.example.study.springaws.dto.PostSaveRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity())
                                .getId();
    }
    
}
