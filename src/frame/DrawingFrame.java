package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import mvc.controller.ButtonController;
import mvc.controller.DrawingController;
import mvc.view.DrawingView;
import mvc.view.ButtonView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawingFrame extends JFrame {

	private DrawingView drawingView=new DrawingView(); //app ce podrazumjevati da je view instanciran i da ga imamo ... panel nam je sad view
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
					drawingController.addPoint(e);
				} else {
					buttonController.selectedClick(e.getX(),e.getY());
				}
			}
		});
		buttonView.getBtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

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
				}
			}
		});

		buttonView.getComboBox_Shapes().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				switch (buttonView.getComboBox_Shapes().getSelectedItem().toString()) {
				case "Point":

					break;
				case "Line":

					break;
				default:

					break;
				}

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

	}


	//View mozemo da direktno instanciramo iz Frama
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
}
