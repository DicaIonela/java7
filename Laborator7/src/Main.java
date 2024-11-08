public class Main {
    public static void main(String[] args) {
        // Obținem instanța Singleton a clasei Admitere
        Admitere admitere = Admitere.getInstance();



        // Înscriem 10 studenți distincti
        admitere.inmatriculeaza(20);
        Student studtest=new Student("Cosmin",Gen.M, 5, Facultate.FIA);
        Student studtest2=new Student("Georgiana",Gen.F, 5, Facultate.FEFS);
        admitere.inmatriculeaza(studtest.getNrMatricol());

        // Afișăm totalul studenților
        admitere.afiseazaTotiiStudentii();

        // Afișăm studenții din facultăți
        admitere.afiseazaStudPeGen();

        // Afișăm primele 10 numere matricole
        admitere.afiseazaPrimele10NrMatricole();

        // Permitem utilizatorului să aleagă facultăți
        admitere.alegeFacultate();
    }
}
