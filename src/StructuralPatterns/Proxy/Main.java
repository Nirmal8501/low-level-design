package StructuralPatterns.Proxy;

public class Main {
    public static void main(String[] args) {
        Image realImage = new RealImage("dog.png"); // At object creation the expensive operations start running which i dont wish
        realImage.display();

        Image newImage = new RealImage("cat.png");
        newImage.display();


//        Proxy

        Image proxyImage = new ProxyImage("dog.png");
//        proxyImage.display();
    }
}
