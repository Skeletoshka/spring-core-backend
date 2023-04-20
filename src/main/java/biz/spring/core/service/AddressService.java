package biz.spring.core.service;

import biz.spring.core.model.Address;
import biz.spring.core.repository.AddressRepository;
import biz.spring.core.utils.OrmUtils;
import biz.spring.core.validator.AddressValidator;
import biz.spring.core.view.AddressView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AddressService extends BaseService<Address>{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressValidator addressValidator;

    @Value("classpath:/script/address/find.sql")
    Resource findSql;

    @Override
    protected void init() {
        init(addressRepository, addressValidator);
    }

    public List<AddressView> find(String search){
        return addressRepository.findListForObject(OrmUtils.loadResource(findSql), Map.of("search", search), AddressView.class);
    }
}
