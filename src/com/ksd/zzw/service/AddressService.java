package com.ksd.zzw.service;

import com.ksd.zzw.entity.Address;

import java.util.List;

public interface AddressService {
    List getPageAddress(String tableName, Integer currentPage, Integer pageSize);

    Integer getAllCount(String username);

    Address getAddress(Integer id);

    void deleteAddress(Address address);

    void modifyAddress(Address address);

    void addAddress(Address address);
}
