package com.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

interface FileVersionService {
	
	public String getLatestPath(String namespace,String key);
	public Collection<String> getAllFilesByNameSpace(String namespace);
	public Boolean updateNewPath(String namespace,String key,String value);

}


public class FileService implements FileVersionService {
	
	
	static Map<String, List<String>> pathMap = new HashMap<>();
//	static Map<String, >  = new HashMap<>();
	@Override
	public String getLatestPath(String namespace, String key) {
		
		return pathMap.get(namespace+key).get(pathMap.get(namespace+key).size() - 1);
	}

	@Override
	public Collection<String> getAllFilesByNameSpace(String namespace) {
		
		List<String> fileList = new LinkedList<>();
		for(Entry<String, List<String>> entry: pathMap.entrySet()) {
			if(entry.getKey().contains(namespace)) {
				fileList.add(entry.getValue().get(entry.getValue().size() - 1));
			}
		}
		
		return fileList;
	}

	@Override
	public Boolean updateNewPath(String namespace, String key, String value) {
		try {
			List<String> resList = pathMap.get(namespace+key);
			resList.add(value);
			pathMap.put(namespace+key, resList);
//			pathMap.put(namespace+key, value);
			return true;
		} catch (Exception e) {
			return false;
		}
//		pathMap.put(key, value);
//		return null;
	}
	
	// namespace+key
//	"abc+xyz"
//	"clp+razorpaytxn"
	
	
	
}
