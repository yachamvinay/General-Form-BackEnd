package com.example.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImp implements IUserService {
	
	

	@Autowired
	UserRepository urepo;


	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		
		if(urepo.findByUemail(user.getUemail())!=null) {
			User pass = urepo.findByUemail(user.getUemail());
			if(pass.getUpassword().equals(user.getUpassword())){
				return true;
			}
			
			return false;
		}
		return false;
	}
		

	@Override
	public boolean register(User user) {
		if(urepo.findByUemail(user.getUemail())==null) {
			urepo.save(user);
			return true;
		}
		
		return false;
}


	
}