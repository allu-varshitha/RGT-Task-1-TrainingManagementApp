package com.rgt.employee.service;

import java.util.List;

import com.rgt.employee.entity.TrainingEntity;
import com.rgt.employee.entity.UserEntity;

public interface TrainingManagementService {

    public void addUser(UserEntity ue);

    public void addTraining(TrainingEntity te);

    public void showUsers(List<UserEntity> list);

    public void showTraining(List<TrainingEntity> list);

    public boolean contains(TrainingEntity te, int userId);

    public void getOverDueTrainingsonDueDate(List<TrainingEntity> trainings);
}
