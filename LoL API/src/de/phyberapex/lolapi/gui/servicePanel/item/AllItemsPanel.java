package de.phyberapex.lolapi.gui.servicePanel.item;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;

import de.phyberapex.lolapi.gui.MainFrame;
import de.phyberapex.lolapi.model.Item;

public class AllItemsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton getResultButton;
	private JPanel resultPanel;
	private JList<Item> resultList;

	public AllItemsPanel() {
		super();
		createGUI();
		layoutGUI();
	}

	private void createGUI() {
		this.setBorder(BorderFactory.createTitledBorder("getAllChampions()"));
		this.getResultButton = new JButton("Get Result");
		this.getResultButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SwingWorker<String, String>() {

					@Override
					protected String doInBackground() throws Exception {
						resultList.setListData(MainFrame.getInstance()
								.getClient().getItemService().getAllItems()
								.toArray(new Item[] {}));
						return null;
					}

				}.execute();
			}
		});
		this.resultPanel = new JPanel();
		this.resultPanel.setBorder(BorderFactory.createTitledBorder("Result"));
		this.resultList = new JList<Item>();
	}

	private void layoutGUI() {
		this.setLayout(new GridBagLayout());
		this.resultList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		this.resultList.setEnabled(false);
		this.resultList.setVisibleRowCount(24);
		JScrollPane listScroller = new JScrollPane(this.resultList);
		this.resultPanel.setLayout(new BorderLayout());
		this.resultPanel.add(listScroller, BorderLayout.CENTER);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(getResultButton, c);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(resultPanel, c);
	}
}
