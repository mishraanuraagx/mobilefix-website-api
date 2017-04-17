package com.teamscreenbiz.transaction;


import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction,Long> {
}
