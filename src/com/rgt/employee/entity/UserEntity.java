package com.rgt.employee.entity;

import com.rgt.employee.enums.Role;

public class UserEntity {
    
    private int userId;
    private String userName;
    private Role role;
   //A constructor is called when you create a new UserEntity object.
    public UserEntity(int userId, String userName, Role role) {
        this.userId = userId;//Refers to the current object’s userId field.
        this.userName = userName;
        this.role = role;
    }

    public int getUserId() {
        return userId;//Returns the userId of this user.
    }

    public void setUserId(int userId) {
        this.userId = userId;//updates the userId of this user.
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "userId=" + userId + ", userName=" + userName + ", role=" + role;
        //By overriding the toString() method of the Object class, we can return values of the object

    }
}
