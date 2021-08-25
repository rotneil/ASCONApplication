/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asconapplication;

import controlPanel.ClientListPage;
import controlPanel.ClientEditPage;
import controlPanel.HomePagePanel;
import controlPanel.RegisterPanel;
import controlPanel.SettingsPagePanel;
import controlPanel.ClientViewPage;
import alertDialog.ErrorMessageDialog;
import objectScripts.Client;

/**
 *
 * @author Oluwafemi Nehemiah 
 * Rotneil IT Consult
 * (rotneil@yahoo.com)
 */
public final class ASCONApplication extends javax.swing.JFrame 
    implements Constants {

    // Global variables
    
    // instance variables
    private SchemaHelper mSchema;
    private ClientViewPage myViewClient;
    private ClientEditPage editClient;
    
    /**
     * Creates new form ApplicationHomePage
     */
    public ASCONApplication() {
        initComponents();
        this.setLocationRelativeTo(null);
        mSchema = new SchemaHelper (this);
        
        // show the home page panel
        changeActionPage (ACTION_CONTROLLER.HOME_PAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homePanel = new javax.swing.JPanel();
        actionPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        newClientButton = new javax.swing.JButton();
        clientListButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        asconlogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrative Staff College of Nigera (ASCON) Portal");

        homePanel.setPreferredSize(new java.awt.Dimension(420, 526));

        actionPanel.setPreferredSize(new java.awt.Dimension(420, 526));

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(actionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(actionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("\t\t\t\t  Powered by\n\t\t\t                   Rotneil IT Consult\n\t\t\trotneil@yahoo.com, +234 805 323 7746 (C)2016");
        jTextArea1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Control"));
        jPanel3.setPreferredSize(new java.awt.Dimension(139, 562));

        newClientButton.setText("Register New Client");
        newClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newClientButtonActionPerformed(evt);
            }
        });

        clientListButton.setText("Client List");
        clientListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientListButtonActionPerformed(evt);
            }
        });

        settingsButton.setText("Settings");
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        homeButton.setText("Home Page");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        asconlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asconLogo.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(newClientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clientListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(settingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(asconlogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(newClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(clientListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(settingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(asconlogo, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newClientButtonActionPerformed
        // TODO add your handling code here:
        changeActionPage (ACTION_CONTROLLER.REGRISTRATION_PAGE);
    }//GEN-LAST:event_newClientButtonActionPerformed

    private void clientListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientListButtonActionPerformed
        // TODO add your handling code here:
        changeActionPage (ACTION_CONTROLLER.CLIENT_PAGE);
    }//GEN-LAST:event_clientListButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        // TODO add your handling code here:
        changeActionPage (ACTION_CONTROLLER.SETTINGS_PAGE);
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        changeActionPage (ACTION_CONTROLLER.HOME_PAGE);
    }//GEN-LAST:event_homeButtonActionPerformed

    /*
    ** This method returns an instance of the SchemaHelper associated with
    ** this application.
    */
    public SchemaHelper getSchema ()
    {
        return this.mSchema;
    }
    
    /*
    ** The Date Variables
    **
    */
    public String [] getDaysOfMonth () {
        return new String [] {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
            "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
            "24", "25", "26", "27", "28", "29", "30", "31"};
    }
    
    public String [] getMonthOfYear () {
        return new String [] {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    }
    
    public String [] getYear () {
        String [] year = new String [1000];
        for (int i = 0; i < year.length; ++i)
            year [i] = String.valueOf((i + YEAR_START));
        return year;
    }
    
    /* 
    ** METHOD setViewClient is used to instantiate a Client Profile
    ** so that it can be displayed on the view panel
    */
    public void showClientView (long clientId)
    {
        myViewClient = new ClientViewPage (this, clientId);
        changeActionPage(ACTION_CONTROLLER.CLIENT_PRINT_VIEW);
    }
    
    // method to launch the ClientEditPage
    public void showClientEditPage (Client client, int callingPage)
    {
        editClient = new ClientEditPage (this, client, callingPage);
        changeActionPage(ACTION_CONTROLLER.CLIENT_EDIT_PAGE);
    }
    
    /**
     * This method changes the panel that is displayed on the homePanel
     * A number of control panels were designed to overwrite the content
     * of the homePanel using integers defined in the interface Constants
     * 
     * page is the control integer
     */
    public void changeActionPage (int page)
    {
        try {
            switch (page){
                case 0: default:
                    actionPanel = new HomePagePanel (this);
                    break;
                case 1: // REGISTRATION PAGE
                    actionPanel = new RegisterPanel (this);
                    break;
                case 2: // CLIENT PAGE
                    actionPanel = new ClientListPage (this);
                    break;
                case 3: // SETTINGS_PAGE
                    actionPanel = new SettingsPagePanel (this);
                    break;
                case 4: // CLIENT EDIT PAGE
                    if (editClient != null)
                        actionPanel = editClient;
                    else
                        ErrorMessageDialog.show(this, "Edit Client has not been " +
                                "initialized. Use method showEditClient(...)"
                                + " of ApplicationHomePage");
                    break;
                case 5: // CLIENT_PRINT_VIEW
                    if (myViewClient != null)
                        actionPanel = myViewClient;
                    else
                        ErrorMessageDialog.show(this, "View Client has not been " +
                                "initialized. Use method showViewClient(...)"
                                + " of ApplicationHomePage");
                    break;
            }

            homePanel.removeAll();
            javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
            homePanel.setLayout(homePanelLayout);
            homePanelLayout.setHorizontalGroup(
                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(actionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
            );
            homePanelLayout.setVerticalGroup(
                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(actionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
            );
        } catch (Exception e) {
            ErrorMessageDialog.show(this, "TRANSITION ERROR", e.getMessage());
        }
    }
    
    /**
     * This method converts figures to words for receipt printing
     * application
     * @param amount The amount in figures
     * @return The equivalent in words
     */
    public String amountToWord (double amount)
    {
        // transform it to words
        String word = figuresToWord (amount);
        
        // trim off the and and spaces
        while (word.startsWith("and "))
            word = word.substring(4, word.length());
        while (word.endsWith("and "))
            word = word.substring(0, word.lastIndexOf("and "));
        while (word.endsWith(" "))
            word = word.substring(0, word.length() - 1);
        if (word.endsWith(","))
            word = word.substring(0, word.length() - 1);
        
        // make word sentence case and put currency
        if (word.length() > 0) {
            String start = "" + word.charAt(0);
            word = word.replaceFirst(start, start.toUpperCase());
            word += " " + CURRENCY + " only.";
        }
        
        return word;
    }
    
    // RECURSIVE METHOD THAT CHANGES FIGURES TO WORDS
    private String figuresToWord(double figure)
    {
        String word = "";
        String wordIndex = "";
        
        // get the n-multiple of 1000 that is just less than figure
        int n = figure > 0 ? (int) (Math.log10(figure) / 3) : 0;
        
        // form the word index
        switch (n) {
            case 8: wordIndex = "heptallion, "; break;
            case 7: wordIndex = "hexallion, "; break;
            case 6: wordIndex = "pentallion, "; break;
            case 5: wordIndex = "zillion, "; break;
            case 4: wordIndex = "trillion, "; break;
            case 3: wordIndex = "billion, "; break;
            case 2: wordIndex = "million, "; break;
            case 1: wordIndex = "thousand, "; break;
            default:
        }
        
        // get the numbers with which figure is greater than pow of 1000
        int newFigure;
        if (n > 0)
            newFigure = (int) (figure / Math.pow(1000, n));
        else
            newFigure = (int)figure;
        
        // form the hundred word
        switch ((int) (newFigure / 100)) {
            case 9: word += "nine hundred "; break;
            case 8: word += "eight hundred "; break;
            case 7: word += "seven hundred "; break;
            case 6: word += "six hundred "; break;
            case 5: word += "five hundred "; break;
            case 4: word += "four hundred "; break;
            case 3: word += "three hundred "; break;
            case 2: word += "two hundred "; break;
            case 1: word += "one hundred "; break;
            case 0: word += (n > 0 ? "and " : "");
            default:
        }
        
        // form the tens word
        int tens = newFigure % 100;
        switch ((int) (tens / 10)) {
            case 9: word += "and ninty "; break;
            case 8: word += "and eighty "; break;
            case 7: word += "and seventy "; break;
            case 6: word += "and sixty "; break;
            case 5: word += "and fifty "; break;
            case 4: word += "and forty "; break;
            case 3: word += "and thirty "; break;
            case 2: word += "and twenty "; break;
            case 1:
            switch (tens) {
                case 19: word += "and nineteen "; break;
                case 18: word += "and eighteen "; break;
                case 17: word += "and seventeen "; break;
                case 16: word += "and sixteen "; break;
                case 15: word += "and fifteen "; break;
                case 14: word += "and fourteen "; break;
                case 13: word += "and thirteen "; break;
                case 12: word += "and twelve "; break;
                case 11: word += "and eleven "; break;
                case 10: word += "and ten "; break;
                default:
            }
            default:
        }
        
        // form the unit word
        if (tens > 19 || tens < 10) 
        {
            switch (tens % 10) {
                case 9: word += "nine "; break; 
                case 8: word += "eight "; break;
                case 7: word += "seven "; break;
                case 6: word += "six "; break;
                case 5: word += "five "; break;
                case 4: word += "four "; break;
                case 3: word += "three "; break;
                case 2: word += "two "; break;
                case 1: word += "one "; break;
                default:
            }
        }
        if (n == 0)
            return word;
        else
            return word + wordIndex + figuresToWord (figure % Math.pow(1000, n));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ASCONApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ASCONApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ASCONApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ASCONApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // START MYSQL DAEMON
                new ASCONApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JLabel asconlogo;
    private javax.swing.JButton clientListButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton newClientButton;
    private javax.swing.JButton settingsButton;
    // End of variables declaration//GEN-END:variables
}
