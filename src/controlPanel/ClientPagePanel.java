/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlPanel;

import asconapplication.ApplicationHomePage;
import asconapplication.Constants;
import alertDialog.ErrorMessageDialog;
import java.sql.ResultSet;
import java.sql.SQLException;
import listModel.ClientCellRenderer;
import listModel.ClientListModel;

/**
 *
 * @author Oluwafemi Nehemiah (rotneil@yahoo.com)
 */
public class ClientPagePanel extends javax.swing.JPanel implements Constants {

    // instance variables
    private ApplicationHomePage parent;
    private ClientListModel clientListModel;
    private ClientCellRenderer mRenderer;
    private ResultSet searchResult;
    private String nameSearch;
    private String addressSearch;
    private String companySearch;
    private long accomodationSearch;
    private long arrivalSearch;
    
    /**
     * Creates new form ClientPagePanel
     */
    public ClientPagePanel(ApplicationHomePage parent) {
        this.parent = parent;
        searchResult = parent.getSchema().getAllClient();
        clientListModel = new ClientListModel (parent, searchResult);
        mRenderer = new ClientCellRenderer (parent);
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        companyField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        accomodationField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        arrivalField = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        nameButton = new javax.swing.JButton();
        companyButton = new javax.swing.JButton();
        addressButton = new javax.swing.JButton();
        accomodationButton = new javax.swing.JButton();
        arrivalButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchList = new javax.swing.JList();

        setPreferredSize(new java.awt.Dimension(420, 526));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Client"));

        jLabel15.setText("Name of Client:");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jLabel16.setText("Name of Company: ");

        companyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyFieldActionPerformed(evt);
            }
        });

        jLabel17.setText("Address: ");

        jLabel18.setText("Accomodation Type: ");

        addressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressFieldActionPerformed(evt);
            }
        });

        accomodationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accomodationFieldActionPerformed(evt);
            }
        });

        jLabel19.setText("Arrival Date: ");

        arrivalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrivalFieldActionPerformed(evt);
            }
        });

        resetButton.setText("Reset Search/List");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        nameButton.setText("Search");
        nameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameButtonActionPerformed(evt);
            }
        });

        companyButton.setText("Search");

        addressButton.setText("Search");
        addressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressButtonActionPerformed(evt);
            }
        });

        accomodationButton.setText("Search");
        accomodationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accomodationButtonActionPerformed(evt);
            }
        });

        arrivalButton.setText("Search");
        arrivalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrivalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameButton, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(companyField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addressButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(companyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(accomodationField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accomodationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(arrivalField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(arrivalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameButton))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(companyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyButton))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressButton))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(accomodationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accomodationButton))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(arrivalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrivalButton))
                .addGap(3, 3, 3)
                .addComponent(resetButton))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Search List"));

        searchList.setModel(clientListModel);
        searchList.setCellRenderer(mRenderer);
        searchList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(searchList);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameButtonActionPerformed
        // TODO add your handling code here:
        refineSearch ();
    }//GEN-LAST:event_nameButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
        refineSearch ();
    }//GEN-LAST:event_nameFieldActionPerformed

    private void companyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyFieldActionPerformed
        // TODO add your handling code here:
        refineSearch ();
    }//GEN-LAST:event_companyFieldActionPerformed

    private void accomodationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accomodationFieldActionPerformed
        // TODO add your handling code here:
        refineSearch ();
    }//GEN-LAST:event_accomodationFieldActionPerformed

    private void arrivalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrivalFieldActionPerformed
        // TODO add your handling code here:
        refineSearch ();
    }//GEN-LAST:event_arrivalFieldActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        resetSearch ();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void searchListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchListMouseClicked
        // TODO add your handling code here:
        processClick (evt);
    }//GEN-LAST:event_searchListMouseClicked

    private void addressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressButtonActionPerformed
        // TODO add your handling code here:
        refineSearch ();
    }//GEN-LAST:event_addressButtonActionPerformed

    private void addressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressFieldActionPerformed
        // TODO add your handling code here:
        refineSearch ();
    }//GEN-LAST:event_addressFieldActionPerformed

    private void accomodationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accomodationButtonActionPerformed
        // TODO add your handling code here:
        refineSearch ();
    }//GEN-LAST:event_accomodationButtonActionPerformed

    private void arrivalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrivalButtonActionPerformed
        // TODO add your handling code here:
        refineSearch ();
    }//GEN-LAST:event_arrivalButtonActionPerformed

    
    // METHOD TO RESET THE SEARCH LIST
    private void resetSearch ()
    {
        nameField.setText("");
        companyField.setText("");
        addressField.setText("");
        arrivalField.setText("");
        accomodationField.setText("");
        
        searchResult = parent.getSchema().getAllClient();
        updateList ();
    }
    
    // METHOD TO REFINE SEARCH LIST
    private void refineSearch ()
    {
        // obtain user's input for all the fields
        nameSearch = nameField.getText();
        companySearch = companyField.getText();
        addressSearch = addressField.getText();
        try {
            accomodationSearch = Long.parseLong(accomodationField.getText());
        } catch (NumberFormatException e) {
            accomodationSearch = 0;
        }
        
        try {
            arrivalSearch = Long.parseLong(arrivalField.getText());
        } catch (NumberFormatException e) {
            arrivalSearch = 0;
        }
        
        searchResult = parent.getSchema().getClient(nameSearch, 
            companySearch, addressSearch, accomodationSearch, arrivalSearch);
        updateList ();
    }
    
    // METHOD TO RESPOND TO USER'S CLICKS
    private void processClick (java.awt.event.MouseEvent evt)
    {
        switch (evt.getClickCount()) {
            case 1: default:
                // DO NOTHING: ORDER BY NEHEMIAH
                break;
            case 2: // case for viewing client
                try {
                    int index = searchList.locationToIndex(evt.getPoint());
                    searchResult.absolute(index + 1);
                    long clientId = searchResult.getLong(CLIENT.ID);
                    parent.showClientView(clientId);
                } catch (SQLException e) {
                    ErrorMessageDialog.show(parent, e.getMessage());
                }
                break;
        }
    }
    
    // method to update list
    public void updateList ()
    {
        clientListModel.updateList(searchResult);
        searchList.setModel(clientListModel);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accomodationButton;
    private javax.swing.JTextField accomodationField;
    private javax.swing.JButton addressButton;
    private javax.swing.JTextField addressField;
    private javax.swing.JButton arrivalButton;
    private javax.swing.JTextField arrivalField;
    private javax.swing.JButton companyButton;
    private javax.swing.JTextField companyField;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nameButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton resetButton;
    private javax.swing.JList searchList;
    // End of variables declaration//GEN-END:variables
}
