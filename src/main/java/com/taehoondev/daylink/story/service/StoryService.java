package com.taehoondev.daylink.story.service;

import com.taehoondev.daylink.story.domain.Story;
import com.taehoondev.daylink.story.dto.AddStoryRequest;
import com.taehoondev.daylink.story.dto.UpdateStoryRequest;
import com.taehoondev.daylink.story.repository.StoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final 혹은 @NotNull 필드의 생성자 추가
@Service
public class StoryService {

    private final StoryRepository storyRepository;

    // 스토리 추가 메서드
    public Story save(AddStoryRequest request) {
        return storyRepository.save(request.toEntity());
    }

    // 전체 스토리 조회 메서드
    public List<Story> findAll() {
        return storyRepository.findAll();
    }

    // 특정 스토리 조회 메서드
    public Story findById(long id) {
        return storyRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: " + id));
    }

    // 스토리 삭제 메서드
    public void delete(long id) {
        storyRepository.deleteById(id);
    }

    // 스토리 수정 메서드
    @Transactional // 작업을 하나의 단위로 묶어서 실행
    public Story update(long id, UpdateStoryRequest request) {
        Story story = storyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        story.update(request.getTitle(), request.getContent());

        return story;
    }
}
