package com.andrii.productrestservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "subgroups")
public class Subgroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "subgroup_description")
    private String subgroupDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    public Subgroup() {}

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

    public String getSubgroupDescription() {
        return subgroupDescription;
    }

    public void setSubgroupDescription(String subgroupDescription) {
        this.subgroupDescription = subgroupDescription;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
