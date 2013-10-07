package de.phyberapex.lolapi.gui.servicePanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.gvaneyck.rtmp.ServerInfo;

import de.phyberapex.lolapi.gui.MainFrame;
import static de.phyberapex.lolapi.base.Constants.*;

public class LoginInfoDialog extends JDialog {

	private static final long serialVersionUID = 4699999076292666566L;
	private JLabel usernameLabel, passwordLabel, clientVersionLabel,
			serverLabel;
	private JTextField usernameTextField, passwordTextField,
			clientVersionTextField;
	private JComboBox<ServerInfo> serverComboBox;
	private JButton saveButton, cancelButton;

	public LoginInfoDialog() {
		super();
		createGUI();
		layoutGUI();
	}

	private void createGUI() {
		this.usernameLabel = new JLabel("Loginname:");
		this.passwordLabel = new JLabel("Password:");
		this.usernameTextField = new JTextField(
				LOL_LOGIN_INFO.getProperty("LOGINNAME"));
		this.passwordTextField = new JPasswordField();
		this.clientVersionLabel = new JLabel("Client version:");
		this.clientVersionTextField = new JTextField(
				LOL_LOGIN_INFO.getProperty("CLIENT_VERSION"));
		this.serverLabel = new JLabel("Server:");
		this.serverComboBox = new JComboBox<>();
		this.serverComboBox.addItem(ServerInfo.BR);
		this.serverComboBox.addItem(ServerInfo.EUNE);
		this.serverComboBox.addItem(ServerInfo.EUW);
		this.serverComboBox.addItem(ServerInfo.KR);
		this.serverComboBox.addItem(ServerInfo.LAN);
		this.serverComboBox.addItem(ServerInfo.LAS);
		this.serverComboBox.addItem(ServerInfo.NA);
		this.serverComboBox.addItem(ServerInfo.OCE);
		this.serverComboBox.addItem(ServerInfo.PBE);
		this.serverComboBox.addItem(ServerInfo.PH);
		this.serverComboBox.addItem(ServerInfo.RU);
		this.serverComboBox.addItem(ServerInfo.SG);
		this.serverComboBox.addItem(ServerInfo.TH);
		this.serverComboBox.addItem(ServerInfo.TR);
		this.serverComboBox.addItem(ServerInfo.TW);
		this.serverComboBox.addItem(ServerInfo.VN);
		this.serverComboBox.setSelectedItem(parseServer(LOL_LOGIN_INFO
				.getProperty("SERVER")));
		this.saveButton = new JButton("Save");
		this.saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOL_LOGIN_INFO.setProperty("LOGINNAME",
						usernameTextField.getText());
				LOL_LOGIN_INFO.setProperty("PASSWORD", passwordTextField
						.getText().toString());
				LOL_LOGIN_INFO.setProperty("CLIENT_VERSION",
						clientVersionTextField.getText());
				LOL_LOGIN_INFO.setProperty("SERVER", serverComboBox
						.getSelectedItem().toString());
				saveLoginInfo();
				MainFrame.getInstance().setStatusText(
						"Configuration saved successfully");
				dispose();
			}
		});
		this.cancelButton = new JButton("Cancel");
		this.cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	private void layoutGUI() {
		this.setLayout(new GridLayout(5, 2));
		this.add(this.usernameLabel);
		this.add(this.usernameTextField);
		this.add(this.passwordLabel);
		this.add(this.passwordTextField);
		this.add(this.clientVersionLabel);
		this.add(this.clientVersionTextField);
		this.add(this.serverLabel);
		this.add(this.serverComboBox);
		this.add(this.saveButton);
		this.add(this.cancelButton);
		this.pack();
		this.setLocationRelativeTo(MainFrame.getInstance());
	}
}
