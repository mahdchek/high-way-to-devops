package com.rte.highwaytodevops.documents;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

//@Data
//@Builder
//@Document(indexName = "annonce-document")
//@Setting(settingPath = "doc-settings/annonce-settings.json")
public class AnnonceIndex {

    @Id
    private Long id;
    @Field(type = Text)
    private String title;
    @Field(type = Text)
    private String description;
    private List<String> tags;
}
