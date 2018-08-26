package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

import mvc.controller.ButtonController;
import mvc.controller.DrawingController;
import mvc.view.ButtonView;
import mvc.view.DrawingView;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class DrawingFrame extends JFrame {
	private DrawingView drawingView=new DrawingView();
	private DrawingController drawingController;
	private ButtonView buttonView=new ButtonView();
	private ButtonController buttonController;

	public DrawingFrame() {
		setSize(640,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(drawingView, BorderLayout.CENTER);
		drawingView.setBackground(Color.BLACK);
		drawingView.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!buttonView.getTglbtnSelected().isSelected()) {
					buttonView.getBtnDelete().setEnabled(false);
					buttonView.getComboBox_Shapes().setEnabled(true);
					drawingController.handleMousePressed(e);
				} else {
					buttonView.getBtnDelete().setEnabled(true);
					buttonView.getComboBox_Shapes().setEnabled(false);
					buttonController.selectedClick(e.getX(),e.getY());
				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if(!buttonView.getTglbtnSelected().isSelected()) {
					drawingController.drawShape(e);
				}

			}


		});

		//		drawingView.addMouseMotionListener(new MouseMotionAdapter() {
		//
		//			@Override
		//			public void mouseDragged(MouseEvent e) {
		//				drawingController.handleMouseDragged(e);
		//				super.mouseDragged(e);
		//			}
		//		
		//		});

		getContentPane().add(buttonView, BorderLayout.NORTH);

		buttonView.getBtnUndo().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				buttonController.undoClick();
			}
		});

		buttonView.getBtnRedo().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				buttonController.redoClick();

			}
		});

		buttonView.getTglbtnSelected().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(buttonView.getTglbtnSelected().isSelected()) {
					buttonController.unselectArray();
					buttonView.getComboBox_Shapes().setEnabled(true);
				} else
					buttonView.getComboBox_Shapes().setEnabled(false);
			}
		});


		buttonView.getBtnDelete().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buttonController.deleteShape();
			}
		});

		buttonView.getBtnUpdate().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buttonController.updateShape();
			}
		});


		buttonView.getBtnOutlineColor().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buttonController.changeOutlineColor();
			}
		});

		buttonView.getBtnInteriorColor().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buttonController.changeInteriorColor();
			}
		});

	}

	public DrawingView getDrawingView() {
		return drawingView;
	}
	public void setDrawingView(DrawingView drawingView) {
		this.drawingView = drawingView;
	}

	public DrawingController getDrawingController() {
		return drawingController;
	}

	public void setDrawingController(DrawingController drawingController) {
		this.drawingController = drawingController;
	}

	public ButtonController getButtonController() {
		return buttonController;
	}

	public void setButtonController(ButtonController buttonController) {
		this.buttonController = buttonController;
	}

	public ButtonView getButtonView() {
		return buttonView;
	}

}
