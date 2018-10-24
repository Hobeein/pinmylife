package com.services;

import java.util.List;

import com.domain.UserInfo;

public interface UserInfoServicesInterface {
	/**
	 * 以用户名为基点的查询
	 * @param name String 输入用户名
	 * @return List 返回的查询结果是一个List的字符串数组。
	 */
	public List userInfoQueryByName(String name);
	/**
	 * 以用户手机或邮箱为基点的查询
	 * @param poe String 输入用户手机或用户邮箱
	 * @return List 返回的查询结果是一个List的字符串数组。
	 */
	public List userInfoQueryByPhone(String phone);
	/**
	 * 以用户手机或邮箱为基点的查询
	 * @param poe String 输入用户手机或用户邮箱
	 * @return List 返回的查询结果是一个List的字符串数组。
	 */
	public List userInfoQueryByEmail(String email);
	/**
	 * 以用户id为基点的查询
	 * @param id int 输入用户id
	 * @return List 返回的查询结果是一个List的字符串数组。
	 */
	public List userInfoQueryById(int id);
	/**
	 * 查询所有用户表中的数据
	 * @return List 返回的查询结果是一个List的字符串数组。
	 */
	public List userInfoQueryAll();
	/**
	 * 插入用户数据到数据库
	 * @param uif 用户user对象。
	 * @return String 返回一个成功“success”或失败“fail”的字符串。
	 */
	public String userInfoInsert(UserInfo uif);
	/**
	 * 更新用户数据到数据库
	 * @param uif 用户的user对象。
	 * @return String 返回一个成功“success”或失败“fail”的字符串。
	 */
	public String userInfoUpdata(UserInfo uif);
	/**
	 * 删除用户在数据库的数据（此操作预备给管理员使用）
	 * @param uif 用户的user对象。
	 * @return String 返回一个成功“success”或失败“fail”的字符串。
	 */
	public String userInfoDelete(UserInfo uif);
	
}
