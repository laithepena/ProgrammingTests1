package com.demo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDictionary<K, V> implements DictInterface<K, V>
{
	//private Entry<K, V>[] dictionary; // array of unsorted entries
	
	private List<Entry<K,V>>[] dictionary2;
	
	//private List<dictionary>[] dictionary2;
	
	private int numberOfEntries;
	private final static int DEFAULT_CAPACITY = 25;
	public ListDictionary()
	{
		this(DEFAULT_CAPACITY); // call next constructor
	} // end default constructor
	public ListDictionary(int initialCapacity)
	{
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		/*Entry<K, V>[] tempDictionary =(Entry<K, V>[])new Entry[initialCapacity];
		dictionary = tempDictionary;*/
		
		List<Entry<K, V>>[] tempDictionary2 =new ArrayList[initialCapacity];
		dictionary2 =  tempDictionary2;
		
		
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



	public V add(K key, V value)
	{
		V result = null;
		int keyIndex = locateIndex(key);  //3 
		
		System.out.println("from add keyIndex ------- "+keyIndex);
		//System.out.println("locate index - dictionary2[0].hashCode())%25 = "+dictionary2[0].hashCode()%25);

		if (dictionary2[keyIndex] == null)
		{
			dictionary2[keyIndex]=new ArrayList<Entry<K,V>>();
			
		}
		//else{
			ensureCapacity();
		dictionary2[keyIndex].add(new Entry<K, V>(key, value));
		
		numberOfEntries++;
		//}
		
		/*System.out.println(keyIndex +" "+ key);
		
		System.out.println(dictionary2[keyIndex].get(0).getValue());*/
		return result;
	} // end add
	
	
	/*public V add1(K key, V value)
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
*/
	private void ensureCapacity()
	{
		if (numberOfEntries == dictionary2.length)
			dictionary2 = Arrays.copyOf(dictionary2, 2 * dictionary2.length);
	} // end ensureCapacity

	private int locateIndex(K key)
	{
		
		int index = 0; int ex=0;
	//	System.out.println("locate index - dictionary2[index].hashCode())%25 = "+dictionary2[index].hashCode()%25);
		// key.equals((dictionary2[index].hashCode())%25)
		
		//System.out.println("locate index - dictionary2[0].hashCode())%25 = "+dictionary2[0].hashCode()%25);

		//System.out.println("locate index - dictionary2[1].hashCode())%25 = "+dictionary2[1].hashCode()%25);
		
		/*while ( (index < numberOfEntries) )//&& !key.equals((dictionary2[index].hashCode())%25) )
			{
			index++;
			
			System.out.println("from locate index - key = "+key);
			//System.out.println("from locateIndex hashcode "+(dictionary2[index].hashCode())%25);
		//	System.out.println("locate index - dictionary2[index].hashCode())%25 = "+dictionary2[index].hashCode()%25);
			}*/
		//index=dictionary2[key].hashCode()/25;
		index=key.hashCode()%25;
		return index;
		
		
	} //
	@Override
	public V remove(K key)
	{
		V result = null;
		int keyIndex = locateIndex(key);

		System.out.println("remove keyIndex  "+keyIndex);
		   int i=0;
		while(i<dictionary2[keyIndex].size() )
		{
			if(key.equals(dictionary2[keyIndex].get(i).key)){
				dictionary2[keyIndex].remove(i);
  
          return result;
			} i++;
		
	} 
		return result;
	}// end remove
	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		V result = null;
		int keyIndex = locateIndex(key);
   int i=0;
		//System.out.println("getValue keyIndex  "+keyIndex);
		while(i<dictionary2[keyIndex].size() )
		{
			if(key.equals(dictionary2[keyIndex].get(i).key)){
  System.out.println(dictionary2[keyIndex].get(i).key);
  System.out.println(dictionary2[keyIndex].get(i).value);
  return result;
			}
  i++;
		}
		//result = dictionary2[keyIndex].getValue();

		//dictionary2[index].get(innerIndex).getValue()
		return result;
	}
	@Override
	public boolean contains(K key) {
		
		/*int index = 0;  boolean b=false;
		while (index < numberOfEntries )//&& key.equals(dictionary[index].getKey())) 
				{
						
			if(key.equals(dictionary[index].getKey())){
				return true;
			}
			index++;
			}*/
		
		
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
		// System.out.println(dictionary2[keyIndex].get(0).getValue());
		
		int index = 0; int innerIndex;
		
		while (index < dictionary2.length ){
			//		System.out.println(" "+key+" "+"index  "+index+" "+dictionary[index].getValue());
			//System.out.println("key "+dictionary[index].getKey()+"  "+"value "+dictionary[index].getValue());
			
			// to check null object always use ==null or !=null
			if(dictionary2[index]!=null){
				innerIndex=0;
							
				while(innerIndex<dictionary2[index].size()){
					System.out.println(dictionary2[index].get(innerIndex).key);
					System.out.println(dictionary2[index].get(innerIndex).value);
					innerIndex++;
				}
			}
		
			index++;
			
		}
	}
	
	// System.out.println(dictionary2[keyIndex].get(0).getValue());
	
	@Override
	public void prefixSearch(String prefix) {
		/*int index = 0;  boolean b=false;
		
		while (index < numberOfEntries )//&& key.equals(dictionary[index].getKey())) 
				{
						
				if(dictionary[index].getKey().toString().startsWith(prefix))
			{
				System.out.println("Results for Prefix "+prefix+" --- "+dictionary[index].getKey());
			}
			index++;
			}
		
	}*/
	}
} 