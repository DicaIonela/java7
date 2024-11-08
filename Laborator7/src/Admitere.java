import java.util.*;
public class Admitere {
    // Singleton Instance
    private static volatile Admitere instance;

    // Colecții pentru studenți folosind HashMap
    private HashMap<Integer, Student> registruMatricol; // Registrul matricol, cheia este nr. matricol
    private HashMap<Facultate, List<Student>> facultati; // Facultăți
    private HashMap<Gen, List<Student>> genuri; // Genuri
    private Set<Student> studentiUnici; // Set pentru a verifica unicitatea unui student
    private Student studentNou;
    // Constructor privat pentru Singleton
    private Admitere() {
        registruMatricol = new HashMap<>();
        facultati = new HashMap<>();
        genuri = new HashMap<>();
        studentiUnici = new HashSet<>(); // Folosim un Set pentru a verifica unicitatea studenților
    }

    // Singleton - obținerea instanței
    public static Admitere getInstance() {
        if (instance == null) {
            synchronized (Admitere.class) {
                if (instance == null) {
                    instance = new Admitere();
                }
            }
        }
        return instance;
    }

    // Metoda pentru a înmatricula n studenți
    public void inmatriculeaza(int n) {
        Random rand = new Random();
        int studentiInregistrati = 0;

        while (studentiInregistrati < n) {
            // Creăm un student aleator
            Student studentNou = new Student();

            // Verificăm dacă studentul există deja (după nume, medie și facultate)
            if (studentiUnici.contains(studentNou)) {
                System.out.println("stud. " + studentNou + " *** student deja inscris in Registrul matricol");
                continue; // Dacă există deja, trecem mai departe
            }

            // Adăugăm studentul în registrul matricol
            registruMatricol.put(studentNou.getNrMatricol(), studentNou);

            // Adăugăm studentul la facultatea respectivă
            facultati.computeIfAbsent(studentNou.getFacultate(), k -> new ArrayList<>()).add(studentNou);

            // Adăugăm studentul la genul respectiv
            genuri.computeIfAbsent(studentNou.getGen(), k -> new ArrayList<>()).add(studentNou);

            // Adăugăm studentul în Set pentru unicitate
            studentiUnici.add(studentNou);

            studentiInregistrati++;
        }
        public void inmatriculeazaStudent(Student studentNou) {
            // Verificăm dacă studentul există deja (după nume, medie și facultate)
            if (studentiUnici.contains(studentNou)) {
                System.out.println("Studentul " + studentNou + " este deja înregistrat în Registrul matricol.");
            } else {
                // Adăugăm studentul în registrul matricol
                registruMatricol.put(studentNou.getNrMatricol(), studentNou);

                // Adăugăm studentul la facultatea respectivă
                facultati.computeIfAbsent(studentNou.getFacultate(), k -> new ArrayList<>()).add(studentNou);

                // Adăugăm studentul la genul respectiv
                genuri.computeIfAbsent(studentNou.getGen(), k -> new ArrayList<>()).add(studentNou);

                // Adăugăm studentul în Set pentru unicitate
                studentiUnici.add(studentNou);

                System.out.println("Studentul " + studentNou + " a fost înmatriculat cu succes.");
            }
        }


        // Raport
        System.out.println("--------------------------- 1p ----------------------------------");
        System.out.println("Raport");
        System.out.println("- total in registru " + registruMatricol.size() + " studenti");
    }

    // Metoda pentru a afișa studenții dintr-o facultate
    public void afiseazaStudFacultate(Facultate facultate) {
        List<Student> studentiFacultate = facultati.get(facultate);
        if (studentiFacultate == null || studentiFacultate.isEmpty()) {
            System.out.println("Nu sunt studenti inmtriculati");
        } else {
            for (int i = 0; i < studentiFacultate.size(); i++) {
                Student student = studentiFacultate.get(i);
                System.out.println((i + 1) + ". " + student);
            }
        }
    }

    // Metoda pentru a afișa studenții pe genuri
    public void afiseazaStudPeGen() {
        int baieti = 0;
        int fete = 0;

        // Contează studenții pe genuri
        for (List<Student> studentiGen : genuri.values()) {
            for (Student student : studentiGen) {
                if (student.getGen() == Gen.M) {
                    baieti++;
                } else {
                    fete++;
                }
            }
        }

        System.out.println("--------------------------- 2p ---------------------------");
        System.out.println("Baieti:" + baieti);
        System.out.println("Fete :" + fete);
    }

    // Metoda pentru a afișa primele 10 numere matricole
    public void afiseazaPrimele10NrMatricole() {
        System.out.println("--------------------------- 2p ---------------------------");
        System.out.println("Primele 10 nr. matricole:");
        int count = 1;
        for (Student student : registruMatricol.values()) {
            if (count > 10) break;
            System.out.println(count + ". " + student);
            count++;
        }
    }

    // Metoda pentru a afișa studenții pe facultăți
    public void afiseazaFacultati() {
        System.out.println("--------------------------- 2p ----------------------------------");
        System.out.println("- inmatriculati pe facultati");

        for (Facultate facultate : Facultate.values()) {
            List<Student> studentiFacultate = facultati.getOrDefault(facultate, new ArrayList<>());
            System.out.println(facultate + " : " + studentiFacultate.size() + " studenti");
        }
    }

    // Metoda pentru a permite utilizatorului să aleagă o facultate și să afiseze studenții
    public void afiseazaTotiiStudentii() {
        System.out.println("Primele " + registruMatricol.size() + " nr. matricole:");
        int count = 1;
        for (Student student : registruMatricol.values()) {
            System.out.println(count + ". " + student);
            count++;
        }
    }
    // Metoda pentru a permite utilizatorului să aleagă o facultate și să afiseze studenții
    public void alegeFacultate() {
        Scanner sc = new Scanner(System.in);
        int facultateAlegere = 0;
        while (true) {
            System.out.println("Alegeti facultatea(FDSA=1 FEFS=2 FIA=3 FIESC=4 FIMM=5 FIG=6 FLSC=7 FS=8 FSEAP=9 FSE=10 gata>=11):");
            facultateAlegere = sc.nextInt();
            if (facultateAlegere == 11) {
                System.out.println("*** Succes!");
                break;
            }
            Facultate facultate = Facultate.getFacultate(facultateAlegere - 1);
            afiseazaStudFacultate(facultate);
        }
    }
}
