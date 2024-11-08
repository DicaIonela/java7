import java.util.Arrays;
import java.util.List;
public enum Facultate {
    FDSA, FEFS, FIA, FIESC, FIMM, FIG, FLSC, FS, FSEAP, FSE;
    private static List<Facultate> l=Arrays.asList(values());
    final public static int nrFacultati = l.size();
    public static Facultate getFacultate(int i){
        return l.get(i);
    }
}
