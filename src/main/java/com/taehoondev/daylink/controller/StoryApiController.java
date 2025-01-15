package com.taehoondev.daylink.controller;

import com.taehoondev.daylink.domain.Story;
import com.taehoondev.daylink.dto.AddStoryRequest;
import com.taehoondev.daylink.dto.StoryResponse;
import com.taehoondev.daylink.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class StoryApiController {

    private final StoryService storyService;

    @PostMapping("/api/stories")
    public ResponseEntity<Story> addStory(@RequestBody AddStoryRequest request) {
        Story savedStory = storyService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedStory);
    }

    @GetMapping("/api/stories")
    public ResponseEntity<List<StoryResponse>> findAllStories() {
        List<StoryResponse> stories = storyService.findAll()
                .stream()
                .map(StoryResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(stories);
    }
}