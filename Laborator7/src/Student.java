import java.util.Objects;
import java.util.Random;
public class Student extends Persoana {
        private double medieAdmitere;
        private Facultate facultate;
        private int nrMatricol;
        private static int nrMatricolCounter = 1;
        @Override
        public String toString() {
            return "stud. " +super.toString()+", " + medieAdmitere + ", " + facultate;
        }
        public Student(String nume, Gen gen, double medieAdmitere, Facultate facultate) {
            super(nume,gen);
            this.medieAdmitere = medieAdmitere;
            this.facultate = facultate;
        }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Double.compare(student.medieAdmitere, medieAdmitere) == 0 &&
                nrMatricol == student.nrMatricol &&
                Objects.equals(getNume(), student.getNume()) &&
                facultate == student.facultate;
    }
    @Override
    public int hashCode() {
        return Objects.hash(getNume(), medieAdmitere, facultate, nrMatricol);
    }
        public Student() {
            super();  // Apelăm constructorul din Persoana pentru nume și gen
            this.medieAdmitere = 5 /*+ new Random().nextDouble() * 5*/; // Media între 5 și 10
            this.facultate = Facultate.getFacultate(new Random().nextInt(Facultate.nrFacultati)); // Facultate aleatorie
            this.nrMatricol = nrMatricolCounter++;
        }
        public double getMedieAdmitere() {
            return medieAdmitere;
        }
        public int getNrMatricol(){
            return nrMatricol;
        }
        public Facultate getFacultate() {
            return facultate;
        }
// clasa mai trebuie completata si cu altele pentru
// ca aplicatia sa poata functiona asa cum s-a cerut
    }

