package mvc.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;

public class ButtonView extends JPanel {
	GridBagLayout gridBagLayout = new GridBagLayout();
	private JButton btnUndo = new JButton("Undo");
	private JButton btnRedo = new JButton("Redo");
	private JToggleButton tglbtnSelected = new JToggleButton("Select");
	private JComboBox comboBox_Shapes = new JComboBox();
	private JButton btnDelete = new JButton("Delete");
	private JButton btnUpdate = new JButton("Update");
	private JButton btnOutlineColor = new JButton("Outline Color");
	private JButton btnInteriorColor = new JButton("Interior color");


	public ButtonView() {

		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		gbc_btnUndo.insets = new Insets(0, 0, 5, 5);
		gbc_btnUndo.gridx = 0;
		gbc_btnUndo.gridy = 0;
		add(btnUndo, gbc_btnUndo);

		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.insets = new Insets(0, 0, 5, 5);
		gbc_btnRedo.gridx = 1;
		gbc_btnRedo.gridy = 0;
		add(btnRedo, gbc_btnRedo);
		
		
		GridBagConstraints gbc_tglbtnSelected = new GridBagConstraints();
		gbc_tglbtnSelected.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnSelected.gridx = 2;
		gbc_tglbtnSelected.gridy = 0;
		add(tglbtnSelected, gbc_tglbtnSelected);
		
		GridBagConstraints gbc_comboBox_Shapes = new GridBagConstraints();
		gbc_comboBox_Shapes.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Shapes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Shapes.gridx = 3;
		gbc_comboBox_Shapes.gridy = 0;
		add(comboBox_Shapes, gbc_comboBox_Shapes);
		comboBox_Shapes.setModel(new DefaultComboBoxModel<>(new String[] {"Point", "Line", "Square", "Circle", "Rectangle"}));
		
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 4;
		gbc_btnDelete.gridy = 0;
		add(btnDelete, gbc_btnDelete);
		
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdate.gridx = 0;
		gbc_btnUpdate.gridy = 1;
		add(btnUpdate, gbc_btnUpdate);
		

	
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnColor.gridx = 1;
		gbc_btnColor.gridy = 1;
		add(btnOutlineColor, gbc_btnColor);
		
		
		GridBagConstraints gbc_btnIn = new GridBagConstraints();
		gbc_btnIn.insets = new Insets(0, 0, 0, 5);
		gbc_btnIn.gridx = 2;
		gbc_btnIn.gridy = 1;
		add(btnInteriorColor, gbc_btnIn);
		
		
		
	}

	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public JToggleButton getTglbtnSelected() {
		return tglbtnSelected;
	}

	public JComboBox getComboBox_Shapes() {
		return comboBox_Shapes;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnOutlineColor() {
		return btnOutlineColor;
	}

	public JButton getBtnInteriorColor() {
		return btnInteriorColor;
	}

}