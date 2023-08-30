package com.example.fashionblog8.Controller;

import com.example.fashionblog8.Model.DesignCategory;
import com.example.fashionblog8.Repository.DesignCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class DesignCategoryController {

    @Autowired
    private DesignCategoryRepository designCategoryRepository;

    @GetMapping
    public List<DesignCategory> getAllDesignCategories() {
        return designCategoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesignCategory> getDesignCategoryById(@PathVariable Long id) {
        DesignCategory category = designCategoryRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        return ResponseEntity.ok(category);
    }

    @PostMapping("designctegory")
    public DesignCategory createDesignCategory(@RequestBody DesignCategory category) {
        return designCategoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesignCategory> updateDesignCategory(@PathVariable Long id, @RequestBody DesignCategory updatedCategory) {
        DesignCategory category = designCategoryRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        category.setName(updatedCategory.getName());

        DesignCategory updated = designCategoryRepository.save(category);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDesignCategory(@PathVariable Long id) {
        DesignCategory category = designCategoryRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        designCategoryRepository.delete(category);
        return ResponseEntity.noContent().build();
    }
}
