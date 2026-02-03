package BehaviouralPatterns.Memento;

// Implement undo functionality on a test editor to go back to the previously typed content
public class TextEditor {

    private String content;
    private final MementoCaretaker<TextEditorMemento> history = new MementoCaretaker<>();

    public void write(String text) {
        if (content != null) {
            history.add(save());
        }
        this.content = text;
    }

//    Key note -> I have assumed that each editor has a caretaker, so if u wish, u can also have the undo thing in caretaker
//    to separate the two, and do like caretaker.saveState(pass obj here) and caretaker.undo(editor) and so on so it separates resposiblity
//    but neither is wrong, it depends on use case and both have implemented correct memento.

    public void undo() {
//  1) Fetch the previous memento (i.e state)
//  2) Reload the currentt state from memento -> To restore lets make another private function

        if (history.isEmpty()) {
            return; // or throw domain-specific exception
        }
        TextEditorMemento lastState = history.getLastState();
        restore(lastState);
    }

    public String getContent() {
        return content;
    }

    private TextEditorMemento save() {
        return new TextEditorMemento(this.content);
    }

    private void restore(TextEditorMemento lastState) {
        this.content = lastState.getContent();
    }
}
