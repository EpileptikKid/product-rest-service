package com.andrii.productrestservice.service;

import com.andrii.productrestservice.model.Group;
import com.andrii.productrestservice.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private  final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getAllGroups(String sortBy, String search) {
        List<Group> groups;
        if (search != null) {
            groups = groupRepository.findByNameContainingOrGroupDescriptionContaining(search, search);
        } else {
            groups = groupRepository.findAll();
        }

        switch (sortBy) {
            case "id" -> groups.sort(Comparator.comparing(Group::getId));
            case "name" -> groups.sort(Comparator.comparing(Group::getName));
            case "description" -> groups.sort(Comparator.comparing(Group::getGroupDescription));
        }

        return groups;
    }

    public Optional<Group> getById(Long id) {
        return groupRepository.findById(id);
    }

    public Group save(Group group) {
        return groupRepository.save(group);
    }

    public Group update(Long id, Group group) {
        Optional<Group> existingGroup = groupRepository.findById(id);
        if (existingGroup.isPresent()) {
            group.setId(id);
            return groupRepository.save(group);
        } else {
            return null;
        }
    }

    public Group delete(Long id) {
        Optional<Group> group = groupRepository.findById(id);
        if (group.isPresent()) {
            groupRepository.deleteById(id);
            return group.get();
        } else {
            return null;
        }
    }
}
