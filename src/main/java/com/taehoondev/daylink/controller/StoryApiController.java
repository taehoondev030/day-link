package com.taehoondev.daylink.controller;

import com.taehoondev.daylink.domain.Story;
import com.taehoondev.daylink.dto.AddStoryRequest;
import com.taehoondev.daylink.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}