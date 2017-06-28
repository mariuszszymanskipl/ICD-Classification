package services;

import domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Mariusz Szymanski
 */
public class ICDBuilderTest {

    private ICDBuilder icdBuilder;

    @Before
    public void setUp(){
        icdBuilder = new ICDBuilder();
    }

    @Test
    public void shouldReturnAllClassification() throws Exception {
        Classification classification = icdBuilder.getAllClassification();
        assertTrue(classification.getSections().size() != 0);
    }

    @Test
    public void shouldReturnDistinctSections() throws Exception {
       List<Section> distinctSections
               = icdBuilder.getAllClassification().getSections();
       assertTrue(distinctSections.size() != 0);
    }

    @Test
    public void shouldReturnDistinctSubsections() throws Exception {
        List<Subsection> distinctSubsections
                = icdBuilder.getAllClassification().getSections().get(0).getSubsections();
        assertTrue(distinctSubsections.size() != 0);
    }

    @Test
    public void shouldReturnDistinctMainCategories() throws Exception {
        List<MainCategory> distinctMainCategories
                = icdBuilder.getAllClassification().getSections().get(0)
                .getSubsections().get(0).getMainCategories();
        assertTrue(distinctMainCategories.size() != 0);
    }

    @Test
    public void shouldReturnDistinctDetailedCategories() throws Exception {
        List<DetailedCategory> distinctDetailedCategories
                = icdBuilder.getAllClassification().getSections().get(1)
                .getSubsections().get(0).getMainCategories()
                .get(0).getDetailedCategories();
        assertTrue(distinctDetailedCategories.size() != 0);
    }
}