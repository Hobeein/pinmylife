package com.dao.pictureDBC;

import java.util.List;

import com.domain.Picture;

public interface PictureDaoInterface {
	/**
	 * ��ѯ����picture���е�����
	 * @return {@link List} ����List��������picture������,���󷵻�null
	 */
	public List queryAllPicture();
	/**
	 * ͨ���û���id��ѯͼƬ
	 * @param id {@link Integer} �û���id
	 * @return {@link List} ����ĳһ���û���picture���е���������
	 */
	public List queryPictureById(Integer id);
	/**
	 * ����һ��picture���ݵ�picture����
	 * @param pic {@link Picture} ��ֵ��picture����
	 * @return boolean ����һ���жϳɹ���ʧ�ܵĲ���ֵ
	 */
	public boolean insertPicture(Picture pic);
	/**
	 * ����һ��picture����
	 * @param pic {@link Picture} ��ֵ��picture����
	 * @return boolean ����һ���жϳɹ���ʧ�ܵĲ���ֵ
	 */
	public boolean updatePicture(Picture pic);
	/**
	 * ɾ��һ��picture�������
	 * @param pic {@link Picture} ��ֵ��picture����
	 * @return boolean ����һ���жϳɹ���ʧ�ܵĲ���ֵ
	 */
	public boolean deletePicture(Picture pic);
	/**
	 * 
	 * @param firistR {@link Integer} ���ôӵڼ�λ��ʼ��ѯ���±���㿪ʼ
	 * @param maxR {@link Integer} ��������ѯ���� 
	 * @return {@link List} ����list����Ĳ�ѯ���ݣ�����Ϊ���õ��������
	 */
	public List queryPictureForPage(int firistR,int maxR);
}
