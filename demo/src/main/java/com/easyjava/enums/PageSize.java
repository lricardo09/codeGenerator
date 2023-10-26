package com.easyjava.enums;

public enum PageSize {
    PAGE_SIZE5(5),
    PAGE_SIZE10(10),
    PAGE_SIZE15(15),
    PAGE_SIZE20(20),
    PAGE_SIZE25(25);
    private  int size;
     PageSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
