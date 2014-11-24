/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minitwitter;

import java.util.ArrayList;

/**
 *
 * @author vanik
 */
public class UserGroup implements UserEntity, UserEntityElement{

    private String name;
    private ArrayList<UserEntity> users = new ArrayList<UserEntity>();
    private int id;
    
    public UserGroup(String name) {
        this.name = name;
    }
    public void setUserId(int id) {
        this.id = id;
    }
    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String toString() {
        return name;
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void accept(UserEntityElementVisitor visitor) {
        visitor.visit(this);
    }
    
}
