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
        user.add(ue);//Takes a UserEntity object (ue) and adds it to the user list
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
        return te.getMapUserWithStatus().containsKey(userId);//Calls getMapUserWithStatus() on the TrainingEntity 
                                                            //and Checks if the map has the given userId as a key. 
    }

    @Override
    public void getOverDueTrainingsonDueDate(List<TrainingEntity> trainings) {
    	// TODO Auto-generated method stub
    	LocalDate today = LocalDate.now();//Gets the current date.
    	for(TrainingEntity te:trainings) { //iterating the total training list using foreach
    		for(Map.Entry<Integer,Status> entry:te.getMapUserWithStatus().entrySet()) { // converting hashmap into set 
    			if(entry.getValue().equals(Status.PENDING)&&te.getTrainingdueDate().isBefore(today)){
    				//getKey-->userId and getvalue-->pending/completed and checks that any pending status that too before curr date -->true-->overdue
    				System.out.println("User ID: " + entry.getKey() + ", Training: " + te.getTrainingTitle() + ", Due Date: " + te.getTrainingdueDate()); 
    			}else {
    				System.out.println("No pending trainings left with respect to dueDate of trainings");
    			}
    		}
    	}

    }
    
}
