package com.app.app.dao;

import java.util.List;

import com.app.app.pojos.User;

public interface IUserDao {
	public User save(User user);
	public List<User> getAll();
}
