public class Test {
    public static void main(String[] args) {
        Movie theNotebook = new Movie(Genre.ROMANCE, "The Notebook", 10, 5.00, 120);
        Movie narnia = new Movie(Genre.FANTASY, "Narnia", 2, 5.00, 120);
        Movie theJournal = new Movie(Genre.ROMANCE, "The Notebook", 10, 5.00, 120);
        Movie sleeplessInSeattle = new Movie(Genre.ROMANCE, "Sleepless In Seattle", 11);
        VideoGame callOfDuty = new VideoGame(Genre.SCI_FI, "Call of Duty", 100);
        VideoGame valorant = new VideoGame(Genre.ACTION, "Valorant", 6, 8.00, 1, false);
        //System.out.println(theNotebook);
        //System.out.println(sleeplessInSeattle);
        // System.out.println(theNotebook.equals(sleeplessInSeattle));
        // System.out.println(sleeplessInSeattle.equals(theNotebook));
        // System.out.println(theNotebook.equals(theJournal));
        // System.out.println(theJournal.equals(theNotebook));
        //System.out.println(theNotebook.compareTo(sleeplessInSeattle));
        //System.out.println(sleeplessInSeattle.compareTo(theNotebook));
        //System.out.println(theNotebook.compareTo(theJournal));
        //System.out.println(theJournal.compareTo(theNotebook));
        // System.out.println(callOfDuty);
        // System.out.println(valorant);
        // //System.out.println(valorant.compareTo(callOfDuty));
        // System.out.println(callOfDuty.compareTo(valorant));
        Blockbuster criminalRecords = new Blockbuster();
        criminalRecords.addMedia(theNotebook);
        criminalRecords.addMedia(callOfDuty);
        criminalRecords.addMedia(valorant);
        criminalRecords.addMedia(narnia);
        criminalRecords.addMedia(sleeplessInSeattle);

        System.out.println(Olivia.cart);
        System.out.println(Olivia.addToCart(valorant, criminalRecords));
        System.out.println(Olivia.cart);



        //System.out.println(valorant.equals(callOfDuty));
        //System.out.println(narnia.equals(theNotebook));
        //System.out.println(criminalRecords.mostPopularMovie());
        //criminalRecords.sortMedia();
        //System.out.println(criminalRecords.findMedia(sleeplessInSeattle));
        //System.out.println(criminalRecords.mediaItems);
        //System.out.println(Olivia.addToCart(theNotebook, criminalRecords));
        //System.out.println(criminalRecords.mediaItems);

        //criminalRecords.removeMedia(callOfDuty);
        //criminalRecords.removeMedia(sleeplessInSeattle);
        //criminalRecords.removeMedia(theNotebook);
        //System.out.println(criminalRecords.mostPopularMovie());

    }
}