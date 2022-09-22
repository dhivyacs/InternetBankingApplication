package com.company;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Main {

    public static void main(String[] args) {

        List<TransactionDetail> details = Arrays.asList(
                new TransactionDetail(LocalDate.of(2020, Month.NOVEMBER, 01), "Morrisons", "card", 10.40, "Groceries"),
                new TransactionDetail(LocalDate.of(2020, Month.OCTOBER, 28), "CYBG", "direct debit", 600.00, "MyMonthlyDD"),
                new TransactionDetail(LocalDate.of(2020, Month.OCTOBER, 28), "PureGym", "direct debit", 40.00, "MyMonthlyDD"),
                new TransactionDetail(LocalDate.of(2020, Month.OCTOBER, 01), "M&S", "card", 5.99, "Groceries"),
                new TransactionDetail(LocalDate.of(2020, Month.SEPTEMBER, 30), "McMillan", "internet", 10.00, "")
        );

        Logger logger = LogManager.getLogger(Main.class);

        Scanner scanner = new Scanner(System.in);

        logger.debug("Enter category name - ");

        String categoryName = scanner.nextLine();

        logger.debug("Enter year - ");

        int year = scanner.nextInt();

        //All transactions for a given category - latest first
        logger.debug("Display all transactions for given category : " +categoryName);
        List<TransactionDetail> result = details.stream().filter(t -> t.getCategory().equals(categoryName))
                .sorted(Comparator.comparing(TransactionDetail::getTransactionDate).reversed())
                .collect(Collectors.toList());

        result.forEach(s -> logger.debug(s.toString()));

        //Total outgoing per category
        Double totalAmount = details.stream().filter(t -> t.getCategory().equals(categoryName))
                .mapToDouble(x -> x.getAmount())
                .sum();

        logger.debug("Display total amount for given category " +categoryName + ":" +totalAmount);

        //Monthly average spend in a given category
        OptionalDouble averageSpend = details.stream().filter(t -> t.getCategory().equals(categoryName))
                .mapToDouble(x -> x.getAmount())
                .average();

        if(averageSpend.isPresent()) {
            logger.debug("Display average spend for given category " +categoryName + ":" +averageSpend.getAsDouble());
        }

        //Highest spend in a given category, for a given year
        logger.debug("Display highest spend transaction for given category " +categoryName + " -");
        details.stream().filter(t -> t.getTransactionDate().getYear() == 2020)
                .filter(t -> t.getCategory().equals(categoryName))
                .sorted(Comparator.comparingDouble(TransactionDetail::getAmount).reversed())
                .findFirst().ifPresent(s -> logger.debug(s.toString()));


        //Lowest spend in a given category, for a given year
        logger.debug("Display lowest spend transaction for given category " +categoryName + " -");
        details.stream().filter(t -> t.getTransactionDate().getYear() == 2020)
                .filter(t -> t.getCategory().equals(categoryName))
                .sorted(Comparator.comparingDouble(TransactionDetail::getAmount))
                .findFirst().ifPresent(s -> logger.debug(s.toString()));
    }
}
