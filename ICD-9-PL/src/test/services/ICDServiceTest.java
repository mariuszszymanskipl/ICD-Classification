package services;

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
    public void getDistinctElements() throws Exception {

       List<Section> distinctCategories =  icdService.getDistinctSections();
       assertTrue(distinctCategories.size() != 0);
       assertTrue(distinctCategories.get(0).getSubsections().size() != 0);
    }

    @Test
    public void getDistinctSubsections() throws Exception {
        List<Subsection> distinctCategories =  icdService.getDistinctSubsections("00");
        assertTrue(distinctCategories.size() != 0);
    }
}