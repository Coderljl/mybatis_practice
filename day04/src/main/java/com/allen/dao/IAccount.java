package com.allen.dao;

import com.allen.domain.Account;
import com.allen.domain.AccountUser;

import java.util.List;

public interface IAccount  {
    /**
     * 查询所有用户
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户带有用户信息
     * @return
     */
    List<AccountUser> findAllAccoun();
}
