public class LaserPrinter extends Printer {

    public int cenaToneruLaser = 50;

    @Override
    public void vytisknout(String text) {
      System.out.println("Laser printed your text: " + text);
    }

    @Override
    public void getCostPerPage(int strany) {
        int cenaVseho = cenaToneruLaser + strany;
        System.out.println("Cena vytistenych stran: " + cenaVseho);
    }


}
