package com.ohgiraffers.section02.reflection;

public class Account {

    private String bankCode;
    private String accNo;
    private String accPwd;
    private int balance;

    public Account() {
    }

    public Account(String bankCode, String accNo, String accPwd) {
        this.bankCode = bankCode;
        this.accNo = accNo;
        this.accPwd = accPwd;
    }

    public Account(String bankCode, String accNo, String accPwd, int balance) {
        this(bankCode, accNo, accPwd);
        this.balance = balance;
    }

    public String deposit (int money){

        String str = "";

        if(money > 0) {
            this.balance -= money;
            str = money + "원이 입금";
        }else{
            str = "임금 잘못 입력 됨";
        }
        return str;
    }

    public String withdraw (int money){
        String str = "";

        if(this.balance >= money) {
            this.balance -= money;
            str = money + "원이 출금";
        }else{
            str = "잔액 부족스";
        }
        return str;
    }
}
