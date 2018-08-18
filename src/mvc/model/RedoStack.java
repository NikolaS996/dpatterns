package mvc.model;

import java.util.Deque;
import java.util.LinkedList;

import shape.Command;

public class RedoStack {
	  
	  private static Deque<Command> redoStack = new LinkedList<>();
	  
	  
	  public static void redoLastCommand() {
		    if (!redoStack.isEmpty()) {
		      Command previousCommand = redoStack.pollLast();
		      UndoStack.getUndoStack().offerLast(previousCommand);
		      previousCommand.execute();
		    }
		  }

	public static Deque<Command> getRedoStack() {
		return redoStack;
	}

}
