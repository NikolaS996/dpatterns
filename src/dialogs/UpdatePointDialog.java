package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shape.point.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdatePointDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Point point;
	private JTextField txtX;
	private JTextField txtY;
	JComboBox cmbMove;
	

	public UpdatePointDialog(Point pt) {
		point=new Point(pt.getX(), pt.getY(), pt.getColor());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblMove = new JLabel("Move: ");
			GridBagConstraints gbc_lblMove = new GridBagConstraints();
			gbc_lblMove.insets = new Insets(0, 0, 5, 5);
			gbc_lblMove.gridx = 1;
			gbc_lblMove.gridy = 1;
			contentPanel.add(lblMove, gbc_lblMove);
		}
		{
			cmbMove = new JComboBox();
			GridBagConstraints gbc_cmbMove = new GridBagConstraints();
			gbc_cmbMove.insets = new Insets(0, 0, 5, 0);
			gbc_cmbMove.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbMove.gridx = 3;
			gbc_cmbMove.gridy = 1;
			contentPanel.add(cmbMove, gbc_cmbMove);
			
		}
		{
			JLabel lblCoordinateX = new JLabel("Coordinate X:");
			GridBagConstraints gbc_lblCoordinateX = new GridBagConstraints();
			gbc_lblCoordinateX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateX.gridx = 1;
			gbc_lblCoordinateX.gridy = 3;
			contentPanel.add(lblCoordinateX, gbc_lblCoordinateX);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 3;
			gbc_txtX.gridy = 3;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblCoordinateY = new JLabel("Coordinate Y:");
			GridBagConstraints gbc_lblCoordinateY = new GridBagConstraints();
			gbc_lblCoordinateY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateY.gridx = 1;
			gbc_lblCoordinateY.gridy = 5;
			contentPanel.add(lblCoordinateY, gbc_lblCoordinateY);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 3;
			gbc_txtY.gridy = 5;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
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
						
						if(txtX.getText().isEmpty() || txtY.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Fill empty spaces!", "Error!",
									JOptionPane.WARNING_MESSAGE);
						} else {
							try {
							int coordinateX= Integer.parseInt(txtX.getText());
							int coordinateY=Integer.parseInt(txtY.getText());
							
							Object[] option = { "Yes", "No" };
							int answer = JOptionPane.showOptionDialog(null,
									"Are you sure that you want to move object?",
									"Choose one option:", JOptionPane.YES_NO_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null, option, option[0]);
							if (answer == 0) {

								if (cmbMove.getSelectedItem().toString().equals("TO")) {
									point.moveTo(coordinateX, coordinateY);
									System.out.println(point);
									
								}

								if (cmbMove.getSelectedItem().toString().equals("FOR")) {
									point.moveFor(coordinateX, coordinateY);
									System.out.println(point);
								}
								setVisible(false);
							}
							
							}
							catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva!", "Error",
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
							setVisible(false);
							cancel();
							dispose();
						}

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cmbMove.setModel(new DefaultComboBoxModel(new String[] { "FOR", "TO" }));
		txtX.setText(String.valueOf(this.point.getX()));
		txtY.setText(String.valueOf(this.point.getY()));
		
		pack();
		setVisible(true);
	}

	public Point getPoint() {
		return point;
	}
	
	public void cancel() {
		point = null;
	}

}