package com.example.demo.service;

import com.example.demo.model.StudentDataModel;
import com.example.demo.repoistory.StudentDataRepo;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.ArrayList;

@Service
public class StudentService {

    @Autowired
    public StudentDataRepo studentDataRepo;

    public String createStudent(final String studentName, final String studentAge,final String adhar, final String univ) {
        String randomId = UUID.randomUUID().toString();
        StudentDataModel studentDataModel =  studentDataRepo.createStudent(randomId, studentName, studentAge,adhar,univ);
        return studentDataModel.getId();
    }

    public StudentDataModel getStudent(final String id) throws BadRequestException {
        StudentDataModel studentDataModel = studentDataRepo.getStudentById(id);

        if(studentDataModel == null) {
            throw new BadRequestException("Invalid User");
        }

        return studentDataModel;
    }

    public ArrayList<StudentDataModel> getStudents(final String univ) throws BadRequestException {
    	ArrayList<StudentDataModel> listOfStudents = studentDataRepo.getListByUnivName(univ);
    	
    	if(listOfStudents == null){
    		throw new BadRequestException("Invalid Univ");
    	}
    	return listOfStudents;
    }
}
