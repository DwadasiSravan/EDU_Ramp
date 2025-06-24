public class Redo {
    private final TextEditor editor;

    public Redo(TextEditor editor) {
        this.editor = editor;
    }

    public void execute() {
        if (!editor.getRedoStack().isEmpty()) {
            editor.getUndoStack().push(editor.getText());
            editor.setText(editor.getRedoStack().pop());
        } else {
            System.out.println("Nothing to redo");
        }
    }
}
