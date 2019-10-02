package com.miraclesoft.io.awt.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.awt.Config;
import com.miraclesoft.io.model.Users;
import com.miraclesoft.io.repository.UserRepo;

@Repository
public class UserDAO {
	
	@Autowired
	UserRepo userRepo;
	
	/*
	 * @Autowired Config config;
	 * 
	 * 
	 * private SessionFactory sessionFactory;
	 * 
	 * private EntityManagerFactory entityManagerFactory;
	 */
	
	Users loginUser;
	
	/*
	 * public SessionFactory getSessionFactory() {
	 * 
	 * this.entityManagerFactory = config.entityManagerFactory();
	 * 
	 * if(entityManagerFactory.unwrap(SessionFactory.class) == null){ throw new
	 * NullPointerException("factory is not a hibernate factory"); }
	 * this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
	 * 
	 * return sessionFactory; }
	 */

	
	public Users findByUsername(String userName) {
		
		/*
		 * Session session = this.sessionFactory.getCurrentSession();
		 * 
		 * CriteriaBuilder builder =
		 * this.sessionFactory.getCurrentSession().getCriteriaBuilder();
		 * 
		 * // Create CriteriaQuery CriteriaQuery<Users> query =
		 * builder.createQuery(Users.class);
		 * 
		 * Root<Users> root = query.from(Users.class);
		 * query.select(root).where(builder.equal(root.get("username"),userName));
		 * Query<Users> q=session.createQuery(query); loginUser = q.getSingleResult();
		 */
		
		
		Users uu = userRepo.findByUsername(userName);
 
		return uu;
		
		 
		
	}	 

}
