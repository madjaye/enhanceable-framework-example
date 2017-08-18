package demo.enhanceable.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by michael on 17/08/2017.
 */
public class FeatureUtils {

    /**
     *
     * @param featuresString - the comma separated list of features supported by the client
     * @return Returns the comma separated featureString as a list of Strings
     */
    public static final List<String> getSupportedFeatures(String featuresString) {
        List<String> features;
        if(featuresString != null) {
            features = Arrays.asList(featuresString.split(","));
        } else {
            features = new ArrayList<>();
        }
        return features;
    }


}
