package com.narvar.challenge.api.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dnb",
        "amazon",
        "goodreads",
        "librarything"
})
public class Identifiers {

    @JsonProperty("dnb")
    private List<String> dnb = null;
    @JsonProperty("amazon")
    private List<String> amazon = null;
    @JsonProperty("goodreads")
    private List<String> goodreads = null;
    @JsonProperty("librarything")
    private List<String> librarything = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dnb")
    public List<String> getDnb() {
        return dnb;
    }

    @JsonProperty("dnb")
    public void setDnb(List<String> dnb) {
        this.dnb = dnb;
    }

    @JsonProperty("amazon")
    public List<String> getAmazon() {
        return amazon;
    }

    @JsonProperty("amazon")
    public void setAmazon(List<String> amazon) {
        this.amazon = amazon;
    }

    @JsonProperty("goodreads")
    public List<String> getGoodreads() {
        return goodreads;
    }

    @JsonProperty("goodreads")
    public void setGoodreads(List<String> goodreads) {
        this.goodreads = goodreads;
    }

    @JsonProperty("librarything")
    public List<String> getLibrarything() {
        return librarything;
    }

    @JsonProperty("librarything")
    public void setLibrarything(List<String> librarything) {
        this.librarything = librarything;
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
