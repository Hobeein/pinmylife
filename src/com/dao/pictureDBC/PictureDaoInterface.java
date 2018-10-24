package com.dao.pictureDBC;

import java.util.List;

import com.domain.Picture;

public interface PictureDaoInterface {
	/**
	 * 查询所有picture表中的数据
	 * @return {@link List} 返回List包含所有picture的数据,错误返回null
	 */
	public List queryAllPicture();
	/**
	 * 通过用户的id查询图片
	 * @param id {@link Integer} 用户的id
	 * @return {@link List} 返回某一个用户的picture表中的所有数据
	 */
	public List queryPictureById(Integer id);
	/**
	 * 插入一条picture数据到picture表中
	 * @param pic {@link Picture} 赋值的picture对象
	 * @return boolean 返回一个判断成功或失败的布尔值
	 */
	public boolean insertPicture(Picture pic);
	/**
	 * 更新一条picture数据
	 * @param pic {@link Picture} 赋值的picture对象
	 * @return boolean 返回一个判断成功或失败的布尔值
	 */
	public boolean updatePicture(Picture pic);
	/**
	 * 删除一条picture表的数据
	 * @param pic {@link Picture} 赋值的picture对象
	 * @return boolean 返回一个判断成功或失败的布尔值
	 */
	public boolean deletePicture(Picture pic);
	/**
	 * 
	 * @param firistR {@link Integer} 设置从第几位开始查询，下标从零开始
	 * @param maxR {@link Integer} 设置最大查询条数 
	 * @return {@link List} 返回list对象的查询数据，条数为设置的最大条数
	 */
	public List queryPictureForPage(int firistR,int maxR);
}
