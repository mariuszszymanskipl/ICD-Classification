package services;

import domain.Category;
import domain.Section;
import domain.Subsection;

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
public class ICDService {

    private ICDClassification icdClassification = new ICDClassification();

    private List<Category> categories = icdClassification.getICDclassification();

    public List<Section> getDistinctSections() {

        List<Category> distinctElements = categories.stream()
                .filter(distinctByKey(Category::getChapter))
                .collect(Collectors.toList());

        List<Section> sections = new ArrayList<>();

        distinctElements.forEach((record) -> sections.add(new Section(
                record.getChapterNumber(),
                record.getChapter(),
                this.getDistinctSubsections(record.getChapterNumber()))));

        return sections;
    }

    public List<Subsection> getDistinctSubsections(String section) {

        List<Category> distinctElements = categories.stream()
                .filter(e -> Objects.equals(e.getChapterNumber(), section))
                .collect(Collectors.toList());

        List<Subsection> subsections = new ArrayList<>();

        distinctElements.forEach((record) -> subsections.add(new Subsection(
                record.getBlockNumber(),
                record.getBlock())));

        return subsections;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
