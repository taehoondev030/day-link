package com.taehoondev.daylink.story.repository;

import com.taehoondev.daylink.story.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}