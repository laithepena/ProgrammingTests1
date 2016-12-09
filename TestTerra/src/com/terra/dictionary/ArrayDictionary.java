package com.terra.dictionary;

import java.util.Arrays;


public class ArrayDictionary<K, V> implements DictInterface<K, V>
{
	private Entry<K, V>[] dictionary; // array of unsorted entries
	private int numberOfEntries;
	private final static int DEFAULT_CAPACITY = 25;
	public ArrayDictionary()
	{
		this(DEFAULT_CAPACITY); // call next constructor
	} // end default constructor
	public ArrayDictionary(int initialCapacity)
	{
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		Entry<K, V>[] tempDictionary =
		(Entry<K, V>[])new Entry[initialCapacity];
		dictionary = tempDictionary;
		numberOfEntries = 0;
	} // end constructor


//###### INNER CLASS STARTS ############################
	private class Entry<S, T>
	{
		private S key;
		private T value;
		private Entry(S searchKey, T dataValue)
		{
			key = searchKey;
			value = dataValue;
		} // end constructor
		private S getKey()
		{
			return key;
		} // end getKey
		private T getValue()
		{

			return value;
		} // end getValue
		private void setValue(T newValue)
		{
			value = newValue;
		} // end setValue
	} // end Entry
	
//###### INNER CLASS ENDS ############################


	@Override
	public V add(K key, V value)
	{
		V result = null;
		
		// Handling of invalid entries 
		if (key==null || value==null || key=="" || value==""){
			System.out.println("....!!!..WARNING: --- Some enterered Key/Value - either the WORD or the MEANING is not Proper or Supported - Invalid Key/Value ones will be ignored" );
					
		return result;
		}
		
		int keyIndex = locateIndex(key);
		if (keyIndex < numberOfEntries)
		{
			// key found; return and replace old value
			result = dictionary[keyIndex].getValue();
			dictionary[keyIndex].setValue(value);
		}
		else
		{
			ensureCapacity();
			dictionary[numberOfEntries] = new Entry<K, V>(key, value);
			numberOfEntries++;
		} // end if
		return result;
	} // end add

	private void ensureCapacity()
	{
		if (numberOfEntries == dictionary.length)
			dictionary = Arrays.copyOf(dictionary, 2 * dictionary.length);
	} // end ensureCapacity

	private int locateIndex(K key)
	{
		int index = 0; int ex=0;
		while ( (index < numberOfEntries) &&
				!key.equals(dictionary[index].getKey()) )
			{index++;
			
			}
	
		return index;
		
		
	} //
	@Override
	public V remove(K key)
	{
		V result = null;
		int keyIndex = locateIndex(key);

		System.out.println("remove keyIndex  "+keyIndex);

		if (keyIndex < numberOfEntries)
		{
			result = dictionary[keyIndex].getValue();
			dictionary[keyIndex] = dictionary[numberOfEntries - 1];
			numberOfEntries--;
		} // end
		return result;
	} // end remove
	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		V result = null;
		int keyIndex = locateIndex(key);

		System.out.println("getValue keyIndex  "+keyIndex);

		result = dictionary[keyIndex].getValue();


		return result;
	}
	@Override
	public boolean contains(K key) {
		
		int index = 0;  boolean b=false;
		while (index < numberOfEntries )//&& key.equals(dictionary[index].getKey())) 
				{
						
			if(key.equals(dictionary[index].getKey())){
				return true;
			}
			index++;
			}
		
		
		return false;
	}
	
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		int size = 0;  
		while (size < numberOfEntries )//&& key.equals(dictionary[index].getKey())) 
				{
				size++;
			}
		return size;
	}
	
	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		int index = 0;
		while (index < numberOfEntries){
			//		System.out.println(" "+key+" "+"index  "+index+" "+dictionary[index].getValue());
			System.out.println("key "+dictionary[index].getKey()+"  "+"value "+dictionary[index].getValue());

			index++;
		}
	}
	@Override
	public void prefixSearch(String prefix) {
		int index = 0;  boolean b=false;
		
		while (index < numberOfEntries )//&& key.equals(dictionary[index].getKey())) 
				{
						
				if(dictionary[index].getKey().toString().startsWith(prefix))
			{
				System.out.println("Results for Prefix "+prefix+" --- "+dictionary[index].getKey());
			}
			index++;
			}
		
	}
} 