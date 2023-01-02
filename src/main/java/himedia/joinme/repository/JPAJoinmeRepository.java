package himedia.joinme.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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
	public Member memberSave(Member member) {
		em.persist(member);
		return member;
	}

	@Override
	public Post postSave(Post post) {
		em.persist(post);
		return post;
	}

	@Override
	public Contest contestSave(Contest contest) {
		em.persist(contest);
		return contest;
	}

	@Override
	public Join joinSave(Join join) {
		em.persist(join);
		return join;
	}

	@Override
	public Community communitySave(Community community) {
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
	public Optional<Member> findByMemberId(String memberId) {
		List<Member> result =  em.createQuery("select m from Member m where m.memberId=:member_id", Member.class)
								.setParameter("member_id", memberId)
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
				.setParameter("nickname", updatePost.getTextbox())
				.setParameter("postNo", postNo)
				.executeUpdate();
				
		log.info("result >> {}", result);
		em.clear();
	}

	@Override
	public void updateContest(int postNo, Contest updateContest) {
		String sql = "update Post p "
				+ "set company_name=:companyName, "
				+ "field=:field, "
				+ "target_name=:targetName, "
				+ "host_name=:hostName, "
				+ "reword=:reword, "
				+ "start_date=:startDate, "
				+ "end_date=:endDate, "
				+ "contest_link=:contestLink "
				+ "where post_no=:postNo";
		
		int result = em.createQuery(sql)
				.setParameter("companyName", updateContest.getCompanyName())
				.setParameter("field", updateContest.getField())
				.setParameter("targetName", updateContest.getTargetName())
				.setParameter("hostName", updateContest.getHostName())
				.setParameter("reword", updateContest.getReward())
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
		String sql = "update Post p "
				+ "set region=:region, "
				+ "join_link=:joinLink, "
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
		String sql = "update Post p "
				+ "set category=:category "
				+ "where post_no=:postNo";
		
		int result = em.createQuery(sql)
				.setParameter("category", updateCommunity.getCategory())
				.setParameter("postNo", postNo)
				.executeUpdate();
		
		log.info("result >> {}", result);
		em.clear();
	}
}