package com.perfectorial.dto;

/**
 * @author Mohsen Ebrahimi
 */
public interface Executor<I extends RequestDto, O extends ResponseDto> {
    O execute(I input);
}
