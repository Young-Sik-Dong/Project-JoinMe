package himedia.joinme.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import himedia.joinme.domain.Community;
import himedia.joinme.domain.Contest;
import himedia.joinme.domain.Join;
import himedia.joinme.domain.Member;
import himedia.joinme.domain.Post;

public interface JoinmeRepository {

	Member saveMember(Member member);
	Post savePost(Post post);
	Contest saveContest(Contest contest);
	Join saveJoin(Join join);
	Community saveCommunity(Community community);
	
	Optional<Member> findByMemberNo(int memberNo);
	Optional<Member> findByMemberId(String memberId);
	Optional<Post> findByPostNo(int postNo);
	Optional<Contest> findByContest(int postNo);
	Optional<Join> findByJoin(int postNo);
	Optional<Community> findByCommunity(int postNo);
	List<Post> findAllPostName(String postName);
	List<Post> findReversePostName(String postName);
	List<Contest> findAllContest();
	List<Contest> findAllReverseContest();
	List<Join> findAllJoin();
	List<Join> findAllReverseJoin();
	List<Community> findAllCommunity();
	List<Community> findAllReverseCommunity();
	
	void updateMember(int memberNo, Member updateMember);
	void updateContest(int postNo, Contest updateContest);
	void updateJoin(int postNo, Join updateJoin);
	void updateCommunity(int postNo, Community updateCommunity);
	
	void deleteMember(int memberNo);
	void deleteContest(int postNo);
	void deleteJoin(int postNo);
	void deleteCommunity(int postNo);
}