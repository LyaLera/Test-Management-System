package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.ru.netology.repository.IssueRepository;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmptyIssueManagerTest {
    IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);


    Issue first = new Issue(1, "name1", "author1", "label1", "assignee2", true, 1);
    Issue second = new Issue(2, "name2", "author1", "label2", "assignee2", false, 2);

    @Test
    public void shouldNotFindIfOpenedIfEmpty() {

        Collection<Issue> actual = manager.findIfOpened(true);
        Collection<Issue> expected = List.of();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotOpenByIdIfEmpty() {

        manager.openById(2);

        assertFalse(second.getIsOpened());
    }

    @Test
    public void shouldNotCloseByIdIfEmpty() {

        manager.closeById(1);

        assertTrue(first.getIsOpened());
    }

    @Test
    public void shouldNotFilterByAuthorIfEmpty() {

        Collection<Issue> actual = manager.filterByAuthor("author2");
        Collection<Issue> expected = List.of();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFilterByLabelIfEmpty() {

        Collection<Issue> actual = manager.filterByLabel("label1");
        Collection<Issue> expected = List.of();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFilterByAssigneeIfEmpty() {

        Collection<Issue> actual = manager.filterByAssignee("assignee1");
        Collection<Issue> expected = List.of();

        assertEquals(expected, actual);
    }

}