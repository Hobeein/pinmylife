package com.dao.pictureDBC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.domain.Picture;
import com.utils.HibernateUtils;

public class PictureDaoImp implements PictureDaoInterface {

	@Override
	public List queryAllPicture() {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			List sendBackList = new ArrayList();
			session = HibernateUtils.getSession();
			session.beginTransaction();
			List pifList = session.createQuery("from Picture pic").list();
			for(Iterator iter = pifList.iterator();iter.hasNext();){
				Picture pic = (Picture) iter.next();
				if(pic.getPictureId()!=null){
					sendBackList.add(pic);
				}
			}
			session.getTransaction().commit();
			return sendBackList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
		return null;
	}

	@Override
	public List queryPictureById(Integer id) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			List sendBackList = new ArrayList();
			session = HibernateUtils.getSession();
			session.beginTransaction();
			List pifList = session.createQuery("from Picture pic where pic.userInfo.userId=?").setParameter(0, id).list();
			for(Iterator iter = pifList.iterator();iter.hasNext();){
				Picture pic = (Picture) iter.next();
				if(pic.getPictureId()!=null){
					sendBackList.add(pic);
				}
			}
			session.getTransaction().commit();
			return sendBackList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
		return null;
	}

	@Override
	public boolean insertPicture(Picture pic) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			session.save(pic);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().commit();
			return false;
		}finally {
			HibernateUtils.closeSession(session);
		}
		return true;
	}

	@Override
	public boolean updatePicture(Picture pic) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			session.update(pic);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().commit();
			return false;
		}finally {
			HibernateUtils.closeSession(session);
		}
		return true;
	}

	@Override
	public boolean deletePicture(Picture pic) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			session.delete(pic);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().commit();
			return false;
		}finally {
			HibernateUtils.closeSession(session);
		}
		return true;
	}

	@Override
	public List queryPictureForPage(int firistR,int maxR){
		//TODO:图片数据表分页查询方法
		Session session=null;
		try {
			List sendBackList = new ArrayList();
			session = HibernateUtils.getSession();
			session.beginTransaction();
			List pifList = session.createQuery("from Picture pic order by id desc").setFirstResult(firistR).setMaxResults(maxR).list();
			for(Iterator iter = pifList.iterator();iter.hasNext();){
				Picture pic = (Picture) iter.next();
				if(pic.getPictureId()!=null){
					sendBackList.add(pic);
				}
			}
			session.getTransaction().commit();
			return sendBackList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
		return null;
	}
}
