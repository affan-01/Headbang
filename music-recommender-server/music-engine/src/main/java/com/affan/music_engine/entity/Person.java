package com.affan.music_engine.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import lombok.*;

@Node
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private String name;
}