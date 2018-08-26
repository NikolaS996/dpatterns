package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddSquareDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtSideLength;
	
	public boolean accepted = false;

	public AddSquareDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblEnterLengthSide = new JLabel("Enter length side of square:");
			GridBagConstraints gbc_lblEnterLengthSide = new GridBagConstraints();
			gbc_lblEnterLengthSide.insets = new Insets(0, 0, 5, 0);
			gbc_lblEnterLengthSide.gridx = 4;
			gbc_lblEnterLengthSide.gridy = 1;
			contentPanel.add(lblEnterLengthSide, gbc_lblEnterLengthSide);
		}
		{
			txtSideLength = new JTextField();
			GridBagConstraints gbc_txtSideLength = new GridBagConstraints();
			gbc_txtSideLength.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSideLength.gridx = 4;
			gbc_txtSideLength.gridy = 3;
			contentPanel.add(txtSideLength, gbc_txtSideLength);
			txtSideLength.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {

						if (txtSideLength.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Fill empty space!", "Error!",
									JOptionPane.WARNING_MESSAGE);
						} else {
							try {
								int sideLength = Integer.parseInt(txtSideLength.getText());
								if (sideLength <= 0) {
									JOptionPane.showMessageDialog(null, "Length of side must be greater then zero",
											"Error", JOptionPane.ERROR_MESSAGE);
								} else {
									accepted = true;
								}
								
								setVisible(false);
							} catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Only numbers are allowed!", "Error",
										JOptionPane.ERROR_MESSAGE);

							}

						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						int answer = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da �elite da otka�ete?",
								"Izaberite jednu od opcija:",
								JOptionPane.INFORMATION_MESSAGE);
						if (answer == JOptionPane.OK_OPTION) {
							accepted = false;
							setVisible(false);
							dispose();
						}
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}