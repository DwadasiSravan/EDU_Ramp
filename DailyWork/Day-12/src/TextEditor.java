import java.util.Stack;

public class TextEditor {
    private String text = "";
    private final Stack<String> undoStack = new Stack<>();
    private final Stack<String> redoStack = new Stack<>();

    public void type(String newText) {
        undoStack.push(text);
        text += newText;
        redoStack.clear();
    }

    public void setText(String newText) {
        text = newText;
    }

    public String getText() {
        return text;
    }

    public Stack<String> getUndoStack() {
        return undoStack;
    }

    public Stack<String> getRedoStack() {
        return redoStack;
    }

    public void showText() {
        System.out.println("Text: " + text);
    }
}
