package com.workoutrandomizer.gui;

import java.awt.Color;
import java.awt.Font;

/**
 * Color scheme and styling constants for the Skeet-themed GUI
 */
public class SkeetTheme {
    // Colors
    public static final Color BACKGROUND_DARK = new Color(13, 13, 13);
    public static final Color PANEL_DARK = new Color(20, 20, 20);
    public static final Color PANEL_DARKER = new Color(15, 15, 15);
    public static final Color ACCENT_CYAN = new Color(0, 191, 255);
    public static final Color TEXT_WHITE = new Color(240, 240, 240);
    public static final Color TEXT_GRAY = new Color(180, 180, 180);
    public static final Color HOVER_COLOR = new Color(30, 30, 30);
    public static final Color SELECTED_COLOR = new Color(25, 25, 25);
    public static final Color BORDER_COLOR = new Color(0, 191, 255, 100);
    
    // Fonts (with monospace fallback)
    public static final Font MAIN_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    public static final Font TITLE_FONT = new Font(Font.MONOSPACED, Font.BOLD, 18);
    public static final Font HEADER_FONT = new Font(Font.MONOSPACED, Font.BOLD, 16);
    public static final Font BUTTON_FONT = new Font(Font.MONOSPACED, Font.BOLD, 14);
    
    // Dimensions
    public static final int SIDEBAR_WIDTH = 200;
    public static final int WINDOW_WIDTH = 900;
    public static final int WINDOW_HEIGHT = 600;
    public static final int BORDER_THICKNESS = 1;
}
