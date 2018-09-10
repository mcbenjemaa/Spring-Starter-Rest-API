package com.enable.restfullapp.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
   @Autowired	UserService userService;
   
   @GetMapping("/users")
   public List<User> getAll(){
	   
	   return userService.findAll();
   }
   
   @GetMapping("/users/{id}")
   public Resource<User> getOne(@PathVariable int id){
	   
	   User user=userService.findOne(id);
	   
	   if(user==null)
		   throw new UserNotFoundException("id-"+id);
	   
	   
	   // HATEOAS
	   
	   Resource<User>  reource=new Resource(user);
	   
	   
	   ControllerLinkBuilder link= ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAll());
	   
	   reource.add(link.withRel("all-users"));
	   
	   
	   return reource;
   }
   
   
   @PostMapping("/users")
   public ResponseEntity createUser(@Valid @RequestBody User user) {
	   
	 User saveduser= userService.save(user);
	 
	URI location= ServletUriComponentsBuilder
	  .fromCurrentRequest()
	  .path("/{id}")
	  .buildAndExpand(saveduser.getId())
	  .toUri();
	 
	return ResponseEntity.created(location).build();
	  
   }
   
   
   @DeleteMapping("/users/{id}")
   public void delete(@PathVariable int id){
	   
	   User user=userService.delete(id);
	   
	   if(user==null)
		   throw new UserNotFoundException("id-"+id);
	   
   }
   

}
