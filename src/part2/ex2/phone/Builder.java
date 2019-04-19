package part2.ex2.phone;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Builder<T> {

    private final Supplier<T> instatiator;
    private List<Consumer<T>> instanceModifiers = new ArrayList<>();

    public Builder(Supplier<T> instatiator){
        this.instatiator = instatiator;
    }
    public static <T> Builder<T>of(Supplier<T> instatiator){
        return new Builder<>(instatiator);
    }
    public <E> Builder<T>with(BiConsumer<T, E> consumer, E value){
        Consumer<T> cons = instance -> consumer.accept(instance,value);
        instanceModifiers.add(cons);
        return this;
    }

    public T build(){
        T value = instatiator.get();
        instanceModifiers.forEach(modifier -> modifier.accept(value));
        instanceModifiers.clear();
        return value;
    }

}
