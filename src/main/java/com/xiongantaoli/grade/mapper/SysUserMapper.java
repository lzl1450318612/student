package com.xiongantaoli.grade.mapper;

import java.util.List;

import com.xiongantaoli.grade.entity.SysUser;

public interface SysUserMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysUser record);

	int insertSelective(SysUser record);

	SysUser selectByPrimaryKey(Long id);
	
	/**
	 * 根据用户名查找唯一用户
	 * @param userName
	 * @return
	 */
	SysUser selectByUsername(String userName);

	/**
	 *  根据条件查询用户信息
	 * 
	 * @param user
	 * @return
	 */
	List<SysUser> selectByUser(SysUser user);
	
	

	int updateByPrimaryKeySelective(SysUser record);

	int updateByPrimaryKey(SysUser record);
}