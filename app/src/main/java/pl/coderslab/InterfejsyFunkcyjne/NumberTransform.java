package pl.coderslab.InterfejsyFunkcyjne;

public class NumberTransform implements Transform{

    @Override
    public Object transform(Object o) {
        return (int) o-1;
    }
}
