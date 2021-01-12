package br.com.wtag.lottery.model.input;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.wtag.lottery.model.entity.Bets;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bets input.
 *
 * @author  Mario Sakamoto <mskamot@gmail.com>
 * @see     lombok.Data
 * @see     lombok.NoArgsConstructor
 * @see     java.lang.Long
 * @see     javax.validation.constraints.NotNull
 * @see     javax.validation.constraints.NotEmpty
 * @see     javax.validation.constraints.Email
 * @see     javax.validation.constraints.Size
 * @see     java.lang.String
 * @since   1.0.0
 * @version 1.0.0, 12 Jan 2021
 */
@Data
@NoArgsConstructor
public class BetsInput {

	private Long id;
	@NotNull @NotEmpty @Email @Size(max=255)
	private String email;

	/**
	 * To bets.
	 * 
	 * @return Bets
	 * @see    br.com.wtag.lottery.model.entity.Bets;
	 * @see    java.time.LocalDateTime 
	 */
	public Bets toBets() {
		return new Bets(id, email, LocalDateTime.now(), null);
	}
	
}