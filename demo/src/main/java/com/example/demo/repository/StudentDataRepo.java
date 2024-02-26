package com.example.demo.repoistory;

import com.example.demo.model.StudentDataModel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Component
public class StudentDataRepo {
    private Map<String, StudentDataModel> studentDataMap;
    private Map<String, ArrayList<StudentDataModel>> universityStudentDataMap;

    public StudentDataRepo() {
        studentDataMap = new HashMap<>();
        universityStudentDataMap = new HashMap<>();
    }

    public StudentDataModel getStudentById(final String id) {
        return studentDataMap.getOrDefault(id, null);
    }

    public StudentDataModel createStudent(final String id, final String name, final String age,final String adhar,final String univ) {
        StudentDataModel newStudentDataModel = new StudentDataModel(id, name, age, adhar, univ);
        studentDataMap.put(id, newStudentDataModel);
        universityStudentDataMap.computeIfAbsent(univ, k->new ArrayList()).add(newStudentDataModel);
        return newStudentDataModel;
    }
    
    public ArrayList<StudentDataModel> getListByUnivName(final String univ){
    	return universityStudentDataMap.getOrDefault(univ,null);
    }
}
