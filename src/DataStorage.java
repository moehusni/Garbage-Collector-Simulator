import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import java.util.Set;

public abstract class DataStorage 
{

	static Map<String, LinkedList<Object>> map = new LinkedHashMap<String, LinkedList<Object>>();

	public static void addtoList(Object obj) 
	{ 	
		String className = obj.getClass().getName();

		if (map.containsKey(className)) // if the key Value (className) previously been created.
		{ 
			LinkedList<Object> groupList = map.get(className); // then retrieve the linkedlist and store it into temp LinkedList.
			groupList.add(obj);			// adding the new obj into the LinkedList.
			map.put(className, groupList);

		} 
		else 
		{ // else the new Object is from a unlisted className

			// created a new linkedList for new Object.
			LinkedList<Object> linkedList = new LinkedList<Object>();

			// add the new Object into the List
			linkedList.add(obj);

			// add the knewly created LinkedList into LinkedHashMap.
			map.put(className, linkedList);
		}

	}
	
	public static void deleteFrom(Obj obj) 
	{

		Set<String> keys = DataStorage.map.keySet();
		for (String className : keys) 
		{
			// storing the Linklist into a temperoray LinkedList called groupList
			LinkedList<Object> groupList = DataStorage.map.get(className);
			groupList.remove(obj);
			map.put(className, groupList);
		
		}
	}
}