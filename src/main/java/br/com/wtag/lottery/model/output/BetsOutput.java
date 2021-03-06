package br.com.wtag.lottery.model.output;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bets output.
 *
 * @author  Mario Sakamoto <mskamot@gmail.com>
 * @see     lombok.Data
 * @see     lombok.NoArgsConstructor
 * @see     lombok.AllArgsConstructor
 * @see     java.lang.Long
 * @see     java.lang.String
 * @see     com.fasterxml.jackson.annotation.JsonFormat
 * @see     java.time.LocalDateTime
 * @see     java.util.List
 * @see     br.com.wtag.lottery.model.output.RandomNumbersOutput
 * @since   1.0.0
 * @version 1.0.0, 12 Jan 2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BetsOutput {

	private String email;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime registered;
	private List<RandomNumbersOutput> randomNumbers;
	
}