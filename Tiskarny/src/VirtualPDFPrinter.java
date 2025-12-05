public class VirtualPDFPrinter extends Printer{

    public int cenaToneruVirtual = 20;

    @Override
    public void vytisknout(String text) {
        System.out.println("Virtual printed your text: " + text);
    }

    @Override
    public void getCostPerPage(int strany) {
        int cenaVseho = cenaToneruVirtual + strany / 5;
        System.out.println("Cena vytistenych stran: " + cenaVseho);
    }
}
