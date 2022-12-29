package himedia.joinme.repository;

import java.util.List;

import himedia.joinme.domain.Member;

public interface JoinmeRepository {
	
//	Contest contestSave(Contest contest);
//	Join joinSave(Join join);
//	Community communitySave(Community community);

	
	
//	Community communityUpdate(Community community);
//	Community communityDelete(Community community);

//	Contest contestUpdate(Contest contest);
//	Contest contestDelete(Object object);

//	Join joinUpdate(Join join);
//	Join joinDelete(Object object);

	Member memberSave(Member member);
	void memberUpdate(String memberId, Member updateMember);
	
	//findByPost(Long index, postNo);
	//findByTitle(String postTitle);
	//findByWriter(String postWriter);
	//findByPostNo(String postNo);
	//findById(memberId);
	//findByPassword(memberId);
	
	
//	List<Object> findAll();
}