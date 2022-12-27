package himedia.joinme.repository;

import java.util.List;
import java.util.Optional;

public interface Repository {
	Object save(Object object);
//	Optional<Object> findBy
	Optional<Object> findByName(String name);
	List<Object> findAll();
}
