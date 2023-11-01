import java.util.*;
//https://secure-media.collegeboard.org/apc/_ap06_frq_computer_sc_51650.pdf
//import java.util.TreeMap;
//import java.util.Iterator;
//Map<String, Integer> s1 = new TreeMap<String, Integer>();
		//Set s2 = s1.keySet();
	    //Iterator<String> iter = s2.iterator();
public class Thesaurus {
	private Map<String, String[]> wordMap;
	public Thesaurus() {
		wordMap = new HashMap();
		
	}
	public void addsynonym(String word, String syn) {
		String[] putsingle=new String[1];
		putsingle[0]=syn;
		if(wordMap.containsKey(word)) {
			String[] OldSyns = wordMap.get(word);
			String[] NewSyns = new String[wordMap.get(word).length+1];
			for(int i =0; i<=wordMap.size();i++) {
				if(i<=wordMap.get(word).length-1) {
					NewSyns[i]=OldSyns[i];
				}else {
					NewSyns[i]=syn;
				}
			}
			wordMap.replace(word, NewSyns);
		}else {
			wordMap.put(word,putsingle);
		}
	}
	public Set removeSynonym(String syn) {
		Set s2 = wordMap.keySet();
	    Iterator<String> iter = s2.iterator();
	    while(iter.hasNext()) {
	    	String iterNext = iter.next();
	    	String[] OldSyns = wordMap.get(iterNext);
			String[] NewSyns = new String[wordMap.get(iterNext).length-1];
			for(int i=0;i<wordMap.get(iterNext).length;i++) {
				int y=i;
				if(OldSyns[y].equals(syn)) {
					y--;
				}
				NewSyns[i]=OldSyns[y];
			}
	    }
	}
}
