package com.sweb.bestlunch.entities.lunch;

import com.sweb.bestlunch.entities.lunch.LunchSet;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SearchTag {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NaturalId
    private String name;
    @ManyToMany(mappedBy = "tags",fetch = FetchType.LAZY)
    private List<LunchSet> lunchSets= new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LunchSet> getLunchSets() {
        return lunchSets;
    }

}
