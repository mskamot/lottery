package br.com.wtag.lottery.model.output;

import java.util.ArrayList;
import java.util.List;

import br.com.wtag.lottery.model.entity.RandomNumbers;
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

	private final static Integer ZERO = 0;
	private Long id;
	private Integer randomNumber;
	
	/**
	 * Random numbers output.
	 * 
	 * @param randomNumbers RandomNumbers
	 * @see   br.com.wtag.lottery.model.output.RandomNumbersOutput
	 * @see   br.com.wtag.lottery.model.entity.RandomNumbers
	 */
	public RandomNumbersOutput(RandomNumbers randomNumbers) {
		this(randomNumbers.getId(), randomNumbers.getRandomNumber());
	}
	
	/**
	 * Get list.
	 * 
	 * @param  randomNumbersList List<RandomNumbers>
	 * @return RandomNumbersOutput
	 * @see    java.util.List
	 * @see    br.com.wtag.lottery.model.output.RandomNumbersOutput
	 * @see    br.com.wtag.lottery.model.entity.RandomNumbers
	 * @see    java.util.ArrayList
	 * @see    java.lang.Integer
	 */
	public List<RandomNumbersOutput> getList(List<RandomNumbers> randomNumbersList) {
		if (randomNumbersList != null && !randomNumbersList.isEmpty()) {
			List<RandomNumbersOutput> randomNumbersOutputList = new ArrayList<>();
			for (Integer x = ZERO; x < randomNumbersList.size(); x++) {
				randomNumbersOutputList.add(new RandomNumbersOutput(randomNumbersList.get(x)));
			}
			return randomNumbersOutputList;
		} else {
			return null;
		}
	}
	
}