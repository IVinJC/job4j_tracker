package ru.job4j.tracker;

import java.util.List;

public class FindItemName implements UserAction {
    private final Output out;

    public FindItemName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = memTracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
