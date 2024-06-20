package com.subh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subh.entity.User;
import com.subh.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(User user) throws Exception {
		
		User isExist = userRepo.findByEmail(user.getEmail());
		if(isExist !=null) {
			throw new Exception ("User is already exist  with this Email" + user.getEmail() );
		}
       
		User createdUser = userRepo.save(user);
		
		return createdUser;
	}

	@Override
	public User findUserById(Long userId) throws Exception {
		
		//use userRepo
		
	Optional<User> opt = userRepo.findById(userId);
	
	if(opt.isPresent()) {
		return opt.get();
	}
       throw new Exception ("User is not exist with this id :" + userId);
     	
	}

	@Override
	public List<User> findAllUsers() {
      
		List<User> getAllUsers = userRepo.findAll();
		
		return getAllUsers;
	}

	@Override
	public void deleteUser(Long userId) throws Exception {
    
		 userRepo.deleteById(userId);
		
	}

	@Override
	public User updateUser(User user, Integer userId) throws Exception {
		
		User oldUser = new User();
		if(oldUser.getFullName()!=null) {
			oldUser.setFullName(user.getFullName());
		}
		if(oldUser.getPassword() !=null) {
			oldUser.setPassword(user.getPassword());
		}
		if(oldUser.getMobile() !=null) {
			oldUser.setMobile(user.getMobile());;
		}
		
		return oldUser;
	}

	
		
	
}
