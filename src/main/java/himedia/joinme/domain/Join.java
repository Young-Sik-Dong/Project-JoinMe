package himedia.joinme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recruitment")
public class Join {
	@Id
	@Column (name = "post_no")
	private int postNo;
	@Column (name = "contest_no")
	private int contestNo;
	@Column (name = "member_no")
	private int memberNo;
	private String region;
	@Column (name = "join_link")
	private String joinLink;
}