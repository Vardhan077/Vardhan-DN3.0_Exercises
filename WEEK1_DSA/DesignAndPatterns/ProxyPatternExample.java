
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ImageProxy("image1.jpg");
        Image image2 = new ImageProxy("image2.jpg");

        image1.display();
        System.out.println("");

        image1.display();  // Should not reload image
        System.out.println("");

        image2.display();
        System.out.println("");

        image2.display();  // Should not reload image
    }
}


interface Image {
    void display();
}

class ActualImage implements Image {
    private String filename;

    public ActualImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ImageProxy implements Image {
    private String filename;
    private ActualImage actualImage;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (actualImage == null) {
            actualImage = new ActualImage(filename);
        }
        actualImage.display();
    }
}
