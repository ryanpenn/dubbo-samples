package cn.ryanpenn.dubbo.samples.sample.consumer.web.viewmodel;

import lombok.Builder;
import lombok.Data;

/**
 * RestResult
 */
@Data
@Builder
public class RestResult {
    private int code;
    private String msg;
    private Object data;
}
