package BehaviouralPatterns.Memento;

// It is a snapshot so hence shd be immutable in memento
public class TextEditorMemento {
    private final String content;

    public TextEditorMemento(String content) {
        this.content = content;
    }

    String getContent() {   // package-private on purpose
        return content;
    }
}
