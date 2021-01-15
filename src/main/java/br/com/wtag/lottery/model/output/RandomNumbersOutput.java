package br.com.wtag.lottery.model.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Random numbers output.
 *
 * @author  Mario Sakamoto <mskamot@gmail.com>
 * @see     lombok.Data
 * @see     lombok.NoArgsConstructor
 * @see     lombok.AllArgsConstructor
 * @see     java.lang.Integer
 * @see     java.lang.Long
 * @since   1.0.0
 * @version 1.0.0, 12 Jan 2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RandomNumbersOutput {

	private Integer randomNumber;
	
}