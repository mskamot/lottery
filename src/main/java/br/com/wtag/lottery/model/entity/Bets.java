package br.com.wtag.lottery.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bets.
 *
 * @author  Mario Sakamoto <mskamot@gmail.com>
 * @see		javax.persistence.Entity
 * @see     lombok.Data
 * @see     lombok.NoArgsConstructor
 * @see     lombok.AllArgsConstructor
 * @see		javax.persistence.Id
 * @see		javax.persistence.GeneratedValue
 * @see     javax.persistence.GenerationType
 * @see     java.lang.Long
 * @see		javax.validation.constraints.NotNull
 * @see		javax.validation.constraints.NotBlank
 * @see		javax.validation.constraints.Size
 * @see     java.lang.String
 * @see		javax.persistence.Column
 * @see     java.time.LocalDateTime
 * @see		javax.persistence.OneToMany
 * @see		javax.persistence.FetchType
 * @see		org.hibernate.annotations.Fetch
 * @see     org.hibernate.annotations.FetchMode
 * @see     java.util.List
 * @see     br.com.wtag.lottery.model.entity.RandomNumbers
 * @see     java.util.ArrayList
 * @since   1.0.0
 * @version 1.0.0, 12 Jan 2021
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bets {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull 
	@NotBlank 
	@Size(max=255)
	private String email;
	@NotNull
	@Column(name = "registered")
	private LocalDateTime registered;
	@OneToMany(mappedBy="bets", fetch=FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	private List<RandomNumbers> randomNumbers = new ArrayList<>();
	
}