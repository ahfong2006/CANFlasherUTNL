/*
 * CANFlasherUTNL - Flash tool for NXP LPC11C22/24 devices.
 * It writes HEX files via the built-in CAN bootloader to the target flash 
 * through an USBtin (USB-to-CAN interface).
 * http://www.fischl.de/can/bootloader/canflasherutnl/
 *
 * Copyright (C) 2016  Thomas Fischl 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.File;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.text.DefaultCaret;
import jssc.SerialPortList;

/**
 * Main window frame for CANFlasherUTNL
 * 
 * @author Thomas Fischl
 */
public class CANFlasherUTNL extends javax.swing.JFrame implements LPCFlashListener {

    /** File chooser dialog */
    final JFileChooser fc = new JFileChooser();
    
    /** Flash engine for LPC controller */
    LPCFlash lpcflash = new LPCFlash();
    
    /**
     * Creates new form CANFlasherUTNL
     */
    public CANFlasherUTNL() {
        initComponents();
        
        DefaultCaret caret = (DefaultCaret) logTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        lpcflash.addListener(this);
        
        Preferences prefs = Preferences.userNodeForPackage(CANFlasherUTNL.class);
        serialPort.setSelectedItem(prefs.get("PORT", "COM1"));
        fileNameField.setText(prefs.get("FILENAME", ""));
        
    }

    /**
     * Add output message to log window
     * @param message Message to print out
     */
    @Override
    public void outputMessage(String message) {
        logTextArea.append(message);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serialPort = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fileNameField = new javax.swing.JTextField();
        filebrowseButton = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        logTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CANFlasherUTNL v1.0");

        serialPort.setModel(new javax.swing.DefaultComboBoxModel(SerialPortList.getPortNames()));

        jLabel1.setText("USBtin port");

        jLabel2.setText("HEX filename");

        filebrowseButton.setText("Browse");
        filebrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filebrowseButtonActionPerformed(evt);
            }
        });

        uploadButton.setText("Upload");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        logTextArea.setEditable(false);
        logTextArea.setColumns(20);
        logTextArea.setRows(5);
        logTextArea.setText("CANFlahserUTNL is a flash utility for NXP LPC11C22/24 devices.\nIt writes HEX files via the built-in CAN bootloader to the target flash \nthrough an USB-to-CAN interface USBtin.\n\nUsage:\n1. Plugin USBtin (USB-to-CAN interface)\n2. Start this tool, select port and HEX file name\n3. Power up LPC with mode pins set for CAN bootloading\n4. Press \"Upload\" to start firmware upload");
        jScrollPane1.setViewportView(logTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(serialPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fileNameField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filebrowseButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(uploadButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(serialPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fileNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filebrowseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uploadButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Handle file browse button event
     * 
     * @param evt Action event
     */
    private void filebrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filebrowseButtonActionPerformed
        
        // open file chooser dialog
        fc.setSelectedFile(new File(fileNameField.getText()));
        int returnVal = fc.showOpenDialog(CANFlasherUTNL.this);

        // Take the file name on success
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            fileNameField.setText(file.getAbsolutePath());
        }        
    }//GEN-LAST:event_filebrowseButtonActionPerformed

    /**
     * Handle upload button event
     * 
     * @param evt Action event
     */
    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
   
        // clear log window
        logTextArea.setText("");
        
        // save settings
        Preferences prefs = Preferences.userNodeForPackage(CANFlasherUTNL.class);
        prefs.put("PORT", (String)serialPort.getSelectedItem());
        prefs.put("FILENAME", (String)fileNameField.getText());
                
        // run flash engine within new thread
        new Thread(new Runnable() {                                    
            public void run() {
              uploadButton.setEnabled(false);
              lpcflash.flash(serialPort.getSelectedItem().toString(), fileNameField.getText());
              uploadButton.setEnabled(true);

            }
        }).start();
    }//GEN-LAST:event_uploadButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CANFlasherUTNL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CANFlasherUTNL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CANFlasherUTNL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CANFlasherUTNL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CANFlasherUTNL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fileNameField;
    private javax.swing.JButton filebrowseButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea logTextArea;
    private javax.swing.JComboBox serialPort;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
}
