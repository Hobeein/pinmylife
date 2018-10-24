package com.services;

import java.util.List;

import com.domain.UserInfo;

public interface UserInfoServicesInterface {
	/**
	 * ���û���Ϊ����Ĳ�ѯ
	 * @param name String �����û���
	 * @return List ���صĲ�ѯ�����һ��List���ַ������顣
	 */
	public List userInfoQueryByName(String name);
	/**
	 * ���û��ֻ�������Ϊ����Ĳ�ѯ
	 * @param poe String �����û��ֻ����û�����
	 * @return List ���صĲ�ѯ�����һ��List���ַ������顣
	 */
	public List userInfoQueryByPhone(String phone);
	/**
	 * ���û��ֻ�������Ϊ����Ĳ�ѯ
	 * @param poe String �����û��ֻ����û�����
	 * @return List ���صĲ�ѯ�����һ��List���ַ������顣
	 */
	public List userInfoQueryByEmail(String email);
	/**
	 * ���û�idΪ����Ĳ�ѯ
	 * @param id int �����û�id
	 * @return List ���صĲ�ѯ�����һ��List���ַ������顣
	 */
	public List userInfoQueryById(int id);
	/**
	 * ��ѯ�����û����е�����
	 * @return List ���صĲ�ѯ�����һ��List���ַ������顣
	 */
	public List userInfoQueryAll();
	/**
	 * �����û����ݵ����ݿ�
	 * @param uif �û�user����
	 * @return String ����һ���ɹ���success����ʧ�ܡ�fail�����ַ�����
	 */
	public String userInfoInsert(UserInfo uif);
	/**
	 * �����û����ݵ����ݿ�
	 * @param uif �û���user����
	 * @return String ����һ���ɹ���success����ʧ�ܡ�fail�����ַ�����
	 */
	public String userInfoUpdata(UserInfo uif);
	/**
	 * ɾ���û������ݿ�����ݣ��˲���Ԥ��������Աʹ�ã�
	 * @param uif �û���user����
	 * @return String ����һ���ɹ���success����ʧ�ܡ�fail�����ַ�����
	 */
	public String userInfoDelete(UserInfo uif);
	
}
