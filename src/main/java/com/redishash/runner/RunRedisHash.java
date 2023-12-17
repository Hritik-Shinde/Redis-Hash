package com.redishash.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.redishash.dao.StudentDao;
import com.redishash.model.Student;

@Component
public class RunRedisHash implements CommandLineRunner {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public void run(String... args) throws Exception {
		
		studentDao.addStudent(new Student(1,10,"Hritik","abc"));
		studentDao.addStudent(new Student(2,11,"Shinde","abc123"));
		studentDao.addStudent(new Student(3,12,"Hrx","123"));
		studentDao.addStudent(new Student(4,13,"Hii","124"));
		studentDao.addStudent(new Student(5,14,"Hritik1","abc11"));
		System.out.println("All Data");
		studentDao.getAllStudent().forEach((k,v)->System.out.println(k+"----"+v));
		System.out.println(studentDao.getOneStudent(4));   
		studentDao.deleteStudent(5);
		studentDao.updateStudent(new Student(4,13,"hritik123","xzy"));
		System.out.println("After Modification");
		studentDao.getAllStudent().forEach((k,v)->System.out.println(k+"----"+v));
		

	}

}
