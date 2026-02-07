package StructuralPatterns.Proxy;

public class RealImage implements Image {

    String fileName;
    public RealImage(String fileName) {
        this.fileName = fileName;
        someExpensiveOperation();
    }

    public void someExpensiveOperation() {
        System.out.println("Doing some expensive operation after initialization");
    }

    @Override
    public void display() {
        System.out.println("Loading image" + fileName);
    }
}
