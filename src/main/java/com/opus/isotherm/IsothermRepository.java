package com.opus.isotherm;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "isotherms", path = "isotherms")
public interface IsothermRepository extends MongoRepository<Isotherm, ObjectId> {

    List<Isotherm> findByIndex(@Param("index") Integer index);


}
