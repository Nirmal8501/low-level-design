package BehaviouralPatterns.Memento;

public class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.write("Hello 1");
        System.out.println(textEditor.getContent());

        textEditor.write("Hello 2");
        System.out.println(textEditor.getContent());

        textEditor.write("Hello 3");
        System.out.println(textEditor.getContent());

        textEditor.write("Hello 4");
        System.out.println(textEditor.getContent());

        textEditor.undo();
        System.out.println(textEditor.getContent());
        textEditor.undo();
        System.out.println(textEditor.getContent());

        textEditor.write("Hello 5");
        System.out.println(textEditor.getContent());
        textEditor.undo();
        System.out.println(textEditor.getContent());

    }
}