package com.mati.springshop.common;

import java.util.ArrayList;
import java.util.List;

public class PagedResult<T> {

    List<T> data;
    int pageNumber;
    int totalPages;

    public PagedResult(ArrayList<T> data, int pageNumber, int totalPages) {
    }
}
