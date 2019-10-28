package vn.edu.hust.soict.afc.boundaries;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import vn.edu.hust.soict.afc.entities.Station;
import vn.edu.hust.soict.afc.services.StationService;

public class MainGUI extends JFrame {
	/**
	 * Define UI state
	 */
	private Station selectedStation;
	private boolean actCheckIn;
	private boolean byTicket;
	private String itemId; // id of selected ticket or card
	private boolean open;
	private Map<String, Station> listStations;
	private DefaultListModel<String> listTicketIds;
	private List<String> stationKeys;

	/**
	 * Auto-generated JWT Config
	 */
	private static final long serialVersionUID = -3291303651386410923L;
	private JPanel contentPanel;
	private JTextField barcodeInputField;

	/**
	 * @return the selected Station
	 */
	public Station getSelectedStation() {
		return selectedStation;
	}

	/**
	 * @param station the selected station to set
	 */
	public void setSelectedStation(Station station) {
		this.selectedStation = station;
	}

	/**
	 * @return the actCheckIn
	 */
	public boolean isActCheckIn() {
		return actCheckIn;
	}

	/**
	 * @param actCheckIn the actCheckIn to set
	 */
	public void setActCheckIn(boolean actCheckIn) {
		this.actCheckIn = actCheckIn;
	}

	/**
	 * @return the byTicket
	 */
	public boolean isByTicket() {
		return byTicket;
	}

	/**
	 * @param byTicket the byTicket to set
	 */
	public void setByTicket(boolean byTicket) {
		this.byTicket = byTicket;
	}

	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the open
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * @return the listStations
	 */
	public Map<String, Station> getListStations() {
		return listStations;
	}

	/**
	 * @param listStations the listStations to set
	 */
	public void setListStations(Map<String, Station> listStations) {
		this.listStations = listStations;
	}

	/**
	 * @return the listTicketIds
	 */
	public DefaultListModel<String> getListTicketIds() {
		return listTicketIds;
	}

	/**
	 * @param listTicketIds the listTicketIds to set
	 */
	public void setListTicketIds(DefaultListModel<String> listTicketIds) {
		this.listTicketIds = listTicketIds;
	}

	/**
	 * @return the stationKeys
	 */
	public List<String> getStationKeys() {
		return stationKeys;
	}

