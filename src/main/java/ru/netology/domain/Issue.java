package ru.netology.domain;

public class Issue implements Comparable<Issue> {
    private int id;
    private String name;
    private String author;
    private String label;
    private String assignee;
    private boolean isOpened;
    private int date;

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }


    public String getLabel() {
        return label;
    }


    public String getAssignee() {
        return assignee;
    }


    public boolean getIsOpened() {
        return isOpened;
    }

    public boolean setIsOpened(boolean opened) {
        this.isOpened = opened;
        return opened;
    }

    public Issue(int id, String name, String author, String label, String assignee, boolean isOpened, int date) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.label = label;
        this.assignee = assignee;
        this.isOpened = isOpened;
        this.date = date;
    }

    @Override
    public int compareTo(Issue o) {
        return date - o.date;
    }
}
