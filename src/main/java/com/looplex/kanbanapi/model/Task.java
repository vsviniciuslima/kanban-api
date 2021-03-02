package com.looplex.kanbanapi.model;

import lombok.*;

import javax.persistence.*;

@Data @NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    private @Id @GeneratedValue Long id;

    @Column (name = "description")
    private String description;

    public Task(String description, String document, String status, String responsible, String creationDate, String dueDate, String[] tags) {
        this.description = description;
        this.document = document;
        this.status = status;
        this.responsible = responsible;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.tags = tags;
    }

    @Column (name = "document")
    private String document;
    @Column(name = "status")
    private String status;
    @Column(name = "responsible")
    private String responsible;
    @Column(name = "creationDate")
    private String creationDate;
    @Column(name = "dueDate")
    private String dueDate;
    @Column(name = "tags")
    private String[] tags;

    private void setId() { }
}
