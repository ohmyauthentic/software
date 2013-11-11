package njust.Test;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import njust.PO.Topic;
import njust.PO.User;
import njust.Sessionfactory.HibernateSessionFactory;


public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session1=HibernateSessionFactory.getSession();
		Transaction tx=session1.beginTransaction();
		Query query;
		User user=new User();
		try {
			String sqlString="from User as u where u.username=?";
			query=session1.createQuery(sqlString);
			query.setParameter(0, "zheng");
			List<User> list=query.list();
			user=list.get(0);
			System.out.println(user.getUsername());
		} catch (Exception e) {
			// TODO: handle exception
		}
		 Topic topic=new Topic();
			topic.setTopicId("111");
			topic.setUser(user);
			topic.setTopicName("ceshi");
			topic.setType("shijuan"); 
			topic.setWordDescription("word");
			topic.setPicUrl("url");
			topic.setTopicUrl("file");
			topic.setDownloadNum(0);
			topic.setHate(0);
			topic.setLove(0);
			topic.setPublishTime(new Timestamp(0));

			try {  
				session1.save(topic);  
				tx.commit();
				System.out.println("c  g");
			} catch (Exception e) {  
				tx.rollback();  
				e.printStackTrace();  
			}finally{  
				session1.close();  
			}
			
	}

}
