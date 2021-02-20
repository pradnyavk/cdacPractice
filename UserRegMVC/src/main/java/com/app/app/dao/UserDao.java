package com.app.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.app.app.pojos.*;

@Component
public class UserDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public int save(User user) {
		Integer i = (Integer) hibernateTemplate.save(user);
		return i;
	}
	
	public List<User> getAll(){
		return hibernateTemplate.loadAll(User.class);
	}
}
