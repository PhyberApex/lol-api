package de.phyberapex.lolapi.gui.servicePanel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import de.phyberapex.lolapi.client.service.ChampionService;
import de.phyberapex.lolapi.gui.MainFrame;
import de.phyberapex.lolapi.model.Champion;

public class ChampionServicePanel extends JScrollPane {

	private static final long serialVersionUID = 1L;
	private ChampionService champService;
	private JPanel content;
	private JPanel allChampsPanel, champByIdPanel;
	private JTextField champByIdTextField;
	private JButton allChampsButton, champByIdButton;
	private JPanel champByIdResultPanel;
	private JList<Champion> allChampsResultList;

	public ChampionServicePanel() {
		super();
		createGUI();
		layoutGUI();
	}

	private void createGUI() {
		this.content = new JPanel();
	}

	private void layoutGUI() {
		this.content.setLayout(new GridLayout(2, 1));
		this.content.add(getAllChampsPanel());
		this.content.add(getChampByIdPanel());
		this.setViewportView(content);
	}

	private JPanel getAllChampsPanel() {
		if (this.allChampsPanel == null) {
			this.allChampsPanel = new JPanel(new GridBagLayout());
			this.allChampsPanel.setBorder(BorderFactory
					.createTitledBorder("getAllChamps"));
			this.allChampsButton = new JButton("Get result");
			this.allChampsButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					new SwingWorker<String, String>() {

						@Override
						protected String doInBackground() throws Exception {
							allChampsResultList.setListData(getChampService()
									.getAllChampions().toArray(
											new Champion[] {}));
							;
							return null;
						}

					}.execute();
				}
			});
			this.allChampsResultList = new JList<>();
			this.allChampsResultList
					.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			this.allChampsResultList.setVisibleRowCount(15);
			this.allChampsPanel.add(allChampsButton);
			this.allChampsPanel.add(allChampsResultList);
		}
		return this.allChampsPanel;
	}

	private JPanel getChampByIdPanel() {
		if (this.champByIdPanel == null) {
			this.champByIdPanel = new JPanel(new GridBagLayout());
			this.champByIdPanel.setBorder(BorderFactory
					.createTitledBorder("getChampById"));
			this.champByIdButton = new JButton("Get result");
			this.champByIdTextField = new JTextField();
			this.champByIdTextField.setPreferredSize(new Dimension(120, 25));
			this.champByIdPanel.add(champByIdTextField);
			this.champByIdPanel.add(champByIdButton);
		}
		return this.champByIdPanel;
	}

	public ChampionService getChampService() {
		if (this.champService == null) {
			this.champService = MainFrame.getInstance().getClient()
					.getChampionService();
		}
		return this.champService;
	}
}