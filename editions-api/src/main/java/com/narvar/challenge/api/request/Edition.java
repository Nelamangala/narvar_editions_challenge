package com.narvar.challenge.api.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "key",
        "title",
        "subtitle",
        "work_title",
        "work_titles",
        "other_titles",
        "number_of_pages",
        "weight",
        "series",
        "covers",
        "ia_loaded_id",
        "lc_classifications",
        "latest_revision",
        "ocaid",
        "contributions",
        "description",
        "subject_time",
        "edition_name",
        "genres",
        "contributors",
        "source_records",
        "languages",
        "subjects",
        "publish_country",
        "subject_place",
        "by_statement",
        "oclc_numbers",
        "type",
        "uris",
        "physical_dimensions",
        "revision",
        "publishers",
        "isbn_invalid",
        "title_prefix",
        "ia_box_id",
        "table_of_contents",
        "dewey_decimal_class",
        "physical_format",
        "last_modified",
        "authors",
        "publish_places",
        "pagination",
        "uri_descriptions",
        "classifications",
        "created",
        "lccn",
        "notes",
        "identifiers",
        "isbn_13",
        "url",
        "isbn_10",
        "publish_date",
        "coverimage",
        "works",
        "first_sentence"
})
public class Edition {

    @JsonProperty("number_of_pages")
    private Double numberOfPages;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("weight")
    private String weight;
    @JsonProperty("series")
    private List<String> series = null;
    @JsonProperty("covers")
    private List<Double> covers = null;
    @JsonProperty("ia_loaded_id")
    private List<String> iaLoadedId = null;
    @JsonProperty("lc_classifications")
    private List<String> lcClassifications = null;
    @JsonProperty("latest_revision")
    private Double latestRevision;
    @JsonProperty("ocaid")
    private String ocaid;
    @JsonProperty("contributions")
    private List<String> contributions = null;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("subject_time")
    private List<String> subjectTime = null;
    @JsonProperty("edition_name")
    private String editionName;
    @JsonProperty("genres")
    private List<String> genres = null;
    @JsonProperty("contributors")
    private List<Contributor> contributors = null;
    @JsonProperty("source_records")
    private List<String> sourceRecords = null;
    /**
     * (Required)
     */
    @JsonProperty("title")
    @NotNull
    private String title;
    @JsonProperty("work_titles")
    private List<String> workTitles = null;
    @JsonProperty("languages")
    private List<Language> languages = null;
    @JsonProperty("subjects")
    private List<String> subjects = null;
    @JsonProperty("publish_country")
    private String publishCountry;
    @JsonProperty("subject_place")
    private List<String> subjectPlace = null;
    @JsonProperty("by_statement")
    private String byStatement;
    @JsonProperty("oclc_numbers")
    private List<String> oclcNumbers = null;
    /**
     * (Required)
     */
    @JsonProperty("type")
    private Type type;
    @JsonProperty("uris")
    private List<String> uris = null;
    @JsonProperty("physical_dimensions")
    private String physicalDimensions;
    /**
     * (Required)
     */
    @JsonProperty("revision")
    private Double revision;
    @JsonProperty("other_titles")
    private List<String> otherTitles = null;
    @JsonProperty("publishers")
    private List<String> publishers = null;
    @JsonProperty("isbn_invalid")
    private List<String> isbnInvalid = null;
    @JsonProperty("title_prefix")
    private String titlePrefix;
    @JsonProperty("ia_box_id")
    private List<String> iaBoxId = null;
    @JsonProperty("table_of_contents")
    private List<TableOfContent> tableOfContents = null;
    @JsonProperty("dewey_decimal_class")
    private List<String> deweyDecimalClass = null;
    @JsonProperty("physical_format")
    private String physicalFormat;
    /**
     * (Required)
     */
    @JsonProperty("last_modified")
    private LastModified lastModified;
    /**
     * (Required)
     */
    @NotNull
    @JsonProperty("key")
    private String key;
    @JsonProperty("authors")
    private List<Author> authors = null;
    @JsonProperty("publish_places")
    private List<String> publishPlaces = null;
    @JsonProperty("pagination")
    private String pagination;
    @JsonProperty("uri_descriptions")
    private List<Object> uriDescriptions = null;
    @JsonProperty("classifications")
    private Classifications classifications;
    @JsonProperty("created")
    private Created created;
    @JsonProperty("lccn")
    private List<String> lccn = null;
    @JsonProperty("notes")
    private Object notes;
    @JsonProperty("identifiers")
    private Identifiers identifiers;
    @JsonProperty("isbn_13")
    private List<String> isbn13 = null;
    @JsonProperty("url")
    private List<String> url = null;
    @JsonProperty("isbn_10")
    private List<String> isbn10 = null;
    @JsonProperty("publish_date")
    private String publishDate;
    @JsonProperty("coverimage")
    private String coverimage;
    @JsonProperty("work_title")
    private List<String> workTitle = null;
    @JsonProperty("works")
    private List<Work> works = null;
    @JsonProperty("first_sentence")
    private FirstSentence firstSentence;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("number_of_pages")
    public Double getNumberOfPages() {
        return numberOfPages;
    }

