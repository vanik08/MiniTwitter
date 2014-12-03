/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minitwitter;

public class Tweet implements UserEntityElement{
    
    private User user;
    private String tweet;
    
    public Tweet(User user, String tweet) {
        this.user = user;
        this.tweet = tweet;
    }
    public String toString() {
        return tweet;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    @Override
    public void accept(UserEntityElementVisitor visitor) {
        visitor.visit(this);
    }
    
}
