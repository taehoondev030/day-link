package com.taehoondev.daylink.repository;

import com.taehoondev.daylink.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}