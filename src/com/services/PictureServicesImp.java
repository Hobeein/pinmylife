package com.services;

import java.util.List;

import com.dao.pictureDBC.PictureDaoImp;
import com.dao.pictureDBC.PictureDaoInterface;
import com.domain.Picture;

public class PictureServicesImp implements PictureServicesInterface {
	
	PictureDaoInterface picDao = new PictureDaoImp();
	
	@Override
	public List queryAllPicture() {
		// TODO Auto-generated method stub
		return picDao.queryAllPicture();
	}

	@Override
	public List queryPictureById(Integer id) {
		// TODO Auto-generated method stub
		return picDao.queryPictureById(id);
	}

	@Override
	public boolean insertPicture(Picture pic) {
		// TODO Auto-generated method stub
		return picDao.insertPicture(pic);
	}

	@Override
	public boolean updatePicture(Picture pic) {
		// TODO Auto-generated method stub
		return picDao.updatePicture(pic);
	}

	@Override
	public boolean deletePicture(Picture pic) {
		// TODO Auto-generated method stub
		return picDao.deletePicture(pic);
	}
	
	@Override
	public List queryPictureForPage(int firistR, int maxR) {
		// TODO Auto-generated method stub
		return picDao.queryPictureForPage(firistR, maxR);
	}
}
