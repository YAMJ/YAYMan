/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ImagePopupFrame.java
 *
 * Created on May 25, 2010, 3:01:41 PM
 */

package yayman;

import javax.swing.*;
import java.awt.*;

public class ImagePopupFrame extends javax.swing.JFrame {
    private ImageIcon theImage;
    private int minWidth;
    private int minHeight;
    private JComponent anchor;

    public ImagePopupFrame(ImageIcon img, JComponent comp) {
        initComponents();
        minWidth = comp.getWidth();
        minHeight = comp.getHeight();
        anchor = comp;
        theImage = img;
        this.scaleImage(minWidth, minHeight);
        this.setLocation(comp.getLocationOnScreen().x-this.getWidth()+minWidth, comp.getLocationOnScreen().y);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusable(false);
        setFocusableWindowState(false);
        setName("Form"); // NOI18N
        setResizable(false);
        setUndecorated(true);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(yayman.YAYManApp.class).getContext().getResourceMap(ImagePopupFrame.class);
        imgLabel.setBackground(resourceMap.getColor("imgLabel.background")); // NOI18N
        imgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLabel.setText(resourceMap.getString("imgLabel.text")); // NOI18N
        imgLabel.setName("imgLabel"); // NOI18N
        imgLabel.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                imgLabelMouseWheelMoved(evt);
            }
        });
        imgLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imgLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imgLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgLabelMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_imgLabelMouseClicked

    private void imgLabelMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_imgLabelMouseWheelMoved
        if (this.isVisible()) {
            double w = this.getWidth();
            int origEast = this.getLocationOnScreen().x+this.getWidth();
            double h = this.getHeight();
            if (evt.getWheelRotation() > 0) {
                w = w*1.1;
                h = h*1.1;
            } else {
                w = w*.9;
                h = h*.9;
            }
            if (w < minWidth) w = minWidth;
            if (h < minHeight) h = minHeight;
            this.scaleImage((int)w, (int)h);
        }
    }//GEN-LAST:event_imgLabelMouseWheelMoved

    private void imgLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgLabelMouseExited
        this.setVisible(false);
    }//GEN-LAST:event_imgLabelMouseExited

    public void specialResize(int w, int h) {
        this.setBounds(anchor.getLocationOnScreen().x-w+minWidth, anchor.getLocationOnScreen().y, w, h);
    }

    public void scaleImage(int maxW, int maxH) {
        Image img = theImage.getImage();
        int w = maxW;
        int h = maxH;
        int iw = img.getWidth(null);
        int ih = img.getHeight(null);
        double xScale = (double)w/iw;
        double yScale = (double)h/ih;
        double scale = Math.min(xScale, yScale);
        int width = (int)(scale*iw);
        int height = (int)(scale*ih);
        ImageIcon scaledImage = new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_FAST));
        imgLabel.setIcon(scaledImage);
        specialResize(scaledImage.getIconWidth(), scaledImage.getIconHeight());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgLabel;
    // End of variables declaration//GEN-END:variables

}
