package cyiq.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang.StringUtils;

import cyiq.bean.User;
import cyiq.dao.UserDao;
import cyiq.utils.JDBCUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User login(User user) {
		Connection conn = null;
		User newUser = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select userID,userName,loginName,loginPwd,sex,birthday,education,"
					+ "telephone,interest,path,filename,remark from s_user "
					+ "where loginName=? and loginPwd=?";
			Object[] params = {user.getLoginName(),user.getLoginPwd()};
			QueryRunner query = new QueryRunner();
			newUser = query.query(conn, sql, new BeanHandler<User>(User.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		return newUser;
	}

	@Override
	public void save(User user) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into s_user (userID,userName,loginName,loginPwd,sex,birthday,"
					+ "education,telephone,interest,path,filename,remark)"
					+ " values(null,?,?,?,?,?,?,?,?,?,?,?)";
			Object[] params = {user.getUserName(),user.getLoginName(),user.getLoginPwd(),user.getSex(),
					user.getBirthday(),user.getEducation(),user.getTelephone(),user.getInterest(),
					user.getPath(),user.getFilename(),user.getRemark()
			};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
	}

	@Override
	public List<User> findUsersByCondition(User user) {
		Connection conn = null;
		List<User> userList = null;
		try {
			conn = JDBCUtils.getConnection();
			StringBuffer stringBuffer = new StringBuffer();
			List paramsList = new ArrayList();
			if(StringUtils.isNotBlank(user.getUserName())){
				stringBuffer.append("and userName like ? ");
				paramsList.add("%"+user.getUserName()+"%");
			}
			if(StringUtils.isNotBlank(user.getSex())){
				stringBuffer.append("and sex=?");
				paramsList.add(user.getSex());
			}
			if(StringUtils.isNotBlank(user.getEducation())){
				stringBuffer.append("and education=? ");
				paramsList.add(user.getEducation());
			}
			if("2".equals(user.getIsUpload())){
				stringBuffer.append("and path is NULL or path=''");
			}
			if("1".equals(user.getIsUpload())){
				stringBuffer.append("and path is NOT NULL and filename <> '' ");
			}
			String sql = "select userID,userName,loginName,loginPwd,sex,birthday,education,"
					+ "telephone,interest,path,filename,remark from s_user "
					+ "where 1=1 "+stringBuffer.toString();
			System.out.println(sql);
			Object[] params = paramsList.toArray();
			QueryRunner query = new QueryRunner();
			userList = query.query(conn, sql, new BeanListHandler<User>(User.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		return userList;
	}

	@Override
	public User findUsersById(Integer userID) {
		Connection conn = null;
		User newUser = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select userID,userName,loginName,loginPwd,sex,birthday,education,"
					+ "telephone,interest,path,filename,remark from s_user "
					+ "where userID=?";
			Object[] params = {userID};
			QueryRunner query = new QueryRunner();
			newUser = query.query(conn, sql, new BeanHandler<User>(User.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		return newUser;
	}

	@Override
	public void update(User user) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update  s_user set userName=?,loginName=?,loginPwd=?,sex=?,birthday=?,"
					+ "education=?,telephone=?,interest=?,path=?,filename=?,remark=? "
					+ "where userID=?";
			Object[] params = {user.getUserName(),user.getLoginName(),user.getLoginPwd(),user.getSex(),
					user.getBirthday(),user.getEducation(),user.getTelephone(),user.getInterest(),
					user.getPath(),user.getFilename(),user.getRemark(),user.getUserID()
			};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		
	}

	@Override
	public void delete(Integer userID) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "delete from  s_user where userID=?";
			Object[] params = {userID};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
	}

}
