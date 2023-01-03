package himedia.joinme.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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

@SpringBootTest
@Transactional
//@Slf4j
class JPAJoinmeRepositoryTest {

	@Autowired JPAJoinmeRepository repository;
	@Autowired EntityManager em;
	
	@Test
	void memberSave() {
		Member member1 = new Member("id4", "1234", "하루");
		
		Member savedItem = repository.memberSave(member1);
		
		assertThat(savedItem.getMemberId()).isEqualTo(member1.getMemberId());
	}
	
	@Test
	void postSave() {
		Post post1 = new Post("COMMUNITY", 1, "제목1", "본문1");
		Post savedPost = repository.postSave(post1);
		
		assertThat(savedPost.getPostNo()).isEqualTo(post1.getPostNo());
	}
	
	@Test
	void contestSave() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		Post post = repository.postSave(new Post("COMMUNITY", member.getMemberNo(), "제목1", "본문1"));
		
		Contest contest = repository.contestSave(new Contest(post.getPostNo(), post.getPostNo(), "company1", "field",
												"target", "host", "reward", "2023-01-01", "2023-02-01", "link1"));
		
		assertThat(contest.getPostNo()).isEqualTo(post.getPostNo());
	}
	
	@Test
	void joinSave() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		Post post = repository.postSave(new Post("COMMUNITY", member.getMemberNo(), "제목1", "본문1"));
		
		Join join = repository.joinSave(new Join(post.getPostNo(), post.getPostNo(), "region", "link"));

		assertThat(join.getPostNo()).isEqualTo(post.getPostNo());
	}
	
	@Test
	void communitySave() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		Post post = repository.postSave(new Post("COMMUNITY", member.getMemberNo(), "제목1", "본문1"));
		
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
		Post post = repository.postSave(new Post("COMMUNITY", member.getMemberNo(), "제목1", "본문1"));
		
		Optional<Post> findPost = repository.findByPostNo(post.getPostNo());
		
		assertThat(findPost).isNotNull();
	}
	
	@Test
	void findAllPostName() {
		List<Post> findPost = repository.findAllPostName("COMMUNITY");
		
		assertThat(findPost.size()).isEqualTo(3);
	}
	
	@Test
	void findByContest() {
		Contest contest = repository.findByContest(1).get();
		
		assertThat(contest).isNotNull();
	}
	
	@Test
	void findByJoin() {
		Join join = repository.findByJoin(4).get();
		
		assertThat(join).isNotNull();
	}
	
	@Test
	void findByCommunity() {
		Community community = repository.findByCommunity(7).get();
		
		assertThat(community).isNotNull();
	}
	
	@Test
	void updateMember() {
		Member member1 = repository.memberSave(new Member("id5", "1234", "하루"));
		Member member2 = new Member("id6", "1357", "하나");

		repository.updateMember(member1.getMemberNo(), member2);
		member1 = repository.findByMemberNo(member1.getMemberNo()).get();
		
		assertThat(member1.getMemberPassword()).isEqualTo(member2.getMemberPassword());
	}
	
	@Test
	void updatePost() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		Post post = repository.postSave(new Post("COMMUNITY", member.getMemberNo(), "제목1", "본문1"));
		Post updatePost = new Post("제목2", "본문2");
		
		repository.updatePost(post.getPostNo(), updatePost);
		post = repository.findByPostNo(post.getPostNo()).get();
		
		assertThat(post.getTitle()).isEqualTo(updatePost.getTitle());
	}
	
	@Test
	void updateContest() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		Post post = repository.postSave(new Post("CONTEST", member.getMemberNo(), "제목1", "본문1"));
		
		Contest contest = repository.contestSave(new Contest(post.getPostNo(), post.getPostNo(), "company1", "field1",
				"target", "host", "reward", "2023-01-01", "2023-02-01", "link1"));
		
		Contest updateContest = new Contest("company2", "field2", "target2", 
				"host2", "reward2", "2023-02-01", "2023-03-01", "link2");
		
		repository.updateContest(post.getPostNo(), updateContest);
		contest = repository.findByContest(post.getPostNo()).get();
		
		assertThat(contest.getCompanyName()).isEqualTo(updateContest.getCompanyName());
	}
	
	@Test
	void updateJoin() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		Post post = repository.postSave(new Post("JOIN", member.getMemberNo(), "제목1", "본문1"));
		Join join = repository.joinSave(new Join(post.getPostNo(), 1, "region1", "link1"));
		Join updateJoin = new Join("region2", "link2");
		
		repository.updateJoin(post.getPostNo(), updateJoin);
		join = repository.findByJoin(join.getPostNo()).get();
		
		assertThat(join.getRegion()).isEqualTo(updateJoin.getRegion());
	}
	
	@Test
	void updateCommunity() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		Post post = repository.postSave(new Post("JOIN", member.getMemberNo(), "제목1", "본문1"));
		Community community = repository.communitySave(new Community(post.getPostNo(), "커뮤니티1"));
		Community updateCommunity = new Community("커뮤니티2");
		
		repository.updateCommunity(post.getPostNo(), updateCommunity);
		community = repository.findByCommunity(community.getPostNo()).get();
		
		assertThat(community.getCategory()).isEqualTo(updateCommunity.getCategory());
	}
	
	@Test
	void deleteMember() {
		Member member = repository.memberSave(new Member("id5", "1234", "하루"));
		
		repository.deleteMember(member.getMemberNo());
		Optional<Member> find = repository.findByMemberNo(member.getMemberNo());
		
		assertThat(find).isEmpty();
	}
	
	@Test
	void deletePost() {
		Post post = repository.postSave(new Post("JOIN", 1, "제목1", "본문1"));
		
		repository.deletePost(post.getPostNo());
		Optional<Post> find = repository.findByPostNo(post.getPostNo());
		
		assertThat(find).isEmpty();
	}
}