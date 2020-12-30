package com.credere.probejean.probeposition.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProbePositionRepository extends MongoRepository<ProbePosition, UUID> {}
