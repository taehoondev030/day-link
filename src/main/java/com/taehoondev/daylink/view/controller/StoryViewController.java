package com.taehoondev.daylink.view.controller;

import com.taehoondev.daylink.story.domain.Story;
import com.taehoondev.daylink.story.service.StoryService;
import com.taehoondev.daylink.view.dto.StoryListViewResponse;
import com.taehoondev.daylink.view.dto.StoryViewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class StoryViewController {

    private final StoryService storyService;

    @GetMapping("/stories")
    public String getStories(Model model) {
        List<StoryListViewResponse> stories = storyService.findAll().stream()
                .map(StoryListViewResponse::new)
                .toList();
        model.addAttribute("stories", stories);

        return "storyList";
    }

    @GetMapping("/stories/{id}")
    public String getStory(@PathVariable Long id, Model model) {
        Story story = storyService.findById(id);
        model.addAttribute("story", new StoryViewResponse(story));

        return "story";
    }
}
