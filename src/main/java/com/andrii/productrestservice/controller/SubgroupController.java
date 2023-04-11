package com.andrii.productrestservice.controller;

import com.andrii.productrestservice.dto.SubgroupDTO;
import com.andrii.productrestservice.model.Subgroup;
import com.andrii.productrestservice.service.SubgroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subgroups")
public class SubgroupController {
    private final SubgroupService subgroupService;

    private final ModelMapper modelMapper;

    @Autowired
    public SubgroupController(SubgroupService subgroupService, ModelMapper modelMapper) {
        this.subgroupService = subgroupService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<SubgroupDTO>> getAllSubgroups(@RequestParam(defaultValue = "id") String sortBy,
                                                             @RequestParam(required = false) String search) {
        return ResponseEntity.ok(subgroupService.getAllSubgroups(sortBy, search).stream().map(this::convertToSubgroupDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubgroupDTO> getSubgroupById(@PathVariable Long id) {
        Optional<Subgroup> subgroup = subgroupService.getById(id);
        return subgroup.map(sb -> ResponseEntity.ok(convertToSubgroupDTO(sb))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<SubgroupDTO> createSubgroup(@RequestBody Subgroup subgroup) {
        return ResponseEntity.ok(convertToSubgroupDTO(subgroupService.save(subgroup)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubgroupDTO> updateSubgroup(@PathVariable Long id,
                                             @RequestBody Subgroup subgroup) {
        Subgroup updatedSubgroup = subgroupService.update(id, subgroup);
        if (updatedSubgroup != null) {
            return ResponseEntity.ok(convertToSubgroupDTO(updatedSubgroup));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubgroup(@PathVariable Long id) {
        Subgroup deletedSubgroup = subgroupService.delete(id);
        if (deletedSubgroup != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private SubgroupDTO convertToSubgroupDTO(Subgroup subgroup) {
        return modelMapper.map(subgroup, SubgroupDTO.class);
    }
}
