package com.affan.music_engine.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import com.affan.music_engine.entity.Person;

public interface PersonRepository extends Neo4jRepository<Person, String> {
}