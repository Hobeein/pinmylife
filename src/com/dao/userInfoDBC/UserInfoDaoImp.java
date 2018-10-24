package com.dao.userInfoDBC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.domain.UserInfo;
import com.utils.HibernateUtils;

public class UserInfoDaoImp implements UserInfoDaoInterface {

	@Override
	public List userInfoQueryByName(String name) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			ArrayList list=new ArrayList();
			session = HibernateUtils.getSession();//获取session对象
			session.beginTransaction();//开始session事务
			List userInfo=session.createQuery("from UserInfo uif where uif.username=?").setParameter(0, name).list();
			for(Iterator iter=userInfo.iterator();iter.hasNext();){//迭代获取查询的数据
				UserInfo getinfo=(UserInfo)iter.next();
				if(getinfo.getUserId()!=null){
					list.add(getinfo);
				}
			}
			session.getTransaction().commit();//获取事务并开始与数据库交互。
			return list;//返回获取到的数据
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//若出现错误，则控制台打印错误代码
			session.getTransaction().rollback();//发生错误时回滚当前操作，增加程序的健壮性。
		}finally {
			HibernateUtils.closeSession(session);//关闭事务
		}
		return null;
	}

	@Override
	public List userInfoQueryByPhone(String phone) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			ArrayList list=new ArrayList();
			session = HibernateUtils.getSession();//获取session对象
			session.beginTransaction();//开始session事务
			
			List userInfo=session.createQuery("from UserInfo uif where uif.phone=?").setParameter(0, phone).list();
			for(Iterator iter=userInfo.iterator();iter.hasNext();){//迭代获取查询的数据
				UserInfo getinfo=(UserInfo)iter.next();
				if(getinfo.getUserId()!=null){
					list.add(getinfo);
				}
			}
			session.getTransaction().commit();//获取事务并开始与数据库交互。
			return list;//返回获取到的数据
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//若出现错误，则控制台打印错误代码
			session.getTransaction().rollback();//发生错误时回滚当前操作，增加程序的健壮性。
		}finally {
			HibernateUtils.closeSession(session);//关闭事务
		}
		return null;
	}
	
	@Override
	public List userInfoQueryByEmail(String email) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			ArrayList list=new ArrayList();
			session = HibernateUtils.getSession();//获取session对象
			session.beginTransaction();//开始session事务
			
			List userInfo=session.createQuery("from UserInfo uif where uif.email=?").setParameter(0, email).list();
			for(Iterator iter=userInfo.iterator();iter.hasNext();){//迭代获取查询的数据
				UserInfo getinfo=(UserInfo)iter.next();
				if(getinfo.getUserId()!=null){
					list.add(getinfo);
				}
			}
			session.getTransaction().commit();//获取事务并开始与数据库交互。
			return list;//返回获取到的数据
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//若出现错误，则控制台打印错误代码
			session.getTransaction().rollback();//发生错误时回滚当前操作，增加程序的健壮性。
		}finally {
			HibernateUtils.closeSession(session);//关闭事务
		}
		return null;
	}

	@Override
	public List userInfoQueryById(int id) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			ArrayList list=new ArrayList();
			session = HibernateUtils.getSession();//获取session对象
			session.beginTransaction();//开始session事务
			
			List userInfo=session.createQuery("from UserInfo uif where uif.userId=?").setParameter(0, id).list();
			for(Iterator iter=userInfo.iterator();iter.hasNext();){//迭代获取查询的数据
				UserInfo getinfo=(UserInfo)iter.next();
				if(getinfo.getUserId()!=null){
					list.add(getinfo);
				}
			}
			session.getTransaction().commit();//获取事务并开始与数据库交互。
			return list;//返回获取到的数据
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//若出现错误，则控制台打印错误代码
			session.getTransaction().rollback();//发生错误时回滚当前操作，增加程序的健壮性。
		}finally {
			HibernateUtils.closeSession(session);//关闭事务
		}
		return null;
	}

	@Override
	public List userInfoQueryAll() {
		// TODO Auto-generated method stub
		ArrayList<String> messager=new ArrayList<String>();
		messager.add("this function is totuly done.");
		return messager;
	}

	@Override
	public String userInfoInsert(UserInfo uif) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=HibernateUtils.getSession();
			session.beginTransaction();
			session.save(uif);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			return "Fail";
		}finally {
			HibernateUtils.closeSession(session);
		}
		return "Success";
	}

	@Override
	public String userInfoUpdata(UserInfo uif) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=HibernateUtils.getSession();
			session.beginTransaction();
			session.update(uif);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			return "Fail";
		}finally {
			HibernateUtils.closeSession(session);
		}
		return "Success";
	}

	@Override
	public String userInfoDelete(UserInfo uif) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=HibernateUtils.getSession();
			session.beginTransaction();
			session.delete(uif);
			session.getTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			return "Fail";
		}finally {
			HibernateUtils.closeSession(session);
		}
		return "Success";
	}

}
