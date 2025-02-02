package spring.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dto.UserDTORequest;
import spring.dto.UserDTOResponse;
import spring.entity.UsersTable;
import spring.repository.Repo;

@Service
public class ServiceImplentation implements Services {
	
	
	
	@Autowired		
	 Repo repo;
	
	@Override
	public UserDTOResponse addUser(UserDTORequest dto) {
		
		UsersTable user = new UsersTable();
		
		BeanUtils.copyProperties(dto, user);
		
		user.setDeleteflag(false);
		
		repo.save(user);
		
		UserDTOResponse responsedto  = new UserDTOResponse();
		
		responsedto.setId(dto.getId());
		responsedto.setMessage("Created with UserID: " + user.getId());
		
		return responsedto;
		
	}

	@Override
	public boolean signin(String username, String password) {
		// TODO Auto-generated method stub
		
		Optional<UsersTable> userOptional = repo.findByUsername(username);
        
        if (userOptional.isPresent()) {
            UsersTable user = userOptional.get();
            
            if(user.isDeleteflag() == true) 
            {
            	return false;
            }
            
            return user.getPassword().trim().equals(password); 
        }
        
        return false;
	}

	@Override
	public boolean deleteUser(String username, String password) {
		// TODO Auto-generated method stub
		
		Optional<UsersTable> userOptional = repo.findByUsername(username);
		
		if (userOptional.isPresent())
		{
            UsersTable user = userOptional.get();
            
            if(user.getPassword().equals(password))
            {
            user.setDeleteflag(true);
            repo.save(user);
            return true;
            }
        }
		return false;
	}

	@Override
	public UserDTOResponse updatePassword(String username, String password, String newpassword) {
		// TODO Auto-generated method stub
		

		Optional<UsersTable> userOptional = repo.findByUsername(username); 
		if (userOptional.isPresent())
		{
            UsersTable user = userOptional.get();
            
           if( user.getPassword().equals(password)) {
        	   user.setPassword(newpassword);
        	   repo.save(user);
           }else {
        	   UserDTOResponse responsedto  = new UserDTOResponse();
              	responsedto.setMessage("Your password cannot be updated wrong password!!");
              	return responsedto;
           }
           
           UserDTOResponse responsedto  = new UserDTOResponse();
       	responsedto.setMessage("Your password has been updated!!");
           return responsedto;
		}
		
		UserDTOResponse responsedto  = new UserDTOResponse();
       	responsedto.setMessage("Your password cannot be updated wrong username!!");
		
		return responsedto;
	}

	@Override
	public UserDTOResponse logout() {
		// TODO Auto-generated method stub
		
		UserDTOResponse responsedto  = new UserDTOResponse();
	responsedto.setMessage("You have been logged out !!");
		
		return responsedto;
	}

}
