package himedia.joinme.repository;

import java.util.List;
import java.util.Optional;

public interface JoinmeRepository {
	Object save(Object object);
	List<Object> findAll();
}