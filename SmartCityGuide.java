import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class SmartCityGuide extends JFrame implements ActionListener {

    private JLabel titleLabel;
    private JLabel cityImageLabel;
    private JButton attractionsButton;
    private JButton restaurantsButton;
    private JButton hotelsButton;
    private JButton parksButton;
    private JButton museumsButton;
    private JButton hospitalsButton;

    public SmartCityGuide() {
        setTitle("Smart City Guide");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 240, 240)); // Set background color

        titleLabel = new JLabel("Welcome to Smart City Guide");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Use a custom font
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Add padding
        add(titleLabel, BorderLayout.NORTH);

        cityImageLabel = new JLabel();
        cityImageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(cityImageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        attractionsButton = createButton("Attractions", "Gwalior Attractions");
        restaurantsButton = createButton("Restaurants", "Gwalior Restaurants");
        hotelsButton = createButton("Hotels", "Gwalior Hotels");
        parksButton = createButton("Parks", "Gwalior Parks");
        museumsButton = createButton("Museums", "Gwalior Museums");
        hospitalsButton = createButton("Hospitals", "Gwalior Hospitals");
        buttonPanel.add(attractionsButton);
        buttonPanel.add(restaurantsButton);
        buttonPanel.add(hotelsButton);
        buttonPanel.add(parksButton);
        buttonPanel.add(museumsButton);
        buttonPanel.add(hospitalsButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
        loadCityImage(); // Load the city image after the frame is visible
    }

    private JButton createButton(String text, String location) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Use a custom font
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openGoogleMaps(location);
            }
        });
        return button;
    }

    private void loadCityImage() {
        try {
            ImageIcon icon = new ImageIcon(new URL(
                    "https://i2.wp.com/gangatimes.com/wp-content/uploads/2022/10/Picsart_22-10-01_13-22-57-512-scaled.jpg"));
            Image image = icon.getImage().getScaledInstance(cityImageLabel.getWidth(), cityImageLabel.getHeight(),
                    Image.SCALE_SMOOTH);
            cityImageLabel.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load image: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openGoogleMaps(String location) {
        try {
            String url = "https://www.google.com/maps/search/?api=1&query=" + location.replace(" ", "+");
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to open Google Maps: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new SmartCityGuide();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implementation not needed here
    }
}
