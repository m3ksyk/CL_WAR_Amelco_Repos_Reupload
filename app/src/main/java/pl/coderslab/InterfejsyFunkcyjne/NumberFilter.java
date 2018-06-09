package pl.coderslab.InterfejsyFunkcyjne;

public class NumberFilter implements Filter {


    @Override
    public boolean check(Object v) {
        return (int) v < 20;
    }
}
