package biz.spring.core.dto.dnk;

import biz.spring.core.model.DocumentReal;
import biz.spring.core.model.dnk.News;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class NewsDTO {

    @Schema(description = "ИД новости")
    private Integer newsId;

    @Schema(description = "Титул новости")
    private String newsTitle;

    @Schema(description = "Текст новости")
    private String newsText;

    @Schema(description = "Дата создания новости")
    private Date documentRealDateCreate;

    @Schema(description = "ИД статуса новости")
    private Integer documentTransitId;

    @Schema(description = "Имя статуса заявки")
    private String documentTransitName;

    @Schema(description = "Цвет статуса заявки")
    private Integer documentTransitColor;

    @Schema(description = "Номер документа заявки")
    private String documentRealNumber;

    public NewsDTO() {
    }

    public NewsDTO(Integer newsId,
                   String newsTitle,
                   String newsText) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsText = newsText;
    }

    public News toEntity(){
        return toEntity(new News());
    }

    public News toEntity(News entity){
        entity.setNewsId(this.newsId);
        entity.setNewsText(this.newsText);
        entity.setNewsTitle(this.newsTitle);
        return entity;
    }

    public DocumentReal toDocumentReal(){
        return toDocumentReal(new DocumentReal());
    }

    public DocumentReal toDocumentReal(DocumentReal entity){
        entity.setDocumentRealId(this.newsId);
        entity.setDocumentRealNumber(this.documentRealNumber);
        entity.setDocumentTypeId(News.DOCUMENT_TYPE_ID);
        entity.setDocumentRealDateCreate(this.documentRealDateCreate);
        return entity;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public Date getDocumentRealDateCreate() {
        return documentRealDateCreate;
    }

    public void setDocumentRealDateCreate(Date documentRealDateCreate) {
        this.documentRealDateCreate = documentRealDateCreate;
    }

    public Integer getDocumentTransitId() {
        return documentTransitId;
    }

    public void setDocumentTransitId(Integer documentTransitId) {
        this.documentTransitId = documentTransitId;
    }

    public String getDocumentTransitName() {
        return documentTransitName;
    }

    public void setDocumentTransitName(String documentTransitName) {
        this.documentTransitName = documentTransitName;
    }

    public Integer getDocumentTransitColor() {
        return documentTransitColor;
    }

    public void setDocumentTransitColor(Integer documentTransitColor) {
        this.documentTransitColor = documentTransitColor;
    }

    public String getDocumentRealNumber() {
        return documentRealNumber;
    }

    public void setDocumentRealNumber(String documentRealNumber) {
        this.documentRealNumber = documentRealNumber;
    }
}
