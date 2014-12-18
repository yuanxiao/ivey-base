package com.ivey.module.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.ivey.base.module.dao.member.MemberBaseDao;
import com.ivey.commons.utils.RegexUtils;
import com.ivey.module.member.dto.MemberDto;
import com.ivey.module.member.dto.UserDto;

@Component
public class MemberDao extends MemberBaseDao{

	public UserDto getLoginMember(UserDto user){
		String userName = user.getUserName();
		String userPwd = user.getUserPwd();
		boolean emailLogin = RegexUtils.matches(RegexUtils.EMAIL, userName);
		String sql = "";
		if (emailLogin){
			sql = " select  USER_ID AS userId , EMAIL AS email ,MOBILE AS mobile ,USER_NAME AS userName ,USER_PWD AS  userPwd,USER_TYPE AS userType  from t_user where  email = ? and user_pwd = ?";
		}else{
			boolean mobileLogin = RegexUtils.matches(RegexUtils.MOBILEPHONE, userName);
			if (mobileLogin){
				sql = " select    USER_ID AS userId , EMAIL AS email ,MOBILE AS mobile ,USER_NAME AS userName ,USER_PWD AS  userPwd,USER_TYPE AS userType  from t_user where  mobile = ? and user_pwd = ?";
			}else{
				sql = " select   USER_ID AS userId , EMAIL AS email ,MOBILE AS mobile ,USER_NAME AS userName ,USER_PWD AS  userPwd,USER_TYPE AS userType   from t_user where  user_name = ? and user_pwd = ?";
			}

		}
		user = jdbcTemplate.query(sql, new String[] { userName, userPwd }, new ResultSetExtractor<UserDto>(){

			public UserDto extractData(ResultSet rs) throws SQLException,DataAccessException{
				UserDto user = null;
				if (rs.next()){
					user = new UserDto();
					fillEntity(user, rs);
				}
				return user;
			}
		});
		return user;
	}

	public MemberDto getMemberInfo(String nick){

		MemberDto memberDto = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append(" TI.ID AS id,  ");
		sql.append(" TI.USER_ID AS userId,  ");
		sql.append(" 	TI.AVATAR AS avatar, ");
		sql.append(" 		TI.BIRTHDAY AS birthday , ");
		sql.append(" 		TI.CITY AS city, ");
		sql.append(" 		TI.DISTRICT AS district, ");
		sql.append(" 		TI.EMAIL AS email, ");
		sql.append(" 		TI.FIRST_NAME AS firstName, ");
		sql.append(" 		TI.LAST_NAME AS lastName, ");
		sql.append(" 		TI.MOBILE_PHONE AS mobile, ");
		sql.append(" 		TI.PROVINCE AS province, ");
		sql.append(" 		TI.SEX AS sex, ");
		sql.append(" 		TI.TEL_PHONE AS telPhone ");
		sql.append(" FROM  T_MEMBER_INFO TI,    T_USER TU	");
		sql.append(" WHERE  TI.USER_ID = TU.USER_ID  ");
		sql.append(" AND TU.USER_NAME =  ?");

		memberDto = jdbcTemplate.query(sql.toString(), new String[] { nick }, new ResultSetExtractor<MemberDto>(){

			public MemberDto extractData(ResultSet rs) throws SQLException,DataAccessException{
				MemberDto memberDto = new MemberDto();
				if (rs.next()){
					fillEntity(memberDto, rs);
				}
				return memberDto;
			}
		});
		return memberDto;
	}

	public MemberDto getMemberInfo(Long memberId){
		return null;
	}

}
