package com.juhnkim.projectclassroom.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "authority")
    private String authority;

    @OneToMany(
            mappedBy = "authority",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Account> accountList;

    public Authority() {

    }

    public Authority(String authority) {
        this.authority = authority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
