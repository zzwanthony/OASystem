package com.ksd.zzw.actions;

import com.ksd.zzw.entity.Address;
import com.ksd.zzw.service.AddressService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.util.Map;

public class AddressAction extends ActionSupport implements ModelDriven<Address> {

    @Resource(name = "addressService")
    AddressService addressService;

    private String method;
    private Address address = new Address();

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String dealAddress() {
        if ("toadd".equals(method)) {
            return "toadd";
        } else if ("toedit".equals(method)) {
            address = addressService.getAddress(address.getId());
            Map map = (Map) ActionContext.getContext().get("request");
            map.put("address", address);
            return "toedit";
        } else if ("delete".equals(method)) {
            addressService.deleteAddress(address);
            return "success";
        } else if ("add".equals(method)) {
            addressService.addAddress(address);
            return "success";
        } else if ("modify".equals(method)) {
            addressService.modifyAddress(address);
            return "success";
        } else
            return "error";
    }

    @Override
    public Address getModel() {
        return this.address;
    }
}
