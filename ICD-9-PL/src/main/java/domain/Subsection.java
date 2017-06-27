package domain;

import java.util.List;

/**
 * @author Mariusz Szymanski
 */
public class Subsection {

    private String code;
    private String title;
    private List<MainCategory> mainCategories;

    public Subsection(String code, String title) {
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

    public List<MainCategory> getMainCategories() {
        return mainCategories;
    }

    public void setMainCategories(List<MainCategory> mainCategories) {
        this.mainCategories = mainCategories;
    }
}
