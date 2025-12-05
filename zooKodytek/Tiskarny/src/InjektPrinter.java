public class InjektPrinter extends Printer {

    public int cenaToneruInjekt = 30;

    @Override
    public void vytisknout(String text) {
        System.out.println("Injekt printed your text: " + text);
    }

    @Override
    public void getCostPerPage(int strany) {
        int cenaVseho = cenaToneruInjekt + strany;
        System.out.println("Cena vytistenych stran: " + cenaVseho);
    }
}
