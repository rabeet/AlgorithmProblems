package Glassdoor;

//URL:https://www.glassdoor.com/Interview/Bloomberg-L-P-Software-Engineer-Interview-Questions-EI_IE3096.0,13_KO14,31_IP10.htm
//Build a data structure to store and retrieve stock values of a given company. 2 Answers

import Utilities.DoublyLinkedList;
import Utilities.Node;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Bloomberg_117 {

	public static void main(String[] args) {
		Stock stock = new Stock(5);
		stock.updatePrice("GOOG", 1);
		stock.updatePrice("GOOG", 3);
		stock.updatePrice("GOOG", 2);
		stock.updatePrice("GOOG", 4);
		stock.updatePrice("GOOG", 1);
		stock.updatePrice("GOOG", 8);
		System.out.println(stock.getPrice("GOOG"));
		System.out.println(stock.getPriceGraph("GOOG"));
		System.out.println(stock.getPrice("BLOOMB"));
	}
}

class Stock {

	private int max_size;
	private Map<String, DoublyLinkedList> stockPrices;

	public Stock(int max_size) {
		stockPrices = new HashMap<>();
		this.max_size = max_size;
	}

	public Integer getPrice(String company) {
		if (stockPrices.containsKey(company))
			return stockPrices.get(company).last.data;
		else return null;
	}

	public void updatePrice(String company, int price) {
		DoublyLinkedList dl = stockPrices.getOrDefault(company, new DoublyLinkedList());
		if (dl.size == max_size) {
			dl.first = dl.first.next;
			dl.first.prev = null;
		}
		dl.addNode(price);
		stockPrices.put(company, dl);
	}

	public String getPriceGraph(String company) {
		if (stockPrices.containsKey(company)) {
			String prices = "";
			Node node = stockPrices.get(company).first;
			while (node != null) {
				prices += prices.isEmpty() ? node.data : " -> " + node.data;
				node = node.next;
			}
			return prices;
		} else return null;
	}

}