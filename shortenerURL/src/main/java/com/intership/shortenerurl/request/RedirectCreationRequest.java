package com.intership.shortenerurl.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class RedirectCreationRequest {
    @NotNull
    private String alias;
    @NotNull
    private String url;

    public RedirectCreationRequest(final String alias, final String url) {
        this.alias = alias;
        this.url = url;
    }


}