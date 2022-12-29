package himedia.joinme.repository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import himedia.joinme.domain.Member;

@SpringBootTest
@Transactional
class JPAJoinmeRepositoryTest {

	@Autowired JPAJoinmeRepository repository;
	@Autowired EntityManager em;
	
	
	
	@Test
	void memberSave() {
		Member member1 = new Member("1", "1", "1", "1", "2022-12-29");
		
		Member savedItem = repository.memberSave(member1);
		
		assertThat(savedItem.getMemberId()).isEqualTo(member1.getMemberId());
	}
	
	

}