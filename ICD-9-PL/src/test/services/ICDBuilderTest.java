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
       List<Section> distinctSections =  icdBuilder.getDistinctSections();
       assertTrue(distinctSections.size() != 0);
    }

    @Test
    public void shouldReturnDistinctSubsections() throws Exception {
        List<Subsection> distinctSubsections =  icdBuilder.getDistinctSubsections("00");
        assertTrue(distinctSubsections.size() != 0);
    }

    @Test
    public void shouldReturnDistinctMainCategories() throws Exception {
        List<MainCategory> distinctMainCategories =  icdBuilder.getDistinctMainCategories("00.1");
        assertTrue(distinctMainCategories.size() != 0);
    }

    @Test
    public void shouldReturnDistinctDetailedCategories() throws Exception {
        List<DetailedCategory> distinctDetailedCategories
                = icdBuilder.getDistinctDetailedCategories("00.10");
        assertTrue(distinctDetailedCategories.size() != 0);
    }
}