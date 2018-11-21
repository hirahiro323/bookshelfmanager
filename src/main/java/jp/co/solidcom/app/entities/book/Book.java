package jp.co.solidcom.app.entities.book;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 図書 Entityクラス
 * 
 * @author solidcom
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "books")
public class Book {

	@Id
	@Column(name = "book_id")
	private Integer id;

	@Column(name = "book_title")
	private String title;

	@Column(name = "rentaling_user_id")
	private String rentalUserId;

	@Column(name = "rental_start_time")
	private Timestamp startDate;

	@Column(name = "rental_due_time")
	private Timestamp dueDate;

}
