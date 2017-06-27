package services;

import domain.DetailedCategory;
import domain.MainCategory;
import domain.Section;
import domain.Subsection;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Mariusz Szymanski
 */
public class ICDServiceTest {

    private ICDService icdService;

    @Before
    public void setUp(){
        icdService = new ICDService();
    }
    @Test
    public void shouldReturnDistinctSections() throws Exception {
       List<Section> distinctSections =  icdService.getDistinctSections();
       assertTrue(distinctSections.size() != 0);
    }

    @Test
    public void shouldReturnDistinctSubsections() throws Exception {
        List<Subsection> distinctSubsections =  icdService.getDistinctSubsections("00");
        assertTrue(distinctSubsections.size() != 0);
    }

    @Test
    public void shouldReturnDistinctMainCategories() throws Exception {
        List<MainCategory> distinctMainCategories =  icdService.getDistinctMainCategories("00.1");
        assertTrue(distinctMainCategories.size() != 0);
    }

    @Test
    public void shouldReturnDistinctDetailedCategories() throws Exception {
        List<DetailedCategory> distinctDetailedCategories
                = icdService.getDistinctDetailedCategories("00.10");
        assertTrue(distinctDetailedCategories.size() != 0);
    }
}