package com.taehoondev.daylink.view.dto;

import com.taehoondev.daylink.story.domain.Story;
import lombok.Getter;

@Getter
public class StoryListViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public StoryListViewResponse(Story story) {
        this.id = story.getId();
        this.title = story.getTitle();
        this.content = story.getContent();
    }
}
