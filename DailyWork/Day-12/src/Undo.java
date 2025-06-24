public class Undo {
    private TextEditor editor;

    public Undo(TextEditor editor) {
        this.editor = editor;
    }

    public void execute() {
        if (!editor.getUndoStack().isEmpty()) {
            editor.getRedoStack().push(editor.getText());
            editor.setText(editor.getUndoStack().pop());
        } else {
            System.out.println("Nothing to undo");
        }
    }
}
