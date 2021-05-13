package com.gateway.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.AssertTrue;

@Data
public class User {
    private String id;
    private String username;
    @AssertTrue
    public boolean ok() {
        if (StringUtils.isEmpty(username)) {
            return true;
        }
        return false;
    }

}
