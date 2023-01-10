	package himedia.joinme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import himedia.joinme.domain.Community;
import himedia.joinme.domain.Contest;
import himedia.joinme.domain.Join;
import himedia.joinme.domain.Member;
import himedia.joinme.domain.Post;
import himedia.joinme.repository.JPAJoinmeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class JoinmeService {
	private final JPAJoinmeRepository Repository;
	
	public Member savedMember(Member member) {
		Optional<Member> find = Repository.findByMemberId(member.getMemberId());
		
		if(find.isPresent())
			log.info("중복된 ID");
		
		if(find.isEmpty())
			Repository.saveMember(member);
		
		return member;
	}
	public Member updatedMember(Member member) {
		Optional<Member> find = Repository.findByMemberId(member.getMemberId());
		
		if(find.isPresent())
			Repository.updateMember(member.getMemberNo(), member);
		
		return member;
	}
	public Post savedPost(Post post) {
		return Repository.savePost(post);
	}

	public Contest savedContest(int memberNo, Contest contest) {
		Post post = new Post("CONTEST", 1);
		Repository.savePost(post);
		log.info("post = {}", post.getPostName());
		log.info("post = {}", post.getMemberNo());
		log.info("post = {}", post.getPostNo());
		contest.setPostNo(post.getPostNo());
		contest.setContestNo(post.getPostNo());
		return Repository.saveContest(contest);
	}
	
	public Join savedJoin(int memberNo, Join join) {
		Post post = new Post("JOIN", memberNo);
		Repository.savePost(post);
		join.setPostNo(post.getPostNo());
		return Repository.saveJoin(join);
	}
	public Community savedCommunity(int memberNo, Community community) {
		Post post = new Post("COMMUNITY", memberNo);
		Repository.savePost(post);
		community.setPostNo(post.getPostNo());
		return Repository.saveCommunity(community);
	}
	public Post findPost(int postNo) {
		return Repository.findByPostNo(postNo).get();
	}
	public Contest findContest(int postNo) {
		return Repository.findByContest(postNo).get();
	}
	public Join findJoin(int postNo) {
		return Repository.findByJoin(postNo).get();
	}
	public Community findCommunity(int postNo) {
		return Repository.findByCommunity(postNo).get();
	}
	public List<Post> findAllPost(String postName) {
		return Repository.findAllPostName(postName);
	}
	public List<Post> findReversePost(String postName) {
		return Repository.findReversePostName(postName);
	}
	public List<Contest> findAllContest() {
		return Repository.findAllContest();
	}
	public List<Contest> findAllReverseContest() {
		return Repository.findAllReverseContest();
	}
	public List<Join> findAllJoin() {
		return Repository.findAllJoin();
	}
	public List<Join> findAllReverseJoin() {
		return Repository.findAllReverseJoin();
	}
	public List<Community> findAllCommunity() {
		return Repository.findAllCommunity();
	}
	public List<Community> findAllReverseCommunity() {
		return Repository.findAllReverseCommunity();
	}
	
	public Contest updateContest(int postNo, @ModelAttribute Contest contest) {
		Repository.updateContest(postNo, contest);
		return findContest(postNo);
	}
}
