package domain;

import services.ICDBuilder;

import java.util.List;

/**
 * @author Mariusz Szymanski
 */
public class Classification {

    private List<Section> classification;

    public Classification() {
        this.classification = new ICDBuilder().getDistinctSections();
    }

    public List<Section> getClassification() {
        return classification;
    }
}
