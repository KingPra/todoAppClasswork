package todoList.copy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoListModel {

	@Id
	@GeneratedValue()
	private Long id;
	private String task;
}
