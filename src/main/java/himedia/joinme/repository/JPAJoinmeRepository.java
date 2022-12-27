package himedia.joinme.repository;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional
public class JPAJoinmeRepository implements JoinmeRepository {
	
}
