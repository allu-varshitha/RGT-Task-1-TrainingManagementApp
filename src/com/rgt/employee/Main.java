package com.rgt.employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.rgt.employee.entity.TrainingEntity;
import com.rgt.employee.entity.UserEntity;
import com.rgt.employee.enums.Role;
import com.rgt.employee.service.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<UserEntity> user = new ArrayList<>();//user-->stores all user entity objects
        List<TrainingEntity> training = new ArrayList<>();//stores training entity objects
        TrainingManagementService service = new TrainingManagementServiceImpl();//calling obj ref of interface or impl class

        // Add users
        UserEntity user1 = new UserEntity(1, "Varshitha", Role.ADMIN);
        UserEntity user2 = new UserEntity(2, "Naveen", Role.HR);
        UserEntity user3 = new UserEntity(3, "Krishna", Role.EMPLOYEE);
        UserEntity user4 = new UserEntity(4, "Kiran", Role.EMPLOYEE);
        UserEntity user5 = new UserEntity(5, "Radhaa", Role.EMPLOYEE);
        user.add(user1);  //adds them to user list  
        user.add(user2);
        user.add(user3);
        user.add(user4);
        user.add(user5);

        // Add trainings
        TrainingEntity training1 = new TrainingEntity(101, "Java Training", LocalDate.of(2025, 10, 14), new HashMap<>());
        TrainingEntity training2 = new TrainingEntity(201, "React Training", LocalDate.of(2025, 07, 10), new HashMap<>());
        TrainingEntity training3 = new TrainingEntity(301, "MYSQL Training", LocalDate.of(2026, 12, 14), new HashMap<>());
        TrainingEntity training4 = new TrainingEntity(401, "PowerBi Training", LocalDate.of(2022,02, 05), new HashMap<>());
        TrainingEntity training5 = new TrainingEntity(501, "Devops Training", LocalDate.of(2016, 05, 01), new HashMap<>());        
        training.add(training1);//adds to the training list
        training.add(training2);
        training.add(training3);
        training.add(training4);
        training.add(training5);

        int ch;

        do {
            System.out.println("____________________________________");
            System.out.println("Choose:\n1.Show Users\n2.Show Training \n3.Assign Training To Individual User\n4.Assign Training To Multiple Users\n5.Mark Training As Completed\n6.Get All Trainings Of a User(both pending/completed)\n7.Get pending Overdue trainings with their due dates ");
            System.out.println("____________________________________");
            System.out.println("Enter Your Choice : ");
            ch = sc.nextInt();//reads the users choice 
                    
            switch(ch) {
                case 1:
                    System.out.println("User Details Are:");
                    service.showUsers(user); //calls show user to display  users
                    break;

                case 2:
                    System.out.println("Training Related Details Are:");
                    service.showTraining(training); //calls show trainings to display trainings
                    break;

                case 3://input-tid,uid(gettid==tid)
                    System.out.println("Assigning Training for an individual User: ");
                    System.out.println("Select Training Id to assign");
                    service.showTraining(training); 
                    int tid = sc.nextInt();
                    System.out.println("Select User Id ");
                    service.showUsers(user); 
                    int uid = sc.nextInt();
                    for (TrainingEntity te : training) {
                        if (te.getTrainingId() == tid) {//checks that matching training id if it is matched thenassigned to user
                            te.assignTraining(uid); 
                        }
                    }
                    break;

                case 4:// Input - Training id, multiple user ids (,)
                    System.out.println("Assigning Training for Multiple Users: ");
                    System.out.println("Select Training Ids from Below");
                    service.showTraining(training); 
                    tid = sc.nextInt();
                    System.out.println("Select User Ids from Below");
                    service.showUsers(user); 
                    String uids = sc.next();
                    String[] ids = uids.split(",");//reads the strings(splits(,))
                    List<Integer> userIds = new ArrayList<>();
                    for (String s : ids) {
                        userIds.add(Integer.parseInt(s.trim()));//converts from strings to integers
                    }
                    for (TrainingEntity te : training) {
                        if (te.getTrainingId() == tid) {
                            for (int id : userIds) {
                                te.assignTraining(id); //then training will be assigned to listed users
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("Update Status of a User ");
                    service.showTraining(training); 
                    System.out.println("Select User Id and Training Id to mark as completed");
                    int muid = sc.nextInt();
                    int mtid = sc.nextInt();
                    for (TrainingEntity te : training) {
                        if (te.getTrainingId() == mtid) {
                            te.markTrainingCompleted(muid); //marks the training as completed
                        }
                    }
                    break;

                case 6:
                    System.out.println("Get all trainings of a user, both pending and completed");
                    System.out.println("Select User Id from below");
                    service.showUsers(user); 
                    uid = sc.nextInt();
                    for (TrainingEntity te : training) {
                        if (service.contains(te, uid)) {  //checks the training that if it contains or not 
                            System.out.println(te.getTrainingTitle()); 
                        }
                    }
                    break;

                case 7:
                	service.getOverDueTrainingsonDueDate(training);//Calls service method to list pending overdue trainings.
                	break;

                default:
                    System.out.println("Invalid choice ");
            }

        } while (ch != 0); 
    }
}
