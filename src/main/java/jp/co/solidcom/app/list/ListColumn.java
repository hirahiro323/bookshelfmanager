package jp.co.solidcom.app.list;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jp.co.solidcom.app.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 一覧データEntityクラス
 * 
 * @author solidcom
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "books")
public class ListColumn {

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

	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "rentaling_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
	private User user;

}
