package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueRepository {
    private List<Issue> issues = new ArrayList<>();

    public Collection<Issue> getAll() {
        return issues;
    }

    public boolean save(Issue issue) {
        return issues.add(issue);
    }

}
