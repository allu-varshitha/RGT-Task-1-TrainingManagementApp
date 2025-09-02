package com.rgt.employee.entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.rgt.employee.enums.Status;

public class TrainingEntity { 
    private int trainingId;
    private String trainingTitle;
    private LocalDate trainingdueDate;
    private Map<Integer, Status> mapUserWithStatus = new HashMap<>();
    
	public TrainingEntity(int trainingId, String trainingTitle, LocalDate trainingdueDate, Map<Integer, Status> mapUserWithStatus) {
        this.trainingId = trainingId;
        this.trainingTitle = trainingTitle;
        this.trainingdueDate = trainingdueDate;
        this.mapUserWithStatus = mapUserWithStatus;
    }
    
    //  assign training to user
    public void assignTraining(int uid) {
        this.mapUserWithStatus.put(uid, Status.PENDING);
    }
    
    //  mark training as completed
    public void markTrainingCompleted(int muid) {
        if (this.mapUserWithStatus.containsKey(muid)) {
            this.mapUserWithStatus.put(muid, Status.COMPLETED);
        } else {
            System.out.println("User Id is not present in specified training");
        }    
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getTrainingTitle() {
        return trainingTitle;
    }

    public void setTrainingTitle(String trainingTitle) {
        this.trainingTitle = trainingTitle;
    }

    public LocalDate getTrainingdueDate() {
        return trainingdueDate;
    }

    public void setTrainingdueDate(LocalDate trainingdueDate) {
        this.trainingdueDate = trainingdueDate;
    }

    public Map<Integer, Status> getMapUserWithStatus() {
        return mapUserWithStatus;
    }

    @Override
    public String toString() {
        return "trainingId=" + trainingId + ", trainingTitle=" + trainingTitle + ", trainingdueDate=" 
                + trainingdueDate + ", mapUserWithStatus:" + mapUserWithStatus;
    }
}
