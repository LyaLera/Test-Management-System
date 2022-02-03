package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.ru.netology.repository.IssueRepository;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleIssueManagerTest {
    IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);


    Issue first = new Issue(1, "name1", "author1", "label1", "assignee2", true, 1);
    Issue second = new Issue(2, "name2", "author1", "label2", "assignee2", false, 2);
    Issue third = new Issue(3, "name3", "author2", "label1", "assignee1", false, 3);
    Issue fourth = new Issue(4, "name4", "author1", "label2", "assignee2", true, 1);
    Issue fifth = new Issue(5, "name5", "author2", "label2", "assignee2", false, 2);
    Issue sixth = new Issue(6, "name6", "author2", "label1", "assignee1", true, 4);
    Issue seventh = new Issue(7, "name7", "author1", "label1", "assignee1", false, 3);
    Issue eighth = new Issue(8, "name8", "author2", "label2", "assignee2", true, 5);
    Issue ninth = new Issue(9, "name9", "author1", "label2", "assignee2", true, 1);
    Issue tenth = new Issue(10, "name10", "author2", "label1", "assignee1", false, 6);
    Issue eleventh = new Issue(11, "name11", "author1", "label2", "assignee1", false, 4);

    @BeforeEach
    public void setUp() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
    }

    @Test
    public void shouldFindIfOpened() {

        Collection<Issue> actual = manager.findIfOpened(true);
        Collection<Issue> expected = List.of(first, fourth, ninth, sixth, eighth);

        assertEquals(expected, actual);
    }


    @Test
    public void shouldOpenById() {

        manager.openById(10);

        assertTrue(tenth.getIsOpened());
    }

    @Test
    public void shouldCloseById() {

        manager.closeById(6);

        assertFalse(sixth.getIsOpened());
    }

    @Test
    public void shouldFilterByAuthor() {

        Collection<Issue> actual = manager.filterByAuthor("AUTHOR1");
        Collection<Issue> expected = List.of(first, fourth, ninth, second, seventh, eleventh);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByLabel() {

        Collection<Issue> actual = manager.filterByLabel("LABEL2");
        Collection<Issue> expected = List.of(fourth, ninth, second, fifth, eleventh, eighth);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAssignee() {

        Collection<Issue> actual = manager.filterByAssignee("ASSIGNEE1");
        Collection<Issue> expected = List.of(third, seventh, sixth, eleventh, tenth);

        assertEquals(expected, actual);
    }

}
