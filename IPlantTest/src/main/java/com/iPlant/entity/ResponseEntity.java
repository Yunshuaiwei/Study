package com.iPlant.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author yunshuaiwei
 * @className ResponseEntity
 * @description: TODO
 * @date 2022/4/16 0:13
 */
@Data
@Builder
public class ResponseEntity {
    private String msg;
    private Object data;
    private String code;
}
