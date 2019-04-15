 >-------------------------------���������ģ��-------------------------<
       >---------��һ��00x1----------<
       banben版本0.0.2/15:03:42
һ.������ݿ�classroom_manage
	���ı?�ֶ�
		1.�û���user
			id                varchar(40) not null,primary key
			username          varchar(20) not null
			password          varchar(32) not null
			type              varchar(3) not null
		2.���ұ�classroom
			room_no           varchar(4) not null,primary key
			location          varchar(40) not null
		3.�γ̱�course
			course_id         varchar(4) not null,primary key
			name              varchar(20) not null
			teacher           varchar(20) not null
		4.�γ�-���Ұ��ű�arrangement
			id                varchar(40) not null,primary key
			room_no           varchar(4) not null
			course_id         varchar(4) not null
			day               int(1) not null
			start_section     int(1) not null
			end_section       int(1) not null
		5.���activity
			aid               varchar(40) not null,primary key
			name              varchar(40) not null
			room_no           varchar(4) not null
			day               int(1) not null
			start_section     int(1) not null
			end_section       int(1) not null
			status            int(1)
			
��.���������
	1.���û���
		��Ҫ:
		MyEclipse 6.6
		MySql 5.0
		Apache-Tomcat-6.0.44
		����:
		Dreamweaver CS6
		Photoshop CS6
	2.��������
		Java,Jsp
	3.����ܹ�
		B/S
	4.����Ҫ���ⲿjar��
		mysql��
        beanUtils
        log4j����
        jstl������
        
��.������֯����İ�	
		cn.classroom.dao
		cn.classroom.dao.impl
		cn.classroom.domain
		cn.classroom.service
		cn.classroom.service.impl
		cn.classroom.web.contorller
		cn.classroom.web.formbean
		cn.classroom.web.UI
		cn.classroom.factory
		cn.classroom.utils
		cn.classroom.exception
		junit.test
		
		WEB-INF/jsp
		