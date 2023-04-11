package com.andrii.productrestservice.service;

import com.andrii.productrestservice.model.Subgroup;
import com.andrii.productrestservice.repository.SubgroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class SubgroupService {
    private final SubgroupRepository subgroupRepository;

    @Autowired
    public SubgroupService(SubgroupRepository subgroupRepository) {
        this.subgroupRepository = subgroupRepository;
    }

    public List<Subgroup> getAllSubgroups(String sortBy, String search) {
        List<Subgroup> subgroups;
        if (search != null) {
            subgroups = subgroupRepository.findByNameContainingOrSubgroupDescriptionContaining(search, search);
        } else {
            subgroups = subgroupRepository.findAll();
        }

        switch (sortBy) {
            case "id" -> subgroups.sort(Comparator.comparing(Subgroup::getId));
            case "name" -> subgroups.sort(Comparator.comparing(Subgroup::getName));
            case "description" -> subgroups.sort(Comparator.comparing(Subgroup::getSubgroupDescription));
        }

        return subgroups;
    }

    public Optional<Subgroup> getById(Long id) {
        return subgroupRepository.findById(id);
    }

    public Subgroup save(Subgroup subgroup) {
        return subgroupRepository.save(subgroup);
    }

    public Subgroup update(Long id, Subgroup subgroup) {
        Optional<Subgroup> existingSubgroup = subgroupRepository.findById(id);
        if (existingSubgroup.isPresent()) {
            subgroup.setId(id);
            return subgroupRepository.save(subgroup);
        } else {
            return null;
        }
    }

    public Subgroup delete(Long id) {
        Optional<Subgroup> subgroup = subgroupRepository.findById(id);
        if (subgroup.isPresent()) {
            subgroupRepository.deleteById(id);
            return subgroup.get();
        } else {
            return null;
        }
    }
}
