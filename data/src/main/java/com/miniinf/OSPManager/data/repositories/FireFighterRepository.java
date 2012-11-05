package com.miniinf.OSPManager.data.repositories;

import com.miniinf.OSPManager.data.FireFighter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Szubster
 * Date: 15.10.12
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface FireFighterRepository extends PagingAndSortingRepository<FireFighter, BigInteger> {
}
