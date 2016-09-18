import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.*;

public class NorthPanel extends JPanel {
	private MainFrame mf;
	private JPanel northPanel;
	private JLabel destination;
	private JLabel departureTime;
	private JLabel airline;
	private JLabel terminal;

	public NorthPanel(MainFrame mf, ArrayList<Flight> flights) {
		this.mf = mf;
		northPanel = new JPanel();
		GridBagLayout m = new GridBagLayout();
		northPanel.setLayout(m);
		GridBagConstraints con;
		Font bigLabelFont = new Font("Serif", Font.BOLD, 25);
		Font flightFont = new Font("Arial", Font.PLAIN, 15);

		destination = new JLabel("Destination");
		destination.setFont(bigLabelFont);

		departureTime = new JLabel("Avgång");
		departureTime.setFont(bigLabelFont);

		airline = new JLabel("Flygbolag");
		airline.setFont(bigLabelFont);

		terminal = new JLabel("Terminal");
		terminal.setFont(bigLabelFont);

		con = new GridBagConstraints();
		con.fill = GridBagConstraints.BOTH;
		con.weightx = 1;
		con.gridy = 0;
		con.gridx = 0;
		con.gridheight = 2;
		m.setConstraints(destination, con);
		northPanel.add(destination);

		con.gridx = 5;
		m.setConstraints(departureTime, con);
		northPanel.add(departureTime);

		con.gridx = 10;
		m.setConstraints(airline, con);
		northPanel.add(airline);

		con.gridx = 15;
		m.setConstraints(terminal, con);
		northPanel.add(terminal);

		con.gridheight = 1;
		con.weighty = 1;
		try {
			for (int i = 0; i < 30; i++) {
				JLabel flightDestination = new JLabel();
				JLabel flightDepartureTime = new JLabel();
				JLabel flightAirline = new JLabel();
				JLabel flightTerminal = new JLabel();
				flightDestination.setOpaque(true);
				flightDepartureTime.setOpaque(true);
				flightAirline.setOpaque(true);
				flightTerminal.setOpaque(true);
				if ((i & 1) == 0) {
					Color customColor = new Color(148, 148, 184);
					flightDestination.setBackground(customColor);
					flightDepartureTime.setBackground(customColor);
					flightAirline.setBackground(customColor);
					flightTerminal.setBackground(customColor);
				}

				flightDestination.setText(flights.get(i).getArrivalDestination());
				flightDestination.setFont(flightFont);
				flightDestination.setOpaque(true);
				con.gridy = i + 2;
				con.gridx = 0;
				m.setConstraints(flightDestination, con);
				northPanel.add(flightDestination);

				flightDepartureTime.setText(flights.get(i).getProbableFlightTime());
				flightDepartureTime.setFont(flightFont);
				con.gridx = 5;
				m.setConstraints(flightDepartureTime, con);
				northPanel.add(flightDepartureTime);

				flightAirline.setText(flights.get(i).getAirlineName());
				flightAirline.setFont(flightFont);
				con.gridx = 10;
				m.setConstraints(flightAirline, con);
				northPanel.add(flightAirline);

				flightTerminal.setText(String.valueOf(flights.get(i).getTerminal()));
				flightTerminal.setFont(flightFont);
				con.gridx = 15;
				m.setConstraints(flightTerminal, con);
				northPanel.add(flightTerminal);
			}
		} catch (IndexOutOfBoundsException e) {
			for (int i = 0; i < flights.size(); i++) {
				JLabel flightDestination = new JLabel();
				JLabel flightDepartureTime = new JLabel();
				JLabel flightAirline = new JLabel();
				JLabel flightTerminal = new JLabel();
				flightDestination.setOpaque(true);
				flightDepartureTime.setOpaque(true);
				flightAirline.setOpaque(true);
				flightTerminal.setOpaque(true);
				if ((i & 1) == 0) {
					flightDestination.setBackground(Color.lightGray);
					flightDepartureTime.setBackground(Color.lightGray);
					flightAirline.setBackground(Color.lightGray);
					flightTerminal.setBackground(Color.lightGray);
				}

				flightDestination.setText(flights.get(i).getArrivalDestination());
				flightDestination.setFont(flightFont);
				con.gridy = i + 2;
				con.gridx = 0;
				m.setConstraints(flightDestination, con);
				northPanel.add(flightDestination);

				flightDepartureTime.setText(flights.get(i).getProbableFlightTime());
				flightDepartureTime.setFont(flightFont);
				con.gridx = 5;
				m.setConstraints(flightDepartureTime, con);
				northPanel.add(flightDepartureTime);

				flightAirline.setText(flights.get(i).getAirlineName());
				flightAirline.setFont(flightFont);
				con.gridx = 10;
				m.setConstraints(flightAirline, con);
				northPanel.add(flightAirline);

				flightTerminal.setText(String.valueOf(flights.get(i).getTerminal()));
				flightTerminal.setFont(flightFont);
				con.gridx = 15;
				m.setConstraints(flightTerminal, con);
				northPanel.add(flightTerminal);
			}
		}
		///////////////////////////////////// V�NSTER PANEL /////////////////////////////////////

		if (flights.size() > 30) {
			try {
				JPanel blackSeparator = new JPanel();
				blackSeparator.setOpaque(true);
				blackSeparator.setBackground(Color.black);
				con.gridx = 16;
				con.gridy = 0;
				con.weightx = 0;
				m.setConstraints(blackSeparator, con);
				northPanel.add(blackSeparator);

				destination = new JLabel("Destination");
				destination.setFont(bigLabelFont);

				departureTime = new JLabel("Avgång");
				departureTime.setFont(bigLabelFont);

				airline = new JLabel("Flygbolag");
				airline.setFont(bigLabelFont);

				terminal = new JLabel("Terminal");
				terminal.setFont(bigLabelFont);

				con.weightx = 1;
				con.gridy = 0;
				con.gridx = 17;
				con.gridheight = 2;
				m.setConstraints(destination, con);
				northPanel.add(destination);

				con.gridx = 22;
				m.setConstraints(departureTime, con);
				northPanel.add(departureTime);

				con.gridx = 27;
				m.setConstraints(airline, con);
				northPanel.add(airline);

				con.gridx = 32;
				m.setConstraints(terminal, con);
				northPanel.add(terminal);

				con.gridheight = 1;
				con.weighty = 1;
				for (int i = 30; i < 60; i++) {
					blackSeparator = new JPanel();
					blackSeparator.setOpaque(true);
					blackSeparator.setBackground(Color.black);
					con.gridx = 16;
					con.gridy = i - 28;
					m.setConstraints(blackSeparator, con);
					northPanel.add(blackSeparator);

					JLabel flightDestination = new JLabel();
					JLabel flightDepartureTime = new JLabel();
					JLabel flightAirline = new JLabel();
					JLabel flightTerminal = new JLabel();
					flightDestination.setOpaque(true);
					flightDepartureTime.setOpaque(true);
					flightAirline.setOpaque(true);
					flightTerminal.setOpaque(true);
					if ((i & 1) == 0) {
						Color customColor = new Color(148, 148, 184);
						flightDestination.setBackground(customColor);
						flightDepartureTime.setBackground(customColor);
						flightAirline.setBackground(customColor);
						flightTerminal.setBackground(customColor);
					}

					flightDestination.setText(flights.get(i).getArrivalDestination());
					flightDestination.setFont(flightFont);
					con.gridy = i - 28;
					con.gridx = 17;
					m.setConstraints(flightDestination, con);
					northPanel.add(flightDestination);

					flightDepartureTime.setText(flights.get(i).getProbableFlightTime());
					flightDepartureTime.setFont(flightFont);
					con.gridx = 22;
					m.setConstraints(flightDepartureTime, con);
					northPanel.add(flightDepartureTime);

					flightAirline.setText(flights.get(i).getAirlineName());
					flightAirline.setFont(flightFont);
					con.gridx = 27;
					m.setConstraints(flightAirline, con);
					northPanel.add(flightAirline);

					flightTerminal.setText(String.valueOf(flights.get(i).getTerminal()));
					flightTerminal.setFont(flightFont);
					con.gridx = 32;
					m.setConstraints(flightTerminal, con);
					northPanel.add(flightTerminal);
				}
			} catch (IndexOutOfBoundsException e) {
			}

		}

	}

	public JPanel getNorthPanel() {
		return northPanel;
	}

}
