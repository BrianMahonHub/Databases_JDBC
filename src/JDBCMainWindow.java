import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class JDBCMainWindow extends JFrame implements ActionListener {
	private JMenuItem exitItem;

	public JDBCMainWindow() {
		super("A00211953 JDBC Assignment");

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		exitItem = new JMenuItem("Exit");

		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);

		exitItem.addActionListener(this);

		MainContent aWindowContent = new MainContent(
				"Newcastle Player Profiles");
		getContentPane().add(aWindowContent);

		setSize(1140, 600);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(exitItem)) {
			this.dispose();
		}
	}
}