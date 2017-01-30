package com.example.mockito;

import java.util.List;

import static java.util.Arrays.asList;

public class AddressSplitter {

    private AddressInputQueue addressInputQueue;

    public List<String> split() {
        return asList(addressInputQueue.next().split(","));
    }

}
