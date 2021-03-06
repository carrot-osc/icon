package org.optaplanner.examples.icon.domain;

import it.unimi.dsi.fastutil.ints.Int2ObjectRBTreeMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap;

public class Resource {

    private static final Int2ObjectSortedMap<Resource> RESOURCES = new Int2ObjectRBTreeMap<Resource>();

    public synchronized static Resource get(final int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Resource IDs start at 0, you asked for: " + id);
        } else if (!Resource.RESOURCES.containsKey(id)) {
            Resource.RESOURCES.put(id, new Resource(id));
        }
        return Resource.RESOURCES.get(id);
    }

    private final int id;

    private Resource(final int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Resource [id=").append(this.id).append("]");
        return builder.toString();
    }

}
