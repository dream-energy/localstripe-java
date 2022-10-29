package com.project.localstripe.repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import com.stripe.model.HasId;




public abstract class AbstractRepository<T extends HasId> {

    protected Map<String, T> data = new ConcurrentHashMap<>();

    public Optional<T> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }

    public Collection<T> findAll() {
        return data.values();
    }

    public void save(T item) {
        data.put(item.getId(), item);
    }

}
