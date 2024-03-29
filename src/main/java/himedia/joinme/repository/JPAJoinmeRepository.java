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
	public Contest saveContest(Contest contest) {
		em.persist(contest);
		return contest;
	}
	@Override
	public Optional<Contest> findByContest(int postNo) {
		Contest contest = em.find(Contest.class, postNo);
		return Optional.ofNullable(contest);
	}
	@Override
	public void updateContest(int postNo, Contest updateContest) {
		Optional<Contest> contest = findByContest(postNo);
		
		if(contest.isEmpty())
			return;
		contest.get().update(updateContest);
	}
	@Override
	public void deleteContest(int postNo) {
		em.remove(findByContest(postNo).get());
		em.remove(findByPostNo(postNo).get());
	}
	
	@Override
	public List<Contest> findAllContest() {
		return em.createQuery("select c from Contest c", Contest.class).getResultList();
	}
	@Override
	public List<Contest> findAllReverseContest() {
		return em.createQuery("select c from Contest c order by c.postNo desc", Contest.class).getResultList();
	}
	
	@Override
	public Member saveMember(Member member) {
		em.persist(member);
		return member;
	}
	@Override
	public Optional<Member> findByMemberNo(int memberNo) {
		Member member = em.find(Member.class, memberNo);
		return Optional.ofNullable(member);
	}
	@Override
	public void updateMember(int memberNo, Member updateMember) {
		Member member = findByMemberNo(memberNo).get();
		member.setMemberPassword(updateMember.getMemberPassword());
		member.setNickname(updateMember.getNickname());
	}
	@Override
	public void deleteMember(int memberNo) {
		em.remove(findByMemberNo(memberNo).get());
	}
	@Override
	public Post savePost(Post post) {
		em.persist(post);
		return post;
	}
	
	@Override
	public Join saveJoin(Join join) {
		em.persist(join);
		return join;
	}
	@Override
	public Optional<Join> findByJoin(int postNo) {
		Join join = em.find(Join.class, postNo);
		return Optional.ofNullable(join);
	}
	@Override
	public List<Join> findAllJoin() {
		return em.createQuery("select j from Join j", Join.class).getResultList();
	}
	@Override
	public List<Join> findAllReverseJoin() {
		return em.createQuery("select j from Join j order by j.postNo desc", Join.class).getResultList();
	}
	@Override
	public void updateJoin(int postNo, Join updateJoin) {
		Optional<Join> join = findByJoin(postNo);
		
		if(join.isEmpty())
			return;
		
		join.get().setTitle(updateJoin.getTitle());
		join.get().setTextbox(updateJoin.getTextbox());
		join.get().setRegion(updateJoin.getRegion());
		join.get().setJoinLink(updateJoin.getJoinLink());
	}
	@Override
	public void deleteJoin(int postNo) {
		em.remove(findByJoin(postNo).get());
		em.remove(findByPostNo(postNo).get());		
	}
	@Override
	public Community saveCommunity(Community community) {
		em.persist(community);
		return community;
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
	public Optional<Community> findByCommunity(int postNo) {
		Community community = em.find(Community.class, postNo);
		return Optional.ofNullable(community);
	}
	@Override
	public List<Post> findAllPostName(String postName) {
		return em.createQuery("select p from Post p where post_name=:postName", Post.class)
				.setParameter("postName", postName)
				.getResultList();
	}
	@Override
	public List<Post> findReversePostName(String postName) {
		return em.createQuery("select p from Post p where post_name=:postName order by p.postNo desc", Post.class)
				.setParameter("postName", postName)
				.getResultList();
	}

	@Override
	public List<Community> findAllCommunity() {
		return em.createQuery("select c from Community c", Community.class).getResultList();
	}
	@Override
	public List<Community> findAllReverseCommunity() {
		return em.createQuery("select c from Community c order by c.postNo desc", Community.class).getResultList();
	}

	@Override
	public void updateCommunity(int postNo, Community updateCommunity) {
		Optional<Community> community = findByCommunity(postNo);
		
		if(community.isEmpty())
			return;
		
		community.get().setTitle(updateCommunity.getTitle());
		community.get().setTextbox(updateCommunity.getTextbox());
		community.get().setCategory(updateCommunity.getCategory());
	}

	@Override
	public void deleteCommunity(int postNo) {
		em.remove(findByCommunity(postNo).get());
		em.remove(findByPostNo(postNo).get());		
	}
}