package services;

import domain.*;

import javax.enterprise.inject.Default;
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
@Default
public class ICDBuilder {

    private List<Record> records = new ICDClient().getICDRecords();

    public Classification getAllClassification() {
        return new Classification(this.getDistinctSections());
    }

    private List<Section> getDistinctSections() {

        List<Record> distinctElements = records.stream()
                .filter(distinctByKey(Record::getSection))
                .collect(Collectors.toList());

        List<Section> sections = new ArrayList<>();

        distinctElements.forEach((record) -> sections.add(new Section(
                record.getSectionNumber(),
                record.getSection(),
                this.getDistinctSubsections(record.getSectionNumber()))));

        return sections;
    }

    private List<Subsection> getDistinctSubsections(String section) {

        List<Record> distinctElements = records.stream()
                .filter(e -> Objects.equals(e.getSectionNumber(), section))
                .filter(distinctByKey(Record::getSubsection))
                .collect(Collectors.toList());

        List<Subsection> subsections = new ArrayList<>();

        distinctElements.forEach((record) -> subsections.add(new Subsection(
                record.getSubsectionNumber(),
                record.getSubsection(),
                this.getDistinctMainCategories(record.getSubsectionNumber()))));

        return subsections;
    }

    private List<MainCategory> getDistinctMainCategories(String subsectionNumber) {

        List<Record> distinctElements = records.stream()
                .filter(e -> Objects.equals(e.getSubsectionNumber(), subsectionNumber))
                .filter(distinctByKey(Record::getMainCategory))
                .collect(Collectors.toList());

        List<MainCategory> mainCategories = new ArrayList<>();

        distinctElements.forEach((record) -> mainCategories.add(new MainCategory(
                record.getMainCategoryNumber(),
                record.getMainCategory(),
                this.getDistinctDetailedCategories(record.getMainCategoryNumber()))));

        return mainCategories;
    }

    private List<DetailedCategory> getDistinctDetailedCategories(String mainCategoryNumber) {

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
