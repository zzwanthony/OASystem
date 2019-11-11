package com.ksd.zzw.service;

import com.ksd.zzw.dao.IAddressDao;
import com.ksd.zzw.entity.Address;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Resource(name="addressDao")
    private IAddressDao addressDao;

    @Override
    public List getPageAddress(String tableName,Integer currentPage, Integer pageSize) {
        return addressDao.getPageAddress(tableName, currentPage, pageSize);
    }

    @Override
    public Integer getAllCount(String username) {
        return addressDao.getAllCount(username);
    }

    @Override
    public Address getAddress(Integer id) {
        return addressDao.getAddress(id);
    }

    @Override
    public void deleteAddress(Address address) {
        addressDao.deleteAddress(address);
    }

    @Override
    public void modifyAddress(Address address) {
        addressDao.modifyAddress(address);
    }

    @Override
    public void addAddress(Address address) {
        addressDao.addAddress(address);
    }
}
