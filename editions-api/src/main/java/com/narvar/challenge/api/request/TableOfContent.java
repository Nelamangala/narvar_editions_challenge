package com.narvar.challenge.api.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "pagenum",
        "title",
        "level",
        "value",
        "label",
        "type",
        "class"
})
public class TableOfContent {

    @JsonProperty("pagenum")
    private String pagenum;
    @JsonProperty("title")
    private String title;
    @JsonProperty("level")
    private Double level;
    @JsonProperty("value")
    private String value;
    @JsonProperty("label")
    private String label;
    /**
     * (Required)
     */
    @JsonProperty("type")
    private Object type;
    @JsonProperty("class")
    private String _class;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("pagenum")
    public String getPagenum() {
        return pagenum;
    }

    @JsonProperty("pagenum")
    public void setPagenum(String pagenum) {
        this.pagenum = pagenum;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("level")
    public Double getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(Double level) {
        this.level = level;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * (Required)
     */
    @JsonProperty("type")
    public Object getType() {
        return type;
    }

    /**
     * (Required)
     */
    @JsonProperty("type")
    public void setType(Object type) {
        this.type = type;
    }

    @JsonProperty("class")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
