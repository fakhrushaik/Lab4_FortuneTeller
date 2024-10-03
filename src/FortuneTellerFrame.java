import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private final JTextArea fortuneDisplay;
    private final ArrayList<String> fortunes;
    private final Random random;
    private int lastFortuneIndex;

    public FortuneTellerFrame() {
        super("Fortune Teller");

        fortunes = new ArrayList<>();
        random = new Random();
        lastFortuneIndex = -1;

        addFortunes();

        JPanel topPanel = new JPanel();
        ImageIcon icon = new ImageIcon("fortune_image.png"); // Use an appropriate image
        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        topPanel.add(titleLabel);

        fortuneDisplay = new JTextArea(10, 30);
        fortuneDisplay.setFont(new Font("Monospaced", Font.PLAIN, 16));
        fortuneDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneDisplay);

        JPanel bottomPanel = new JPanel();
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        readButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        quitButton.setFont(new Font("SansSerif", Font.PLAIN, 24));

        readButton.addActionListener(e -> showFortune());
        quitButton.addActionListener(e -> System.exit(0));

        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize((int) (screenSize.width * 0.75), (int) (screenSize.height * 0.75));
        setLocationRelativeTo(null);  // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addFortunes() {
        fortunes.add("You will have a great day today!");
        fortunes.add("An unexpected event will bring joy to your life.");
        fortunes.add("You will solve a tough problem soon.");
        fortunes.add("Someone you trust will surprise you.");
        fortunes.add("Good fortune is coming your way.");
        fortunes.add("Be patient; success is near.");
        fortunes.add("A new opportunity will present itself.");
        fortunes.add("Stay positive and good things will happen.");
        fortunes.add("Your hard work will pay off soon.");
        fortunes.add("Happiness is within your reach.");
        fortunes.add("You will make a valuable new connection.");
        fortunes.add("An exciting adventure awaits you.");
    }

    private void showFortune() {
        int newIndex;
        do {
            newIndex = random.nextInt(fortunes.size());
        } while (newIndex == lastFortuneIndex);
        String fortune = fortunes.get(newIndex);
        fortuneDisplay.append(fortune + "\n");
        lastFortuneIndex = newIndex;
    }
}
