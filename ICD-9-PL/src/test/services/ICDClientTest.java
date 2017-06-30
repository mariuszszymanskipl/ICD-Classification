package services;

import domain.Record;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Mariusz Szymanski
 */
public class ICDClientTest {

    private ICDClient icdClient;

    @Before
    public void setUp() {
        icdClient = new ICDClient();
    }

    @Test
    public void shouldCopyRemoteXlsFileToResources() throws Exception {
//        Given
        String filePath = "icd-9plw.5.33.xls";
        File file = new File(filePath);
//        When
        icdClient.copyRemoteXlsFile();
//        Then
        assertTrue(file.exists());
    }

    @Test
    public void getICDRecordReturnNotNullList() throws Exception {
//        Given & When
        List<Record> records = icdClient.getICDRecords();
//        Then
        assertTrue(records.size() != 0);
    }
}