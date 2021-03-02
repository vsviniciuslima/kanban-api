package com.looplex.kanbanapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    private @Id @GeneratedValue Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    private @Column(name = "description") String description;
    private @Column(name = "document") String document;
    private @Column(name = "status") String status;
    private @Column(name = "responsible") String responsible;
    private @Column(name = "creationDate") String creationDate;
    private @Column(name = "dueDate") String dueDate;
    //private @Column(name = "tags") String[] tags;

    public Task(String description, String document, String status, String responsible, String creationDate, String dueDate, String[] tags) {
        this.description = description;
        this.document = document;
        this.status = status;
        this.responsible = responsible;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        //this.tags = tags;
    }

    public Task() {}



    private void setId() { }
}
