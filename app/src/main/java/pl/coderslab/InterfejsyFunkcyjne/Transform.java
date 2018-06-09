package pl.coderslab.InterfejsyFunkcyjne;

@FunctionalInterface
public interface Transform<T, S> {

    T transform(S s);
}
