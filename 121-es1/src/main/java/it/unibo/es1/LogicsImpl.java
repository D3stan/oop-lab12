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
		return buttons.size();
	}

	@Override
	public List<Integer> values() {
		return List.copyOf(buttons);
	}

	@Override
	public List<Boolean> enablings() {
		return buttons.stream().map(button -> button != buttons.size()).toList();
	}

	@Override
	public int hit(int elem) {
		return buttons.set(elem, buttons.get(elem) + 1) + 1;
	}

	@Override
	public String result() {
		return buttons.stream().map(String::valueOf).collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {
		return buttons.stream().distinct().count() == 1;
	}
}
