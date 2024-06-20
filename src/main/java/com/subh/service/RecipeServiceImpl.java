package com.subh.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subh.entity.Recipe;
import com.subh.entity.User;
import com.subh.repository.RecipeRepository;


@Service
public class RecipeServiceImpl implements IRecipeService {
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	

	@Override
	public Recipe createRecipe(Recipe recipe, User user) {

		Recipe createNewRecipe = new Recipe();
		System.out.println("RecipeServiceImpl.createRecipe()");
		createNewRecipe.setTitle(createNewRecipe.getTitle());
		createNewRecipe.setImage(createNewRecipe.getImage());
		createNewRecipe.setIsVagitarian(createNewRecipe.getIsVagitarian());
		createNewRecipe.setDiscription(createNewRecipe.getDiscription());
		createNewRecipe.setUser(user);
		createNewRecipe.setCreatedAt(LocalDateTime.now());
		
		return recipeRepo.save(createNewRecipe);
	}

	@Override
	public Recipe findRecipeById(Long id) throws Exception {
          
		Optional<Recipe> opt = recipeRepo.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		 
		throw new Exception("Recipe not found with this id : "+ id);
	}

	@Override
	public void deleteRecipe(Long id) throws Exception {
       
		 recipeRepo.findById(id);
		 
		 recipeRepo.deleteById(id);
		
		
	}

	@Override
	public Recipe updateRecipe(Recipe recipe, Long id) throws Exception {
         
		Recipe oldRecipe = findRecipeById(id);
		
		if(recipe.getTitle() !=null) {
			oldRecipe.setTitle(recipe.getTitle());
		}
		
		if(recipe.getDiscription() !=null) {
			oldRecipe.setDiscription(recipe.getDiscription());
		}
		
		if(recipe.getImage() !=null) {
			oldRecipe.setImage(recipe.getImage());
		}
		
		return recipeRepo.save(oldRecipe);
	}

	@Override
	public List<Recipe> findAllRecipe() {
		
		return recipeRepo.findAll();
	}

	@Override
	public Recipe likeRecipe(Long recipeId, User user) throws Exception {
        
		Recipe recipe = findRecipeById(recipeId);
		
		
		
		if(recipe.getLikes().contains(user.getUserId())) {
			recipe.getLikes().remove(user.getUserId());
		}
		else {
			recipe.getLikes().add(user.getUserId());
		}
		return null;
	}

}
