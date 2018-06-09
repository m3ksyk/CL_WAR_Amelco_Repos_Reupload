package pl.coderslab.InterfejsyFunkcyjne;

@FunctionalInterface
public interface Filter<V> {

    boolean check(V v);

}
