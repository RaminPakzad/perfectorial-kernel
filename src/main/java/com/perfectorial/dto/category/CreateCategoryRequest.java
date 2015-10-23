package com.perfectorial.dto.category;

import com.perfectorial.dto.Executor;
import com.perfectorial.logic.CategoryLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mohsen Ebrahimi
 */
@Service
public class CreateCategoryRequest implements Executor<CategoryDto, CategoryDto> {
    @Autowired
    private CategoryLogic categoryLogic;

    @Override
    public CategoryDto execute(CategoryDto categoryDto) {
        categoryLogic.create(categoryDto.asEntity());
        return categoryDto;
    }
}
