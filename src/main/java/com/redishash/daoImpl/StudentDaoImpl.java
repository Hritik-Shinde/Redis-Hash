package com.redishash.daoImpl;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Repository;

import com.redishash.dao.StudentDao;
import com.redishash.model.Student;

import jakarta.annotation.Resource;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	
	private final String KEY = "STUDENT";
	
	
	/*
	 *  To perform hash operation  
	 *  Takes refrencetype , keyType , valueType
	 *  to perform hash operation it sould be connected to redis templete
	 */
	@Resource(name = "redisTemplate") // name of methord use in redis config
	private HashOperations<String,Integer,Student> perform;

	@Override
	public void addStudent(Student student) {
		//create new record in hash memory if Id is not present
		perform.putIfAbsent(KEY, student.getStdId(), student);
	}

	@Override
	public void updateStudent(Student student) {
		perform.put(KEY, student.getStdId(), student);
		
	}

	@Override
	public void deleteStudent(Integer id) {
		perform.delete(KEY, id);
		
	}

	@Override
	public Student getOneStudent(Integer Id) {
		// TODO Auto-generated method stub
		return perform.get(KEY, Id);
	}

	@Override
	public Map<Integer, Student> getAllStudent() {
		// TODO Auto-generated method stub
		return perform.entries(KEY);
	}

}
