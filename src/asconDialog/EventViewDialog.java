/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asconDialog;

import asconapplication.ASCONApplication;
import asconapplication.Constants;
import java.util.Calendar;
import javax.swing.JPanel;
import objectScripts.ASCONEvent;

/**
 *
 * @author Oluwafemi Nehemiah
 * Rotneil IT Consult
 * rotneil@yahoo.com
 */
public final class EventViewDialog extends javax.swing.JDialog implements Constants{

    // instance variables
    private final ASCONApplication asconApp;
    private final JPanel host;
    private final ASCONEvent mEvent;
    
    /**
     * Creates new form EventDialog
     * @param ascon The ASCONApplication
     * @param host The host panel
     * @param event The event to be viewed
     */
    public EventViewDialog(ASCONApplication ascon, JPanel host, ASCONEvent event) 
    {
        super(ascon, true);
        
        this.asconApp = ascon;
        this.host = host;
        this.mEvent = event;
        initComponents();
        
        // adjust event button to suilt caller
        setParams ();
        setLocationRelativeTo (host);
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
        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ASCON Event View");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        eventTextArea.setEditable(false);
        eventTextArea.setColumns(20);
        eventTextArea.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        eventTextArea.setLineWrap(true);
        eventTextArea.setRows(5);
        eventTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(eventTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
            .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(okButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        setVisible (false);
    }//GEN-LAST:event_okButtonActionPerformed

    // METHOD TO ADJUST PAGE TO THE CALLER
    private void setParams ()
    {
        // get event date and message
        try {
            eventTextArea.setText(mEvent.getMessage());

            // set the event date beneath the event message
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(mEvent.getDate());
            String [] month = asconApp.getMonthOfYear();
            eventTextArea.append("\n\n\t" + cal.get(Calendar.DAY_OF_MONTH) + " " +
                month [cal.get(Calendar.MONTH)] + ", " + cal.get(Calendar.YEAR));
        } catch (Exception e) {}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea eventTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
