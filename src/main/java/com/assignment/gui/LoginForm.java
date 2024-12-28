/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.assignment.gui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.assignment.dao.CredentialsDao;
import com.assignment.data.Credential;
import com.assignment.dao.mysql.MySqlCredentialsDao;
import com.assignment.data.Person;
import com.assignment.service.ServiceException;
import com.assignment.service.ServiceFactory;
import com.assignment.service.impl.DatabaseConnectionServiceImpl;
import com.assignment.theme.myTheme;
import com.formdev.flatlaf.ui.FlatRoundBorder;

/**
 *
 * @author meher
 */
public class LoginForm extends javax.swing.JDialog {
    private final ServiceFactory serviceFactory = new ServiceFactory();
    private static final String LAST_LOGIN_FILE = "C:\\Users\\meher\\Downloads\\librarymanagementsystem\\last_login.txt";
    private Credential lastLoginCredentials;

    /**
     * Creates new form LoginForm
     */
    public LoginForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadLastLogin();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox(); // Initialize the new checkbox

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setFocusable(false);
        setResizable(false);

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, jLabel2.getFont().getSize()+12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Library Managment System");
        jLabel2.setToolTipText("");

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getSize()+4f));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Welcome to");

        jTextField1.setBorder(new FlatRoundBorder());
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPasswordField1.setBorder(new FlatRoundBorder());

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setText("Login");
        jButton1.setBorder(new FlatRoundBorder());
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel4.setText("Password");

        jCheckBox1.setText("Show password");
        jCheckBox1.setBorder(new FlatRoundBorder());
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Save login info"); // Set text for the new checkbox
        jCheckBox2.setBorder(new FlatRoundBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                        .addComponent(jTextField1))
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)) // Add the new checkbox to the layout
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2) // Add the new checkbox to the layout
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addGap(71, 71, 71))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Person person = null;
        String uesrname = jTextField1.getText();
        String password = new String(jPasswordField1.getPassword());
        try {
            CredentialsDao credentialsDao = new MySqlCredentialsDao(DatabaseConnectionServiceImpl.newConnection());
            if (credentialsDao.validate(uesrname, password)) {
                if (serviceFactory.getStaffService().findByUsername(uesrname) != null) {
                    person = serviceFactory.getStaffService().findByUsername(uesrname);
                } else if (serviceFactory.getUserService().findByUsername(uesrname) != null) {
                    person = serviceFactory.getUserService().findByUsername(uesrname);
                }
            }
            if (person == null) {
                //JOptionPane.showMessageDialog(rootPane, password + "\n" + uesrname);
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            } else {
                saveLastLogin(uesrname, password);
                LoginForm.this.dispose();
                JOptionPane.showMessageDialog(this, "Login successful");
                MainWindow.main(null, person);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            jPasswordField1.setEchoChar((char) 0); // Show password
        } else {
            jPasswordField1.setEchoChar('*'); // Hide password
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void saveLastLogin(String username, String password) {
        if (jCheckBox2.isSelected()) { // Check if "Save Login Info" is selected
            Credential creds = new Credential(username, password);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LAST_LOGIN_FILE))) {
                oos.writeObject(creds);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Clear the saved credentials if the checkbox is not selected
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LAST_LOGIN_FILE))) {
                oos.writeObject(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadLastLogin() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(LAST_LOGIN_FILE))) {
            lastLoginCredentials = (Credential) ois.readObject();
            if (lastLoginCredentials != null) {
                jTextField1.setText(lastLoginCredentials.getUsername());
                jPasswordField1.setText(lastLoginCredentials.getPassword());
                jCheckBox2.setSelected(true); // Set the checkbox to selected if credentials are loaded
            } else {
                jCheckBox2.setSelected(false); // Set the checkbox to not selected if no credentials are loaded
            }
        } catch (IOException | ClassNotFoundException e) {
            // First time use - no saved credentials
            jCheckBox2.setSelected(false); // Set the checkbox to not selected if an exception occurs
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        myTheme.setup();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginForm dialog = new LoginForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2; // Declare the new checkbox
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