	/**
	 * @param stationKeys the stationKeys to set
	 */
	public void setStationKeys(List<String> stationKeys) {
		this.stationKeys = stationKeys;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void init() {
		this.selectedStation = null;
		this.actCheckIn = true;
		this.byTicket = true;
		this.itemId = "";
		this.open = false;
		this.listStations = new HashMap<String, Station>();
		this.stationKeys = new ArrayList<String>();
		this.listTicketIds = new DefaultListModel<String>();
		try {
			List<Station> allStations = new ArrayList<>();

			listTicketIds.addElement("abcz");
			listTicketIds.addElement("fakeauth");
			listTicketIds.addElement("notchout");
			listTicketIds.addElement("outodate");
			listTicketIds.addElement("vlticket");
			allStations = StationService.getAllStations();
			for (int i = 0; i < allStations.size(); i++) {
				listStations.put(allStations.get(i).getStationName(), allStations.get(i));
				stationKeys.add(allStations.get(i).getStationName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		/* init data */
		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 634);
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.CYAN);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);

		/* Title Component */
		JTextPane panelTitle = new JTextPane();
		panelTitle.setEditable(false);
		panelTitle.setBackground(Color.CYAN);
		panelTitle.setFont(new Font("HL-Comic1unicode", Font.BOLD | Font.ITALIC, 36));
		panelTitle.setText("Subway Station");
		panelTitle.setBounds(261, 13, 353, 59);
		contentPanel.add(panelTitle);

		/* Seperator between header and body */
		JSeparator separatorHeader = new JSeparator();
		separatorHeader.setBounds(0, 85, 926, 7);
		contentPanel.add(separatorHeader);

		/* Label for Station */
		JLabel lblSelectStation = new JLabel("Station");
		lblSelectStation.setToolTipText("Select station");
		lblSelectStation.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSelectStation.setBounds(35, 91, 97, 41);
		contentPanel.add(lblSelectStation);

		/* List of all stations goes here */
		JComboBox<String> comboStation = new JComboBox<>();
		comboStation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String selectedKey = (String) combo.getSelectedItem();

				selectedStation = listStations.get(selectedKey);
				System.out.println("Station to go: " + selectedStation.getStationName());
			}
		});
		comboStation.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		stationKeys.forEach(key -> comboStation.addItem(key));
		lblSelectStation.setLabelFor(comboStation);
		comboStation.setBounds(153, 98, 699, 30);
		contentPanel.add(comboStation);

		/* Buttons to select action: Check In or Check Out */
		JRadioButton btnCheckIn = new JRadioButton("Check In");

		btnCheckIn.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int state = e.getStateChange();
				if (state == ItemEvent.SELECTED) {
					setActCheckIn(true);
				} else if (state == ItemEvent.DESELECTED) {
					setActCheckIn(false);
				}
				System.out.println("Action: " + actCheckIn);
			}
		});
		btnCheckIn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCheckIn.setBackground(Color.CYAN);
		btnCheckIn.setSelected(true);
		btnCheckIn.setBounds(153, 150, 88, 25);
		contentPanel.add(btnCheckIn);

		JRadioButton btnCheckOut = new JRadioButton("Check Out");
		btnCheckOut.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCheckOut.setBackground(Color.CYAN);
		btnCheckOut.setBounds(261, 150, 109, 25);
		contentPanel.add(btnCheckOut);
		/* create Group action */
		ButtonGroup actionGroup = new ButtonGroup();
		actionGroup.add(btnCheckIn);
		actionGroup.add(btnCheckOut);

		/* Label for actions */
		JLabel lblSelectAction = new JLabel("Action");
		lblSelectAction.setToolTipText("Select action");
		lblSelectAction.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSelectAction.setBounds(35, 134, 97, 53);
		contentPanel.add(lblSelectAction);

		/* Label for check item */
		JLabel goByLabel = new JLabel("Go by");
		goByLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		goByLabel.setBounds(35, 184, 97, 47);
		contentPanel.add(goByLabel);

		/* Choose check by ticket */
		JRadioButton btnTicket = new JRadioButton("Ticket");

		btnTicket.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int state = e.getStateChange();
				if (state == ItemEvent.SELECTED) {
					setByTicket(true);
				} else if (state == ItemEvent.DESELECTED) {
					setByTicket(false);
				}
				System.out.println("Check by ticket: " + byTicket);
			}
		});
		btnTicket.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnTicket.setSelected(true);
		btnTicket.setBackground(Color.CYAN);
		btnTicket.setBounds(153, 197, 88, 25);
		contentPanel.add(btnTicket);

		/* Choose check by prepaid card */
		JRadioButton btnPrepaidCard = new JRadioButton("Prepaid Card");
		btnPrepaidCard.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnPrepaidCard.setBackground(Color.CYAN);
		btnPrepaidCard.setBounds(261, 197, 125, 25);
		contentPanel.add(btnPrepaidCard);

		/* create Group: Check items */
		ButtonGroup goByGroup = new ButtonGroup();
		goByGroup.add(btnTicket);
		goByGroup.add(btnPrepaidCard);

		/* Text panel describe all list of tickets or cards below it */
		JTextPane panelListOfAvailable = new JTextPane();
		panelListOfAvailable.setEditable(false);
		panelListOfAvailable.setBackground(Color.CYAN);
		panelListOfAvailable.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		panelListOfAvailable.setText("List of available tickets/cards (for testing)");
		panelListOfAvailable.setBounds(35, 231, 344, 25);
		contentPanel.add(panelListOfAvailable);

		/* List of all tickets/cards that available */
		JList<String> listAvailable = new JList<String>(listTicketIds);
		listAvailable.setBounds(35, 281, 344, 159);
		contentPanel.add(listAvailable);

		/* Label: Text Input field for inputting manually */
		JLabel inputBarcodeLabel = new JLabel("You can input your ticket's or card's pseudoBarcode here");
		inputBarcodeLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		inputBarcodeLabel.setBounds(35, 440, 353, 25);
		contentPanel.add(inputBarcodeLabel);

		/* Input area */
		barcodeInputField = new JTextField();
		inputBarcodeLabel.setLabelFor(barcodeInputField);
		barcodeInputField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		barcodeInputField.setBounds(35, 468, 344, 25);
		contentPanel.add(barcodeInputField);
		barcodeInputField.setColumns(10);

		/* Panel for Gate */
		JPanel gatePanel = new JPanel();
		gatePanel.setBounds(449, 165, 401, 275);
		contentPanel.add(gatePanel);

		/* This canvas contain image of a Gate state (close or open) */
		Canvas gateCanvas = new Canvas();
		gatePanel.add(gateCanvas);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(selectedStation.getStationName());
			}
		});
		btnEnter.setBounds(144, 496, 97, 41);
		contentPanel.add(btnEnter);

		JTextPane infoFrame = new JTextPane();
		infoFrame.setEditable(false);
		infoFrame.setBounds(449, 453, 401, 84);
		contentPanel.add(infoFrame);

		/* Footer seperator */
		JSeparator separatorFooter = new JSeparator();
		separatorFooter.setBounds(0, 550, 893, 7);
		contentPanel.add(separatorFooter);

		/* License */
		JTextPane license = new JTextPane();
		license.setBackground(Color.CYAN);
		license.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		license.setText("\u00A9 2019 DuyPV, Automated Fare Collection System");
		license.setBounds(563, 562, 287, 25);
		license.setEditable(false);
		contentPanel.add(license);
	}
}
