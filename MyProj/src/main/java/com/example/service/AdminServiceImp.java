package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Admin;
import com.example.repository.AdminRepository;
import com.example.repository.UserRepository;

@Service
public class AdminServiceImp implements IAdminService {

	@Autowired
	AdminRepository arepo;

	@Autowired
	UserRepository urepo;

	

	@Override
	public boolean login(Admin admin) {
		if(arepo.findByAemail(admin.getAemail())!=null) {
			Admin pass = arepo.findByAemail(admin.getAemail());
			if(pass.getApassword().equals(admin.getApassword())){
				return true;
			}
			
			return false;
		}
		return false;
	}

	@Override
	public boolean register(Admin admin) {
		if(arepo.findByAemail(admin.getAemail())==null) {
			arepo.save(admin);
			return true;
		}
		
		return false;
	}

}
