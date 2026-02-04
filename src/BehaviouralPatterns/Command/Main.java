package BehaviouralPatterns.Command;

class TextEditor {

    public void makeTextBold() {
        System.out.println("Makingg text bold");
    }

    public void makeTextItalics() {
        System.out.println("Making italics");
    }
}

// Now one button can do any types of tasks//actions and is completely decoupled from Text Editor, it has become generic and dumb
class Button {
    private Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void onClick() {
        command.execute();
    }
}

interface Command {
    void execute();
}

class BoldTextCommand implements Command {
    private TextEditor textEditor;

    public BoldTextCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.makeTextBold();
    }
}

class ItalicizeTextCommand implements Command {
    private TextEditor textEditor;

    public ItalicizeTextCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.makeTextItalics();
    }
}

public class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        Button boldButton = new Button(new BoldTextCommand(textEditor));
        Button italicsButton = new Button(new ItalicizeTextCommand(textEditor));

        boldButton.onClick();
        italicsButton.onClick();
    }
}
