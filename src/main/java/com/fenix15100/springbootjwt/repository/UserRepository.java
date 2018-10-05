package com.fenix15100.springbootjwt.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
import com.fenix15100.springbootjwt.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
}
