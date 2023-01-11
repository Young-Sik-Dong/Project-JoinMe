package himedia.joinme.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
	private String code;
	private String displayName;
}