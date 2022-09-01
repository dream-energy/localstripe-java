package fr.dreamenergy.localstripe.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.stripe.model.HasId;

public abstract class AbstractRepository<T extends HasId> {

	protected Map<String, T> data = new HashMap<>();
	
	public Optional<T> findById(String id) {
		return Optional.ofNullable(data.get(id));
	}
	
	public void save(T item) {
		data.put(item.getId(), item);
	}

}
