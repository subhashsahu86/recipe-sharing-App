package com.subh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subh.entity.Recipe;
import com.subh.entity.User;
import com.subh.service.RecipeServiceImpl;
import com.subh.service.UserServiceImpl;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
	
	@Autowired
	private RecipeServiceImpl recipeService;
    
	@Autowired
	private UserServiceImpl userService;
	 
	@PostMapping("/user/{userId}")
	public Recipe createRecipe(@RequestBody Recipe recipe,@PathVariable Long userId) throws Exception {
		
		
		User user = userService.findUserById(userId);
		
		Recipe createdRecipe = recipeService.createRecipe(recipe, user);
		
		return createdRecipe;
	}
	
	@GetMapping()
	public List<Recipe> getAllRecipe(){
		
		List<Recipe> recipes = recipeService.findAllRecipe();
		
		return recipes;
	}
	
	@DeleteMapping("/{recipeId}")
	public String deleteRecipe(@PathVariable Long recipeId) throws Exception {
		
		recipeService.deleteRecipe(recipeId);
		
		return "Recipe Deleted Successfully";
	}
	
	@PutMapping("/{recipeId}")
	public Recipe updateRecipe(@RequestBody Recipe recipe , @PathVariable Long recipeId) throws Exception {
		
		Recipe updatedRecipe = recipeService.updateRecipe(recipe, recipeId);
		
		return updatedRecipe;
		
	}
	
	@PutMapping("/like/{recipeId}/user/{userId}")
	public Recipe likeRecipe( @PathVariable Long recipeId, 
			                  @PathVariable Long userId) throws Exception {
		
		User user = userService.findUserById(userId);
		
		Recipe updatedRecipe =  recipeService.likeRecipe(recipeId, user);    
		
		return updatedRecipe;
		
	}
		
	
}
