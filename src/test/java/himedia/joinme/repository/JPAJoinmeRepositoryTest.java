package himedia.joinme.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import himedia.joinme.domain.Community;
import himedia.joinme.domain.Contest;
import himedia.joinme.domain.Join;
import himedia.joinme.domain.Member;
import himedia.joinme.domain.Post;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
@Slf4j
class JPAJoinmeRepositoryTest {

	@Autowired JPAJoinmeRepository repository;
	@Autowired EntityManager em;
	
	
	
	@Test
	void memberSave() {
		Member member1 = new Member("id1", "1234", "하루");
		
		Member savedItem = repository.memberSave(member1);
		
		assertThat(savedItem.getMemberId()).isEqualTo(member1.getMemberId());
	}
	
	@Test
	void postSave() {
		Post post1 = new Post("커뮤니티", 1, "제목1", "본문1");
		
		Post savedPost = repository.postSave(post1);
		
		assertThat(savedPost.getPostNo()).isEqualTo(post1.getPostNo());
	}
	
	@Test
	void contestSave() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		Post post = repository.postSave(new Post("커뮤니티", member.getMemberNo(), "제목1", "본문1"));
		
		Contest contest = repository.contestSave(new Contest(post.getPostNo(), post.getPostNo(), "company1", "field1",
												"target", "host", "reward", "2023-01-01", "2023-02-01", "link1"));
		
		assertThat(contest.getPostNo()).isEqualTo(post.getPostNo());
	}
	
	@Test
	void joinSave() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		Post post = repository.postSave(new Post("커뮤니티", member.getMemberNo(), "제목1", "본문1"));
		
		Join join = repository.joinSave(new Join(post.getPostNo(), post.getPostNo(), member.getMemberNo(), "region", "link"));

		assertThat(join.getPostNo()).isEqualTo(post.getPostNo());
	}
	
	@Test
	void communitySave() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		Post post = repository.postSave(new Post("커뮤니티", member.getMemberNo(), "제목1", "본문1"));
		
		Community community = repository.communitySave(new Community(post.getPostNo(), "cate1"));
		
		assertThat(community.getPostNo()).isEqualTo(post.getPostNo());
	}
	
	@Test
	void findByMemberNo() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		
		Optional<Member> findMember = repository.findByMemberNo(member.getMemberNo());
		
		assertThat(findMember).isNotNull();
	}
	
	@Test
	void findByMemberId() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		
		Optional<Member> findMember = repository.findByMemberId(member.getMemberId());
		
		assertThat(findMember.get()).isNotNull();
	}
	
	@Test
	void findByPostNo() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		Post post = repository.postSave(new Post("커뮤니티", member.getMemberNo(), "제목1", "본문1"));
		
		Optional<Post> findPost = repository.findByPostNo(post.getPostNo());
		log.info("post_no ==> {}" , findPost);
		
		assertThat(findPost).isNotNull();
	}
	
	@Test
	void updateMember() {
		Member member1 = repository.memberSave(new Member("id5", "1234", "하루"));
		Member member2 = new Member("id6", "1357", "하나");
		log.info("member1 memberPassword==> {}", member1.getMemberPassword());
		log.info("member2 memberPassword==> {}", member2.getMemberPassword());

		repository.updateMember(member1.getMemberNo(), member2);
		member1 = repository.findByMemberNo(member1.getMemberNo()).get();
		log.info("member1 memberPassword==> {}", member1.getMemberPassword());
		log.info("member1 modifyDate ==> {}", member1.getModifyDate());
		
		assertThat(member1.getMemberPassword()).isEqualTo(member2.getMemberPassword());
	}
}