/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlPanel;

import asconapplication.ASCONApplication;
import asconapplication.Constants;
import asconapplication.SchemaHelper;
import alertDialog.ConfirmMessageDialog;
import alertDialog.ErrorMessageDialog;
import alertDialog.SuccessMessageDialog;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Formatter;
import java.util.Locale;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import objectScripts.Client;

/**
 *
 * @author Nehemiah Oluwafemi
 * rotenehe@gmail.com
 */

public final class ClientViewPage extends javax.swing.JPanel
    implements Constants {

    // instance variable
    private final ASCONApplication asconApp;
    private final Client mClient;
    private javax.swing.JPanel printer;
    
    /**
     * Creates new form ViewClientPanel
     * @param ascon
     * @param client
     */
    public ClientViewPage(ASCONApplication ascon, Client client) {
        initComponents ();
        
        
        this.asconApp = ascon;
        mClient = client;
        setPage ();
    }
    
    // constructor that constructors page from client's id
    public ClientViewPage (ASCONApplication parent, long clientId)
    {
        initComponents ();
        this.asconApp = parent;
        
        // get client's profile
        mClient = parent.getSchema().getClientById (clientId);
        setPage();
    }
    
    
    // method to set the page
    private void setPage ()
    {
        // local variable
        SchemaHelper mSchema = asconApp.getSchema();
        
        // block to set the page
        StyledDocument doc = printerPane.getStyledDocument();
        
        // set styles
        Style def = StyleContext.getDefaultStyleContext()
                .getStyle(StyleContext.DEFAULT_STYLE);
        
        Style plain = doc.addStyle("plain", def);
        StyleConstants.setFontFamily(plain, "Serif");
        StyleConstants.setFontSize(plain, 12);
        StyleConstants.setLineSpacing(plain, 100f);
        
        Style bold = doc.addStyle("bold", plain);
        StyleConstants.setBold(bold, true);
        StyleConstants.setLineSpacing(bold, 150f);
        
        Style small = doc.addStyle("small", plain);
        StyleConstants.setFontSize(small, 7);
        StyleConstants.setLineSpacing(small, 5f);
        
        try {
            // show the header
            doc.insertString(doc.getLength(), "Personal Details\tRef. No: " +
                    mClient.getClientStringAttribute(mSchema, Client.REFERENCE_NUMBER),
                    doc.getStyle("bold"));
            
            // Personal Details
            doc.insertString(doc.getLength(), "\nName: " + 
                    mClient.getClientStringAttribute(mSchema, Client.NAME), 
                    doc.getStyle("plain"));
            doc.insertString(doc.getLength(), "\nCompany: " + 
                    mClient.getClientStringAttribute(mSchema, Client.COMPANY), 
                    doc.getStyle("plain"));
            doc.insertString(doc.getLength(), "\nAddress: " + 
                    mClient.getClientStringAttribute(mSchema, Client.ADDRESS), 
                    doc.getStyle("plain"));
            
            // Residential Details
            doc.insertString(doc.getLength(), "\n\nResidental Details", 
                    doc.getStyle("bold"));
            doc.insertString(doc.getLength(), "\nAccomodation: " + 
                    mClient.getClientStringAttribute(mSchema, Client.ACCOMODATION), 
                    doc.getStyle("plain"));
            doc.insertString(doc.getLength(), "\nBlock: " + 
                    mClient.getClientStringAttribute(mSchema, Client.BLOCK), 
                    doc.getStyle("plain"));
            doc.insertString(doc.getLength(), "\nLocation: " + 
                    mClient.getClientStringAttribute(mSchema, Client.LOCATION), 
                    doc.getStyle("plain"));
            doc.insertString(doc.getLength(), "\nRoom Number: " + 
                    mClient.getClientStringAttribute(mSchema, Client.ROOM_NUMBER), 
                    doc.getStyle("plain"));
            doc.insertString(doc.getLength(), "\nOccupant Type: " + 
                    mClient.getClientStringAttribute(mSchema, Client.OCCUPANT), 
                    doc.getStyle("plain"));
            doc.insertString(doc.getLength(), "\nArrival Date: " + 
                    mClient.getClientStringAttribute(mSchema, Client.ARRIVAL_DATE), 
                    doc.getStyle("plain"));
            doc.insertString(doc.getLength(), "\nDeparture Date: " + 
                    mClient.getClientStringAttribute(mSchema, Client.DEPARTURE_DATE), 
                    doc.getStyle("plain"));
            doc.insertString(doc.getLength(), "\nStatus: " + 
                    mClient.getClientStringAttribute(mSchema, Client.STATUS), 
                    doc.getStyle("plain"));
            doc.insertString(doc.getLength(), "\nRemark: " + 
                    mClient.getClientStringAttribute(mSchema, Client.REMARK), 
                    doc.getStyle("plain"));
            
            // Course Details
            doc.insertString(doc.getLength(), "\n\nCourse Details",
                    doc.getStyle("bold"));
            
            doc.insertString(doc.getLength(), "\nCourse: " + 
                    mClient.getClientStringAttribute(mSchema, Client.COURSE_TITLE), 
                    doc.getStyle("plain"));
            doc.insertString(doc.getLength(), "\nDepartment: " + 
                    mClient.getClientStringAttribute(mSchema, Client.DEPARTMENT), 
                    doc.getStyle("plain"));
            doc.insertString(doc.getLength(), "\nCost: " + 
                    asconApp.amountToWord(mClient.getClientCost ()), 
                    doc.getStyle("bold"));
            
            // cost formatter
            Formatter f = new Formatter ();
            f.format("%(,.2f", mClient.getClientCost());
            doc.insertString(doc.getLength(), " (" + f.toString() + ")", 
                    doc.getStyle("plain"));
        } catch (BadLocationException e) {
            ErrorMessageDialog.show(asconApp, "BAD LOCATION EXCEPTION",
                    e.getMessage());
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        buttonPanel = new javax.swing.JPanel();
        printButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        printerPanel = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        detailsPanel = new javax.swing.JPanel();
        printerPane = new javax.swing.JTextPane();

        jScrollPane1.setViewportView(jTextPane1);

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(650, 512));

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printButton)
                    .addComponent(deleteButton)
                    .addComponent(editButton))
                .addGap(0, 0, 0))
        );

        printerPanel.setBackground(new java.awt.Color(255, 255, 255));

        logoPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/printLogo.jpg"))); // NOI18N

        javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        logoPanelLayout.setVerticalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        detailsPanel.setBackground(new java.awt.Color(255, 255, 255));

        printerPane.setEditable(false);
        printerPane.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        printerPane.setMargin(new java.awt.Insets(5, 5, 5, 5));

        javax.swing.GroupLayout detailsPanelLayout = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(detailsPanelLayout);
        detailsPanelLayout.setHorizontalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(printerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        detailsPanelLayout.setVerticalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(printerPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout printerPanelLayout = new javax.swing.GroupLayout(printerPanel);
        printerPanel.setLayout(printerPanelLayout);
        printerPanelLayout.setHorizontalGroup(
            printerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(detailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        printerPanelLayout.setVerticalGroup(
            printerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printerPanelLayout.createSequentialGroup()
                .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(printerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(printerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        // confirm action
        boolean response = ConfirmMessageDialog.show(
                asconApp, "Are you sure you want to delete Client's record?");
        if (response) {
            boolean deleted = asconApp.getSchema().deleteClient (
                    mClient.getClientLongAttribute(Client.ID));
            
            if (deleted) {
                SuccessMessageDialog.show(asconApp, "Client Deleted Successfully");
                asconApp.changeActionPage(ACTION_CONTROLLER.CLIENT_PAGE);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
        printDetails ();
    }//GEN-LAST:event_printButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        // lauch the Edit page
        asconApp.showClientEditPage(mClient, ACTION_CONTROLLER.CLIENT_PRINT_VIEW);
    }//GEN-LAST:event_editButtonActionPerformed

    /*
    ** THIS method prints the details on the View Client page
    */
    private void printDetails ()
    {
        // instantiate the Job control
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new PrintClient ());
        
        // get the print attributes
        PrintRequestAttributeSet set = new HashPrintRequestAttributeSet ();
        
        // show dialog
        boolean doPrint = job.printDialog(set);
        
        // perform the printing operation
        if (doPrint) {
            try {
                StyledDocument doc = printerPane.getStyledDocument();
                doc.insertString(doc.getLength(), "\n\n\n\n\nPowered By"
                        + "\nRotneil IT (c)2016"
                        + "\n(+234 805 323 7746, rotneil@yahoo.com)",
                        doc.getStyle("small"));
                
                job.setJobName("Rotneil IT Consult (ASCON: " 
                        + mClient.getClientName().split(" ")[0] + ")");
                        
                job.print();
                SuccessMessageDialog.show(asconApp, "Client profile printed " +
                        "successfully");
                asconApp.changeActionPage(ACTION_CONTROLLER.CLIENT_PAGE);
            } catch (PrinterException | BadLocationException e) {
                ErrorMessageDialog.show(asconApp, e.getMessage());
            }
        }
    }
    
    private class PrintClient implements Printable {

        @Override
        public int print(Graphics graphics, PageFormat pf, int pageIndex) 
                throws PrinterException
        {
            if (pageIndex > 0)
                return NO_SUCH_PAGE;
            
            // translate graphics so as to stay within imageable valus in
            // Page format
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate (pf.getImageableX(), pf.getImageableY());
            
            // print Printer's panel
            printerPanel.printAll(g2d);
            return PAGE_EXISTS;
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JButton printButton;
    private javax.swing.JTextPane printerPane;
    private javax.swing.JPanel printerPanel;
    // End of variables declaration//GEN-END:variables
}
