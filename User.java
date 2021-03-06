/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minitwitter;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author vanik
 */
public class User extends javax.swing.JFrame implements UserEntity, 
        Observer, Subject, UserEntityElement {

    private String name;
    private ArrayList<User> followings = new ArrayList<>();
    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<String> tweets = new ArrayList<>();
    private ArrayList<Tweet> newsfeed = new ArrayList<>(); 
    private Admin admin;
    private DefaultListModel followingModel, newsfeedModel;
    private String id;
    private long creationTime;
    private long lastUpdateTime;
 
    public User(Admin admin, String name) {
        
        this.setTitle(name);
        this.name = name;
        this.admin = admin;
        this.id = "user:" + name;
        this.creationTime = System.currentTimeMillis();
        initComponents();
        creationTimeLabel.setText("Creation Time: " + creationTime);
        followingModel = new DefaultListModel();
        newsfeedModel = new DefaultListModel();        
        setFollowersModel(); 
        setNewsfeedModel(); 
        followings.add(this);
    }
    public String getId() {
        return id;
    }
    public void setUserId(String id) {
        this.id = id;
    }
    public ArrayList<Tweet> getNewsfeed() {
        return newsfeed;
    }
    public void setNewsfeed(ArrayList<Tweet> newsfeed) {
        this.newsfeed = newsfeed;
    }
    public void setFollowersModel() { 
                
        followingModel.clear();
        for(int i=0; i < followings.size(); i++) {
            followingModel.addElement(followings.get(i).toString());
        }
        currentFollowingList.setModel(followingModel);      
    }
    public void setNewsfeedModel() {  
        
        newsfeedModel.clear();
        for(int i=0; i < newsfeed.size(); i++) { 
            newsfeedModel.addElement(newsfeed.get(i).toString());  
        }       
        newsFeedList.setModel(newsfeedModel);

    }
    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        followTextField = new javax.swing.JTextField();
        followUserBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        currentFollowingList = new javax.swing.JList();
        postTweetBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tweetMessageTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        newsFeedList = new javax.swing.JList();
        creationTimeLabel = new javax.swing.JLabel();
        lastUpdateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        followTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followTextFieldActionPerformed(evt);
            }
        });

        followUserBtn.setText("Follow User");
        followUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followUserBtnActionPerformed(evt);
            }
        });

        currentFollowingList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(currentFollowingList);

        postTweetBtn.setText("Post Tweet");
        postTweetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postTweetBtnActionPerformed(evt);
            }
        });

        tweetMessageTextArea.setColumns(19);
        tweetMessageTextArea.setRows(2);
        jScrollPane2.setViewportView(tweetMessageTextArea);

        newsFeedList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(newsFeedList);

        creationTimeLabel.setText("Creation Time");

        lastUpdateLabel.setText("Last Update");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(followTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(followUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(postTweetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 35, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(creationTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lastUpdateLabel)
                        .addGap(112, 112, 112))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(followTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(followUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creationTimeLabel)
                    .addComponent(lastUpdateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(postTweetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void followTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_followTextFieldActionPerformed

    private void followUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followUserBtnActionPerformed
        String name = followTextField.getText();
        followTextField.setText("");
        User user = admin.getUser().get(name);
        followings.add(user);
        setFollowersModel();
    }//GEN-LAST:event_followUserBtnActionPerformed

    private void postTweetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postTweetBtnActionPerformed
        String tweetMsg = tweetMessageTextArea.getText();
        Tweet tweet = new Tweet(this, this.name + ": " + tweetMsg);
        newsfeed.add(tweet);  
        this.notifi();
     
        admin.getTweets().add(tweet);       
        findPositives(tweet);      
        admin.updateStats();
    }//GEN-LAST:event_postTweetBtnActionPerformed
    public void findPositives(Tweet tweet) {
        String msg = tweet.getTweet();
        if(msg.contains("good") ||
           msg.contains("awsome") ||
           msg.contains("happy")) {
            admin.getPositives().add(new PositiveMessages(msg));
        }
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel creationTimeLabel;
    private javax.swing.JList currentFollowingList;
    private javax.swing.JTextField followTextField;
    private javax.swing.JButton followUserBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lastUpdateLabel;
    private javax.swing.JList newsFeedList;
    private javax.swing.JButton postTweetBtn;
    private javax.swing.JTextArea tweetMessageTextArea;
    // End of variables declaration//GEN-END:variables


    public String toString() {
        return name;
    }
    @Override
    public void update(Subject sub) {      
        if(sub instanceof User) {
            User user = (User) sub;
            for(int i=0; i < followings.size(); i++) {
                if(followings.get(i).getId()==user.getId()) {
                    newsfeed = user.getNewsfeed();
                    this.setNewsfeedModel();
                    lastUpdateTime = System.currentTimeMillis();
                    lastUpdateLabel.setText("Last Update: " + lastUpdateTime);
                    admin.setLastUpdate(lastUpdateTime);
                }
            }
            
        }
    }
    @Override
    public void attach(Observer observer) {
        admin.getObservers().add(observer);
    }

    @Override
    public void detach(Observer observer) {
        admin.getObservers().remove(observer);
    }

    @Override
    public void notifi() {
        for(int i=0; i < admin.getObservers().size(); i++)
            admin.getObservers().get(i).update(this);      
    }    

    @Override
    public void accept(UserEntityElementVisitor visitor) {
        visitor.visit(this);
    }

}
