package himedia.joinme.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	@Id
	private String memberId;
	private String memberPw;
	private String memberName;
	private String nickname;
	private String registrationDate;
}