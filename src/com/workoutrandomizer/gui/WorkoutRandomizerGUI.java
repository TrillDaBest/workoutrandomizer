package com.workoutrandomizer.gui;

import com.workoutrandomizer.data.WorkoutGenerator;
import com.workoutrandomizer.model.Exercise;
import com.workoutrandomizer.model.WorkoutSplit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Main application window with Skeet-themed GUI
 */
public class WorkoutRandomizerGUI extends JFrame {
    private final WorkoutGenerator workoutGenerator;
    private WorkoutSplit currentSplit;
    private final List<SidebarButton> sidebarButtons;
    
    // GUI Components
    private JPanel mainContentPanel;
    private JTextArea workoutDisplay;
    private JLabel titleLabel;
    
    public WorkoutRandomizerGUI() {
        this.workoutGenerator = new WorkoutGenerator();
        this.currentSplit = WorkoutSplit.LEGS;
        this.sidebarButtons = new ArrayList<>();
        
        setupFrame();
        setupUI();
        setVisible(true);
    }
    
    private void setupFrame() {
        setTitle("Workout Randomizer");
        setSize(SkeetTheme.WINDOW_WIDTH, SkeetTheme.WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(SkeetTheme.BACKGROUND_DARK);
    }
    
    private void setupUI() {
        setLayout(new BorderLayout());
        
        // Header
        add(createHeader(), BorderLayout.NORTH);
        
        // Sidebar
        add(createSidebar(), BorderLayout.WEST);
        
        // Main content area
        add(createMainContent(), BorderLayout.CENTER);
    }
    
    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setBackground(SkeetTheme.PANEL_DARKER);
        header.setPreferredSize(new Dimension(SkeetTheme.WINDOW_WIDTH, 60));
        header.setBorder(new LineBorder(SkeetTheme.BORDER_COLOR, 1));
        
        JLabel title = new JLabel("WORKOUT RANDOMIZER");
        title.setFont(SkeetTheme.TITLE_FONT);
        title.setForeground(SkeetTheme.ACCENT_CYAN);
        
        header.add(title);
        return header;
    }
    
    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setBackground(SkeetTheme.PANEL_DARK);
        sidebar.setPreferredSize(new Dimension(SkeetTheme.SIDEBAR_WIDTH, getHeight()));
        sidebar.setBorder(new LineBorder(SkeetTheme.BORDER_COLOR, 1));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        
        // Add padding at top
        sidebar.add(Box.createVerticalStrut(20));
        
        // Section label
        JLabel sectionLabel = new JLabel("WORKOUT SPLITS");
        sectionLabel.setFont(SkeetTheme.HEADER_FONT);
        sectionLabel.setForeground(SkeetTheme.TEXT_GRAY);
        sectionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(sectionLabel);
        
        sidebar.add(Box.createVerticalStrut(15));
        
        // Add buttons for each split
        for (WorkoutSplit split : WorkoutSplit.values()) {
            SidebarButton button = new SidebarButton(split.getDisplayName());
            button.setMaximumSize(new Dimension(SkeetTheme.SIDEBAR_WIDTH - 10, 45));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            button.addActionListener(e -> selectSplit(split, button));
            
            sidebar.add(button);
            sidebar.add(Box.createVerticalStrut(5));
            sidebarButtons.add(button);
        }
        
        // Select first button by default
        if (!sidebarButtons.isEmpty()) {
            sidebarButtons.get(0).setSelected(true);
        }
        
        // Add glue to push everything to top
        sidebar.add(Box.createVerticalGlue());
        
        return sidebar;
    }
    
    private JPanel createMainContent() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(SkeetTheme.BACKGROUND_DARK);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Title panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(SkeetTheme.BACKGROUND_DARK);
        titleLabel = new JLabel("LEGS WORKOUT");
        titleLabel.setFont(SkeetTheme.HEADER_FONT);
        titleLabel.setForeground(SkeetTheme.ACCENT_CYAN);
        titlePanel.add(titleLabel);
        
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        
        // Workout display area
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(SkeetTheme.PANEL_DARKER);
        displayPanel.setBorder(new LineBorder(SkeetTheme.BORDER_COLOR, 2));
        
        workoutDisplay = new JTextArea();
        workoutDisplay.setFont(SkeetTheme.MAIN_FONT);
        workoutDisplay.setForeground(SkeetTheme.TEXT_WHITE);
        workoutDisplay.setBackground(SkeetTheme.PANEL_DARKER);
        workoutDisplay.setEditable(false);
        workoutDisplay.setMargin(new Insets(20, 20, 20, 20));
        workoutDisplay.setLineWrap(true);
        workoutDisplay.setWrapStyleWord(true);
        workoutDisplay.setText("Click 'GENERATE WORKOUT' to create a randomized workout plan.");
        
        JScrollPane scrollPane = new JScrollPane(workoutDisplay);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(SkeetTheme.PANEL_DARKER);
        
        displayPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(displayPanel, BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(SkeetTheme.BACKGROUND_DARK);
        buttonPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
        
        SkeetButton generateButton = new SkeetButton("GENERATE WORKOUT");
        generateButton.addActionListener(e -> generateWorkout());
        
        buttonPanel.add(generateButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        return mainPanel;
    }
    
    private void selectSplit(WorkoutSplit split, SidebarButton clickedButton) {
        this.currentSplit = split;
        
        // Update button states
        for (SidebarButton button : sidebarButtons) {
            button.setSelected(button == clickedButton);
        }
        
        // Update title
        titleLabel.setText(split.getDisplayName().toUpperCase() + " WORKOUT");
        
        // Clear workout display
        workoutDisplay.setText("Click 'GENERATE WORKOUT' to create a randomized workout plan.");
    }
    
    private void generateWorkout() {
        List<Exercise> workout = workoutGenerator.generateWorkout(currentSplit);
        
        StringBuilder sb = new StringBuilder();
        sb.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        sb.append("  ").append(currentSplit.getDisplayName().toUpperCase()).append(" WORKOUT\n");
        sb.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n");
        
        for (int i = 0; i < workout.size(); i++) {
            Exercise exercise = workout.get(i);
            sb.append(String.format("%d. %s\n", i + 1, exercise.getFullName()));
            sb.append("   Sets: 3-4  |  Reps: 8-12\n\n");
        }
        
        sb.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        sb.append("Total Exercises: ").append(workout.size()).append("\n");
        
        workoutDisplay.setText(sb.toString());
    }
    
    public static void main(String[] args) {
        // Set system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create and show GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(WorkoutRandomizerGUI::new);
    }
}
