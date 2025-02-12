package com.taehoondev.daylink.story.dto;

import com.taehoondev.daylink.story.domain.Story;
import lombok.Getter;

@Getter
public class StoryResponse {

    private final String title;
    private final String content;

    public StoryResponse(Story story) {
        this.title = story.getTitle();
        this.content = story.getContent();
    }
}