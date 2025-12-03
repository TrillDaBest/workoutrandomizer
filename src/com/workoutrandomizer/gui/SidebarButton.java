package com.workoutrandomizer.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Custom styled button for the sidebar navigation
 */
public class SidebarButton extends JButton {
    private boolean selected = false;
    
    public SidebarButton(String text) {
        super(text);
        setupStyle();
    }
    
    private void setupStyle() {
        setFont(SkeetTheme.MAIN_FONT);
        setForeground(SkeetTheme.TEXT_GRAY);
        setBackground(SkeetTheme.PANEL_DARK);
        setFocusPainted(false);
        setBorderPainted(true);
        setBorder(new LineBorder(SkeetTheme.PANEL_DARK, 1));
        setContentAreaFilled(true);
        setOpaque(true);
        setHorizontalAlignment(SwingConstants.LEFT);
        setMargin(new Insets(10, 15, 10, 15));
        
        // Mouse hover effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!selected) {
                    setBackground(SkeetTheme.HOVER_COLOR);
                    setBorder(new LineBorder(SkeetTheme.BORDER_COLOR, 1));
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (!selected) {
                    setBackground(SkeetTheme.PANEL_DARK);
                    setBorder(new LineBorder(SkeetTheme.PANEL_DARK, 1));
                }
            }
        });
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected) {
            setBackground(SkeetTheme.SELECTED_COLOR);
            setForeground(SkeetTheme.ACCENT_CYAN);
            setBorder(new LineBorder(SkeetTheme.ACCENT_CYAN, 2));
        } else {
            setBackground(SkeetTheme.PANEL_DARK);
            setForeground(SkeetTheme.TEXT_GRAY);
            setBorder(new LineBorder(SkeetTheme.PANEL_DARK, 1));
        }
    }
}
