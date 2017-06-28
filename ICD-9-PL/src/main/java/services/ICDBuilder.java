package services;

import domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Mariusz Szymanski
 */
public class ICDBuilder {

    private List<Record> records = new ICDClient().getICDRecords();

    public Classification getAllClassification() {

        return new Classification(this.getDistinctSections());
    }

    public List<Section> getDistinctSections() {

        List<Record> distinctElements = records.stream()
                .filter(distinctByKey(Record::getChapter))
                .collect(Collectors.toList());

        List<Section> sections = new ArrayList<>();

        distinctElements.forEach((record) -> sections.add(new Section(
                record.getChapterNumber(),
                record.getChapter(),
                this.getDistinctSubsections(record.getChapterNumber()))));

        return sections;
    }

    public List<Subsection> getDistinctSubsections(String section) {

        List<Record> distinctElements = records.stream()
                .filter(e -> Objects.equals(e.getChapterNumber(), section))
                .filter(distinctByKey(Record::getBlock))
                .collect(Collectors.toList());

        List<Subsection> subsections = new ArrayList<>();

        distinctElements.forEach((record) -> subsections.add(new Subsection(
                record.getBlockNumber(),
                record.getBlock(),
                this.getDistinctMainCategories(record.getBlockNumber()))));

        return subsections;
    }

    public List<MainCategory> getDistinctMainCategories(String subsectionNumber) {

        List<Record> distinctElements = records.stream()
                .filter(e -> Objects.equals(e.getBlockNumber(), subsectionNumber))
                .filter(distinctByKey(Record::getMainCategory))
                .collect(Collectors.toList());

        List<MainCategory> mainCategories = new ArrayList<>();

        distinctElements.forEach((record) -> mainCategories.add(new MainCategory(
                record.getMainCategoryNumber(),
                record.getMainCategory(),
                this.getDistinctDetailedCategories(record.getMainCategoryNumber()))));

        return mainCategories;
    }

    public List<DetailedCategory> getDistinctDetailedCategories(String mainCategoryNumber) {

        List<Record> distinctElements = records.stream()
                .filter(e -> Objects.equals(e.getMainCategoryNumber(), mainCategoryNumber))
                .filter(distinctByKey(Record::getDetailedCategory))
                .collect(Collectors.toList());

        List<DetailedCategory> detailedCategories = new ArrayList<>();

        distinctElements.forEach((record) -> detailedCategories.add(new DetailedCategory(
                record.getDetailedCategoryNumber(),
                record.getDetailedCategory())));

        return detailedCategories;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
