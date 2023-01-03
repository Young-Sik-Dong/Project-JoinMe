package himedia.joinme.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import himedia.joinme.domain.Member;

@SpringBootTest
@Transactional
class JoinmeServiceTest {

	@Autowired JoinmeService service;
	
	@Test
	void savedMember() {
		Member member = new Member("id3", "1234", "하루");
		
		Member savedMember = service.savedMember(member);
		
		assertThat(savedMember.getMemberNo()).isEqualTo(member.getMemberNo());
	}

	@Test
	void savedContest() {
	}
	
	@Test
	void SavedJoin() {
	}
}
