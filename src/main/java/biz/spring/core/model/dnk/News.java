package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "news")
public class News {

    public static final int DOCUMENT_TYPE_ID = 3;

    @Id
    @Column(name = "news_id", nullable = false)
    private Integer newsId;

    @Column(name = "news_title", nullable = false)
    @NotNull(message = "Поле \"Титул новости\" не может быть пустым")
    @Size(max = 255, message = "Поле \"Титул новости\" не может иметь более {max} символов")
    private String newsTitle;

    @Column(name = "news_text", nullable = false)
    @NotNull(message = "Поле \"Текст новости\" не может быть пустым")
    @Size(max = 5000, message = "Поле \"Текст новости\" не может иметь более {max} символов")
    private String newsText;

    public News() {
    }

    public News(Integer newsId,
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
}
