package de.phyberapex.lolapi.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingWorker;

import de.phyberapex.lolapi.client.APIClient;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	private APIClient client;
	private JMenu mFile, mEdit;
	private JMenuItem iConnect, iDisconnect, iClose;
	private JMenuItem iLoginCreds;

	public MenuBar(APIClient client) {
		this.client = client;
		createGUI();
		layoutGUI();
	}

	private void createGUI() {
		this.mFile = new JMenu("File");
		this.iConnect = new JMenuItem("Connect to riot server");
		this.iConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.getInstance().setStatusText(
						"Trying to connect to riot server");
				iConnect.setEnabled(false);
				new SwingWorker<String, String>() {

					@Override
					protected String doInBackground() throws Exception {
						try {
							client.connectAndLogin();
							iDisconnect.setEnabled(true);
							MainFrame.getInstance().update();
							MainFrame.getInstance().setStatusText(
									"Successfully connected");
						} catch (IOException e) {
							MainFrame.getInstance()
									.setStatusText(
											"Error while connecting: "
													+ e.getMessage());
							iConnect.setEnabled(true);
						}
						return null;
					}

				}.execute();
			}
		});
		this.mFile.add(iConnect);
		this.iDisconnect = new JMenuItem("Disconnect from riot server");
		this.iDisconnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.getInstance().setStatusText(
						"Trying to disconnect from riot server");
				client.close();
				iConnect.setEnabled(true);
				iDisconnect.setEnabled(false);
				MainFrame.getInstance().setStatusText(
						"Successfully disconnected");
			}
		});
		this.iDisconnect.setEnabled(false);
		this.mFile.add(iDisconnect);
		this.iClose = new JMenuItem("Close");
		this.iClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (client.isConnected()) {
					MainFrame.getInstance().setStatusText(
							"Closing connection with riot.");
					client.close();
				}
				MainFrame.getInstance().setStatusText("Closing application");
				System.exit(0);
			}
		});
		this.mFile.add(iClose);
		this.add(mFile);
		this.mEdit = new JMenu("Edit");
		this.iLoginCreds = new JMenuItem("Login information...");
		this.mEdit.add(iLoginCreds);
		this.add(mEdit);
	}

	private void layoutGUI() {

	}

}
