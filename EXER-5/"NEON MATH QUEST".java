import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NeonMathQuest extends JFrame implements ActionListener {

   
    private JLabel questionLabel, timerLabel, streakLabel, scoreLabel;
    private JTextField inputField;
    private JButton btnSubmit, btnReset;
    private JRadioButton radEasy, radMed, radHard;
    private JCheckBox[] opBoxes;
    
   
    private int score = 0, streak = 0, timeLeft = 15;
    private BigInteger correctAnswer;
    private int rangeMin = 1, rangeMax = 20;
    private final Random rand = new Random();
    private Timer gameTimer;


    private final Color DARK_BG = new Color(18, 18, 18);
    private final Color ACCENT_CYAN = new Color(0, 255, 255);
    private final Color ACCENT_PINK = new Color(255, 0, 255);
    private final Font DISPLAY_FONT = new Font("Monospaced", Font.BOLD, 42);

    public NeonMathQuest() {
        setupWindow();
        initTimer();
        

        setLayout(new BorderLayout());
        
    
        JPanel header = new JPanel(new GridLayout(1, 3));
        header.setBackground(DARK_BG);
        streakLabel = createStatLabel("STREAK: 0", ACCENT_PINK);
        timerLabel = createStatLabel("TIME: 15", Color.YELLOW);
        scoreLabel = createStatLabel("SCORE: 0", ACCENT_CYAN);
        header.add(streakLabel);
        header.add(timerLabel);
        header.add(scoreLabel);
        add(header, BorderLayout.NORTH);

        
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(DARK_BG);
        questionLabel = new JLabel("READY?");
        questionLabel.setFont(DISPLAY_FONT);
        questionLabel.setForeground(Color.WHITE);
        centerPanel.add(questionLabel);
        add(centerPanel, BorderLayout.CENTER);

        
        JPanel interactionPanel = new JPanel(new FlowLayout());
        interactionPanel.setBackground(DARK_BG);
        inputField = new JTextField(8);
        inputField.setFont(new Font("Monospaced", Font.BOLD, 30));
        inputField.setBackground(Color.BLACK);
        inputField.setForeground(ACCENT_CYAN);
        inputField.setCaretColor(Color.WHITE);
        
        btnSubmit = new JButton("VAPORIZE");
        styleButton(btnSubmit, ACCENT_CYAN);
        btnSubmit.addActionListener(this);

        interactionPanel.add(inputField);
        interactionPanel.add(btnSubmit);
        
      
        JPanel footer = new JPanel(new GridLayout(1, 2));
        footer.setBackground(DARK_BG);
        footer.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, ACCENT_CYAN));

      
        JPanel opsPanel = new JPanel();
        opsPanel.setBackground(DARK_BG);
        String[] opNames = {"+", "-", "*", "/"};
        opBoxes = new JCheckBox[4];
        for(int i=0; i<4; i++){
            opBoxes[i] = new JCheckBox(opNames[i], i < 2);
            opBoxes[i].setBackground(DARK_BG);
            opBoxes[i].setForeground(Color.WHITE);
            opsPanel.add(opBoxes[i]);
        }
        
     
        JPanel diffPanel = new JPanel();
        diffPanel.setBackground(DARK_BG);
        radEasy = new JRadioButton("Level 1", true);
        radMed = new JRadioButton("Level 2");
        radHard = new JRadioButton("Level 3");
        ButtonGroup bg = new ButtonGroup();
        JRadioButton[] diffs = {radEasy, radMed, radHard};
        for(JRadioButton r : diffs){
            r.setBackground(DARK_BG);
            r.setForeground(Color.LIGHT_GRAY);
            r.addActionListener(this);
            bg.add(r);
            diffPanel.add(r);
        }

        footer.add(opsPanel);
        footer.add(diffPanel);

        JPanel southStack = new JPanel(new BorderLayout());
        southStack.add(interactionPanel, BorderLayout.NORTH);
        southStack.add(footer, BorderLayout.SOUTH);
        add(southStack, BorderLayout.SOUTH);

        nextQuestion();
        setVisible(true);
    }

    private void setupWindow() {
        setTitle("NEON MATH QUEST");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JLabel createStatLabel(String text, Color color) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setForeground(color);
        l.setFont(new Font("Monospaced", Font.BOLD, 20));
        return l;
    }

    private void styleButton(JButton b, Color c) {
        b.setBackground(Color.BLACK);
        b.setForeground(c);
        b.setFocusPainted(false);
        b.setFont(new Font("Monospaced", Font.BOLD, 18));
        b.setBorder(BorderFactory.createLineBorder(c, 2));
    }

    private void initTimer() {
        gameTimer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("TIME: " + timeLeft);
            if (timeLeft <= 0) {
                gameTimer.stop();
                handleWrong("TIME'S UP!");
            }
        });
    }

    private void nextQuestion() {
        List<String> activeOps = new ArrayList<>();
        if(opBoxes[0].isSelected()) activeOps.add("+");
        if(opBoxes[1].isSelected()) activeOps.add("-");
        if(opBoxes[2].isSelected()) activeOps.add("*");
        if(opBoxes[3].isSelected()) activeOps.add("/");

        if(activeOps.isEmpty()) activeOps.add("+");

        String op = activeOps.get(rand.nextInt(activeOps.size()));
        int n1 = rand.nextInt(rangeMax - rangeMin + 1) + rangeMin;
        int n2 = rand.nextInt(rangeMax - rangeMin + 1) + rangeMin;

        // Logic adjustments
        if (op.equals("-") && n1 < n2) { int tmp = n1; n1 = n2; n2 = tmp; }
        if (op.equals("/")) { n1 = n1 * n2; } // Ensures whole number division

        questionLabel.setText(n1 + " " + op + " " + n2);
        
        switch(op) {
            case "+": correctAnswer = BigInteger.valueOf(n1 + n2); break;
            case "-": correctAnswer = BigInteger.valueOf(n1 - n2); break;
            case "*": correctAnswer = BigInteger.valueOf(n1 * n2); break;
            case "/": correctAnswer = BigInteger.valueOf(n1 / n2); break;
        }

        inputField.setText("");
        timeLeft = 15;
        gameTimer.restart();
    }

    private void handleWrong(String msg) {
        streak = 0;
        streakLabel.setText("STREAK: 0");
        JOptionPane.showMessageDialog(this, msg + "\nCorrect Answer: " + correctAnswer);
        nextQuestion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            try {
                BigInteger userAns = new BigInteger(inputField.getText().trim());
                if(userAns.equals(correctAnswer)) {
                    score += (10 * (streak + 1));
                    streak++;
                    scoreLabel.setText("SCORE: " + score);
                    streakLabel.setText("STREAK: " + streak);
                    nextQuestion();
                } else {
                    handleWrong("SYSTEM ERROR: INCORRECT");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ENTER A NUMERIC VALUE");
            }
        } else {
            if(radEasy.isSelected()) { rangeMin = 1; rangeMax = 20; }
            else if(radMed.isSelected()) { rangeMin = 20; rangeMax = 100; }
            else { rangeMin = 100; rangeMax = 500; }
            nextQuestion();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NeonMathQuest::new);
    }
}
