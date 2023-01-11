package himedia.joinme.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import himedia.joinme.domain.Contest;
import himedia.joinme.domain.Member;
import himedia.joinme.domain.Post;

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
		Contest contest = new Contest("제목1", "company1", "field",
				"target", "host", "reward", "2023-01-01", "2023-02-01", "link1");
		
		Contest savedContest = service.savedContest(1, contest);
		
		assertThat(contest.getPostNo()).isEqualTo(savedContest.getPostNo());
	}
	
	@Test
	void SavedJoin() {
	}
}
