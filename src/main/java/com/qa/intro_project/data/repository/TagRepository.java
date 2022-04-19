package com.qa.intro_project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.intro_project.data.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
