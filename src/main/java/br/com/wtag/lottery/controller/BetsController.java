package br.com.wtag.lottery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wtag.lottery.model.entity.Bets;
import br.com.wtag.lottery.model.entity.RandomNumbers;
import br.com.wtag.lottery.model.input.BetsInput;
import br.com.wtag.lottery.model.output.BetsOutput;
import br.com.wtag.lottery.model.repository.BetsRepository;
import br.com.wtag.lottery.model.repository.RandomNumbersRepository;
import br.com.wtag.lottery.service.LotteryService;

/**
 * Bets controller.
 *
 * @author  Mario Sakamoto <mskamot@gmail.com>
 * @see     org.springframework.web.bind.annotation.RestController
 * @see     org.springframework.web.bind.annotation.RequestMapping
 * @see     org.springframework.beans.factory.annotation.Autowired
 * @see     br.com.wtag.lottery.model.repository.BetsRepository
 * @see     br.com.wtag.lottery.model.repository.RandomNumbersRepository
 * @see     java.lang.Integer
 * @since   1.0.0
 * @version 1.0.0, 12 Jan 2021
 */
@RestController
@RequestMapping("/bets")
public class BetsController {

	@Autowired
	private BetsRepository betsRepository;
	@Autowired
	private RandomNumbersRepository randomNumbersRepository;
	private static final Integer ONE = 1;
	private static final Integer SIX = 6;
	private static final Integer SIXTY = 60;
	private static final Integer ZERO = 0;
	
	/**
	 * Create.
	 * 
	 * @param  betsInput BetsInput
	 * @return BetsOutput
	 * @see    org.springframework.web.bind.annotation.PostMapping
	 * @see    br.com.wtag.lottery.model.output.BetsOutput
	 * @see    org.springframework.web.bind.annotation.RequestBody
	 * @see    javax.validation.Valid
	 * @see    br.com.wtag.lottery.model.input.BetsInput;
	 * @see    br.com.wtag.lottery.model.entity.Bets;
	 * @see    br.com.wtag.lottery.model.entity.RandomNumbers;
	 * @see    java.util.List
	 * @see    java.lang.Integer
	 * @see    br.com.wtag.lottery.service.LotteryService;
	 */
	@PostMapping
	public BetsOutput create(@RequestBody @Valid BetsInput betsInput) {
		Bets bets = betsRepository.save(betsInput.toBets());
		RandomNumbers randomNumbers;
		List<RandomNumbers> randomNumbersList = new ArrayList<>();
		for (Integer x = ZERO; x < SIX; x++) {
			randomNumbers = new RandomNumbers();
			randomNumbers.setRandomNumber(LotteryService.getRandomNumber(ONE, SIXTY, randomNumbersList));
			randomNumbers.setBets(bets);
			randomNumbersRepository.save(randomNumbers);
			randomNumbersList.add(randomNumbers);
		}
		bets.setRandomNumbers(randomNumbersList);
		return new BetsOutput(bets);
	}
	
	/**
	 * Read.
	 * 
	 * @param  email String
	 * @return List<BetsOutput>
	 * @see    org.springframework.web.bind.annotation.GetMapping
	 * @see    java.util.List
	 * @see    br.com.wtag.lottery.model.output.BetsOutput
	 * @see    org.springframework.web.bind.annotation.PathVariable
	 * @see    java.lang.String
	 * @see    java.util.stream.Collectors
	 */
	@GetMapping("/history/{email}")
	public List<BetsOutput> read(@PathVariable String email) {
		return betsRepository.findByEmailOrderByRegisteredAsc(email).stream().map(bets -> 
				new BetsOutput(bets)).collect(Collectors.toList());
	}

}