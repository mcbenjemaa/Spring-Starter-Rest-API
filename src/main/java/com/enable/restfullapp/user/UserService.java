package com.enable.restfullapp.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	private static List<User> users=new ArrayList<>();
	
	private static int usersCount=3;
	
	static {
		users.add(new User(1,"Adam",new Date()));
		users.add(new User(2,"Micheal",new Date()));
		users.add(new User(3,"Sam",new Date()));
		
	}
	
	
	
	public List<User> findAll(){
		return users;
	}
	
	
	public User save(User user) {
		if(user.getId()==0) {
			user.setId(++usersCount);
		}
		
		users.add(user);
		
		return user;
	}
	
	
	public User findOne(int id) {
		
		for(User u : users ) {
			if(u.getId()==id)
				return u;
		}
		
		return null;
	}
	
	
	
	public User delete(int id) {
		Iterator<User> iterator=users.iterator();
		
		while(iterator.hasNext()) {
			User user=iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}
	
}