    @JsonProperty("number_of_pages")
    public void setNumberOfPages(Double numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @JsonProperty("subtitle")
    public String getSubtitle() {
        return subtitle;
    }

    @JsonProperty("subtitle")
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @JsonProperty("weight")
    public String getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(String weight) {
        this.weight = weight;
    }

    @JsonProperty("series")
    public List<String> getSeries() {
        return series;
    }

    @JsonProperty("series")
    public void setSeries(List<String> series) {
        this.series = series;
    }

    @JsonProperty("covers")
    public List<Double> getCovers() {
        return covers;
    }

    @JsonProperty("covers")
    public void setCovers(List<Double> covers) {
        this.covers = covers;
    }

    @JsonProperty("ia_loaded_id")
    public List<String> getIaLoadedId() {
        return iaLoadedId;
    }

    @JsonProperty("ia_loaded_id")
    public void setIaLoadedId(List<String> iaLoadedId) {
        this.iaLoadedId = iaLoadedId;
    }

    @JsonProperty("lc_classifications")
    public List<String> getLcClassifications() {
        return lcClassifications;
    }

    @JsonProperty("lc_classifications")
    public void setLcClassifications(List<String> lcClassifications) {
        this.lcClassifications = lcClassifications;
    }

    @JsonProperty("latest_revision")
    public Double getLatestRevision() {
        return latestRevision;
    }

    @JsonProperty("latest_revision")
    public void setLatestRevision(Double latestRevision) {
        this.latestRevision = latestRevision;
    }

    @JsonProperty("ocaid")
    public String getOcaid() {
        return ocaid;
    }

    @JsonProperty("ocaid")
    public void setOcaid(String ocaid) {
        this.ocaid = ocaid;
    }

    @JsonProperty("contributions")
    public List<String> getContributions() {
        return contributions;
    }

    @JsonProperty("contributions")
    public void setContributions(List<String> contributions) {
        this.contributions = contributions;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("subject_time")
    public List<String> getSubjectTime() {
        return subjectTime;
    }

    @JsonProperty("subject_time")
    public void setSubjectTime(List<String> subjectTime) {
        this.subjectTime = subjectTime;
    }

    @JsonProperty("edition_name")
    public String getEditionName() {
        return editionName;
    }

    @JsonProperty("edition_name")
    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }

    @JsonProperty("genres")
    public List<String> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @JsonProperty("contributors")
    public List<Contributor> getContributors() {
        return contributors;
    }

    @JsonProperty("contributors")
    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    @JsonProperty("source_records")
    public List<String> getSourceRecords() {
        return sourceRecords;
    }

    @JsonProperty("source_records")
    public void setSourceRecords(List<String> sourceRecords) {
        this.sourceRecords = sourceRecords;
    }

    /**
     * (Required)
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * (Required)
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("work_titles")
    public List<String> getWorkTitles() {
        return workTitles;
    }

    @JsonProperty("work_titles")
    public void setWorkTitles(List<String> workTitles) {
        this.workTitles = workTitles;
    }

    @JsonProperty("languages")
    public List<Language> getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    @JsonProperty("subjects")
    public List<String> getSubjects() {
        return subjects;
    }

    @JsonProperty("subjects")
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @JsonProperty("publish_country")
    public String getPublishCountry() {
        return publishCountry;
    }

    @JsonProperty("publish_country")
    public void setPublishCountry(String publishCountry) {
        this.publishCountry = publishCountry;
    }

    @JsonProperty("subject_place")
    public List<String> getSubjectPlace() {
        return subjectPlace;
    }

    @JsonProperty("subject_place")
    public void setSubjectPlace(List<String> subjectPlace) {
        this.subjectPlace = subjectPlace;
    }

    @JsonProperty("by_statement")
    public String getByStatement() {
        return byStatement;
    }

    @JsonProperty("by_statement")
    public void setByStatement(String byStatement) {
        this.byStatement = byStatement;
    }

    @JsonProperty("oclc_numbers")
    public List<String> getOclcNumbers() {
        return oclcNumbers;
    }

    @JsonProperty("oclc_numbers")
    public void setOclcNumbers(List<String> oclcNumbers) {
        this.oclcNumbers = oclcNumbers;
    }

    /**
     * (Required)
     */
    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    /**
     * (Required)
     */
    @JsonProperty("type")
    public void setType(Type type) {
        this.type = type;
    }

    @JsonProperty("uris")
    public List<String> getUris() {
        return uris;
    }

    @JsonProperty("uris")
    public void setUris(List<String> uris) {
        this.uris = uris;
    }

    @JsonProperty("physical_dimensions")
    public String getPhysicalDimensions() {
        return physicalDimensions;
    }

    @JsonProperty("physical_dimensions")
    public void setPhysicalDimensions(String physicalDimensions) {
        this.physicalDimensions = physicalDimensions;
    }

    /**
     * (Required)
     */
    @JsonProperty("revision")
    public Double getRevision() {
        return revision;
    }

    /**
     * (Required)
     */
    @JsonProperty("revision")
    public void setRevision(Double revision) {
        this.revision = revision;
    }

    @JsonProperty("other_titles")
    public List<String> getOtherTitles() {
        return otherTitles;
    }

    @JsonProperty("other_titles")
    public void setOtherTitles(List<String> otherTitles) {
        this.otherTitles = otherTitles;
    }

    @JsonProperty("publishers")
    public List<String> getPublishers() {
        return publishers;
    }

    @JsonProperty("publishers")
    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }

