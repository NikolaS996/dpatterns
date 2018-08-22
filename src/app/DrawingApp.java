package app;

import mvc.controller.ButtonController;
import mvc.controller.DrawingController;
import frame.DrawingFrame;
import mvc.model.DrawingModel;

public class DrawingApp {

	public static void main(String[] args) {			
		DrawingFrame drawingFrame = new DrawingFrame();
		DrawingModel drawingModel = new DrawingModel();
		DrawingController drawingController = new DrawingController(drawingModel,drawingFrame);

		//frame obavjestavamo ko mu je kontroler
		drawingFrame.setDrawingController(drawingController);
		//kazemo viewu ko je njegov model
		drawingFrame.getDrawingView().setDrawingmodel(drawingModel);

		ButtonController buttonController = new ButtonController(drawingFrame,drawingModel);
		drawingFrame.setButtonController(buttonController);
	}
}
