package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shape.circle.Circle;
import shape.line.Line;
import shape.point.Point;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;


public class UpdateCircleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Circle circle;
	private JTextField txtToX;
	private JTextField txtForX;
	private JTextField txtBX;
	private JTextField txtToY;
	private JTextField txtForY;
	private JTextField txtBY;
	private JTextField txtBRadius;
	private JComboBox cmbCircle;
	private JTextField txtForRadius;
	private JTextField txtToRadius;

	public UpdateCircleDialog(Circle crl) {
		circle=new Circle(new Point(crl.getCenter().getX(), crl.getCenter().getY()), crl.getR(), crl.getColor(), crl.getInsideColor());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblMove = new JLabel("Move:");
			GridBagConstraints gbc_lblMove = new GridBagConstraints();
			gbc_lblMove.insets = new Insets(0, 0, 5, 5);
			gbc_lblMove.gridx = 1;
			gbc_lblMove.gridy = 1;
			contentPanel.add(lblMove, gbc_lblMove);
		}
		{
			cmbCircle = new JComboBox();
			
			cmbCircle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (cmbCircle.getSelectedItem().toString().equals("For")) {
						txtToX.setEditable(false);
						txtToY.setEditable(false);
						txtBX.setEditable(false);
						txtBY.setEditable(false);
						txtForX.setEditable(true);
						txtForY.setEditable(true);
					} else if(cmbCircle.getSelectedItem().toString().equals("To")){
						txtToX.setEditable(true);
						txtToY.setEditable(true);
						txtBX.setEditable(false);
						txtBY.setEditable(false);
						txtForX.setEditable(false);
						txtForY.setEditable(false);
					} else {
					
						txtToX.setEditable(false);
						txtToY.setEditable(false);
						txtBX.setEditable(true);
						txtBY.setEditable(true);
						txtForX.setEditable(false);
						txtForY.setEditable(false);
						txtBRadius.setEditable(true);
					}
					
					
				}
			});
			
			GridBagConstraints gbc_cmbCircle = new GridBagConstraints();
			gbc_cmbCircle.insets = new Insets(0, 0, 5, 5);
			gbc_cmbCircle.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbCircle.gridx = 3;
			gbc_cmbCircle.gridy = 1;
			contentPanel.add(cmbCircle, gbc_cmbCircle);
		}
		{
			JLabel lblCoordinateX = new JLabel("Coordinate Center X:");
			GridBagConstraints gbc_lblCoordinateX = new GridBagConstraints();
			gbc_lblCoordinateX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateX.gridx = 3;
			gbc_lblCoordinateX.gridy = 2;
			contentPanel.add(lblCoordinateX, gbc_lblCoordinateX);
		}
		{
			JLabel lblCoordinateY = new JLabel("Coordinate Center Y:");
			GridBagConstraints gbc_lblCoordinateY = new GridBagConstraints();
			gbc_lblCoordinateY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateY.gridx = 5;
			gbc_lblCoordinateY.gridy = 2;
			contentPanel.add(lblCoordinateY, gbc_lblCoordinateY);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 0);
			gbc_lblRadius.gridx = 7;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			JLabel lblTo = new JLabel("To:");
			GridBagConstraints gbc_lblTo = new GridBagConstraints();
			gbc_lblTo.insets = new Insets(0, 0, 5, 5);
			gbc_lblTo.gridx = 1;
			gbc_lblTo.gridy = 3;
			contentPanel.add(lblTo, gbc_lblTo);
		}
		{
			txtToX = new JTextField();
			GridBagConstraints gbc_txtToX = new GridBagConstraints();
			gbc_txtToX.insets = new Insets(0, 0, 5, 5);
			gbc_txtToX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtToX.gridx = 3;
			gbc_txtToX.gridy = 3;
			contentPanel.add(txtToX, gbc_txtToX);
			txtToX.setColumns(10);
		}
		{
			txtToY = new JTextField();
			GridBagConstraints gbc_txtToY = new GridBagConstraints();
			gbc_txtToY.insets = new Insets(0, 0, 5, 5);
			gbc_txtToY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtToY.gridx = 5;
			gbc_txtToY.gridy = 3;
			contentPanel.add(txtToY, gbc_txtToY);
			txtToY.setColumns(10);
		}
		{
			txtToRadius = new JTextField();
			GridBagConstraints gbc_txtToRadius = new GridBagConstraints();
			gbc_txtToRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtToRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtToRadius.gridx = 7;
			gbc_txtToRadius.gridy = 3;
			contentPanel.add(txtToRadius, gbc_txtToRadius);
			txtToRadius.setColumns(10);
		}
		{
			JLabel lblFor = new JLabel("For:");
			GridBagConstraints gbc_lblFor = new GridBagConstraints();
			gbc_lblFor.insets = new Insets(0, 0, 5, 5);
			gbc_lblFor.gridx = 1;
			gbc_lblFor.gridy = 4;
			contentPanel.add(lblFor, gbc_lblFor);
		}
		{
			txtForX = new JTextField();
			GridBagConstraints gbc_txtForX = new GridBagConstraints();
			gbc_txtForX.insets = new Insets(0, 0, 5, 5);
			gbc_txtForX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtForX.gridx = 3;
			gbc_txtForX.gridy = 4;
			contentPanel.add(txtForX, gbc_txtForX);
			txtForX.setColumns(10);
		}
		{
			txtForY = new JTextField();
			GridBagConstraints gbc_txtForY = new GridBagConstraints();
			gbc_txtForY.insets = new Insets(0, 0, 5, 5);
			gbc_txtForY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtForY.gridx = 5;
			gbc_txtForY.gridy = 4;
			contentPanel.add(txtForY, gbc_txtForY);
			txtForY.setColumns(10);
		}
		{
			txtForRadius = new JTextField();
			GridBagConstraints gbc_txtForRadius = new GridBagConstraints();
			gbc_txtForRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtForRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtForRadius.gridx = 7;
			gbc_txtForRadius.gridy = 4;
			contentPanel.add(txtForRadius, gbc_txtForRadius);
			txtForRadius.setColumns(10);
		}
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 5;
			contentPanel.add(label, gbc_label);
		}
		{
			JLabel lblBasicUpdate = new JLabel("Basic update:");
			GridBagConstraints gbc_lblBasicUpdate = new GridBagConstraints();
			gbc_lblBasicUpdate.insets = new Insets(0, 0, 0, 5);
			gbc_lblBasicUpdate.gridx = 1;
			gbc_lblBasicUpdate.gridy = 6;
			contentPanel.add(lblBasicUpdate, gbc_lblBasicUpdate);
		}
		{
			txtBX = new JTextField();
			GridBagConstraints gbc_txtBX = new GridBagConstraints();
			gbc_txtBX.insets = new Insets(0, 0, 0, 5);
			gbc_txtBX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBX.gridx = 3;
			gbc_txtBX.gridy = 6;
			contentPanel.add(txtBX, gbc_txtBX);
			txtBX.setColumns(10);
		}
		{
			txtBY = new JTextField();
			GridBagConstraints gbc_txtBY = new GridBagConstraints();
			gbc_txtBY.insets = new Insets(0, 0, 0, 5);
			gbc_txtBY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBY.gridx = 5;
			gbc_txtBY.gridy = 6;
			contentPanel.add(txtBY, gbc_txtBY);
			txtBY.setColumns(10);
		}
		{
			txtBRadius = new JTextField();
			GridBagConstraints gbc_txtBRadius = new GridBagConstraints();
			gbc_txtBRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBRadius.gridx = 7;
			gbc_txtBRadius.gridy = 6;
			contentPanel.add(txtBRadius, gbc_txtBRadius);
			txtBRadius.setColumns(10);
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
						
						if(cmbCircle.getSelectedItem().toString().equals("For") && (txtForX.getText().isEmpty() || txtForY.getText().isEmpty()) ) {
						
								JOptionPane.showMessageDialog(null, "Fill empty spaces!", "Error!",
										JOptionPane.WARNING_MESSAGE);
							
						} else if(cmbCircle.getSelectedItem().toString().equals("To") && (txtToX.getText().isEmpty() || txtToY.getText().isEmpty())){
							JOptionPane.showMessageDialog(null, "Fill empty spaces!", "Error!",
									JOptionPane.WARNING_MESSAGE);
						} else if(cmbCircle.getSelectedItem().toString().equals("Basic update") && (txtBX.getText().isEmpty() || txtBY.getText().isEmpty() || txtBRadius.getText().isEmpty())) {
							
								JOptionPane.showMessageDialog(null, "Fill empty spaces!", "Error!",
										JOptionPane.WARNING_MESSAGE);
						} 
						else {
							try {
							
							Object[] option = { "Yes", "No" };
							int answer = JOptionPane.showOptionDialog(null,
									"Are you sure that you want to move object?",
									"Choose one option:", JOptionPane.YES_NO_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null, option, option[0]);
							if (answer == 0) {
								
								if (cmbCircle.getSelectedItem().toString().equals("Basic update")) {
									circle.getCenter().setX(Integer.parseInt(txtBX.getText()));
									circle.getCenter().setY(Integer.parseInt(txtBY.getText()));
									circle.setR(Integer.parseInt(txtBRadius.getText()));
									
									
								}

								if (cmbCircle.getSelectedItem().toString().equals("For")) {
									circle.moveFor(Integer.parseInt(txtForX.getText()), Integer.parseInt(txtForY.getText()));
		
								} 
								
								if (cmbCircle.getSelectedItem().toString().equals("To")) {
									circle.moveTo(Integer.parseInt(txtToX.getText()), Integer.parseInt(txtToY.getText()));
		
								}
								
								setVisible(false);
							}
							
							}
							catch (NumberFormatException ex) {
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
						int answer = JOptionPane.showConfirmDialog(null, "Are you sure that you want to cancel?",
								"Choose one option:",
								JOptionPane.INFORMATION_MESSAGE);
						if (answer == JOptionPane.OK_OPTION) {
							setVisible(false);
							cancel();
							dispose();
						}

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);			}
		}
		cmbCircle.setModel(new DefaultComboBoxModel(new String[] { "For", "To", "Basic update" }));
		txtToX.setEditable(false);
		txtToY.setEditable(false);
		txtBX.setEditable(false);
		txtBY.setEditable(false);
		txtToRadius.setEditable(false);
		txtBRadius.setEditable(false);
		txtForRadius.setEditable(false);
		
		txtToX.setText(String.valueOf(this.circle.getCenter().getX()));
		txtToY.setText(String.valueOf(this.circle.getCenter().getY()));
		txtToRadius.setText(String.valueOf(this.circle.getR()));
		txtForX.setText(String.valueOf(this.circle.getCenter().getX()));
		txtForY.setText(String.valueOf(this.circle.getCenter().getY()));
		txtForRadius.setText(String.valueOf(this.circle.getR()));
		
	
		pack();
		setVisible(true);
		
	}

	public Circle getCircle() {
		return circle;
	}
	
	public void cancel() {
		circle = null;
	}
}