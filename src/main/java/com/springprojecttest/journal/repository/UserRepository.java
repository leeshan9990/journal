 package com.springprojecttest.journal.repository;

import com.springprojecttest.journal.entity.JournalEntry;
import com.springprojecttest.journal.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String userName);
    void deleteByUserName(String username);

}
