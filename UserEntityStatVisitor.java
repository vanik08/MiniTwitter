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
public class UserEntityStatVisitor implements UserEntityElementVisitor {

    private int userTotal;
    private int groupTotal;
    private int tweetTotal;
    private int positiveTotal;

    public void setUserTotal(int userTotal) {
        this.userTotal = userTotal;
    }

    public void setGroupTotal(int groupTotal) {
        this.groupTotal = groupTotal;
    }

    public void setTweetTotal(int tweetTotal) {
        this.tweetTotal = tweetTotal;
    }

    public void setPositiveTotal(int positiveTotal) {
        this.positiveTotal = positiveTotal;
    }

    public int getUserTotal() {
        return userTotal;
    }

    public int getGroupTotal() {
        return groupTotal;
    }

    public int getTweetTotal() {
        return tweetTotal;
    }

    public int getPositiveTotal() {
        return positiveTotal;
    }
    @Override
    public void visit(User user) {
        setUserTotal(getUserTotal()+1);
    }

    @Override
    public void visit(UserGroup group) {
        setGroupTotal(getGroupTotal()+1);
    }

    @Override
    public void visit(Tweet tweet) {
        setTweetTotal(getTweetTotal()+1);
    }

    @Override
    public void visit(PositiveMessages positives) {
        setPositiveTotal(getPositiveTotal()+1);
    }
    
    
}
