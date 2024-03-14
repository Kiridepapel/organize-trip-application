package com.organizetrip.organizetripapplication.components;

import javax.swing.*;
import com.organizetrip.organizetripapplication.classes.Review;

public class ReviewPanel extends JPanel {
    // Variables declaration
    private JButton dpnBtnStar;
    private JLabel dpnImg;
    private JLabel dpnLblName;
    private JLabel dpnLblStar;
    private JPanel dpnPanel;
    private JScrollPane dpnScrollPane;
    private JEditorPane dpnTxtAreaDescription;

    public ReviewPanel(Review review) {
        // Configura el panel y añade los elementos
        init(review);
    }

    private void init(Review review) {
        dpnPanel = new JPanel();
        dpnImg = new JLabel();
        dpnLblName = new JLabel();
        dpnBtnStar = new JButton();
        dpnLblStar = new JLabel();
        dpnScrollPane = new JScrollPane();
        dpnTxtAreaDescription = new JEditorPane();

        dpnPanel.setBackground(new java.awt.Color(61, 61, 61));

        dpnImg.setIcon(new ImageIcon(getClass().getResource(review.getImgUrl()))); // NOI18N

        dpnLblName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dpnLblName.setForeground(new java.awt.Color(255, 255, 255));
        dpnLblName.setHorizontalAlignment(SwingConstants.LEFT);
        dpnLblName.setText(review.getName());

        dpnBtnStar.setIcon(new ImageIcon(getClass().getResource("/assets/images/small_star.png"))); // NOI18N
        dpnBtnStar.setBorder(null);
        dpnBtnStar.setBorderPainted(false);
        dpnBtnStar.setContentAreaFilled(false);
        dpnBtnStar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        dpnLblStar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        dpnLblStar.setForeground(new java.awt.Color(255, 255, 255));
        dpnLblStar.setHorizontalAlignment(SwingConstants.CENTER);
        dpnLblStar.setText(review.getRating().toString());

        dpnTxtAreaDescription.setEditable(false);
        dpnTxtAreaDescription.setBackground(new java.awt.Color(61, 61, 61));
        dpnTxtAreaDescription.setBorder(null);
        dpnTxtAreaDescription.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        dpnTxtAreaDescription.setForeground(java.awt.Color.white);
        dpnTxtAreaDescription.setText(review.getComment());
        dpnTxtAreaDescription.setToolTipText("");
        dpnTxtAreaDescription.setCaretColor(new java.awt.Color(61, 61, 61));
        dpnTxtAreaDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        dpnScrollPane.setViewportView(dpnTxtAreaDescription);
        
        GroupLayout dpnPanelLayout = new GroupLayout(dpnPanel);
        dpnPanel.setLayout(dpnPanelLayout);
        dpnPanelLayout.setHorizontalGroup(
            dpnPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(dpnPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(dpnPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(dpnPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(dpnLblStar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(dpnBtnStar))
                    .addComponent(dpnImg))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dpnPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(dpnLblName, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpnScrollPane, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        dpnPanelLayout.setVerticalGroup(
            dpnPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, dpnPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dpnImg, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dpnPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dpnLblStar, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpnBtnStar, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addGroup(dpnPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(dpnLblName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dpnScrollPane, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        dpnPanel.add(dpnImg);
        dpnPanel.add(dpnLblName);
        dpnPanel.add(dpnBtnStar);
        dpnPanel.add(dpnLblStar);
        dpnPanel.add(dpnScrollPane);
        this.add(dpnPanel);
    }
}
