package com.iyb.ak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlDto {
    private String url;
    private String method;
    private Set<String> permissions;

    public UrlDto(String url, String method) {
        this.url = url;
        this.method = method;
    }
}