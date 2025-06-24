public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Undo undo = new Undo(editor);
        Redo redo = new Redo(editor);

        editor.type("Hello");
        editor.showText();

        editor.type(" World");
        editor.showText();

        undo.execute();
        editor.showText();

        redo.execute();
        editor.showText();

        undo.execute();
        undo.execute();
        editor.showText();

        redo.execute();
        editor.showText();

        editor.type(" Java");
        editor.showText();

        redo.execute();
    }
}
