/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listModel;

import asconapplication.ASCONApplication;
import asconapplication.SchemaHelper;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import objectScripts.Client;

/**
 *
 * @author Oluwafemi Nehemiah
 * rotenehe@gmail.com
 */
public class ClientCellRenderer extends javax.swing.JPanel 
    implements ListCellRenderer <Client> {

    // instance variables
    private ASCONApplication parent;
    private SchemaHelper mSchema;
    
    /**
     * Creates new form ClientCellRenderer
     */
    public ClientCellRenderer(ASCONApplication parent) {
        initComponents();
        this.parent = parent;
        mSchema = parent.getSchema();
        setOpaque (true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        companyLabel = new javax.swing.JLabel();
        accomodationLabel = new javax.swing.JLabel();
        refLabel = new javax.swing.JLabel();
        courseLabel = new javax.swing.JLabel();

        nameLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
            .addComponent(companyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(accomodationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(courseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(refLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(companyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(accomodationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(courseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(refLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accomodationLabel;
    private javax.swing.JLabel companyLabel;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel refLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList<? extends Client> list, 
            Client value, int index, boolean isSelected, boolean cellHasFocus) {
        nameLabel.setText(value.getClientStringAttribute(mSchema, 
                Client.NAME));
        companyLabel.setText(value.getClientStringAttribute(mSchema,
                Client.COMPANY));
        accomodationLabel.setText(value.getClientStringAttribute(mSchema,
                Client.ACCOMODATION));
        courseLabel.setText(value.getClientStringAttribute(mSchema,
                Client.COURSE_TITLE));
        refLabel.setText("Ref No: " + value.getClientStringAttribute(mSchema,
                Client.REFERENCE_NUMBER));
        Color background;
        Color foreground;
        
        // check if the cell is selected or not
        if (isSelected) {
            background = Color.cyan;
            foreground = Color.white;
        } else {
            background = Color.white;
            foreground = Color.black;
        }
        
        setBackground (background);
        setForeground (foreground);
        return this;
    }
}
