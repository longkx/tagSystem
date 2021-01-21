package com.longkx;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "property")
@Data
public class Property {

    @Id
    private Long id;

    private String name;
}
