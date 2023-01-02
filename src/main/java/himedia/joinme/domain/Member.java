package himedia.joinme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "member_no")
	private int memberNo;
	@Column (name = "member_id")
	private String memberId;
	@Column (name = "member_password")
	private String memberPassword;
	@Column (name = "nickname")
	private String nickname;
	@Column (name = "registration_date")
	private String registrationDate;
	@Column (name = "modify_date")
	private String modifyDate;
	
	public Member(String memberId, String memberPassword, String nickname) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.nickname = nickname;
	}
}