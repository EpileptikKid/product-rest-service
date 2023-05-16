package com.andrii.productrestservice.dto;

import com.andrii.productrestservice.model.Group;
import org.springframework.stereotype.Component;

@Component
public class SubgroupDTO {
    private Long id;
    private String name;
    private String subgroupDescription;
    private Long group;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSubgroupDescription() { return subgroupDescription; }

    public void setSubgroupDescription(String subgroupDescription) { this.subgroupDescription = subgroupDescription; }

    public long getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group.getId();
    }
}
