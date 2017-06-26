package services;

import org.apache.poi.util.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * @author Mariusz Szymanski
 */
public class ICDClassification {

    private static final String REMOTE_ICD9_URL
            = "https://danepubliczne.gov.pl/dataset"
            + "/a5f6b1ae-211a-4481-885e-ba9ff54c5ad4"
            + "/resource/a3647fe8-8e50-4836-b816-ec6861fac35f"
            + "/download/icd-9plw.5.33.xls";

    public void copyRemoteXlsFile() throws IOException {

        InputStream initialStream = new URL(REMOTE_ICD9_URL).openStream();
        File targetFile = new File("src/main/resources/icd-9plw.5.33.xls");

        Files.copy(
                initialStream,
                targetFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING);

        IOUtils.closeQuietly(initialStream);
    }
}
