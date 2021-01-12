package br.com.wtag.lottery.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wtag.lottery.model.entity.RandomNumbers;

/**
 * Random numbers repository.
 *
 * @author  Mario Sakamoto <mskamot@gmail.com>
 * @see     org.springframework.data.jpa.repository.JpaRepository
 * @see     br.com.wtag.lottery.model.entity.RandomNumbers
 * @see     java.lang.Long
 * @since   1.0.0
 * @version 1.0.0, 12 Jan 2021
 */
public interface RandomNumbersRepository extends JpaRepository<RandomNumbers, Long> {

}