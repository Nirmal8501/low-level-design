package StructuralPatterns.Proxy;

public class ProxyImage implements Image {
//    Holds refernce to real image

    private RealImage image;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {

//        here u can put logic like if !user.isAdmin n stuff like tthat for access control
        if(image == null) {
            image = new RealImage(fileName); // Helps in lazy loading n caching
        }
        image.display();
    }
}
