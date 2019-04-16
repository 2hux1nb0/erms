package cn.classroom.dao;

import java.util.List;

import cn.classroom.domain.Classroom;

//?????????classroom????????
public interface ClassroomDao {

	void addClassroom(Classroom classroom);

	void updateClassroom(Classroom classroom);

	void deleteClassroom(String room_no);

	// Classroom findClassroom(String room_no);

	boolean findClassroom(String room_no);

	List<Classroom> getAll();

}