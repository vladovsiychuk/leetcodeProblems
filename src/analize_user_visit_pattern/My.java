package analize_user_visit_pattern;

import java.util.*;

public class My {
    HashMap<String, Integer> webSiteCount = new HashMap<>();
    public List<String> result(String[] username, int[] timestamp, String[] website){

        HashMap<String, Set<String>> sitesPerUsers = new HashMap<>();

        for (int i = 0; i < website.length; i++) {
            if (sitesPerUsers.get(website[i]) != null
             && sitesPerUsers.get(website[i]).contains(username[i]))
                continue;

            sitesPerUsers.put(website[i], new HashSet<String>());
            sitesPerUsers.get(website[i]).add(username[i]);
            webSiteCount.put(website[i],
                    webSiteCount.getOrDefault(website[i], 0) + 1);
        }

        List<String> sites = new ArrayList<>();
        for (String site : webSiteCount.keySet())
            sites.add(site);

        Collections.sort(sites,
                new myComparator());

        List<String> tmp = new ArrayList<>();
        for (int i = 0, k = 0; i < sites.size() && k < 3; i++, k++)
            tmp.add(sites.get(i));

        return tmp;
    }

    private class myComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            int comp = webSiteCount.get(b).compareTo(webSiteCount.get(b));
            if (comp == 0)
                return a.compareTo(b);
            return comp;
        }
    }
}

