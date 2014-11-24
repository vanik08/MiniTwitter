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
public interface UserEntityElementVisitor {
    public void visit(User user);
    public void visit(UserGroup group);
    public void visit(Tweet tweet);
    public void visit(PositiveMessages positives);
}
