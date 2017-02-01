import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by Skx on 01/02/2017.
 */
public class Language {

    public String language;
    public double val;

    public Language() {
    }

    public Language(String language, double val) {
        this.language = language;
        this.val = val;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<Language> findAll(Map<String, Integer> mapa){

        List<Language> languages = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {

            Language language = new Language(entry.getKey(), entry.getValue());

            languages.add(language);

        }

        return languages;

    }

    public List<Language> findAllByPorcentage(Map<String, Integer> mapa){

        List<Language> languages = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            double porcentage = (((double) entry.getValue()) / totalLanguage(mapa) * 100);

            Language language = new Language(entry.getKey(), porcentage);

            languages.add(language);

            System.out.println("Key : " + entry.getKey() + " Porcentage : " + porcentage + "%") ;
        }

        return languages;

    }

    public int totalLanguage(Map<String, Integer> mapa){

        int count = 0;

        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            count = count + entry.getValue();
        }

        return  count;
    }

    public List<Language> findRest(String value){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> object = restTemplate.getForEntity("https://api.github.com/orgs/stackbuilders/repos", Object[].class);

        return  null;
    }
}
