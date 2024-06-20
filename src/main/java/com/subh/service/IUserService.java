package com.subh.service;

import java.util.List;

import com.subh.entity.User;

public interface IUserService {
	
	public User createUser(User user) throws Exception;
	
	public User findUserById(Long userId) throws Exception;
	
	public List<User> 	findAllUsers();
	
	public void deleteUser(Long userId) throws Exception;
	
	public User updateUser(User user , Integer userId) throws Exception;
}
