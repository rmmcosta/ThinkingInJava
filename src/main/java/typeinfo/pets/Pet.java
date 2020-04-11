package typeinfo.pets;

import org.jetbrains.annotations.NotNull;

public abstract class Pet implements Comparable {
    public abstract String id();
    @Override
    public int compareTo(@NotNull Object o) {
        return this.id().compareTo(((Pet)o).id());
    }

    @Override
    public String toString() {
        return id();
    }
}
