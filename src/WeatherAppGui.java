import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class WeatherAppGui extends JFrame{

    public WeatherAppGui(){
        //Setting up gui and add title
        super("Weather App");

        //configure gui to end the programs process when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //set size of our gui 
        setSize(450, 650);

        //Load our gui in the center of the screen
        setLocationRelativeTo(null);

        //Make our layout manager null so we can place our components where we want
        setLayout(null);

        //Prevent resize 
        setResizable(false);

        addGuiComponents();
    }

    private void addGuiComponents(){
        //Search field
        JTextField searchField = new JTextField();

        //Set the size and location of the search field
        searchField.setBounds(15, 15, 300, 30);

        //change fontstyle of the search field
        searchField.setFont(new Font("Dialog", Font.PLAIN, 20));

        //Add the search field to the gui
        add(searchField);

        //Search button
        JButton searchButton = new JButton(loadImage("/Users/richmantan/Desktop/Programming/WeatherApp/src/Assets/search.png"));

        //Change cursor to hand when hovering over the button
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(320, 10, 50, 50);
        add(searchButton);

        //Add weather image
        JLabel weatherImage = new JLabel(loadImage("/Users/richmantan/Desktop/Programming/WeatherApp/src/Assets/cloudy.png"));
        weatherImage.setBounds(0, 125, 450, 217);
        add(weatherImage);

        //Add temperature label
        JLabel temperatureLabel = new JLabel("25 °C");
        temperatureLabel.setBounds(0, 250, 450, 54);
        temperatureLabel.setFont(new Font("Dialog", Font.BOLD, 48));

        //Centre the text
        temperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureLabel);

    }

    private ImageIcon loadImage(String path){
        try{
            BufferedImage img = ImageIO.read(new File(path));

            //return the image as an ImageIcon
            return new ImageIcon(img);

        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Could not find resource: " + path);
        return null;
    }
}
