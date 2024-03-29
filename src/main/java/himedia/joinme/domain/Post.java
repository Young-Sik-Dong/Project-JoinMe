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
public class Post {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "post_no")
	private int postNo;
	@Column (name = "post_name")
	private String postName;
	@Column (name = "member_no")
	private int memberNo;
	
	public Post(String postName, int memberNo) {
		this.postName = postName;
		this.memberNo = memberNo;
	}
}
