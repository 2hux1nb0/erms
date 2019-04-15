package cn.classroom.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//������,����dao.properties������Ӧ���ݿ�,��ǿ����ֲ��
public class DaoFactory {
	private Properties daoConfig = new Properties();
	
	private DaoFactory() {
		InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		try {
			daoConfig.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static DaoFactory instance = new DaoFactory();

	public static DaoFactory getInstance() {
		return instance;
	}
	
	public <T> T createDao(Class<T> clazz){
		String name = clazz.getSimpleName();
		String className = daoConfig.getProperty(name);
		try {
			T dao = (T) Class.forName(className).newInstance();
			return dao;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
