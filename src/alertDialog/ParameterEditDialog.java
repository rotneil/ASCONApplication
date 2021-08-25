/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alertDialog;

import asconapplication.ApplicationHomePage;
import asconapplication.Constants;

/**
 *
 * @author Oluwafemi nehemiah
 * rotenehe@gmail.com
 */
public final class ParameterEditDialog extends javax.swing.JDialog 
    implements Constants
{

    // instance variables
    private ApplicationHomePage parent;
    private ParameterEditListener mListener;
    private int settingType;
    private int settingId;
    
    // listener for calling panel
    public interface ParameterEditListener {
        public abstract void onDispose ();
    }
    /**
     * Creates new form ParameterEditDialog
     * @param parent
     * This is the Parent Application
     * @param listener
     * The listening interface
     */
    public ParameterEditDialog(ApplicationHomePage parent, 
            ParameterEditListener listener, int setting, int id) {
        super(parent, true);
        this.parent = parent;
        this.settingType = setting;
        this.settingId = id;
        mListener = listener;
        initComponents();
        setFields ();
        this.setLocationRelativeTo(parent);
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
        jLabel1 = new javax.swing.JLabel();
        typeField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Variable Type:");

        typeField.setEditable(false);

        jLabel2.setText("Variable Name:");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        modifyButton.setText("Modify");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Delete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                    .addComponent(nameField)
                    .addComponent(typeField))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(typeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(modifyButton)
                    .addComponent(jButton1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        // TODO add your handling code here:
        modifySettingsVariable ();
    }//GEN-LAST:event_modifyButtonActionPerformed

    // METHOD TO MODIFY A SETTING VARIABLE
    private void modifySettingsVariable ()
    {
        // update item on the database
        boolean status = parent.getSchema().modifySettingsVariable(
                settingType, settingId, nameField.getText());
        
        // display success message
        if (status) {
            SuccessMessageDialog.show(parent, "Setting item modified successfully");
            dispose ();
        }
    }
    
    // METHOD TO DELETE AN ITEM
    private void deleteSettingsVariable ()
    {
        // delete item from the database
        boolean status = parent.getSchema().deleteSettingsVariable(
                settingType, settingId);
        
        // display success message
        if (status) {
            SuccessMessageDialog.show(parent, "Setting parameter deleted" +
                    " successfully");
            dispose ();
        }
    }
    
    // METHOD TO SET THE FIELD VALUES
    private void setFields ()
    {
        // get the SettingsVariable based on the parameters
        String name = parent.getSchema().getSettingNameById(
                settingType, settingId);
        nameField.setText(name);
        
        // set the title of the dialog
        switch (settingType) {
            case 0: // ACCOMODATION
                setTitle ("Accomodation Parameter Dialog");
                typeField.setText("Accomodation Setting");
                break;
            case 1: // BLOCK TYPE
                setTitle ("Block Type Dialog");
                typeField.setText("Block Type Setting");
                break;
            case 2: // LOCATION
                setTitle ("Location Parameter Dialog");
                typeField.setText("Location Setting");
                break;
            case 3: // OCCUPANT
                setTitle ("Occupant Type Dialog");
                typeField.setText("Occupant Type Setting");
                break;
            default:
        }
        
        // 
    }
    
    @Override
    public void dispose ()
    {
        mListener.onDispose();
        super.dispose();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField typeField;
    // End of variables declaration//GEN-END:variables
}