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
	private String category;
	
	public Community(String title, String textbox, String category) {
		this.title = title;
		this.textbox = textbox;
		this.category = category;
	}
}