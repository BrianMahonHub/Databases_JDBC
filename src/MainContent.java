import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.border.*;

import java.sql.*;

@SuppressWarnings("serial")
public class MainContent extends JInternalFrame implements ActionListener {
	String cmd = null;

	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private Container content;

	private JPanel PlayerDetailsPanel;
	private JPanel StaffDetailsPanel;
	private JPanel exportButtonPanel;
	private JPanel databasePanel;
	private JScrollPane dbContentsPanel1;
	private JScrollPane dbContentsPanel2;

	private static QueryTablePlayers TableModelPlayers = new QueryTablePlayers();
	private JTable TablePlayers = new JTable(TableModelPlayers);
	private static QueryTableStaff TableModelStaff = new QueryTableStaff();
	private JTable TableStaff = new JTable(TableModelStaff);

	private JLabel IDLabel = new JLabel("ID:                 ");
	private JLabel FirstNameLabel = new JLabel("First Name:               ");
	private JLabel LastNameLabel = new JLabel("Last Name:      ");
	private JLabel AgeLabel = new JLabel("Age:        ");
	private JLabel NumberLabel = new JLabel("Squad Number:                 ");
	private JLabel PositionLabel = new JLabel("Position:               ");
	private JLabel NationalityLabel = new JLabel("Nationality:      ");
	private JLabel ValueLabel = new JLabel("Wages:      ");
	private JLabel IDLabel2 = new JLabel("ID:                 ");
	private JLabel FirstNameLabel2 = new JLabel("First Name:               ");
	private JLabel LastNameLabel2 = new JLabel("Last Name:      ");
	private JLabel AgeLabel2 = new JLabel("Age:        ");
	private JLabel NumberLabel2 = new JLabel("Nationality:                 ");
	private JLabel PositionLabel2 = new JLabel("Wages:               ");

	private JTextField IDTF = new JTextField(10);
	private JTextField FirstNameTF = new JTextField(10);
	private JTextField LastNameTF = new JTextField(10);
	private JTextField AgeTF = new JTextField(10);
	private JTextField NumberTF = new JTextField(10);
	private JTextField PositionTF = new JTextField(10);
	private JTextField NationalityTF = new JTextField(10);
	private JTextField ValueTF = new JTextField(10);
	private JTextField IDTF2 = new JTextField(10);
	private JTextField FirstNameTF2 = new JTextField(10);
	private JTextField LastNameTF2 = new JTextField(10);
	private JTextField AgeTF2 = new JTextField(10);
	private JTextField NumberTF2 = new JTextField(10);
	private JTextField PositionTF2 = new JTextField(10);
	private JTextField NumOfNationalityTF = new JTextField(12);
	private JTextField OlderPlayersTF = new JTextField(12);

	private JButton updateButton = new JButton("Update");
	private JButton insertButton = new JButton("Insert");
	private JButton deleteButton = new JButton("Delete");
	private JButton clearButton = new JButton("Clear");
	private JButton exportButton = new JButton("Export Table");
	private JButton updateButton2 = new JButton("Update");
	private JButton insertButton2 = new JButton("Insert");
	private JButton deleteButton2 = new JButton("Delete");
	private JButton clearButton2 = new JButton("Clear");
	private JButton exportButton2 = new JButton("Export Table");
	private JButton NumOfNationality = new JButton("Players by Nationality:");
	private JButton WageBill = new JButton("List Players Older Than");
	private JButton ListOlderPlayers = new JButton("Weekly Wage Bill");
	private JButton ListSpanishStaff = new JButton("List all Spanish Personnel");

	private ButtonGroup databaseButtonGroup = new ButtonGroup();
	private JRadioButton PlayerData = new JRadioButton("Player Data");
	private JRadioButton StaffData = new JRadioButton("Staff Data");

