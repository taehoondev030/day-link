package com.taehoondev.daylink.view.dto;

import com.taehoondev.daylink.story.domain.Story;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class StoryViewResponse {

    private long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public StoryViewResponse(Story story) {
        this.id = story.getId();
        this.title = story.getTitle();
        this.content = story.getContent();
        this.createdAt = story.getCreatedAt();
    }
}
