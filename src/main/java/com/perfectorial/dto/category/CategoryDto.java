package com.perfectorial.dto.category;

import com.perfectorial.dto.AbstractDescriptorDto;
import com.perfectorial.entity.Category;
import org.springframework.beans.BeanUtils;

/**
 * @author Mohsen Ebrahimi
 */
public class CategoryDto extends AbstractDescriptorDto {

    @Override
    // TODO: Plz help. Who can solve the following warning: 'Unchecked Warning' :(
    public Category asEntity() {
        Category category = new Category();
        BeanUtils.copyProperties(this, category);
        return category;
    }
}