    @JsonProperty("isbn_invalid")
    public List<String> getIsbnInvalid() {
        return isbnInvalid;
    }

    @JsonProperty("isbn_invalid")
    public void setIsbnInvalid(List<String> isbnInvalid) {
        this.isbnInvalid = isbnInvalid;
    }

    @JsonProperty("title_prefix")
    public String getTitlePrefix() {
        return titlePrefix;
    }

    @JsonProperty("title_prefix")
    public void setTitlePrefix(String titlePrefix) {
        this.titlePrefix = titlePrefix;
    }

    @JsonProperty("ia_box_id")
    public List<String> getIaBoxId() {
        return iaBoxId;
    }

    @JsonProperty("ia_box_id")
    public void setIaBoxId(List<String> iaBoxId) {
        this.iaBoxId = iaBoxId;
    }

    @JsonProperty("table_of_contents")
    public List<TableOfContent> getTableOfContents() {
        return tableOfContents;
    }

    @JsonProperty("table_of_contents")
    public void setTableOfContents(List<TableOfContent> tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    @JsonProperty("dewey_decimal_class")
    public List<String> getDeweyDecimalClass() {
        return deweyDecimalClass;
    }

    @JsonProperty("dewey_decimal_class")
    public void setDeweyDecimalClass(List<String> deweyDecimalClass) {
        this.deweyDecimalClass = deweyDecimalClass;
    }

    @JsonProperty("physical_format")
    public String getPhysicalFormat() {
        return physicalFormat;
    }

    @JsonProperty("physical_format")
    public void setPhysicalFormat(String physicalFormat) {
        this.physicalFormat = physicalFormat;
    }

    /**
     * (Required)
     */
    @JsonProperty("last_modified")
    public LastModified getLastModified() {
        return lastModified;
    }

    /**
     * (Required)
     */
    @JsonProperty("last_modified")
    public void setLastModified(LastModified lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * (Required)
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * (Required)
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("authors")
    public List<Author> getAuthors() {
        return authors;
    }

    @JsonProperty("authors")
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @JsonProperty("publish_places")
    public List<String> getPublishPlaces() {
        return publishPlaces;
    }

    @JsonProperty("publish_places")
    public void setPublishPlaces(List<String> publishPlaces) {
        this.publishPlaces = publishPlaces;
    }

    @JsonProperty("pagination")
    public String getPagination() {
        return pagination;
    }

    @JsonProperty("pagination")
    public void setPagination(String pagination) {
        this.pagination = pagination;
    }

    @JsonProperty("uri_descriptions")
    public List<Object> getUriDescriptions() {
        return uriDescriptions;
    }

    @JsonProperty("uri_descriptions")
    public void setUriDescriptions(List<Object> uriDescriptions) {
        this.uriDescriptions = uriDescriptions;
    }

    @JsonProperty("classifications")
    public Classifications getClassifications() {
        return classifications;
    }

    @JsonProperty("classifications")
    public void setClassifications(Classifications classifications) {
        this.classifications = classifications;
    }

    @JsonProperty("created")
    public Created getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Created created) {
        this.created = created;
    }

    @JsonProperty("lccn")
    public List<String> getLccn() {
        return lccn;
    }

    @JsonProperty("lccn")
    public void setLccn(List<String> lccn) {
        this.lccn = lccn;
    }

    @JsonProperty("notes")
    public Object getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(Object notes) {
        this.notes = notes;
    }

    @JsonProperty("identifiers")
    public Identifiers getIdentifiers() {
        return identifiers;
    }

    @JsonProperty("identifiers")
    public void setIdentifiers(Identifiers identifiers) {
        this.identifiers = identifiers;
    }

    @JsonProperty("isbn_13")
    public List<String> getIsbn13() {
        return isbn13;
    }

    @JsonProperty("isbn_13")
    public void setIsbn13(List<String> isbn13) {
        this.isbn13 = isbn13;
    }

    @JsonProperty("url")
    public List<String> getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(List<String> url) {
        this.url = url;
    }

    @JsonProperty("isbn_10")
    public List<String> getIsbn10() {
        return isbn10;
    }

    @JsonProperty("isbn_10")
    public void setIsbn10(List<String> isbn10) {
        this.isbn10 = isbn10;
    }

    @JsonProperty("publish_date")
    public String getPublishDate() {
        return publishDate;
    }

    @JsonProperty("publish_date")
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @JsonProperty("coverimage")
    public String getCoverimage() {
        return coverimage;
    }

    @JsonProperty("coverimage")
    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage;
    }

    @JsonProperty("work_title")
    public List<String> getWorkTitle() {
        return workTitle;
    }

    @JsonProperty("work_title")
    public void setWorkTitle(List<String> workTitle) {
        this.workTitle = workTitle;
    }

    @JsonProperty("works")
    public List<Work> getWorks() {
        return works;
    }

    @JsonProperty("works")
    public void setWorks(List<Work> works) {
        this.works = works;
    }

    @JsonProperty("first_sentence")
    public FirstSentence getFirstSentence() {
        return firstSentence;
    }

    @JsonProperty("first_sentence")
    public void setFirstSentence(FirstSentence firstSentence) {
        this.firstSentence = firstSentence;
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
