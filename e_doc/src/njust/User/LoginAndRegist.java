package njust.User;

import java.util.List;
import njust.PO.User;
import njust.Sessionfactory.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginAndRegist {
	private Session session;
	private Transaction tx;
	private Query query;
	private MD5 md5;

	public LoginAndRegist() {
		this.md5 = new MD5();
	}

	public String login(String username, String password) {
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		String mess = "error";
		try {
			String hqlsql = "from User as u where u.username=?";
			query = session.createQuery(hqlsql);
			query.setParameter(0, username);
			@SuppressWarnings("unchecked")
			List<User> list = query.list();
			if (list == null || list.size() == 0)
				mess = "noexist";
			else {
				String spass = list.get(0).getPassword();
				if (md5.checkPWD(spass, password))
					mess = "success";
				else
					mess = "passerror";
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return mess;
	}

	public String regist(String username, String password) {
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		String mess = "error";
		try {
			String hqlsql = "from User as u where u.username=?";
			query = session.createQuery(hqlsql);
			query.setParameter(0, username);
			@SuppressWarnings("unchecked")
			List<User> list = query.list();
			if (list == null || list.size() == 0) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(md5.toMd5Str(password));
				user.setExperience(0);
				user.setRank(0);
				session.save(user);
				tx.commit();
				mess = "success";
			} 
			else mess = "exist";
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return mess;
	}
}
