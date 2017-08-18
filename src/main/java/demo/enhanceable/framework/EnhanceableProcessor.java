package demo.enhanceable.framework;

import java.util.List;

/**
 * Created by michael on 17/08/2017.
 * By creating a new instance of this class the Enhanceable object will execute the appropriate functionality
 * by evaluating the features supported by the client vs the feature that the Enhanceable object can utilise.
 */
public class EnhanceableProcessor<T extends Enhanceable> {

    /**
     *
     * @param enhanceable - the encapsulated enhanceable functionality
     * @param supportedFeatures - A list of features supported by the client
     */
    public EnhanceableProcessor(T enhanceable, List<String> supportedFeatures) {
        processEnhanceable(enhanceable, supportedFeatures);
    }

    private void processEnhanceable(T enhanceable, List<String> supportedFeatures) {
        // decide which method to execute based on whether there is support for the required feature
        if(clientSupportsFeature(enhanceable.getFeature(), supportedFeatures)) {
            enhanceable.executeWithFeature();
        } else {
            enhanceable.executeWithoutFeature();
        }
    }

    // determine whether there is support for the requestedFeature
    private boolean clientSupportsFeature(String requestedFeature, List<String> supportedFeatures) {
        boolean isSupported = false;
        if(requestedFeature != null && supportedFeatures != null) {
            isSupported = supportedFeatures.contains(requestedFeature);
        }
        return isSupported;
    }
}
