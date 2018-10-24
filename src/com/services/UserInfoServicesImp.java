package com.services;

import java.util.List;

import com.dao.userInfoDBC.UserInfoDaoImp;
import com.dao.userInfoDBC.UserInfoDaoInterface;
import com.domain.UserInfo;

public class UserInfoServicesImp implements UserInfoServicesInterface {
	
	UserInfoDaoInterface userInfoDao=new UserInfoDaoImp();
	
	@Override
	public List userInfoQueryByName(String name) {
		// TODO Auto-generated method stub
		return userInfoDao.userInfoQueryByName(name);
	}

	@Override
	public List userInfoQueryByPhone(String phone) {
		// TODO Auto-generated method stub
		return userInfoDao.userInfoQueryByPhone(phone);
	}

	@Override
	public List userInfoQueryByEmail(String email) {
		// TODO Auto-generated method stub
		return userInfoDao.userInfoQueryByEmail(email);
	}

	@Override
	public List userInfoQueryById(int id) {
		// TODO Auto-generated method stub
		return userInfoDao.userInfoQueryById(id);
	}

	@Override
	public List userInfoQueryAll() {
		// TODO Auto-generated method stub
		return userInfoDao.userInfoQueryAll();
	}

	@Override
	public String userInfoInsert(UserInfo uif) {
		// TODO Auto-generated method stub
		return userInfoDao.userInfoInsert(uif);
	}

	@Override
	public String userInfoUpdata(UserInfo uif) {
		// TODO Auto-generated method stub
		return userInfoDao.userInfoUpdata(uif);
	}

	@Override
	public String userInfoDelete(UserInfo uif) {
		// TODO Auto-generated method stub
		return userInfoDao.userInfoDelete(uif);
	}
}
