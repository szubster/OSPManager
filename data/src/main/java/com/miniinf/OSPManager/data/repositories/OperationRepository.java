package com.miniinf.OSPManager.data.repositories;

import com.miniinf.OSPManager.data.Operation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 05.11.12
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface OperationRepository extends PagingAndSortingRepository<Operation, BigInteger> {
}
