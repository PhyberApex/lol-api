package de.phyberapex.lolapi.gui.servicePanel.summonerspell;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import de.phyberapex.lolapi.gui.MainFrame;

public class SpellByIdPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField idTextfield;
	private JButton getResultButton;
	private JLabel resultLabel;

	public SpellByIdPanel() {
		super();
		createGUI();
		layoutGUI();
	}

	private void createGUI() {
		this.setBorder(BorderFactory.createTitledBorder("getSpellById(int id)"));
		this.idTextfield = new JTextField();
		this.idTextfield.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					getResultButton.doClick();
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		this.idTextfield.setPreferredSize(new Dimension(100, 30));
		this.getResultButton = new JButton("Get Result");
		this.getResultButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SwingWorker<String, String>() {

					@Override
					protected String doInBackground() throws Exception {
						resultLabel.setText(MainFrame
								.getInstance()
								.getClient()
								.getSummonerSpellService()
								.getSpellById(
										Integer.parseInt(idTextfield.getText()))
								.toString());
						return null;
					}
				}.execute();
			}
		});
		this.resultLabel = new JLabel("Spell name");
		this.resultLabel.setBorder(BorderFactory.createTitledBorder("Result"));
	}

	private void layoutGUI() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(idTextfield, c);
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		this.add(getResultButton, c);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(resultLabel, c);
	}
}
