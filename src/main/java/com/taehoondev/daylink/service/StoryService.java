package com.taehoondev.daylink.service;

import com.taehoondev.daylink.domain.Story;
import com.taehoondev.daylink.dto.AddStoryRequest;
import com.taehoondev.daylink.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final 혹은 @NotNull 필드의 생성자 추가
@Service
public class StoryService {

    private final StoryRepository storyRepository;

    // 스토리 추가 메서드
    public Story save(AddStoryRequest request) {
        return storyRepository.save(request.toEntity());
    }
}
