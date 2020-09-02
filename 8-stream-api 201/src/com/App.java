package com;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

import com.model.Trader;
import com.model.Transaction;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
public class App {
	
	public static void main(String[] args) {
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2012, 1000),
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710),
		new Transaction(mario, 2012, 700),
		new Transaction(alan, 2012, 950)
		);
		
		//--------------------------------------------------------
		//Finds all transactions in 2011 and sort by value (small to high)
		//--------------------------------------------------------
		
		List<Transaction> tr2011=
				transactions.stream()
				.filter(transaction->transaction.getYear()==2011)
				.sorted(comparing(Transaction::getValue))
				.collect(toList());
		
		//--------------------------------------------------------
		//What are all the unique cities where the traders work?
		//--------------------------------------------------------
		
		Set<String>  cities=
				transactions.stream()
				.map(transaction->transaction.getTrader().getCity())
				.distinct()
				.collect(toSet());
		
		//--------------------------------------------------------
		// Find all traders from Cambridge and sort them by name
		//--------------------------------------------------------
		
		List<Trader> traders=
				transactions.stream()
				.map(Transaction::getTrader)
				.filter(trader->trader.getCity().equals("Cambridge"))
				.distinct()
				.sorted(comparing(Trader::getName))
				.collect(toList());
		
		//--------------------------------------------------------
		//Return a string of all traders’ names sorted alphabetically.
		//--------------------------------------------------------
		
		String traderStr=
				transactions.stream()
				.map(transaction->transaction.getTrader().getName())
				.distinct()
				.sorted()
				//.reduce("", (n1,n2)->n1+n2);
				.collect(joining(",","{","}"));
		
		
		
		//--------------------------------------------------------
		//Are any traders based in Milan?
		//--------------------------------------------------------
		
		boolean milanBased=
				transactions.stream()
				.anyMatch(transaction->transaction.getTrader().getCity().equals("Milan"));
		
		//--------------------------------------------------------
		//Print the values of all transactions from the traders living in Cambridge.
		//--------------------------------------------------------
		
		
		transactions.stream()
		.filter(t->"Cambridge".equals(t.getTrader().getCity()))
		.map(Transaction::getValue)
		.forEach(System.out::println);
				            
		
		//--------------------------------------------------------
		//What’s the highest value of all the transactions?
		//--------------------------------------------------------
		
		OptionalInt optional=
				transactions.stream()
				.mapToInt(Transaction::getValue)
				.max();
		
		System.out.println(optional.getAsInt());
		
		
		//--------------------------------------------------------
		//Find the transaction with the smallest value.
		//--------------------------------------------------------
		
		 optional=
				transactions.stream()
				.mapToInt(Transaction::getValue)
				.min();
		
		System.out.println(optional.getAsInt());
		
		
		
		
		
	}

}
