package com.perfectorial.dto;

import com.perfectorial.entity.Entity;

/**
 * @author Mohsen Ebrahimi
 */
public interface IsEntity {
    <T extends Entity> T asEntity();
}
