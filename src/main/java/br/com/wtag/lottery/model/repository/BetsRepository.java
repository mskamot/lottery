package br.com.wtag.lottery.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wtag.lottery.model.entity.Bets;

/**
 * Bets repository.
 *
 * @author  Mario Sakamoto <mskamot@gmail.com>
 * @see     org.springframework.data.jpa.repository.JpaRepository
 * @see     br.com.wtag.lottery.model.entity.Bets
 * @see     java.lang.Long
 * @see     java.util.List
 * @see     java.lang.String
 * @since   1.0.0
 * @version 1.0.0, 12 Jan 2021
 */
public interface BetsRepository extends JpaRepository<Bets, Long> {

	public List<Bets> findByEmailOrderByRegisteredAsc(final String email);
	
}