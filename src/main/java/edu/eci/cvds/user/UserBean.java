package edu.eci.cvds.user;


import javax.annotation.ManagedBean;

import org.springframework.stereotype.Component;
@Component
@ManagedBean


public class UserBean {
    private String name;

    public UserBean(){

    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
}
