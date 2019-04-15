
			id                varchar(40) not null,primary key
			username          varchar(20) not null
			password          varchar(32) not null
			type              varchar(3) not null
		2.锟斤拷锟揭憋拷classroom
			room_no           varchar(4) not null,primary key
			location          varchar(40) not null
		3.锟轿程憋拷course
			course_id         varchar(4) not null,primary key
			name              varchar(20) not null
			teacher           varchar(20) not null
		4.锟轿筹拷-锟斤拷锟揭帮拷锟脚憋拷arrangement
			id                varchar(40) not null,primary key
			room_no           varchar(4) not null
			course_id         varchar(4) not null
			day               int(1) not null
			start_section     int(1) not null
			end_section       int(1) not null
		5.锟筋动锟斤拷activity
			aid               varchar(40) not null,primary key
			name              varchar(40) not null
			room_no           varchar(4) not null
			day               int(1) not null
			start_section     int(1) not null
			end_section       int(1) not null
			status            int(1)
			
锟斤拷.锟筋建锟斤拷锟斤拷锟斤拷锟斤拷
	1.锟斤拷锟矫伙拷锟斤拷
		锟斤拷要:
		MyEclipse 6.6
		MySql 5.0
		Apache-Tomcat-6.0.44
		锟斤拷锟斤拷:
		Dreamweaver CS6
		Photoshop CS6
	2.锟斤拷锟斤拷锟斤拷锟斤拷
		Java,Jsp
	3.锟斤拷锟斤拷芄锟�
		B/S
	4.锟斤拷锟斤拷要锟斤拷锟解部jar锟斤拷
		mysql锟斤拷
        beanUtils
        log4j锟斤拷锟斤拷
        jstl锟斤拷锟斤拷锟斤拷
        
锟斤拷.锟斤拷锟斤拷锟斤拷织锟斤拷锟斤拷陌锟�	
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
		