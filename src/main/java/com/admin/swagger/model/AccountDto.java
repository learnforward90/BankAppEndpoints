package com.admin.swagger.model;


import lombok.Data;

@Data
public class AccountDto {

    Integer clientId;
    String accountType;

    public AccountType getAccountType() {
        AccountType ans = switch (this.accountType) {
            case "FIXED"    -> AccountType.FIXED;
            case "SAVING"   -> AccountType.SAVING;
            case "CHECKING" -> AccountType.CHECKING;
            default -> null;
        };
        return ans;
    }
}
