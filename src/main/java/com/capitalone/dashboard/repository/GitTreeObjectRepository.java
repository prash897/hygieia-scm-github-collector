package com.capitalone.dashboard.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capitalone.dashboard.model.GitTreeObject;

public interface GitTreeObjectRepository<T extends GitTreeObject> extends CrudRepository<T, ObjectId> {

	List<GitTreeObject> findByPathLike(String pattern); // flash

}
