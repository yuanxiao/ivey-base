package com.ivey.module.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.ivey.base.module.dao.member.MemberBaseDao;
import com.ivey.commons.utils.RegexUtils;
import com.ivey.module.member.dto.UserDto;

@Component
public class UserDao extends MemberBaseDao {

	public UserDto getUser(UserDto user) {
		String userName = user.getUserName();
		String userPwd = user.getUserPwd();
		boolean emailLogin = RegexUtils.matches(RegexUtils.EMAIL, userName);
		String sql = "";
		if (emailLogin) {
			sql = " select * from t_user where  email = ? and user_pwd = ?";
		} else {
			boolean mobileLogin = RegexUtils.matches(RegexUtils.MOBILEPHONE, userName);
			if (mobileLogin) {
				sql = " select * from t_user where  mobile = ? and user_pwd = ?";
			} else {
				sql = " select * from t_user where  user_name = ? and user_pwd = ?";
			}

		}
		user = jdbcTemplate.query(sql, new String[] { userName, userPwd }, new ResultSetExtractor<UserDto>() {
			public UserDto extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserDto user = null;
				if (rs.next()) {
					user = fillEntity(rs);
				}
				return user;
			}
		});
		return user;
	}

	private UserDto fillEntity(ResultSet rs) throws SQLException {
		UserDto user = new UserDto();
		Long userId = rs.getLong("USER_ID");
		String userName = rs.getString("USER_NAME");
		String mobile = rs.getString("MOBILE");
		String email = rs.getString("EMAIL");
		String userPwd = rs.getString("USER_PWD");
		String userType = rs.getString("USER_TYPE");
		user.setUserId(userId);
		user.setUserName(userName);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setUserPwd(userPwd);
		user.setUserType(userType);
		return user;
	}
}
