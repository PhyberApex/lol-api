package de.phyberapex.lolapi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import de.phyberapex.lolapi.base.Config;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	public MenuBar() {
		JMenu mfileMenu = new JMenu("File");
		JMenuItem miApiKey = new JMenuItem("API Key");
		miApiKey.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(Config.getInstance().getApikey());
			}
		});
		mfileMenu.add(miApiKey);
		mfileMenu.add(new JSeparator());
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mfileMenu.add(miExit);
		add(mfileMenu);
	}
}
