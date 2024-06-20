package com.subh.service;

import java.util.List;

import com.subh.entity.Recipe;
import com.subh.entity.User;

public interface IRecipeService {
	
	public Recipe createRecipe(Recipe recipe, User user);
	
	public Recipe findRecipeById(Long id) throws Exception;
	
	public void deleteRecipe(Long id) throws Exception;
	
	public Recipe updateRecipe(Recipe recipe, Long id) throws Exception;
	
	public List<Recipe> findAllRecipe();
	
	public Recipe likeRecipe(Long recipeId, User user) throws Exception;

}
