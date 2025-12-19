package com.saurabh.interface_segregation_principle.BadCode;

interface Machine {
    void print(Document doc);

    void scan(Document doc);

    void fax(Document doc);
}
