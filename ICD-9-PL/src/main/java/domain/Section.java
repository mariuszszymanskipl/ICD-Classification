package domain;

import java.util.List;

/**
 * @author Mariusz Szymanski
 */
public class Section {

    private String code;
    private String title;
    private List<Subsection> subsections;

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

    public List<Subsection> getSubsections() {
        return subsections;
    }

    public void setSubsections(List<Subsection> subsections) {
        this.subsections = subsections;
    }
}
