package com.taehoondev.daylink.story.controller;

import com.taehoondev.daylink.story.domain.Story;
import com.taehoondev.daylink.story.dto.AddStoryRequest;
import com.taehoondev.daylink.story.dto.StoryResponse;
import com.taehoondev.daylink.story.dto.UpdateStoryRequest;
import com.taehoondev.daylink.story.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/stories/{id}")
    public ResponseEntity<StoryResponse> findStory(@PathVariable long id) {
        Story story = storyService.findById(id);

        return ResponseEntity.ok()
                .body(new StoryResponse(story));
    }

    @DeleteMapping("/api/stories/{id}")
    public ResponseEntity<Void> deleteStory(@PathVariable long id) {
        storyService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/stories/{id}")
    public ResponseEntity<Story> updateStory(@PathVariable long id, @RequestBody UpdateStoryRequest request) {
        Story updatedStory = storyService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedStory);
    }
}