package com.taehoondev.daylink.story.dto;

import com.taehoondev.daylink.story.domain.Story;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddStoryRequest {

    private String title;
    private String content;

    public Story toEntity() {
        return Story.builder()
                .title(title)
                .content(content)
                .build();
    }
}
