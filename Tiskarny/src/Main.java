import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Printer laser = new LaserPrinter();
        Printer injekt = new InjektPrinter();
        Printer virtualPDF = new VirtualPDFPrinter();

        ArrayList<Printer> printers = new ArrayList<>();

        printers.add(laser);
        printers.add(injekt);
        printers.add(virtualPDF);

        for (Printer printer : printers) {
            printer.vytisknout("Test text");
            printer.getCostPerPage(50);
        }
    }

    //67%
}
