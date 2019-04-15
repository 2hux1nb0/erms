package cn.classroom.service;

import cn.classroom.domain.QueryResult;
import cn.classroom.domain.User;
import cn.classroom.exception.UserExistException;

//ҵ����Ľӿ�
public interface BusinessService {

	// ��web���ṩע�����
	void register(User user) throws UserExistException;

	// ��web���ṩ��¼����
	User login(String username, String password, String type);

	QueryResult queryUser();
	
	QueryResult queryClassroom();
	
	QueryResult queryCourse();
	
	QueryResult queryActivity();
}