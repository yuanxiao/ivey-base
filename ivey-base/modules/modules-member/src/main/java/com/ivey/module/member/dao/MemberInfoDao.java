package com.ivey.module.member.dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.ivey.base.module.dao.member.MemberBaseDao;
import com.ivey.module.member.repo.User;

@Component
public class MemberInfoDao extends MemberBaseDao {

	public List<User> query() {

		List<User> memberList = null;
		List<Map<String, Object>> resultList = jdbcTemplate
				.queryForList("SELECT userId , ADDRESS AS address, EMAIL AS email , MOBILE as mobile , USER_NAME as userName, USER_PWD as userPwd FROM  T_USER ");
		if (resultList != null && resultList.size() > 0) {
			memberList = new ArrayList<User>();
			Iterator<Map<String, Object>> it = resultList.iterator();
			Map<String, Object> entity = null;
			User member = null;
			while (it.hasNext()) {
				member = new User();
				entity = it.next();
				for (Entry<String, Object> entry : entity.entrySet()) {
					String key = entry.getKey();
					Object value = entry.getValue();
					PropertyDescriptor propDesc;
					try {
						propDesc = new PropertyDescriptor(key, User.class);
						Method methodSetUserName = propDesc.getWriteMethod();
						methodSetUserName.invoke(member, value);
						memberList.add(member);
					} catch (IntrospectionException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}

				}

			}

		}
		return memberList;
	}

}
