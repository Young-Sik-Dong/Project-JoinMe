package himedia.joinme.domain;

import javax.persistence.Column;
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
public class Community {
	@Id
	@Column (name = "post_no")
	private int postNo;
	private String title;
	private String textbox;
	@Column (name = "category")
	private String category;
	@Column (name = "registration_date")
	private String regiDate;
	@Column (name = "modify_date")
	private String modifyDate;
	
	public Community(String title, String textbox, String category) {
		this.title = title;
		this.textbox = textbox;
		this.category = category;
	}
}