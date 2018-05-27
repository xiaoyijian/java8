package com.xyj.java8.ch01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.xyj.java8.ch01.domain.Currency;
import com.xyj.java8.ch01.domain.Transaction;

/**
 * 筛选金额超过1000，按照货币分组
 */
public class TransactionTest {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        groupTransaction(transactions);
        groupTransaction2(transactions);

    }

    /**
     * 根据金额过滤
     * 按照货币分组
     * @param transactions
     * @return
     */
    public static Map<Currency, List<Transaction>> groupTransaction(List<Transaction> transactions) {
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) {
            if (transaction.getPrice() > 1000) {
                Currency currency = transaction.getCurrency();
                List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
                if (transactionsForCurrency == null) {
                    transactionsForCurrency = new ArrayList<>();
                    transactionsByCurrencies.put(currency, transactionsForCurrency);
                }
                transactionsForCurrency.add(transaction);
            }
        }
        return transactionsByCurrencies;
    }

    /**
     * stream api
     * @param transactions
     * @return
     */
    public static Map<Currency, List<Transaction>> groupTransaction2(List<Transaction> transactions) {
        return transactions.stream().filter((Transaction transaction) -> transaction.getPrice() > 100).collect(Collectors.groupingBy(Transaction::getCurrency));
    }

}
