package it.unibo.es2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class LogicsImpl implements Logics {

    private final ArrayList<ArrayList<Boolean>> buttons; 

    public LogicsImpl(int size) {
        this.buttons = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.buttons.add(new ArrayList<>(Collections.nCopies(size, false)));
        }
    }

    @Override
    public String hit(Pair<Integer,Integer> coords) {
        return this.buttons.get(
            coords.getY()).set(coords.getX(), 
            !this.buttons.get(coords.getY()).get(coords.getX())
        ) == true ? " " : "*";
    }

    @Override
    public boolean toQuit() {
        return (
            this.buttons.stream().anyMatch(columns -> {
                return columns.stream().allMatch(value -> value == true);
            }) 
        || 
            IntStream.range(0, this.buttons.size())
                .anyMatch(i -> this.buttons.stream()
                    .map(row -> row.get(i))
                    .allMatch(value -> value == true)
            )
        );
    }

}
