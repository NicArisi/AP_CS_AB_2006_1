import java.util.*;
//https://secure-media.collegeboard.org/apc/_ap06_frq_computer_sc_51650.pdf
public class Thesaurus {
	public static void main(String[] args) {
		Thesaurus words = new Thesaurus();
		words.addsynonym("excellent", "brilliant");
		words.addsynonym("excellent", "great");
		words.addsynonym("excellent", "outstanding");
		words.addsynonym("excellent", "tremendous");
		words.addsynonym("Super", "excellent");
		words.addsynonym("Super", "fantastic");
		words.addsynonym("Super", "great");
		words.addsynonym("Super", "wonderful");
		words.addsynonym("Wonderful", "amazing");
		words.addsynonym("Wonderful", "brilliant");
		words.addsynonym("Wonderful", "fantastic");
		words.addsynonym("Wonderful", "great");
		words.addsynonym("Wonderful", "magnificent");
		words.addsynonym("Awesome", "wonderful");
	}
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
	    	if(OldSyns.length==1 & OldSyns[0].equals(syn)) {
	    		String[] NewSyns = new String[0];
	    		wordMap.replace((String)(Object)iter, NewSyns);
	    	}else {
				String[] NewSyns = new String[wordMap.get(iterNext).length-1];
				int L=0;
				while(L<wordMap.get(iterNext).length-1) {
					int y=L;
					if(OldSyns[y].equals(syn)) {
						y++;
					}
					NewSyns[L]=OldSyns[y];
					L++;
				}
				if(OldSyns[L+1]==syn){
					wordMap.replace((String)(Object)iter, NewSyns);
				}
					//brilliant, great, outstanding, tremendous
					//brilliant, great, outstanding, tremendous            remove wonderful
					
					//excellent, fantastic, great, wonderful
					//excellent, fantastic, great, wonderful
	    	}
	    }
	    return s2;
	}
}
