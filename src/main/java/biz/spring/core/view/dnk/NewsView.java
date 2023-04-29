package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class NewsView {

    @Schema(description = "ИД новости")
    @Column(name = "news_id")
    private Integer newsId;

    @Schema(description = "Титул новости")
    @Column(name = "news_title")
    private String newsTitle;

    @Schema(description = "Текст новости")
    @Column(name = "news_text")
    private String newsText;

    @Schema(description = "Дата создания новости")
    @Column(name = "documentreal_datecreate")
    private Date documentRealDateCreate;

    @Schema(description = "ИД статуса новости")
    @Column(name = "documenttransit_id")
    private Integer documentTransitId;

    @Schema(description = "Имя статуса заявки")
    @Column(name = "documenttransit_name")
    private String documentTransitName;

    @Schema(description = "Цвет статуса заявки")
    @Column(name = "documenttransit_color")
    private Integer documentTransitColor;

    @Schema(description = "Номер документа заявки")
    @Column(name = "documentreal_number")
    private String documentRealNumber;

    public NewsView() {
    }

    public NewsView(Integer newsId,
                    String newsTitle,
                    String newsText) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsText = newsText;
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
