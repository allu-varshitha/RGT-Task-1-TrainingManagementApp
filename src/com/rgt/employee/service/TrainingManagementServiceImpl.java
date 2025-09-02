package com.rgt.employee.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rgt.employee.entity.TrainingEntity;
import com.rgt.employee.entity.UserEntity;
import com.rgt.employee.enums.Status;

public class TrainingManagementServiceImpl implements TrainingManagementService {

    List<UserEntity> user = new ArrayList<UserEntity>();
    List<TrainingEntity> trainings = new ArrayList<TrainingEntity>();

    @Override
    public void addUser(UserEntity ue) {    
        user.add(ue);
    }

    @Override
    public void addTraining(TrainingEntity te) {
        trainings.add(te);
    }

    @Override
    public void showUsers(List<UserEntity> list) {
        for (UserEntity ue : list) {
            System.out.println(ue);
        }
    }

    @Override
    public void showTraining(List<TrainingEntity> list) {
        for (TrainingEntity te : list) {
            System.out.println(te);
        }
    }

    @Override
    public boolean contains(TrainingEntity te, int userId) {
        return te.getMapUserWithStatus().containsKey(userId); 
    }

    @Override
    public void getOverDueTrainingsonDueDate(List<TrainingEntity> trainings) {
    	
    	LocalDate today=LocalDate.now();
    	for(TrainingEntity te:trainings) {
    		for(Map.Entry<Integer,Status> entry:te.getMapUserWithStatus().entrySet()) {
    			if(entry.getValue().equals(Status.PENDING) && te.getTrainingdueDate().isBefore(today)) {
    				System.out.println("user id " +entry.getKey()+",Training "+ te.getTrainingTitle() +",Due date " +te.getTrainingdueDate());
    			}
    		}
    	}
    	

    }
    
}
