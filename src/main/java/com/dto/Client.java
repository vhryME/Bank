package com.dto;


import com.model.Account;
import com.model.Count;

import java.util.List;


//DTO for Account
public class Client {
    private Account account;
    private List<Count> counts;


    public Client() {}

    public Client(Account account, List<Count> counts) {
        this.account = account;
        this.counts = counts;
    }


    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    public List<Count> getCounts() { return counts; }
    public void setCounts(List<Count> counts) { this.counts = counts; }
}
