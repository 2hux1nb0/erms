package cn.classroom.service.impl;

import java.util.List;

import cn.classroom.dao.ActivityDao;
import cn.classroom.dao.ClassroomDao;
import cn.classroom.dao.CourseDao;
import cn.classroom.dao.UserDao;
import cn.classroom.dao.impl.ActivityDaoImpl;
import cn.classroom.dao.impl.ClassroomDaoImpl;
import cn.classroom.dao.impl.CourseDaoImpl;
import cn.classroom.dao.impl.UserDaoImpl;
import cn.classroom.domain.QueryResult;
import cn.classroom.domain.User;
import cn.classroom.exception.UserExistException;
import cn.classroom.factory.DaoFactory;
import cn.classroom.service.BusinessService;
import cn.classroom.utils.WebUtils;

//��web���ṩ���е�ҵ�����
public class BusinessServiceImpl implements BusinessService {

	//����ģʽ spring
	private UserDao dao = DaoFactory.getInstance().createDao(UserDao.class);

	// ��web���ṩע�����
	public void register(User user) throws UserExistException {
		// ���жϵ�ǰҪע����û��Ƿ����
		Boolean b = dao.findUser(user.getUsername());
		if (b) {
			throw new UserExistException(); // ����Ҫע����û��Ѵ���,���web����һ������ʱ�쳣,����web�㴦������쳣,���û�һ���Ѻ���ʾ
		} else {
			user.setPassword(WebUtils.md5(user.getPassword()));
			dao.addUser(user);
		}
	}

	// ��web���ṩ��¼����
	public User login(String username, String password, String type) {
		password = WebUtils.md5(password);
		return dao.findUser(username, password, type);
	}

	// ��ѯ�����û���Ϣ
	public QueryResult queryUser() {
		QueryResult qr = new QueryResult();
		UserDao dao = new UserDaoImpl();
		List list = dao.getAll();
		qr.setList(list);
		return qr;
	}

	// ��ѯ���н�����Ϣ
	public QueryResult queryClassroom() {
		QueryResult qr = new QueryResult();
		ClassroomDao dao = new ClassroomDaoImpl();
		List list = dao.getAll();
		qr.setList(list);
		return qr;
	}

	// ��ѯ���пγ���Ϣ
	public QueryResult queryCourse() {
		QueryResult qr = new QueryResult();
		CourseDao dao = new CourseDaoImpl();
		List list = dao.getAll();
		qr.setList(list);
		return qr;
	}

	// ��ѯ���л������Ϣ
	public QueryResult queryActivity() {
		QueryResult qr = new QueryResult();
		ActivityDao dao = new ActivityDaoImpl();
		List list = dao.getAll();
		qr.setList(list);
		return qr;
	}
}
