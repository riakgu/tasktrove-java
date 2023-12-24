/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasktrove.view;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import tasktrove.config.Database;
import tasktrove.controller.AuthController;
import tasktrove.controller.SettingsController;
import tasktrove.model.User;

/**
 *
 * @author riakgu
 */
public class SettingsView extends javax.swing.JPanel {

    private SettingsController sc;
    private AuthController ac;
    private User user;
    /**
     * Creates new form SettingsView
     */
    public SettingsView(User user) {
        initComponents();
        this.user = user;
        
        sc = new SettingsController();
        ac = new AuthController();
        
        inputNameField.setText(user.getName());
        inputUsernameField.setText(user.getUsername());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        profilePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputUsernameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputNameField = new javax.swing.JTextField();
        submitProfileButton = new javax.swing.JButton();
        passwordPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        inputCurrentPassField = new javax.swing.JTextField();
        inputNewPassField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        submitPassButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(920, 585));
        setMinimumSize(new java.awt.Dimension(920, 585));
        setPreferredSize(new java.awt.Dimension(920, 585));
        setLayout(new java.awt.CardLayout());

        mainPanel.setMaximumSize(new java.awt.Dimension(920, 585));
        mainPanel.setMinimumSize(new java.awt.Dimension(920, 585));
        mainPanel.setPreferredSize(new java.awt.Dimension(920, 585));

        profilePanel.setBackground(new java.awt.Color(255, 255, 255));
        profilePanel.setMaximumSize(new java.awt.Dimension(920, 292));
        profilePanel.setMinimumSize(new java.awt.Dimension(920, 292));
        profilePanel.setPreferredSize(new java.awt.Dimension(920, 292));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Profile");

        jLabel6.setText("Username");

        inputUsernameField.setBackground(new java.awt.Color(242, 247, 255));
        inputUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUsernameFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Name");

        inputNameField.setBackground(new java.awt.Color(242, 247, 255));

        submitProfileButton.setText("Submit");
        submitProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitProfileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(775, 863, Short.MAX_VALUE))
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(submitProfileButton)
                            .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputNameField)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(submitProfileButton)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        passwordPanel.setBackground(new java.awt.Color(255, 255, 255));
        passwordPanel.setMaximumSize(new java.awt.Dimension(920, 292));
        passwordPanel.setMinimumSize(new java.awt.Dimension(920, 292));
        passwordPanel.setPreferredSize(new java.awt.Dimension(920, 292));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        inputCurrentPassField.setBackground(new java.awt.Color(242, 247, 255));

        inputNewPassField.setBackground(new java.awt.Color(242, 247, 255));

        jLabel3.setText("Current Password");

        jLabel4.setText("New Password");

        submitPassButton.setText("Submit");
        submitPassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPassButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanelLayout.createSequentialGroup()
                        .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputNewPassField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputCurrentPassField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(passwordPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(submitPassButton)))
                        .addGap(30, 30, 30))))
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputCurrentPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNewPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(submitPassButton)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void submitPassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPassButtonActionPerformed
        int user_id = user.getUser_id();
        String oldPassword = inputCurrentPassField.getText();
        String newPassword = inputNewPassField.getText();
        
        if (oldPassword.equals(user.getPassword())) {
            
            if (sc.settingsPassword(user_id, newPassword)) {
                JOptionPane.showMessageDialog(this, "Password updated successfully!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "The old password doesn't match!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitPassButtonActionPerformed

    private void inputUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputUsernameFieldActionPerformed

    private void submitProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitProfileButtonActionPerformed
        int user_id = user.getUser_id();
        String name = inputNameField.getText();
        String username = inputUsernameField.getText();
        
        // Validate form
        if (username.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "The name and username must not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (user.getUsername() != username) {
            if (ac.isUserExists(username)) {
                JOptionPane.showMessageDialog(this, "Username already taken", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        if (sc.settingsProfile(user_id, name, username)) {
            JOptionPane.showMessageDialog(this, "Profile updated successfully!");
        }
        
        user.setName(name);
        user.setUsername(username);
    }//GEN-LAST:event_submitProfileButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputCurrentPassField;
    private javax.swing.JTextField inputNameField;
    private javax.swing.JTextField inputNewPassField;
    private javax.swing.JTextField inputUsernameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JButton submitPassButton;
    private javax.swing.JButton submitProfileButton;
    // End of variables declaration//GEN-END:variables
}
