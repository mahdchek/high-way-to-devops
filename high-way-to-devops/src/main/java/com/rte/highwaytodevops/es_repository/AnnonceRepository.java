package com.rte.highwaytodevops.es_repository;

import com.rte.highwaytodevops.documents.AnnonceIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AnnonceRepository extends ElasticsearchRepository<AnnonceIndex, Long> {
}
