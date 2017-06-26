package services;

import domain.Category;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.IOUtils;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mariusz Szymanski
 */
public class ICDClassification {

    private List<Category> classification;

    private static final String REMOTE_ICD9_XLS
            = "https://danepubliczne.gov.pl/dataset"
            + "/a5f6b1ae-211a-4481-885e-ba9ff54c5ad4"
            + "/resource/a3647fe8-8e50-4836-b816-ec6861fac35f"
            + "/download/icd-9plw.5.33.xls";

    private static final File XLS_FILE
            = new File("src/main/resources/icd-9plw.5.33.xls");

    ICDClassification() {
        classification = new ArrayList<>();
        if (!XLS_FILE.exists()) {
            this.copyRemoteXlsFile();
        }
        this.readXlsFile();
    }

    public List<Category> getICDclassification() {
        return classification;
    }

    public void copyRemoteXlsFile() {
        InputStream initialStream = null;
        try {
            initialStream = new URL(REMOTE_ICD9_XLS).openStream();
            Files.copy(
                    initialStream,
                    XLS_FILE.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        IOUtils.closeQuietly(initialStream);
    }

    private void readXlsFile() {
        try {
            InputStream inputStream = new FileInputStream(XLS_FILE);
            HSSFWorkbook wb = new HSSFWorkbook(inputStream);
            inputStream.close();
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            int rows = sheet.getPhysicalNumberOfRows();

            for (int r = 2; r < rows; r++) {
                row = sheet.getRow(r);
                if (row != null) {
                    Category category = new Category();
                    category.setChapterNumber(row.getCell(0).toString());
                    category.setChapter(row.getCell(1).toString());
                    category.setBlockNumber(row.getCell(2).toString());
                    category.setBlock(row.getCell(3).toString());
                    category.setMainCategoryNumber(row.getCell(4).toString());
                    category.setMainCategory(row.getCell(5).toString());
                    if (row.getCell(6) != null) {
                        category.setDetailedCategoryNumber(row.getCell(6).toString());
                    }
                    if (row.getCell(7) != null) {
                        category.setDetailedCategory(row.getCell(7).toString());
                    }
                    classification.add(category);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
