package com.app.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.app.pojos.*;

@Repository
@Transactional
public class UserDao implements IUserDao{

//	EntityManagerFactory entityManagerFactory;
	
//	@PersistenceContext
//	EntityManager entityManager;
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	


	@Override
	public User save(User user) {
		String sql = "insert into user value(default,'"+user.getUseremail()+"','"+user.getUsername()+"','"+user.getUserpassword()+"')";
		int status = template.update(sql);
		System.out.println("User saved!!");
		return user;
	}
	
	@Override
	public List<User> getAll(){
		return template.query("select * from user", new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row) throws SQLException{
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUseremail(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setUserpassword(rs.getString(4));
				return user;
			}
		});
		
	}
}
