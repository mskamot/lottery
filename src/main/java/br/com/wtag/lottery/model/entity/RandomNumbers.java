package br.com.wtag.lottery.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RandomNumbers.
 *
 * @author  Mario Sakamoto <mskamot@gmail.com>
 * @see     javax.persistence.Entity
 * @see     lombok.Data
 * @see     lombok.NoArgsConstructor
 * @see     lombok.AllArgsConstructor
 * @see     javax.persistence.Id
 * @see     javax.persistence.GeneratedValue
 * @see     javax.persistence.GenerationType
 * @see     java.lang.Long
 * @see     javax.validation.constraints.NotNull
 * @see     javax.validation.constraints.Min
 * @see     javax.validation.constraints.Max
 * @see     javax.persistence.Column
 * @see     java.time.LocalDateTime
 * @see     java.lang.Integer
 * @see     javax.persistence.ManyToOne;
 * @see     javax.persistence.FetchType
 * @see     org.hibernate.annotations.Fetch
 * @see     org.hibernate.annotations.FetchMode
 * @see     javax.persistence.JoinColumn
 * @see     br.com.wtag.lottery.model.entity.Bets
 * @see     com.fasterxml.jackson.annotation.JsonBackReference
 * @since   1.0.0
 * @version 1.0.0, 12 Jan 2021
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RandomNumbers {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull 
	@Min(1) 
	@Max(60)
	@Column(name = "random_number")
	private Integer randomNumber;
	@ManyToOne(fetch=FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "bet", nullable = false)
	@JsonBackReference
	private Bets bets;
	
}