package domain;

import java.util.List;

/**
 * @author Mariusz Szymanski
 */
public class MainCategory {

    private String code;
    private String title;
    private List<DetailedCategory> detailedCategories;

    public MainCategory(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DetailedCategory> getDetailedCategories() {
        return detailedCategories;
    }

    public void setDetailedCategories(List<DetailedCategory> detailedCategories) {
        this.detailedCategories = detailedCategories;
    }
}
