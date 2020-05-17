package com.allen.dao;

import com.allen.domain.Account;
import com.allen.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有用户
     * @return
     */
    List<Account> findAll();

    List<AccountUser> findAllAccount();


}
