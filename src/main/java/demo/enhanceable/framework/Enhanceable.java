package demo.enhanceable.framework;

/**
 * Created by michael on 17/08/2017.
 * Functionality that can be enhanced by support of a particular feature should be encapsulated in a class that implements this interface.
 */
public interface Enhanceable {

    /**
     * This method is executed if the feature is supported
     */
    public void executeWithFeature();

    /**
     * This method is executed if the feature is NOT supported
     */
    public void executeWithoutFeature();

    /**
     *
     * @return Returns the feature that is required for the enhanced functionality version
     */
    public String getFeature();

}
