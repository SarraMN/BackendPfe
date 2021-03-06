package com.pfe.back.BackPfe.services;

import java.util.List;

import com.pfe.back.BackPfe.entities.User;



public interface UserService {
	
	public User findByUserName(String userName);
	
	public User add(User user);
	public User findById(Long id);

	public List<User> getUsers();
	

	public User findByEmail(String destinataire);
	public User update(Long id,User user);

	public User update_motdepasse(long id, String password);
	
	public List<User> getUsersSaufAdmin();
	
	public List<User> getlisteFormateurs();
	
	public List<User> getlisteCandidats();


	


}
