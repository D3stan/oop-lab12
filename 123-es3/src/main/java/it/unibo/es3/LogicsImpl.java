package it.unibo.es3;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LogicsImpl implements Logics {

    private static final Random random = new Random(42);   
    private final Map<Point, Boolean> cells;
    private final int width;
    private boolean first = true;

    public LogicsImpl(int width) {
        this.width = width;
        this.cells = new HashMap<>();
        for (int i = 0; i < width; i++){
            for (int j = 0; j < width; j++) {
                this.cells.put(new Point(j, i), false);
            }
        }
    }

    @Override
    public List<Point> getNextCells() {
        if (first) {
            this.first = false;
            for (int i = 0; i < 3; i++) {
                this.cells.computeIfPresent(new Point(random.nextInt(width), random.nextInt(width)), (point, active) -> active = true);
            }
        } else {
            Map<Point, Boolean> tempMap = new HashMap<>();
            this.cells.entrySet().stream().filter(e -> e.getValue() == true).forEach(pointMarked -> {
                this.cells.forEach((point, value) -> {
                    if (this.areClose(point, pointMarked.getKey()) && !(point == pointMarked.getKey())) {
                        tempMap.put(point, true);
                    }
                });
            });
            this.cells.putAll(tempMap);
        }

        return this.cells.entrySet().stream().filter(e -> e.getValue() == true).map(e -> e.getKey()).toList();
    }

    @Override
    public boolean toQuit() {
        return this.cells.values().stream().allMatch(active -> active == true);
    }

    private boolean areClose(Point p1, Point p2) {
        return p1.distance(p2) <= 1.5;
    }
}
