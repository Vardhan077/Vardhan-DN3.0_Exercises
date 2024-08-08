

public class FactoryMethodPattern {
    public static void main(String[] args) {
        DocumentFactory wordDocumentFactory = new WordDocumentFactory();
        Document wordDocument = wordDocumentFactory.createDocument();
        wordDocument.open();
        wordDocument.close();

        DocumentFactory pdfDocumentFactory = new PdfDocumentFactory();
        Document pdfDocument = pdfDocumentFactory.createDocument();
        pdfDocument.open();
        pdfDocument.close();

        DocumentFactory excelDocumentFactory = new ExcelDocumentFactory();
        Document excelDocument = excelDocumentFactory.createDocument();
        excelDocument.open();
        excelDocument.close();
    }
}



interface Document {
    void open();
    void close();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document...");
    }
    public void close() {
        System.out.println("Closing Word document...");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document...");
    }
    public void close() {
        System.out.println("Closing PDF document...");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel document...");
    }
    public void close() {
        System.out.println("Closing Excel document...");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}