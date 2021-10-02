package com.rte.highwaytodevops;

import com.google.common.collect.Lists;
import com.rte.highwaytodevops.documents.AnnonceIndex;
import com.rte.highwaytodevops.entities.Personne;
import com.rte.highwaytodevops.es_repository.AnnonceRepository;
import com.rte.highwaytodevops.repository.PersonneRepository;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@RestController
public class Controller {


    private final PersonneRepository personneRepository;
    private final AnnonceRepository annonceRepository;
    private final RestHighLevelClient client;

    public Controller(PersonneRepository personneRepository, AnnonceRepository annonceRepository, RestHighLevelClient client) {
        this.personneRepository = personneRepository;
        this.annonceRepository = annonceRepository;
        this.client = client;
    }


    @GetMapping("api")
    public AppDetails getAppDetails() {
        return AppDetails.builder()
                .appName("High-way-to-Devops with helm")
                .version("V.1.0.2").build();
    }


    @PostConstruct
    public void initData() {
        Personne p1 = Personne.builder()
                .id(1L)
                .login("mchekini")
                .lastName("CHEKINI")
                .password("test")
                .firstName("mahdi")
                .tjm(610L)
                .build();

        personneRepository.save(p1);

        annonceRepository.deleteAll();

        AnnonceIndex annonce1 = AnnonceIndex.builder()
                .id(1L)
                .title("appartement T2")
                .description("joli appartement T2 situé à paris")
                .build();

        AnnonceIndex annonce2 = AnnonceIndex.builder()
                .id(2L)
                .title("appartement T3 à paris")
                .description("joli appartement T3 situé à paris")
                .build();

        annonceRepository.saveAll(Lists.newArrayList(annonce1, annonce2));
    }


    @GetMapping("api/personnes")
    public List<Personne> getPersonnes() {

        return personneRepository.findAll();

    }


    @GetMapping("elastic/{search}")
    public Object search(@PathVariable("search") String search) throws IOException {
//        SimpleQueryStringBuilder sourceBuilder = QueryBuilders.matchQuery(
//                search,"description","title")
//                .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
//                .operator(Operator.OR);
//
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("annonce-document");
//        searchRequest.source(sourceBuilder);
//
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//        return searchResponse.getHits();
        return null;
    }


}
