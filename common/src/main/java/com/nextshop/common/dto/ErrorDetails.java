package com.nextshop.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Srinivas Velishetti
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private String timestamp;
    private String message;
    private String details;
}
