package com.miniinf.OSPManager.data.repositories;

import com.miniinf.OSPManager.data.FireTruck;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Szubster
 * Date: 05.11.12
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface FireTruckRepository extends PagingAndSortingRepository<FireTruck, BigInteger> {
}
