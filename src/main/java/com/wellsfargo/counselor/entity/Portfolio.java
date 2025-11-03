package com.wellsfargo.counselor.entity;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long portfolioId;

    @CreatedDate
    private LocalDateTime creationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "securities")
    private Set<Security> security;

    public Portfolio() {}

    public long getPortfolioId() {
        return portfolioId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @PostConstruct
    public void onCreate() {
        this.creationDate = LocalDateTime.now();
    }
}
