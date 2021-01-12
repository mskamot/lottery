package br.com.wtag.lottery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.wtag.lottery.model.entity.RandomNumbers;

/**
 * Lottery math.
 *
 * @author  Mario Sakamoto <mskamot@gmail.com>
 * @see     java.lang.String
 * @see     java.lang.Integer
 * @since   1.0.0
 * @version 1.0.0, 12 Jan 2021
 */
public class LotteryService {
	
	private static final String MAX_MUST_BE_GREATER_THAN_MIN = "Max must be greater than min";
	private static final Integer MINUS_ONE = -1;
	private static final Integer ONE = 1;
	private static final Integer ZERO = 0;
	
	/**
	 * Get random number.
	 * 
	 * @param  min Integer
	 * @param  max Integer
	 * @param  randomNumberListForExclude List<RandomNumbers>
	 * @return Integer
     * @see    java.lang.Integer  
     * @see    java.util.List
     * @see    br.com.wtag.lottery.model.entity.RandomNumbers
     * @see    java.lang.IllegalArgumentException
     * @see    java.util.Random
	 */
	public static Integer getRandomNumber(final Integer min, final Integer max, 
			final List<RandomNumbers> randomNumberListForExclude) {
        if (max.compareTo(min) == MINUS_ONE) {
            throw new IllegalArgumentException(MAX_MUST_BE_GREATER_THAN_MIN);
        }
        Integer maximumNumberIncluded = max + ONE; 
        Integer randomNumber = new Random().ints(min, maximumNumberIncluded).limit(ONE).findFirst().getAsInt();
        List<Integer> randomNumberList = getRandomNumberListForExclude(randomNumberListForExclude);
        if (randomNumberList != null && !randomNumberList.isEmpty()) {
	        while (randomNumberList.contains(randomNumber)) {
	        	randomNumber = new Random().ints(min, maximumNumberIncluded).limit(ONE).findFirst().getAsInt();
	        }
        }
        return randomNumber;
    }
	
	/**
	 * Get random number list for exclude.
	 * 
	 * @param  randomNumberListForExclude List<RandomNumbers>
	 * @return List<Integer>
	 * @see    java.util.List
	 * @see    java.lang.Integer
	 * @see    br.com.wtag.lottery.model.entity.RandomNumbers
	 * @see    java.util.ArrayList
	 */
	public static List<Integer> getRandomNumberListForExclude(final List<RandomNumbers> randomNumberListForExclude) {
		List<Integer> randomNumberList = new ArrayList<>();
        if (randomNumberListForExclude != null && !randomNumberListForExclude.isEmpty()) {
        	for (Integer x = ZERO; x < randomNumberListForExclude.size(); x++) {
        		randomNumberList.add(randomNumberListForExclude.get(x).getRandomNumber());
        	}
        }
        return randomNumberList;
	}
	
}