package com.longkx;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PropertyRepository extends ElasticsearchRepository<Property, Long> {
    Page<Property> findByName(String name, Pageable pageable);
}
