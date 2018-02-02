package com.project.beltreview.services;
import com.project.beltreview.models.User;
import com.project.beltreview.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	// Member variables / service initializations go here
	private UserRepository userRepository;
	private BCryptPasswordEncoder bcrypt;
		
	public UserService(UserRepository userRepository){
		this.userRepository=userRepository;
		this.bcrypt= new BCryptPasswordEncoder();

	}
	public boolean isMatch(String password, String dbPass){
		if(bcrypt.matches(password,dbPass)){
			return true;
		}
		else{
			return false;
		}
	}
		// Crud methods to act on services go here.
		public void create(User user){
			List<User> users=(List<User>)userRepository.findAll();
			user.setPassword(  bcrypt.encode( user.getPassword() ) );
				if(users.size()==0){
					user.setAdmin(true);
				}
				userRepository.save(user);
			}
	
		public void update(User user){
				create(user);
			}
		
		public ArrayList<User> all(){

			return userRepository.findAll();
			}
	
		public User findById(long id){
			return (User) userRepository.findOne(id);
	
		}
		
		public void destroy(User user){
				userRepository.delete(user);
	
		}
		
		public User findByEmail(String email){
	
			return (User) userRepository.findByEmail(email);
	
		}

		

	}