package com.alekstar.yourmoneysaver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alekstar.yourmoneysaver.exceptions.ArgumentIsNullException;

@Entity
@Table(name = "AccountTypes")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String comments;

    @SuppressWarnings("unused")
    private AccountType() {

    }

    public AccountType(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getComments() {
        return comments;
    }

    @SuppressWarnings("unused")
    private void setId(long id) {
        this.id = id;
    }

    private void setName(String name) {
        if (name == null) {
            throw new ArgumentIsNullException("name");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty.");
        }
        this.name = name;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
