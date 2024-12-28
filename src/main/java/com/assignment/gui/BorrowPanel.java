/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.assignment.gui;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.assignment.data.BookBorrow;
import com.assignment.data.Borrow;
import com.assignment.data.MagazineBorrow;
import com.assignment.service.ServiceFactory;
import com.formdev.flatlaf.ui.FlatRoundBorder;

/**
 *
 * @author Meher Ali
 */
public class BorrowPanel extends javax.swing.JPanel {
    Borrow borrow = null;
    BookBorrow userBookBorrow = null;
    MagazineBorrow userMagazineBorrow = null;
    DrawMode drawMode = null;

    /**
     * Creates new form userborrowPanel
     */
    public BorrowPanel(Borrow borrow, DrawMode drawMode) {
        this.drawMode = drawMode;
        this.borrow = borrow;
        if (borrow instanceof BookBorrow) {
            this.userBookBorrow = (BookBorrow) borrow;
        } else if (borrow instanceof MagazineBorrow) {
            this.userMagazineBorrow = (MagazineBorrow) borrow;
        }
        initComponents();
        setAllText();
        switch (drawMode) {
            case USER:
                byUser.setVisible(false);
                byUserLabel.setVisible(false);
                break;
        
            default:
                break;
        }
    }

    public void setAllText() {
        borrowingNo.setText("Borrowing No. " + borrow.getId());
        if (borrow instanceof BookBorrow) {
            title.setText(userBookBorrow.getBook().getTitle());
            date.setText(userBookBorrow.getCreatedAt().toString());
            status.setText(userBookBorrow.getStatus().toString());
            //byUser.setText(userBookBorrow.getUsername());
        } else if (borrow instanceof MagazineBorrow) {
            title.setText(userMagazineBorrow.getMagazine().getTitle());
            date.setText(userMagazineBorrow.getCreatedAt().toString());
            status.setText(userMagazineBorrow.getStatus().toString());
            //byUser.setText(userMagazineBorrow.getUsername());
        }
    }

    public void setAllEditable() {
        title.setEditable(false);
        date.setEditable(false);
        status.setEditable(false);
        byUser.setEditable(false);
    }

    public void setAllFocusable() {
        title.setFocusable(false);
        date.setFocusable(false);
        status.setFocusable(false);
        byUser.setFocusable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        borrowingNo = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        title = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        byUser = new javax.swing.JTextField();
        byUserLabel = new javax.swing.JLabel();

        setBorder(new FlatRoundBorder());

        borrowingNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        borrowingNo.setText("Borrowing No. ");

        button.setBackground(new java.awt.Color(0, 102, 51));
        button.setText("Return");
        button.setBorder(new FlatRoundBorder());
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        title.setEditable(false);
        title.setToolTipText("");
        title.setBorder(new FlatRoundBorder());
        title.setFocusable(false);
        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });

        date.setEditable(false);
        date.setToolTipText("");
        date.setBorder(new FlatRoundBorder());
        date.setFocusable(false);
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        status.setEditable(false);
        status.setToolTipText("");
        status.setBorder(new FlatRoundBorder());
        status.setFocusable(false);
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        jLabel1.setText("Title");

        jLabel2.setText("Date");

        jLabel3.setText("Status");

        byUser.setEditable(false);
        byUser.setToolTipText("");
        byUser.setBorder(new FlatRoundBorder());
        byUser.setFocusable(false);
        byUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byUserActionPerformed(evt);
            }
        });

        byUserLabel.setText("By User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(borrowingNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(byUserLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(byUser, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(borrowingNo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(byUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(byUserLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(button)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed
        // nothing to do here
    }//GEN-LAST:event_titleActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // nothing to do here
    }//GEN-LAST:event_dateActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // nothing to do here
    }//GEN-LAST:event_statusActionPerformed

    private void byUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byUserActionPerformed
        // nothing to do here
    }//GEN-LAST:event_byUserActionPerformed

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        ServiceFactory serviceFactory = new ServiceFactory();
        try {
            if (this.borrow instanceof BookBorrow) {
                if (serviceFactory.getBorrowService().returnBook(this.userBookBorrow.getId())) {
                    JOptionPane.showMessageDialog(this, "Book returned successfully", "Success", JOptionPane.INFORMATION_MESSAGE); 
                    ((MainWindow) SwingUtilities.getWindowAncestor(this)).refresgBorrowings();
                } else {
                    JOptionPane.showMessageDialog(this, "Book not returned", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (this.borrow instanceof MagazineBorrow) {
                if (serviceFactory.getBorrowService().returnMagazine(this.userMagazineBorrow.getId())) {
                    JOptionPane.showMessageDialog(this, "Magazine returned successfully", "Success", JOptionPane.INFORMATION_MESSAGE); 
                    ((MainWindow) SwingUtilities.getWindowAncestor(this)).refresgBorrowings();
                } else {
                    JOptionPane.showMessageDialog(this, "Magazine not returned", "Error", JOptionPane.ERROR_MESSAGE);
                } 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel borrowingNo;
    private javax.swing.JButton button;
    private javax.swing.JTextField byUser;
    private javax.swing.JLabel byUserLabel;
    private javax.swing.JTextField date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField status;
    private javax.swing.JTextField title;
    // End of variables declaration//GEN-END:variables
}
