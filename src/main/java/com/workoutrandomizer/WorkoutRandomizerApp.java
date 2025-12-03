package com.workoutrandomizer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class WorkoutRandomizerApp extends JFrame {
    // Skeet-inspired color scheme
    private static final Color BG_DARK = new Color(18, 18, 18);
    private static final Color BG_DARKER = new Color(12, 12, 12);
    private static final Color ACCENT_COLOR = new Color(130, 195, 65);
    private static final Color ACCENT_HOVER = new Color(150, 215, 85);
    private static final Color TEXT_COLOR = new Color(220, 220, 220);
    private static final Color TEXT_SECONDARY = new Color(150, 150, 150);
    private static final Color BORDER_COLOR = new Color(40, 40, 40);

    private JPanel mainPanel;
    private JPanel exercisePanel;
    private JComboBox<String> splitSelector;
    private JButton randomizeButton;

    public WorkoutRandomizerApp() {
        setTitle("Workout Randomizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        // Set dark theme look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        initUI();
    }

    private void initUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(BG_DARK);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Header Panel
        JPanel headerPanel = createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Exercise Display Panel
        exercisePanel = createExercisePanel();
        mainPanel.add(exercisePanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private JPanel createHeaderPanel() {
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setBackground(BG_DARK);
        header.setBorder(new EmptyBorder(0, 0, 20, 0));

        // Title
        JLabel titleLabel = new JLabel("WORKOUT RANDOMIZER");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(ACCENT_COLOR);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(titleLabel, BorderLayout.NORTH);

        // Control Panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        controlPanel.setBackground(BG_DARK);

        // Split selector label
        JLabel splitLabel = new JLabel("Select Split:");
        splitLabel.setForeground(TEXT_COLOR);
        splitLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        controlPanel.add(splitLabel);

        // Split selector dropdown
        splitSelector = new JComboBox<>(ExerciseDatabase.getSplits());
        splitSelector.setPreferredSize(new Dimension(180, 35));
        splitSelector.setBackground(BG_DARKER);
        splitSelector.setForeground(TEXT_COLOR);
        splitSelector.setFont(new Font("Arial", Font.PLAIN, 14));
        splitSelector.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));
        controlPanel.add(splitSelector);

        // Randomize button
        randomizeButton = createStyledButton("RANDOMIZE");
        randomizeButton.addActionListener(e -> randomizeWorkout());
        controlPanel.add(randomizeButton);

        header.add(controlPanel, BorderLayout.CENTER);

        return header;
    }

    private JPanel createExercisePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(BG_DARKER);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COLOR, 1),
            new EmptyBorder(15, 15, 15, 15)
        ));

        JLabel placeholderLabel = new JLabel("Click RANDOMIZE to generate your workout");
        placeholderLabel.setForeground(TEXT_SECONDARY);
        placeholderLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        placeholderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(placeholderLabel, BorderLayout.CENTER);

        return panel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(140, 35));
        button.setBackground(ACCENT_COLOR);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(ACCENT_COLOR, 1));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(ACCENT_HOVER);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(ACCENT_COLOR);
            }
        });

        return button;
    }

    private void randomizeWorkout() {
        String selectedSplit = (String) splitSelector.getSelectedItem();
        List<Exercise> exercises = ExerciseDatabase.getRandomExercises(selectedSplit, 6);

        // Rebuild exercise panel
        mainPanel.remove(exercisePanel);
        exercisePanel = new JPanel();
        exercisePanel.setLayout(new GridLayout(0, 1, 0, 10));
        exercisePanel.setBackground(BG_DARKER);
        exercisePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COLOR, 1),
            new EmptyBorder(15, 15, 15, 15)
        ));

        // Add title
        JLabel workoutTitle = new JLabel(selectedSplit + " Workout");
        workoutTitle.setFont(new Font("Arial", Font.BOLD, 18));
        workoutTitle.setForeground(ACCENT_COLOR);
        workoutTitle.setBorder(new EmptyBorder(0, 0, 10, 0));
        exercisePanel.add(workoutTitle);

        // Add exercises
        for (int i = 0; i < exercises.size(); i++) {
            Exercise exercise = exercises.get(i);
            JPanel exerciseItem = createExerciseItem(i + 1, exercise);
            exercisePanel.add(exerciseItem);
        }

        mainPanel.add(exercisePanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private JPanel createExerciseItem(int number, Exercise exercise) {
        JPanel item = new JPanel();
        item.setLayout(new BorderLayout(10, 0));
        item.setBackground(BG_DARK);
        item.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COLOR, 1),
            new EmptyBorder(12, 15, 12, 15)
        ));

        // Number label
        JLabel numberLabel = new JLabel(String.valueOf(number));
        numberLabel.setFont(new Font("Arial", Font.BOLD, 16));
        numberLabel.setForeground(ACCENT_COLOR);
        numberLabel.setPreferredSize(new Dimension(30, 20));
        item.add(numberLabel, BorderLayout.WEST);

        // Exercise name
        JLabel nameLabel = new JLabel(exercise.getName());
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        nameLabel.setForeground(TEXT_COLOR);
        item.add(nameLabel, BorderLayout.CENTER);

        // Equipment badge
        JLabel equipmentLabel = new JLabel(exercise.getEquipment());
        equipmentLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        equipmentLabel.setForeground(TEXT_SECONDARY);
        equipmentLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COLOR, 1),
            new EmptyBorder(3, 8, 3, 8)
        ));
        item.add(equipmentLabel, BorderLayout.EAST);

        return item;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WorkoutRandomizerApp app = new WorkoutRandomizerApp();
            app.setVisible(true);
        });
    }
}
