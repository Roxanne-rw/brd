package com.zzy.brd.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.zzy.brd.entity.Role;
import com.zzy.brd.entity.User;
import com.zzy.brd.entity.User.State;
import com.zzy.brd.entity.User.UserType;

//数据库的声明利用herbinate
//未用到

public interface UserDao extends BaseDao<User>{

	User findByUsername(String username);

	@Query("select u from User u where u.username=?1 and u.state !=2")
	List<User> findByUsername1(String username);

	@Query("select u from User u where u.realname = ?1 and u.userType = ?2")
	User findByRealname(String realname, UserType type);

	List<User> findByRole(Role role);
	/** 查询 ：根据手机号 */
	@Query("select u from User u where u.mobileno=?1 and u.state != 2")
	User findByMobileno(String mobileno);

	@Query("select u from User u where u.mobileno=?1 and u.state != 2")
	List<User> findByMobileno1(String mobileno);

	@Query("select u from User u where u.mobileno=?1 and  u.userType in ?2  and u.state != 2")
	List<User> findByMobileno2(String mobileno,List<UserType> userTypeList);



	@Query("select u from User u where (u.userType='0' or u.userType='1' or u.userType='2' or u.userType='4' ) and u.state !='2' ")
	List<User> findStatisticsUser();

	/**
	 * 删除
	 *
	 * @param @param deleteId
	 * @param @param del
	 * @return void
	 */
	@Modifying
	@Query(value="update User set state = ?2 where id = ?1")
	void delUser(Long deleteId,State del);

	/**
	 * 停用或启用
	 * @param userId
	 * @param state
	 * @return
	 */
	@Modifying
	@Query(value = "update User set state = ?2 where id = ?1")
	boolean updateWithState(long userId,State state);



	/**
	 * 通过userType查找
	 * @param
	 * @return
	 */
	@Query("select count(*) from User u where u.userType=?1")
	int findUserCount(User.UserType userType);
	/**
	 * 通过userTypeh 和创建时间 查找
	 * @param
	 * @return
	 */
	@Query("select count(*) from User u where u.userType=?1 and u.createdate between ?2 and ?3")
	int findUserCount(User.UserType userType,Date start,Date end);

	/**
	 * 根据用户类型查找非删除的所有用户
	 * @param
	 * @return
	 */
	@Query("select u from User u where u.state = ?1 ")
	List<User> findUsersNoDel(State state);



	/**
	 * @param mobileno
	 * @param realname
	 * @param username
	 * @return
	 */
	@Query("select u from User u where u.state = 1 and u.userType in (0,1,2,4) and (u.username like %?1% "
			+ "and u.realname like %?2% and u.mobileno like %?3%) order by u.id")
	List<User> listAllUsers(String username, String realname, String mobileno);



	/**通过用户类型找到列表
	 * @param user
	 *
	 */
	@Query("select u from User u where u.userType =?1  ")
	List<User> findUserByUsertype(UserType userType);



	/****
	 * 根据 号码和用户类型
	 *
	 */
	@Query("select u from User u where u.mobileno=?1 and u.userType in ( ?2 ) and u.state!='2' ")
	User findByMobileAndUerType(String mobile,List<UserType> typeList);

	/**
	 * 根据用户名查询
	 *
	 **/
	@Query("select u from User u where u.username = ?1 and u.userType in ( ?2 ) and u.state!='2' ")
	User findByUserNameAndUserType(String username,List<UserType> typeList);

}
