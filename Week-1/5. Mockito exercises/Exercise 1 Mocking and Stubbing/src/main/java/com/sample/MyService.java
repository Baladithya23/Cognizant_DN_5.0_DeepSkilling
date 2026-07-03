package com.sample;

public class MyService {

    private ExternalApi externalApi;

    // Constructor Injection (important for testing)
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}