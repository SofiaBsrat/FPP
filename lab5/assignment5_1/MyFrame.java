package assignment5_1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4907950534480263136L;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;

	private JPanel name;
	private JTextField nameT;
	private JLabel nameL;

	private JPanel street;
	private JTextField streetT;
	private JLabel streetL;

	private JPanel city;
	private JLabel cityL;
	private JTextField cityT;

	private JPanel state;
	private JLabel stateL;
	private JTextField stateT;

	private JPanel zip;
	private JLabel zipL;
	private JTextField zipT;

	private JButton buttonS;

	public MyFrame() {
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineTopPanel();
		defineMiddlePanel();
		definebottomPanel();

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		getContentPane().add(mainPanel);
	}

	private void defineTopPanel() {
		topPanel = new JPanel();

		defineNamePanel();
		defineStreetPanel();
		defineCityPanel();

		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(name);
		topPanel.add(street);
		topPanel.add(city);

	}

	private void defineNamePanel() {

		JPanel topLabel = new JPanel();
		JPanel bottomText = new JPanel();
		topLabel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

		nameT = new JTextField(10);
		nameL = new JLabel("Name");
		nameL.setFont(makeSmallFont(nameL.getFont()));
		topLabel.add(nameL);
		bottomText.add(nameT);

		name = new JPanel();
		name.setLayout(new BorderLayout());
		name.add(topLabel, BorderLayout.NORTH);
		name.add(bottomText, BorderLayout.CENTER);
	}

	private void defineStreetPanel() {
		JPanel topLabel = new JPanel();
		JPanel bottomText = new JPanel();
		topLabel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

		streetL = new JLabel("Street");
		streetT = new JTextField(10);

		nameL.setFont(makeSmallFont(nameL.getFont()));
		topLabel.add(streetL);
		bottomText.add(streetT);

		street = new JPanel();
		street.setLayout(new BorderLayout());
		street.add(topLabel, BorderLayout.NORTH);
		street.add(bottomText, BorderLayout.CENTER);

	}

	private void defineCityPanel() {
		JPanel topLabel = new JPanel();
		JPanel bottomText = new JPanel();
		topLabel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

		cityL = new JLabel("City");
		cityT = new JTextField(10);
		cityL.setFont(makeSmallFont(cityL.getFont()));
		topLabel.add(cityL);
		bottomText.add(cityT);

		city = new JPanel();
		city.setLayout(new BorderLayout());
		city.add(topLabel, BorderLayout.NORTH);
		city.add(bottomText, BorderLayout.CENTER);

	}

	private void defineMiddlePanel() {
		middlePanel = new JPanel();

		defineStatePanel();
		defineZipPanel();

		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		middlePanel.add(state);
		middlePanel.add(zip);

	}

	private void defineStatePanel() {
		JPanel topLabel = new JPanel();
		JPanel bottomText = new JPanel();
		topLabel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

		stateL = new JLabel("State");
		stateT = new JTextField(10);
		cityL.setFont(makeSmallFont(stateL.getFont()));
		topLabel.add(stateL);
		bottomText.add(stateT);

		state = new JPanel();
		state.setLayout(new BorderLayout());
		state.add(topLabel, BorderLayout.NORTH);
		state.add(bottomText, BorderLayout.CENTER);

	}

	private void defineZipPanel() {
		JPanel topLabel = new JPanel();
		JPanel bottomText = new JPanel();
		topLabel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

		zipL = new JLabel("Zip");
		zipT = new JTextField(10);
		zipL.setFont(makeSmallFont(zipL.getFont()));
		topLabel.add(zipL);
		bottomText.add(zipT);

		zip = new JPanel();
		zip.setLayout(new BorderLayout());
		zip.add(topLabel, BorderLayout.NORTH);
		zip.add(bottomText, BorderLayout.CENTER);

	}

	private void definebottomPanel() {
		bottomPanel = new JPanel();

		buttonS = new JButton("Submit");
		buttonS.addActionListener(new MyButtonListener());
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.add(buttonS);

	}

	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Address Form");
		centerFrameOnDesktop(this);
		setSize(475, 180);
		setResizable(false);
	}

	public static Font makeSmallFont(Font f) {
		return new Font(f.getName(), f.getStyle(), (f.getSize() - 2));
	}

	public static void centerFrameOnDesktop(Component f) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int frameHeight = f.getSize().height;
		int frameWidth = f.getSize().width;
		f.setLocation(((width - frameWidth) / 3), (height - frameHeight) / 3);
	}

	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String result = "";
			result = String.format("%s\n", nameT.getText());
			result += String.format("%s\n", streetT.getText());
			result += String.format("%s, ", cityT.getText());
			result += String.format("%s ", stateT.getText());
			result += String.format("%s ", zipT.getText());
			
			System.out.println(result);
			nameT.setText("Thank you!");
			streetT.setText("");
			cityT.setText("");
			stateT.setText("");
			zipT.setText("");

		}
	}
}