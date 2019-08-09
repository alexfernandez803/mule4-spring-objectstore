package com.alexfrndz;

import org.mule.runtime.api.store.ObjectStore;
import org.mule.runtime.api.store.ObjectStoreException;

import net.sf.ehcache.Ehcache;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class CustomMonitoredObjectStore implements ObjectStore<Serializable> {

	 private Ehcache cache;

	 
    public boolean contains(String key) throws ObjectStoreException {
    		return cache.isKeyInCache(key);
    }

    public void store(String key, Serializable value) throws ObjectStoreException {
    		Element element = new Element(key, value);
    		System.out.println("Key" + key);
		//cache.put(element);
    }

    public Serializable retrieve(String key) throws ObjectStoreException {
    	System.out.println("retrieve " + key);
    	return null;
    	/**
    		Element element = cache.get(key);
		if (element == null)
		{
		  	System.out.println("retrieve null");
			return null;
		}
	  	System.out.println("retrieve not null " + element.getValue().toString());
		return  element.getValue();
		**/
    }

    public Serializable remove(String key) throws ObjectStoreException {
    	Serializable value = retrieve(key);
		cache.remove(key);
		return value;
    }

    public boolean isPersistent() {
        return false;
    }

    public void clear() throws ObjectStoreException {

    }

    public void open() throws ObjectStoreException {

    }

    public void close() throws ObjectStoreException {

    }

    public List<String> allKeys() throws ObjectStoreException {
        return null;
    }

    public Map<String, Serializable> retrieveAll() throws ObjectStoreException {
        return null;
    }
    

	public Ehcache getCache() {
		return cache;
	}

	public void setCache(Ehcache cache) {
		this.cache = cache;
	}

}
