public class Main {
    public static void main(String[] args) {
        PointOfSale pointOfSale = new PointOfSale();
        // uns clients arriben i s'asseuen a una taula, el cambrer crea una nova Sale,
        // i pren nota de la comanda : 4 Moritz and 1 Cocacola
        int idSale = pointOfSale.makeNewSale();
        pointOfSale.addLineItemToSale(idSale, "Moritz", 4);
        pointOfSale.addLineItemToSale(idSale, "Cocacola", 1);
        // mes tard demanen 2 Coca-cola
        pointOfSale.addLineItemToSale(idSale, "Cocacola", 2);
        // demanen el compte i el cambrer imprimeix el tiquet :
        //Sale 1
        //Moritz 4 x 1.9 = 7.6
        //Cocacola 1 x 1.2 = 1.2
        //Cocacola 2 x 1.2 = 2.4
        //Total 11.2
        pointOfSale.printBillOfSale(idSale);
        double handedAmount = 20. ;
        pointOfSale.payOneSale(idSale, handedAmount);
    }
}