	public MainContent(String aTitle) {

		super(aTitle, false, false, false, false);
		setEnabled(true);

		initiate_db_conn();
		content = getContentPane();
		content.setLayout(null);
		content.setBackground(UIManager
				.getColor("RadioButtonMenuItem.selectionBackground"));
		BorderFactory.createEtchedBorder(15, Color.white, Color.black);

		PlayerDetailsPanel = new JPanel();
		PlayerDetailsPanel.setBackground(UIManager
				.getColor("RadioButtonMenuItem.selectionBackground"));
		PlayerDetailsPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, new Color(255, 255, 255)),
				"CRUD Actions", TitledBorder.LEADING,
				TitledBorder.ABOVE_BOTTOM, null, Color.WHITE));
		PlayerDetailsPanel.setLayout(null);
		IDLabel.setBounds(48, 17, 178, 25);

		StaffDetailsPanel = new JPanel();
		StaffDetailsPanel.setBackground(UIManager
				.getColor("RadioButtonMenuItem.selectionBackground"));
		StaffDetailsPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, new Color(255, 255, 255)),
				"CRUD Actions", TitledBorder.LEADING,
				TitledBorder.ABOVE_BOTTOM, null, Color.WHITE));
		StaffDetailsPanel.setLayout(null);
		IDLabel.setBounds(48, 17, 178, 25);

		databaseButtonGroup.add(PlayerData);
		databaseButtonGroup.add(StaffData);
		PlayerData.setHorizontalAlignment(SwingConstants.CENTER);
		StaffData.setHorizontalAlignment(SwingConstants.CENTER);

		PlayerData.addActionListener(listener);
		StaffData.addActionListener(listener);

		databasePanel = new JPanel();
		databasePanel.setLayout(new GridLayout(1, 3));
		databasePanel.add(PlayerData);
		databasePanel.add(StaffData);
		databasePanel.setSize(690, 35);
		databasePanel.setLocation(15, 10);
		content.add(databasePanel);

		PlayerDetailsPanel.add(IDLabel);
		IDTF.setBounds(156, 17, 225, 25);
		PlayerDetailsPanel.add(IDTF);
		FirstNameLabel.setBounds(48, 42, 178, 25);
		PlayerDetailsPanel.add(FirstNameLabel);
		FirstNameTF.setBounds(156, 42, 225, 25);
		PlayerDetailsPanel.add(FirstNameTF);
		LastNameLabel.setBounds(48, 67, 178, 25);
		PlayerDetailsPanel.add(LastNameLabel);
		LastNameTF.setBounds(156, 66, 225, 25);
		PlayerDetailsPanel.add(LastNameTF);
		AgeLabel.setBounds(48, 92, 178, 25);
		PlayerDetailsPanel.add(AgeLabel);
		AgeTF.setBounds(156, 91, 225, 25);
		PlayerDetailsPanel.add(AgeTF);
		NumberLabel.setBounds(48, 117, 178, 25);
		PlayerDetailsPanel.add(NumberLabel);
		NumberTF.setBounds(156, 116, 225, 25);
		PlayerDetailsPanel.add(NumberTF);
		PositionLabel.setBounds(48, 142, 178, 25);
		PlayerDetailsPanel.add(PositionLabel);
		PositionTF.setBounds(156, 141, 225, 25);
		PlayerDetailsPanel.add(PositionTF);
		NationalityLabel.setBounds(48, 167, 178, 25);
		PlayerDetailsPanel.add(NationalityLabel);
		NationalityTF.setBounds(156, 166, 225, 25);
		PlayerDetailsPanel.add(NationalityTF);
		ValueLabel.setBounds(48, 192, 178, 25);
		PlayerDetailsPanel.add(ValueLabel);
		ValueTF.setBounds(156, 191, 225, 25);
		PlayerDetailsPanel.add(ValueTF);
		IDLabel2.setSize(178, 25);
		IDLabel2.setLocation(48, 17);

		StaffDetailsPanel.add(IDLabel2);
		IDTF2.setBounds(156, 17, 225, 25);
		StaffDetailsPanel.add(IDTF2);
		;
		FirstNameLabel2.setBounds(48, 42, 178, 25);
		StaffDetailsPanel.add(FirstNameLabel2);
		FirstNameTF2.setBounds(156, 42, 225, 25);
		StaffDetailsPanel.add(FirstNameTF2);
		LastNameLabel2.setBounds(48, 67, 178, 25);
		StaffDetailsPanel.add(LastNameLabel2);
		LastNameTF2.setBounds(156, 66, 225, 25);
		StaffDetailsPanel.add(LastNameTF2);
		AgeLabel2.setBounds(48, 92, 178, 25);
		StaffDetailsPanel.add(AgeLabel2);
		AgeTF2.setBounds(156, 91, 225, 25);
		StaffDetailsPanel.add(AgeTF2);
		NumberLabel2.setBounds(48, 117, 178, 25);
		StaffDetailsPanel.add(NumberLabel2);
		NumberTF2.setBounds(156, 116, 225, 25);
		StaffDetailsPanel.add(NumberTF2);
		PositionLabel2.setBounds(48, 142, 178, 25);
		StaffDetailsPanel.add(PositionLabel2);
		PositionTF2.setBounds(156, 141, 225, 25);
		StaffDetailsPanel.add(PositionTF2);

		exportButtonPanel = new JPanel();
		exportButtonPanel.setLayout(new GridLayout(3, 2));
		exportButtonPanel.setBackground(UIManager
				.getColor("RadioButtonMenuItem.selectionBackground"));
		exportButtonPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, new Color(255, 255, 255)),
				"Export Data", TitledBorder.LEADING, TitledBorder.ABOVE_BOTTOM,
				null, Color.WHITE));
		exportButtonPanel.add(NumOfNationality);
		exportButtonPanel.add(NumOfNationalityTF);
		exportButtonPanel.add(WageBill);
		exportButtonPanel.add(OlderPlayersTF);
		exportButtonPanel.add(ListOlderPlayers);
		exportButtonPanel.add(ListSpanishStaff);
		exportButtonPanel.setSize(391, 170);
		exportButtonPanel.setLocation(713, 330);
		content.add(exportButtonPanel);

		this.NumOfNationality.addActionListener(this);
		this.WageBill.addActionListener(this);
		this.ListOlderPlayers.addActionListener(this);
		this.ListSpanishStaff.addActionListener(this);

		TablePlayers
				.setPreferredScrollableViewportSize(new Dimension(900, 300));
		TableStaff.setPreferredScrollableViewportSize(new Dimension(900, 300));

		TablePlayers
				.setPreferredScrollableViewportSize(new Dimension(300, 600));
		dbContentsPanel1 = new JScrollPane(TablePlayers,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		dbContentsPanel1.setVisible(false);
		dbContentsPanel1.setSize(700, 450);
		dbContentsPanel1.setLocation(10, 50);
		content.add(dbContentsPanel1);

		TableStaff.setPreferredScrollableViewportSize(new Dimension(300, 600));
		dbContentsPanel2 = new JScrollPane(TableStaff,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		dbContentsPanel2.setVisible(false);
		dbContentsPanel2.setSize(700, 450);
		dbContentsPanel2.setLocation(10, 50);
		content.add(dbContentsPanel2);

		PlayerDetailsPanel.setSize(391, 309);
		PlayerDetailsPanel.setLocation(713, 10);

		content.add(PlayerDetailsPanel);
		insertButton.setBounds(166, 227, 96, 30);
		PlayerDetailsPanel.add(insertButton);
		deleteButton.setBounds(276, 268, 96, 30);
		PlayerDetailsPanel.add(deleteButton);
		updateButton.setBounds(276, 227, 96, 30);
		PlayerDetailsPanel.add(updateButton);
		clearButton.setBounds(166, 268, 96, 30);
		PlayerDetailsPanel.add(clearButton);
		exportButton.setBounds(40, 227, 110, 30);
		PlayerDetailsPanel.add(exportButton);

		StaffDetailsPanel.setSize(391, 309);
		StaffDetailsPanel.setLocation(713, 10);

		content.add(StaffDetailsPanel);
		insertButton2.setBounds(166, 227, 96, 30);
		StaffDetailsPanel.add(insertButton2);
		deleteButton2.setBounds(276, 268, 96, 30);
		StaffDetailsPanel.add(deleteButton2);
		updateButton2.setBounds(276, 227, 96, 30);
		StaffDetailsPanel.add(updateButton2);
		clearButton2.setBounds(166, 268, 96, 30);
		StaffDetailsPanel.add(clearButton2);
		exportButton2.setBounds(40, 227, 110, 30);
		StaffDetailsPanel.add(exportButton2);

		clearButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		insertButton.addActionListener(this);
		exportButton.addActionListener(this);
		clearButton2.addActionListener(this);
		updateButton2.addActionListener(this);
		deleteButton2.addActionListener(this);
		insertButton2.addActionListener(this);
		exportButton2.addActionListener(this);

		content.add(dbContentsPanel1);
		content.add(dbContentsPanel2);

		setSize(1130, 538);
		setVisible(true);

		PlayerDetailsPanel.setVisible(true);
		StaffDetailsPanel.setVisible(true);
		dbContentsPanel1.setVisible(true);
		dbContentsPanel2.setVisible(true);
		TableModelPlayers.refreshFromDB(stmt);
	}

	public void initiate_db_conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Assignment";
			con = DriverManager.getConnection(url, "root", "admin");
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("Error: Failed to connect to database\n"
					+ e.getMessage());
		}
	}

	ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			if (PlayerData.isSelected()) {
				dbContentsPanel1.setVisible(true);
				dbContentsPanel2.setVisible(false);
				PlayerDetailsPanel.setVisible(true);
				StaffDetailsPanel.setVisible(false);
				TableModelPlayers.refreshFromDB(stmt);
			}

			if (StaffData.isSelected()) {
				dbContentsPanel1.setVisible(false);
				dbContentsPanel2.setVisible(true);
				PlayerDetailsPanel.setVisible(false);
				StaffDetailsPanel.setVisible(true);
				TableModelStaff.refreshFromDB(stmt);
			}
		}
	};

	public void actionPerformed(ActionEvent e) {
		Object target = e.getSource();

		if (target == clearButton) {
			IDTF.setText("");
			FirstNameTF.setText("");
			LastNameTF.setText("");
			AgeTF.setText("");
			NumberTF.setText("");
			PositionTF.setText("");
			NationalityTF.setText("");
			ValueTF.setText("");
		}

		if (target == insertButton) {
			try {
				String updateTemp = "INSERT INTO players VALUES(" + null + ",'"
						+ FirstNameTF.getText() + "','" + LastNameTF.getText()
						+ "','" + AgeTF.getText() + "','" + NumberTF.getText()
						+ "','" + PositionTF.getText() + "','"
						+ NationalityTF.getText() + "','" + ValueTF.getText()
						+ "');";

				stmt.executeUpdate(updateTemp);
			} catch (SQLException sqle) {
				System.err.println("Error with  insert:\n" + sqle.toString());
			} finally {
				TableModelPlayers.refreshFromDB(stmt);
			}
		}

		if (target == deleteButton) {

			try {
				String updateTemp = "DELETE FROM players WHERE id = "
						+ IDTF.getText() + ";";
				stmt.executeUpdate(updateTemp);

			} catch (SQLException sqle) {
				System.err.println("Error with delete:\n" + sqle.toString());
			} finally {
				TableModelPlayers.refreshFromDB(stmt);
			}
		}

		if (target == exportButton) {

			cmd = "select * from players;";

			try {
				rs = stmt.executeQuery(cmd);
				writeToFile(rs);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		if (target == updateButton) {
			try {
				String updateTemp = "UPDATE players SET " + "FirstName = '"
						+ FirstNameTF.getText() + "', LastName = '"
						+ LastNameTF.getText() + "', Age = " + AgeTF.getText()
						+ ", Number =" + NumberTF.getText() + ", Position = '"
						+ PositionTF.getText() + "', Nationality = '"
						+ NationalityTF.getText() + "', Wages = "
						+ ValueTF.getText() + " where id = " + IDTF.getText();

				stmt.executeUpdate(updateTemp);
				// these lines do nothing but the table updates when we access
				// the db.
				rs = stmt.executeQuery("SELECT * from players ");
				rs.next();
				rs.close();
			} catch (SQLException sqle) {
				System.err.println("Error with  update:\n" + sqle.toString());
			} finally {
				TableModelPlayers.refreshFromDB(stmt);
			}
		}

		if (target == clearButton2) {
			IDTF2.setText("");
			FirstNameTF2.setText("");
			LastNameTF2.setText("");
			AgeTF2.setText("");
			NumberTF2.setText("");
			PositionTF2.setText("");
		}

		if (target == insertButton2) {
			try {
				String updateTemp = "INSERT INTO staff VALUES(" + null + ",'"
						+ FirstNameTF2.getText() + "','"
						+ LastNameTF2.getText() + "','" + AgeTF2.getText()
						+ "','" + NumberTF2.getText() + "','"
						+ PositionTF2.getText() + "');";

				stmt.executeUpdate(updateTemp);
			} catch (SQLException sqle) {
				System.err.println("Error with  insert:\n" + sqle.toString());
			} finally {
				TableModelStaff.refreshFromDB(stmt);
			}
		}

		if (target == deleteButton2) {

			try {
				String updateTemp = "DELETE FROM staff WHERE id = "
						+ IDTF2.getText() + ";";
				stmt.executeUpdate(updateTemp);

			} catch (SQLException sqle) {
				System.err.println("Error with delete:\n" + sqle.toString());
			} finally {
				TableModelStaff.refreshFromDB(stmt);
			}
		}

		if (target == exportButton2) {

			cmd = "select * from staff;";

			try {
				rs = stmt.executeQuery(cmd);
				writeToFile(rs);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		if (target == updateButton2) {
			try {
				String updateTemp = "UPDATE staff SET " + "FirstName = '"
						+ FirstNameTF2.getText() + "', LastName = '"
						+ LastNameTF2.getText() + "', Age = "
						+ AgeTF2.getText() + ", Nationality = '"
						+ NumberTF2.getText() + "', Wages =' "
						+ PositionTF2.getText() + "' where id = "
						+ IDTF2.getText();

				stmt.executeUpdate(updateTemp);
				rs = stmt.executeQuery("SELECT * from staff ");
				rs.next();
				rs.close();
			} catch (SQLException sqle) {
				System.err.println("Error with  update:\n" + sqle.toString());
			} finally {
				TableModelStaff.refreshFromDB(stmt);
			}
		}

		
		if(target == this.NumOfNationality){
			String squadsize = this.NumOfNationalityTF.getText();

			cmd = "select * "+  "from players " + "where nationality = '"  +squadsize+"';";

			System.out.println(cmd);
			try{					
				rs= stmt.executeQuery(cmd); 	
				writeToFile(rs);
			}
			catch(Exception e1){e1.printStackTrace();}

		} 
		
		if(target == this.WageBill){
			String older = this.OlderPlayersTF.getText();

			cmd = "select * from players where age >'"  +older+"';";

			System.out.println(cmd);
			try{					
				rs= stmt.executeQuery(cmd); 	
				writeToFile(rs);
			}
			catch(Exception e1){e1.printStackTrace();}

		} 

		if (target == this.ListOlderPlayers) {

			cmd = "SELECT SUM(t.Wages) AS Total_Wages FROM (SELECT Wages FROM players UNION ALL SELECT Wages FROM staff) t ;" ;

			try {
				rs = stmt.executeQuery(cmd);
				writeToFile(rs);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		if (target == this.ListSpanishStaff) {

			cmd = "SELECT FirstName, LastName, Age, Wages, Nationality FROM (SELECT FirstName, LastName, Age, Wages, Nationality FROM players UNION ALL SELECT FirstName, LastName, Age, Wages, Nationality FROM staff) t where Nationality = 'Spanish'";
			try {
				rs = stmt.executeQuery(cmd);
				writeToFile(rs);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	private void writeToFile(ResultSet rs) {
		try {
			System.out.println("Information sent to csv file");
			FileWriter outputFile = new FileWriter("Brian.csv");
			PrintWriter printWriter = new PrintWriter(outputFile);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumns = rsmd.getColumnCount();

			for (int i = 0; i < numColumns; i++) {
				printWriter.print(rsmd.getColumnLabel(i + 1) + ",");
			}
			printWriter.print("\n");
			while (rs.next()) {
				for (int i = 0; i < numColumns; i++) {
					printWriter.print(rs.getString(i + 1) + ",");
				}
				printWriter.print("\n");
				printWriter.flush();
			}
			printWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}