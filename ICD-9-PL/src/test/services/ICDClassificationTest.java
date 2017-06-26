package services;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * @author Mariusz Szymanski
 */
public class ICDClassificationTest {

    private ICDClassification icdClassification;

    @Before
    public void setUp() {
        icdClassification = new ICDClassification();
    }

    @Test
    public void shouldCopyRemoteXlsFileToResources() throws Exception {
//        Given
        String filePath = "src/main/resources/icd-9plw.5.33.xls";
        File file = new File(filePath);
//        When
        icdClassification.copyRemoteXlsFile();
//        Then
        assertTrue(file.exists());
    }
}