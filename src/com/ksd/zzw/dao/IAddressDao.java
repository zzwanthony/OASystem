package com.ksd.zzw.dao;

import com.ksd.zzw.entity.Address;

import java.util.List;

public interface IAddressDao {
    List<Address> getPageAddress(String tableName, Integer currentPage, Integer pageSize);

    Integer getAllCount(String username);

    void deleteAddress(Address id);

    Address getAddress(Integer id);

    void addAddress(Address address);

    void modifyAddress(Address address);
}
