package minitwitter;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.GroupLayout.Group;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.tree.DefaultMutableTreeNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vanik
 */
public class Admin extends javax.swing.JFrame {

    private static Admin instance = null;
    private HashMap<String, User> users; 
    private ArrayList<Observer> observers;
    private HashMap<String, UserGroup> userGroups;
    private int userIds;
    private int userGroupIds;
    private ArrayList<Tweet> tweets;
    private ArrayList<PositiveMessages> positives;
    private UserEntityStatVisitor v;
    private DecimalFormat f = new DecimalFormat("##.##");
    private long lastUpdate;

    
    private Admin() {
        
        //init users, groups, map of user to group and userids
        users = new HashMap<String, User>();
        userGroups = new HashMap<String, UserGroup>();
        userIds = 0;
        userGroupIds = 0;
        observers = new ArrayList<Observer>();
        tweets = new ArrayList<Tweet>();
        positives = new ArrayList<PositiveMessages>();
        
        ArrayList<UserEntityElement> ueElement = new ArrayList<>();
        
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setTitle("Admin Control");
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        
        //Init tree
        root = new DefaultMutableTreeNode("Root");        
       
        tree = new JTree(root);
        tree.setBackground(Color.lightGray);
        jScrollPane1.setViewportView(tree);
        
        updateStats();
    
    }
    public static Admin getInstance() {
        if(instance == null)
            instance = new Admin();
        
        return instance;
    }
    public HashMap<String, User> getUser() {
        return users;
    }
    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }
    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
        this.lastUpdateLabel.setText("Last Update: " + lastUpdate);
        
    }
    public long getLastUpdate() {
        return lastUpdate;
    }
    public void updateStats() {
        v = new UserEntityStatVisitor();
        
        Iterator i = users.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry pairs = (Map.Entry)i.next();
            User nextUser = (User)pairs.getValue();
            nextUser.accept(v);
        }
        Iterator j = userGroups.entrySet().iterator();
        while(j.hasNext()) {
            Map.Entry pairs2 = (Map.Entry)j.next();
            UserGroup nextGroup = (UserGroup)pairs2.getValue();
            nextGroup.accept(v);
        }
        for(int k=0; k < tweets.size(); k++) 
            tweets.get(k).accept(v);
        for(int l=0; l < positives.size(); l++) 
            positives.get(l).accept(v);
        
        
    }
    public ArrayList<Tweet> getTweets() {
        return tweets;
    }
    public ArrayList<PositiveMessages> getPositives() {
        return positives;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        userIdTextField = new javax.swing.JTextField();
        groupIdTextField = new javax.swing.JTextField();
        addUserBtn = new javax.swing.JButton();
        addGroupBtn = new javax.swing.JButton();
        openUserViewBtn = new javax.swing.JButton();
        showMessagesTotalBtn = new javax.swing.JButton();
        showGroupTotalBtn = new javax.swing.JButton();
        showPositivePercentageBtn = new javax.swing.JButton();
        showUserTotalBtn = new javax.swing.JButton();
        statLabel = new javax.swing.JLabel();
        verifyIdBtn = new javax.swing.JButton();
        lastUpdateBtn = new javax.swing.JButton();
        lastUpdateLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        userIdTextField.setToolTipText("");
        userIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIdTextFieldActionPerformed(evt);
            }
        });

        groupIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupIdTextFieldActionPerformed(evt);
            }
        });

        addUserBtn.setText("Add User");
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        addGroupBtn.setText("Add Group");
        addGroupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGroupBtnActionPerformed(evt);
            }
        });

        openUserViewBtn.setText("Open User View");
        openUserViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openUserViewBtnActionPerformed(evt);
            }
        });

        showMessagesTotalBtn.setText("Show Total Messages");
        showMessagesTotalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMessagesTotalBtnActionPerformed(evt);
            }
        });

        showGroupTotalBtn.setText("Show Total Groups");
        showGroupTotalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGroupTotalBtnActionPerformed(evt);
            }
        });

        showPositivePercentageBtn.setText("Show Positive Percentage");
        showPositivePercentageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPositivePercentageBtnActionPerformed(evt);
            }
        });

        showUserTotalBtn.setText("Show Total Users");
        showUserTotalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUserTotalBtnActionPerformed(evt);
            }
        });

        statLabel.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N

        verifyIdBtn.setText("Verify IDs");
        verifyIdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyIdBtnActionPerformed(evt);
            }
        });

        lastUpdateBtn.setText("Last Update");
        lastUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastUpdateBtnActionPerformed(evt);
            }
        });

        lastUpdateLabel.setText("Last Update:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userIdTextField)
                            .addComponent(groupIdTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addGroupBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(addUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(openUserViewBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(showMessagesTotalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(showPositivePercentageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(showUserTotalBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(lastUpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(showGroupTotalBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(verifyIdBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lastUpdateLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addGroupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(openUserViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lastUpdateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verifyIdBtn)
                    .addComponent(lastUpdateBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showGroupTotalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showUserTotalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showMessagesTotalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPositivePercentageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane1.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void groupIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupIdTextFieldActionPerformed

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
  
        String userName = userIdTextField.getText();
        User user = new User(this, userName);
        
        DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(user);
        root.add(userNode);

        users.put(userName, user);
        updateUserLinks(user);
        
        tree.expandRow(0);
        tree.updateUI();
        updateStats();
       
    }//GEN-LAST:event_addUserBtnActionPerformed
    public void updateUserLinks(User user) {
        user.notifi();;
        user.update(user);
        Iterator i = users.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry pairs = (Map.Entry)i.next();
            User nextUser = (User)pairs.getValue();
            nextUser.attach(user);            
        }
    }
    public ArrayList<String> collectAllIds() {
        ArrayList<String> ids = new ArrayList<>();
         
        //iterate through users and collect Ids
        Iterator i = users.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry pairs = (Map.Entry)i.next();
            User nextUser = (User)pairs.getValue();
            ids.add(nextUser.getId());
            System.out.println("id: " + nextUser.getId());
        }
        Iterator j = userGroups.entrySet().iterator();
        while(j.hasNext()) {
            Map.Entry pairs2 = (Map.Entry)j.next();
            UserGroup nextGroup = (UserGroup)pairs2.getValue();
            ids.add(nextGroup.getId());
        }
        return ids;
    }
    public boolean verifyIds() {
        ArrayList<String> ids = this.collectAllIds();
        boolean unique = true;
        boolean noSpaces = true;
        
        String temp = ids.get(0);
        for(int i=1; i < ids.size(); i++) {
            if(ids.contains(temp)) {
                unique = false;
            }
            else if(temp.contains(" ")) {
                noSpaces = false;
            }
            else 
                temp = ids.get(i);
        }
               
        return (unique && noSpaces);
    }
    public String findLastUserToUpdate() {
        String id = "";
        long time = 0;
        
        Iterator i = users.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry pairs = (Map.Entry)i.next();
            User nextUser = (User)pairs.getValue();
            if(nextUser.getLastUpdateTime() > time) {
                time = nextUser.getLastUpdateTime();
                id = nextUser.getId();
            }
        }      
        return id;
    }
    private void userIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIdTextFieldActionPerformed

    private void addGroupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGroupBtnActionPerformed
        
        String groupName = groupIdTextField.getText();
        UserGroup group = new UserGroup(groupName);
        
        userGroups.put(groupName, group);
        
        DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(group);
        groupNode.setAllowsChildren(false);
        root.add(groupNode);
        
        tree.expandRow(0);
        tree.updateUI();  
        
        updateStats();             
    }//GEN-LAST:event_addGroupBtnActionPerformed

    private void openUserViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openUserViewBtnActionPerformed
       
       int selection = tree.getSelectionRows()[0];
       DefaultMutableTreeNode node = 
               (DefaultMutableTreeNode)tree.getPathForRow(selection)
                    .getLastPathComponent();
          
       Object object = node.getUserObject();
       
       if(object instanceof User) {
           //init user
           User userNode = (User) object;
           userNode.setName(node.toString());        
           userNode.setVisible(true);   //open new window          
       }
       else 
           JOptionPane.showMessageDialog(null, "This is a Group.");    
                 
    }//GEN-LAST:event_openUserViewBtnActionPerformed

    private void showGroupTotalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGroupTotalBtnActionPerformed
        statLabel.setText("Total Groups: " + v.getGroupTotal());
    }//GEN-LAST:event_showGroupTotalBtnActionPerformed

    private void showUserTotalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUserTotalBtnActionPerformed
        statLabel.setText("Total Users: " + v.getUserTotal());
    }//GEN-LAST:event_showUserTotalBtnActionPerformed

    private void showMessagesTotalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMessagesTotalBtnActionPerformed
        statLabel.setText("Total Messages: " + v.getTweetTotal());
    }//GEN-LAST:event_showMessagesTotalBtnActionPerformed

    private void showPositivePercentageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPositivePercentageBtnActionPerformed
        statLabel.setText("Positive %: " + f.format(v.getPositiveTotal()));
    }//GEN-LAST:event_showPositivePercentageBtnActionPerformed

    private void verifyIdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyIdBtnActionPerformed
        if(this.verifyIds() == true)
            JOptionPane.showMessageDialog(null, "All IDs are valid");
        else
            JOptionPane.showMessageDialog(null, "Some ID(s) may NOT be valid!");
        
    }//GEN-LAST:event_verifyIdBtnActionPerformed

    private void lastUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastUpdateBtnActionPerformed
        String lastUserToUpdate = this.findLastUserToUpdate();
        JOptionPane.showMessageDialog(null, "ID: " + lastUserToUpdate);
    }//GEN-LAST:event_lastUpdateBtnActionPerformed

    /**
     * @param args the command line arguments
     */
  
    private JTree tree;
    private DefaultMutableTreeNode root;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addGroupBtn;
    private javax.swing.JButton addUserBtn;
    private javax.swing.JTextField groupIdTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lastUpdateBtn;
    private javax.swing.JLabel lastUpdateLabel;
    private javax.swing.JButton openUserViewBtn;
    private javax.swing.JButton showGroupTotalBtn;
    private javax.swing.JButton showMessagesTotalBtn;
    private javax.swing.JButton showPositivePercentageBtn;
    private javax.swing.JButton showUserTotalBtn;
    private javax.swing.JLabel statLabel;
    private javax.swing.JTextField userIdTextField;
    private javax.swing.JButton verifyIdBtn;
    // End of variables declaration//GEN-END:variables
}
