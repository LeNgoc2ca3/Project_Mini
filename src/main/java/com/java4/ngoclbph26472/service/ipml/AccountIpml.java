package com.java4.ngoclbph26472.service.ipml;

import com.java4.ngoclbph26472.dto.AccountDTO;
import com.java4.ngoclbph26472.dto.ProductDTO;
import com.java4.ngoclbph26472.entity.Account;
import com.java4.ngoclbph26472.repositories.AccountRepo;
import com.java4.ngoclbph26472.service.AccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountIpml implements AccountService {

    @Autowired
    AccountRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<AccountDTO> getAll() {
        List<Account> listAccount = repo.findAll();
        TypeToken<List<AccountDTO>> typeToken = new TypeToken<>() {
        };
        List<AccountDTO> listAccountDTO = mapper.map(listAccount, typeToken.getType());
        return listAccountDTO;
    }
}
