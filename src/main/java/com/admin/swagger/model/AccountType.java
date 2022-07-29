package com.admin.swagger.model;

public enum AccountType {

    CHECKING,
    SAVING,
    FIXED;

    public boolean isWithdraw(){
        return switch (this) {
            case CHECKING, SAVING -> true;
            case FIXED -> false;
        };
    }
}
