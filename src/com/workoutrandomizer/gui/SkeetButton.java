package com.workoutrandomizer.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Custom styled button with Skeet theme
 */
public class SkeetButton extends JButton {
    
    public SkeetButton(String text) {
        super(text);
        setupStyle();
    }
    
    private void setupStyle() {
        setFont(SkeetTheme.BUTTON_FONT);
        setForeground(SkeetTheme.TEXT_WHITE);
        setBackground(SkeetTheme.PANEL_DARKER);
        setFocusPainted(false);
        setBorderPainted(true);
        setBorder(new LineBorder(SkeetTheme.ACCENT_CYAN, 2));
        setContentAreaFilled(true);
        setOpaque(true);
        setPreferredSize(new Dimension(180, 40));
        
        // Mouse hover effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(SkeetTheme.HOVER_COLOR);
                setForeground(SkeetTheme.ACCENT_CYAN);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(SkeetTheme.PANEL_DARKER);
                setForeground(SkeetTheme.TEXT_WHITE);
            }
        });
    }
}
