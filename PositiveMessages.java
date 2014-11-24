/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minitwitter;

/**
 *
 * @author vanik
 */
public class PositiveMessages implements UserEntityElement {

    private String msg;

    public PositiveMessages(String msg) {
        this.msg = msg;
    }
    @Override
    public void accept(UserEntityElementVisitor visitor) {
        visitor.visit(this);
    }
    
}
