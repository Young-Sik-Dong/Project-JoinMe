package himedia.joinme.repository;

import java.util.List;
import java.util.Optional;


public interface PostRepository {
	Object save(Object object);
	Optional<Object> findByPostInfo(Long index, String PostNo);
	List<Object> findAll();
}
