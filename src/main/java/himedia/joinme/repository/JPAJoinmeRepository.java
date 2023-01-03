package himedia.joinme.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import himedia.joinme.domain.Community;
import himedia.joinme.domain.Contest;
import himedia.joinme.domain.Join;
import himedia.joinme.domain.Member;
import himedia.joinme.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Transactional
@Slf4j
public class JPAJoinmeRepository implements JoinmeRepository {
	
	private final EntityManager em;
	
	@Override
	public Member saveMember(Member member) {
		em.persist(member);
		return member;
	}

	@Override
	public Post savePost(Post post) {
		em.persist(post);
		return post;
	}

	@Override
	public Contest saveContest(Contest contest) {
		em.persist(contest);
		return contest;
	}

	@Override
	public Join saveJoin(Join join) {
		em.persist(join);
		return join;
	}

	@Override
	public Community saveCommunity(Community community) {
		em.persist(community);
		return community;
	}
	
	@Override
	public Optional<Member> findByMemberNo(int memberNo) {
		Member member = em.find(Member.class, memberNo);
		return Optional.ofNullable(member);
	}

	@Override
	public Optional<Post> findByPostNo(int postNo) {
		Post post = em.find(Post.class, postNo);
		return Optional.ofNullable(post);
	}
	
	@Override
	public List<Post> findAllPostName(String postName) {
		return em.createQuery("select m from Post m where post_name=:postName", Post.class)
				.setParameter("postName", postName)
				.getResultList();
	}
	
	@Override
	public Optional<Member> findByMemberId(String memberId) {
		List<Member> result =  em.createQuery("select m from Member m where m.memberId=:member_id", Member.class)
				.setParameter("member_id", memberId)
								.getResultList();
		return result.stream().findAny();
	}
	
	@Override
	public Optional<Contest> findByContest(int postNo) {
		List<Contest> result =  em.createQuery("select c from Contest c where c.postNo=:post_no", Contest.class)
				.setParameter("post_no", postNo)
				.getResultList();
		return result.stream().findAny();
	}

	@Override
	public Optional<Join> findByJoin(int postNo) {
		List<Join> result =  em.createQuery("select j from Join j where j.postNo=:post_no", Join.class)
				.setParameter("post_no", postNo)
				.getResultList();
		return result.stream().findAny();
	}

	@Override
	public Optional<Community> findByCommunity(int postNo) {
		List<Community> result =  em.createQuery("select c from Community c where c.postNo=:post_no", Community.class)
				.setParameter("post_no", postNo)
				.getResultList();
		return result.stream().findAny();
	}
	
	@Override
	public void updateMember(int memberNo, Member updateMember) {
		String sql = "update Member m "
				+ "set member_password=:memberPassword, "
				+ "nickname=:nickname, "
				+ "modify_date=current_date "
				+ "where member_no=:memberNo";
		
		int result = em.createQuery(sql)
					.setParameter("memberPassword", updateMember.getMemberPassword())
					.setParameter("nickname", updateMember.getNickname())
					.setParameter("memberNo", memberNo)
					.executeUpdate();
		
		log.info("result >> {}", result);
		em.clear();
	}

	@Override
	public void updatePost(int postNo, Post updatePost) {
		String sql = "update Post p "
				+ "set title=:title, "
				+ "textbox=:textbox, "
				+ "modify_date=current_date "
				+ "where post_no=:postNo";
		
		int result = em.createQuery(sql)
				.setParameter("title", updatePost.getTitle())
				.setParameter("textbox", updatePost.getTextbox())
				.setParameter("postNo", postNo)
				.executeUpdate();
				
		log.info("result >> {}", result);
		em.clear();
	}

	@Override
	public void updateContest(int postNo, Contest updateContest) {
		String sql = "update Contest c "
				+ "set company_name=:companyName, "
				+ "field=:field, "
				+ "target_name=:targetName, "
				+ "host_name=:hostName, "
				+ "reward=:reward, "
				+ "start_date=:startDate, "
				+ "end_date=:endDate, "
				+ "contest_link=:contestLink "
				+ "where post_no=:postNo";
		
		int result = em.createQuery(sql)
				.setParameter("companyName", updateContest.getCompanyName())
				.setParameter("field", updateContest.getField())
				.setParameter("targetName", updateContest.getTargetName())
				.setParameter("hostName", updateContest.getHostName())
				.setParameter("reward", updateContest.getReward())
				.setParameter("startDate", updateContest.getStartDate())
				.setParameter("endDate", updateContest.getEndDate())
				.setParameter("contestLink", updateContest.getContestLink())
				.setParameter("postNo", postNo)
				.executeUpdate();
		
		log.info("result >> {}", result);
		em.clear();
	}

	@Override
	public void updateJoin(int postNo, Join updateJoin) {
		String sql = "update Join j "
				+ "set region=:region, "
				+ "join_link=:joinLink "
				+ "where post_no=:postNo";
		
		int result = em.createQuery(sql)
				.setParameter("region", updateJoin.getRegion())
				.setParameter("joinLink", updateJoin.getJoinLink())
				.setParameter("postNo", postNo)
				.executeUpdate();
		
		log.info("result >> {}", result);
		em.clear();
	}

	@Override
	public void updateCommunity(int postNo, Community updateCommunity) {
		String sql = "update Community c "
				+ "set category=:category "
				+ "where post_no=:postNo";
		
		int result = em.createQuery(sql)
				.setParameter("category", updateCommunity.getCategory())
				.setParameter("postNo", postNo)
				.executeUpdate();
		
		log.info("result >> {}", result);
		em.clear();
	}

	@Modifying
	@Override
	public void deleteMember(int memberNo) {
		em.createQuery("delete from Member m where member_no=:memberNo")
			.setParameter("memberNo", memberNo)
			.executeUpdate();
		
		em.clear();
	}

	@Override
	public void deletePost(int postNo) {
		em.createQuery("delete from Post m where post_no=:postNo")
		.setParameter("postNo", postNo)
		.executeUpdate();
		
		em.clear();
	}
}