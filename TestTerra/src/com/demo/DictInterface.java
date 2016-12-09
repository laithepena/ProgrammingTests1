package com.demo;

import java.util.Iterator;

public interface DictInterface < K, V > {
	public V add (K key, V value);
	public V remove (K key);
	public boolean contains (K key);
	public V getValue (K key);
	public void prefixSearch (String prefix);
	public void displayAll ();
	public int getSize ();
}
