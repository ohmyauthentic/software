package njust.User;

import java.util.List;

import njust.PO.Admin;
import njust.Sessionfactory.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminManage {
	private Session session;
	private Transaction tx;
	private Query query;
	private MD5 md5;
	public AdminManage(){
		md5=new MD5();
	}
	public String login(String username, String password) {
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		String mess = "error";
		try {
			String hqlsql = "from Admin as a where a.username=?";
			query = session.createQuery(hqlsql);
			query.setParameter(0, username);
			@SuppressWarnings("unchecked")
			List<Admin> list = query.list();
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
	//添加用户
	public boolean AddAdd(Admin admin){
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		try {
			String hqlsql = "from admin as a where a.username=?";
			query = session.createQuery(hqlsql);
			query.setParameter(0, admin.getUsername());
			@SuppressWarnings("unchecked")
			List<Admin> list = query.list();
			if (list == null || list.size() == 0) {
				MD5 md5=new MD5();
				admin.setPassword(md5.toMd5Str(admin.getPassword()));
				session.save(admin);
				tx.commit();
				return true;
			} 
			else return false;				
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
	//删除用户
	public boolean DeleteAdmin(String username){
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		try {
			String hqlsql = "from Admin as a where a.username=?";
			query = session.createQuery(hqlsql);
			query.setParameter(0, username);
			@SuppressWarnings("unchecked")
			List<Admin> list = query.list();
			if (list == null||list.size() == 0) return true;
			if (list != null&&list.size() != 0){ 
				session.delete(list.get(0));
				tx.commit();
				return true;				
			}
			return false;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}		
	}
	
	//修改用户密码
	public boolean ModifyPassword(String username,String password){
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		try {
			String hqlsql = "from Admin as a where a.username=?";
			query = session.createQuery(hqlsql);
			query.setParameter(0, username);
			@SuppressWarnings("unchecked")
			List<Admin> list = query.list();
			if (list != null&&list.size() != 0){ 
				MD5 md5=new MD5();
				Admin admin=list.get(0);
				admin.setPassword(md5.toMd5Str(password));				
				session.update(admin);
				tx.commit();
				return true;				
			}
			return false;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}		
	}
	//修改用户等级
	public boolean ModifyAuth(String username,int auth){
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		try {
			String hqlsql = "from Admin as a where a.username=?";
			query = session.createQuery(hqlsql);
			query.setParameter(0, username);
			@SuppressWarnings("unchecked")
			List<Admin> list = query.list();
			if (list != null&&list.size() != 0){ 				
				Admin admin=list.get(0);
				admin.setAuth(auth);				
				session.update(admin);
				tx.commit();
				return true;				
			}
			return false;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}		
	}
	//修改用户除了用户名外的所有属性
	public boolean ModifyAdmin(String username,String password,int auth){
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		try {
			String hqlsql = "from Admin as a where a.username=?";
			query = session.createQuery(hqlsql);
			query.setParameter(0, username);
			@SuppressWarnings("unchecked")
			List<Admin> list = query.list();
			if (list != null&&list.size() != 0){ 
				MD5 md5=new MD5();
				Admin admin=list.get(0);
			    admin.setPassword(md5.toMd5Str(password));
			    admin.setAuth(auth);
				session.update(admin);
				tx.commit();
				return true;				
			}
			return false;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}		
	}
	//根据用户名查询
	public Admin findByUsername(String username){
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		try {
			String hqlsql = "from Admin as a where a.username=?";
			query = session.createQuery(hqlsql);
			query.setParameter(0, username);
			@SuppressWarnings("unchecked")
			List<Admin> list = query.list();
		    tx.commit();
			if(list!=null&&list.size()!=0)	return list.get(0);
			else return null;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	//查询所有的用户
	public List findAll(){
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		try {
			String hqlsql = "from Admin";
			query = session.createQuery(hqlsql);
			@SuppressWarnings("unchecked")
			List<Admin> list = query.list();
		    tx.commit();
			return list;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}	
	@SuppressWarnings("unchecked")
	public List<Admin> queryForPage(final String hql,  final int offset, final int length) {
		session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		List<Admin> list;
		try {
			Query query = session.createQuery(hql);
			query.setFirstResult(offset);
			query.setMaxResults(length);
			list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {			
			tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}		
	}
}
