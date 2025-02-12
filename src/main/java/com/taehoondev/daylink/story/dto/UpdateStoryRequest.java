package com.taehoondev.daylink.story.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateStoryRequest {
    private String title;
    private String content;
}
