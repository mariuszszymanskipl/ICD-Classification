package domain;

/**
 * @author Mariusz Szymanski
 */
public class Category {

    private String chapterNumber;
    private String chapter;
    private String blockNumber;
    private String block;
    private String mainCategoryNumber;
    private String mainCategory;
    private String detailedCategoryNumber;
    private String detailedCategory;

    public String getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getMainCategoryNumber() {
        return mainCategoryNumber;
    }

    public void setMainCategoryNumber(String mainCategoryNumber) {
        this.mainCategoryNumber = mainCategoryNumber;
    }

    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public String getDetailedCategoryNumber() {
        return detailedCategoryNumber;
    }

    public void setDetailedCategoryNumber(String detailedCategoryNumber) {
        this.detailedCategoryNumber = detailedCategoryNumber;
    }

    public String getDetailedCategory() {
        return detailedCategory;
    }

    public void setDetailedCategory(String detailedCategory) {
        this.detailedCategory = detailedCategory;
    }
}
