package CtCi_v4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prob7_1 {
	
	/*
	 * 7.1: Design a DS for a generic deck of cards. 
	 * Explain how you would subclass it for a particular card game?
	 */

	public static void main(String[] args) {
		
	}
}

class PlayingCard extends Card{
	
	private Integer value;
	private SuitType type;
	
	public PlayingCard() {
		type = new SuitType();
		type.addType("SPADES");
		type.addType("CLUBS");
		type.addType("DIAMONDS");
		type.addType("HEARTS");
	}
	
	public PlayingCard(int v, SuitType type) {
		this.value = v;
		this.type = type;
	}

	Integer getValue() {
		return value;
	}

	String[] getType() {
		return type.getAllTypes();
	}
}

abstract class Card {
	abstract Integer getValue();
	abstract String[] getType();
}

class SuitType {
	private Set<String> types;
	public SuitType() {
		types = new HashSet<String>();
	}
	public boolean addType(String type) {
		return types.add(type);
	}
	public boolean addType(List<String> types) {
		return types.addAll(types);
	}
	public boolean supports(String t) {
		return types.contains(t);
	}
	public String[] getAllTypes() {
		return types.toArray(new String[]{});
	}
	public String toString() {
		return types.size()+"";
	}
}