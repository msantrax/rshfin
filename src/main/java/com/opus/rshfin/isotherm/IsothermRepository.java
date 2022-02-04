package com.opus.rshfin.isotherm;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "isotherms", path = "isotherms")
public interface IsothermRepository extends MongoRepository<Isotherm, ObjectId> {

//    List<Isotherm> findByIndex(@Param("index") Integer index);


}
