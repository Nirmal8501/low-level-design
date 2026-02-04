package BehaviouralPatterns.Template;

abstract class DataParser {

    public final void processFile() {  // adding final here IMP as child classes shdn't be able to tweak the algo, thats the whole point of template
        openFile();
        parseFile();
        closeFile();
    }

    protected void openFile() {
        System.out.println("Opening File");
    }

    protected void closeFile() {
        System.out.println("Closing File");
    }

    protected abstract void parseFile();

}

class CSVParser extends DataParser {

    @Override
    protected void parseFile() {
        System.out.println("Parsing via csv parser");
    }

    @Override
    protected void openFile() {
        System.out.println("Overridden open file of CSV parser, override if u want new functionality");
    }
}

class XMLParser extends DataParser {

    @Override
    protected void parseFile() {
        System.out.println("Parsing via XML Parser");
    }
}

public class Main {

    public static void main(String[] args) {
        DataParser csvParser = new CSVParser();
        DataParser xmlParser = new XMLParser();

        csvParser.processFile();
        System.out.println("\n\n");
        xmlParser.processFile();

    }
}
