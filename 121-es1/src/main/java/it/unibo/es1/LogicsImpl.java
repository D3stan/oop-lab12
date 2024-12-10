package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

	private final ArrayList<Integer> buttons;

	public LogicsImpl(int size) {
		buttons = new ArrayList<>(Collections.nCopies(size, 0));
	}

	@Override
	public int size() {
		return this.buttons.size();
	}

	@Override
	public List<Integer> values() {
		return List.copyOf(this.buttons);
	}

	@Override
	public List<Boolean> enablings() {
		return this.buttons.stream().map(button -> button != this.buttons.size()).toList();
	}

	@Override
	public int hit(int elem) {
		return this.buttons.set(elem, this.buttons.get(elem) + 1) + 1;
	}

	@Override
	public String result() {
		return this.buttons.stream().map(String::valueOf).collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {
		return this.buttons.stream().distinct().count() == 1;
	}
}
