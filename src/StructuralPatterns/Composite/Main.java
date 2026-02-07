package StructuralPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails();
}

class File implements FileSystemComponent {
    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + fileName);
    }
}

class Folder implements FileSystemComponent {
    private String folderName;
    List<FileSystemComponent> components;

    public Folder(String folderName) {
        this.folderName = folderName;
        components = new ArrayList<FileSystemComponent>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + folderName);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Folder rootFolder = new Folder("root");
        Folder internalFolder1 = new Folder("dir 1");
        FileSystemComponent internalFolder2 = new Folder("dir 2");

        FileSystemComponent file1 = new File("file 1");
        rootFolder.addComponent(internalFolder1);
        rootFolder.addComponent(internalFolder2);
        rootFolder.addComponent(file1);

        internalFolder1.addComponent(new File("file 2 inside internal folder 1"));
        internalFolder1.addComponent(new Folder("folder inside internal folder"));

        rootFolder.showDetails();

    }
}
