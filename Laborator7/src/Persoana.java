import java.util.Random;
public class Persoana {
        private static String numeBaieti[] = {"Andrei", "Liviu", "Vasile", "George",
                "Lucian", "Marius", "Ion", "Cosmin", "Vladimir", "Cosmin", "Alexandru", "Ciprian"};
        private static String numeFete[] = {"Maria", "Mariana", "Ana", "Lucia", "Denisa",
                "Cristina", "Ioana", "Mirabela", "Adina", "Ligia", "Iulia", "Georgiana", "Angela", "Claudia"
        };
        private static Random r = new Random();
        // ------------------------------------------------------
        private String nume;
        private Gen gen;

        public Persoana() {
            gen = r.nextInt(1000) < 511 ? Gen.F : Gen.M;
            nume = gen == Gen.F ? numeFete[r.nextInt(numeFete.length)] :
                    numeBaieti[r.nextInt(numeBaieti.length)];
        }

        public Persoana(String nume, Gen gen) {
            this.nume = nume;
            this.gen = gen;
        }

        public String getNume() {
            return nume;
        }

        public Gen getGen() {
            return gen;
        }

        @Override
        public String toString() {
            return nume + " (" + gen + ") ";
        }

}
