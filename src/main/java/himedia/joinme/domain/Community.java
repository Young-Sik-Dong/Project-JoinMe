package himedia.joinme.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
	@CreatedDate
	@Column (name = "registration_date")
	private String regiDate;
	@LastModifiedDate
	@Column (name = "modify_date")
	private String modifyDate;
	
    @PrePersist
    public void onPrePersist() {
        this.regiDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        this.modifyDate = this.regiDate;
    }
    
    @PreUpdate
    public void onPreUpdate() {
        this.modifyDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }
	
	public Community(String title, String textbox, String category) {
		this.title = title;
		this.textbox = textbox;
		this.category = category;
	}
}