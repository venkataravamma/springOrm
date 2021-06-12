package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context =new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
		/*
		 * Student student=new Student(1234,"sujiki","guntur"); int r=
		 * studentDao.insert(student); System.out.println("done"+r);
		 */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while(go) {
        System.out.println("PRESS 1 for add new student");
        System.out.println("PRESS 2 for display all student");
        System.out.println("PRESS 3 for get details of single  student");
        System.out.println("PRESS 4 for delete student");
        System.out.println("PRESS 5 for uodate  student");
        System.out.println("PRESS 6 for exit");
        try {
        	int input=Integer.parseInt(br.readLine());
        	switch(input) {
        	case 1:
        		//add new student
        		//taking input from users
        		System.out.println("Enter user id:");
        		int uId=Integer.parseInt(br.readLine());
        		
        		System.out.println("enter user name:");
        		String uName=br.readLine();
        		
        		System.out.println("enter city:");
        		String uCity=br.readLine();
        		
        		//creating student obj to add new student
        		Student student=new Student();
        		 student.setStudentId(uId);
        		 student.setStudentName(uName);
        		 student.setStudentCity(uCity);
        		 
        		 // saving student obj
        		int r = studentDao.insert(student);
        		System.out.println(r+" student addedd");
        		System.out.println("================================");
        		break;
        	case 2:
        		//display all student
        		List<Student> allStudents=studentDao.getAllStudent();
        		for(Student s:allStudents) {
        			System.out.println("Id" + s.getStudentId());
        			System.out.println("Name" + s.getStudentName());
        			System.out.println("City" + s.getStudentCity());
        		}
        		System.out.println("*************************************************");
        		break;
        	case 3:
        		//get single student data
        		System.out.println("***************************************************");
        		System.out.println("Enter userId:");
        		int userId=Integer.parseInt(br.readLine());
        		Student s=studentDao.getStudent(userId);
;        		System.out.println("Id" + s.getStudentId());
    			System.out.println("Name" + s.getStudentName());
    			System.out.println("City" + s.getStudentCity());
    	
        		break;
        	case 4:
        		//delete student
        		System.out.println("Enter user id:");
        		int id=Integer.parseInt(br.readLine());
        		studentDao.deleteStudent(id);
        		System.out.println("successfully deleted:");
        		break;
        	case 5:
        		//update student
        		
        		break;
        	case 6:
        		//
        		go=false;
        		break;
        	default:
        	
        	
        	}
        }catch(Exception ex) {
        	System.out.println("Invalid input try with another one");
        	System.out.println(ex.getMessage());
        
        }
    
        }
        System.out.println("thankyou for using my application");
        System.out.println("see you soon"
        		);
        
    }

}