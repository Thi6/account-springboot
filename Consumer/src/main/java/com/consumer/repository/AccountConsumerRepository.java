package com.consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.consumer.entity.AccountSent;
@Repository
public interface AccountConsumerRepository extends MongoRepository<AccountSent, String>{

}
