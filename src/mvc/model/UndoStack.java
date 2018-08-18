package mvc.model;

import java.util.Deque;
import java.util.LinkedList;

import shape.Command;

public class UndoStack {

	private static Deque<Command> undoStack = new LinkedList<>();

	public static void undoLastCommand() {
		if (!undoStack.isEmpty()) {
			Command previousCommand = undoStack.pollLast();
			RedoStack.getRedoStack().offerLast(previousCommand);
			previousCommand.unexecute();
		}
	}

	public static Deque<Command> getUndoStack() {
		return undoStack;
	}

}
