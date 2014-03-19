package de.phyberapex.lolapi.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import de.phyberapex.lolapi.base.MainConstants;

public class MainView extends JFrame {

	private JTabbedPane tbpServices = new JTabbedPane();
	private JLabel lbStatus = new JLabel("STATUS");
	private static final long serialVersionUID = 1L;

	public MainView() {
		setTitle(MainConstants.APP_NAME);
		setSize(800, 600);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
		createGUI();
	}

	private void createGUI() {
		setJMenuBar(new MenuBar());
		setLayout(new GridBagLayout());
		tbpServices.addTab("Champion", new JLabel("BLA"));
		tbpServices.addTab("Game", new JLabel("BLA"));
		tbpServices.addTab("League", new JLabel("BLA"));
		tbpServices.addTab("Lol Static Data", new JLabel("BLA"));
		tbpServices.addTab("Stats", new JLabel("BLA"));
		tbpServices.addTab("Summoner", new JLabel("BLA"));
		tbpServices.addTab("Team", new JLabel("BLA"));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		add(tbpServices, c);
		lbStatus.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(lbStatus, c);
	}

}
