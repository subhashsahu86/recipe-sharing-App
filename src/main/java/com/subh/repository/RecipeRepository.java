package com.subh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subh.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
