package com.example.service;

import com.example.entity.User;

public interface IUserService {

	boolean login(User user);

	boolean register(User user);


}
