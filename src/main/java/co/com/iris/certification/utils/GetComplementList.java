package co.com.iris.certification.utils;

import java.util.ArrayList;
import java.util.List;

public class GetComplementList {

    private GetComplementList(){
    }
    public static List<String> fromFeature(String complements) {
        List<String> tagsList = new ArrayList<>();
        if (complements != null) {
            tagsList = SetData.convertListToLowerCase(SetData.convertStringToList(complements));
            tagsList.add(0, "banca");
        } else{
            tagsList.add(0, "banca");
        }
        return tagsList;
    }
}
