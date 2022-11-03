import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q0811 {
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainMap = new HashMap<>();
        for(String cpdomain: cpdomains) {
            String[] s = cpdomain.split(" ");
            int count = Integer.parseInt(s[0]);
            StringBuilder stringBuilder = new StringBuilder(s[1]);
            int prevStart = 0;
            for (int i = 0; i < stringBuilder.length(); i++){
                if (stringBuilder.charAt(i) == '.') {
                    String subdomain = stringBuilder.substring(prevStart);
                    if (domainMap.containsKey(subdomain)) {
                        domainMap.put(subdomain, domainMap.get(subdomain) + count);
                    } else {
                        domainMap.put(subdomain, count);
                    }
                    prevStart = i + 1;
                }
            }
            String subdomain = stringBuilder.substring(prevStart);
            if (domainMap.containsKey(subdomain)) {
                domainMap.put(subdomain, domainMap.get(subdomain) + count);
            } else {
                domainMap.put(subdomain, count);
            }
        }
        List<String> res = new ArrayList<>();
        for(String domain: domainMap.keySet()){
            int count = domainMap.get(domain);
            res.add(Integer.toString(count) + " " + domain);
        }
        return res;
        
    }

    public static void main(String[] args) {
        subdomainVisits(new String[]{"100 question.leetcode.com", "300 forum.leetcode.com"});
    }
}
