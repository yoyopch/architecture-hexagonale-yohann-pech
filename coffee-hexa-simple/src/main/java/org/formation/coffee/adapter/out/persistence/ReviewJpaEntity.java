package org.formation.coffee.adapter.out.persistence;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class ReviewJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Nullable Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "coffee_id", nullable = false)
    private CoffeeJpaEntity coffee;

    protected ReviewJpaEntity() {

    }

    public @Nullable Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }
}
