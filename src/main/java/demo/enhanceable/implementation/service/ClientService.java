package demo.enhanceable.implementation.service;

import org.springframework.stereotype.Service;

/**
 * Created by michael on 17/08/2017.
 */
@Service
public class ClientService {

    /**
     *
     * @return Returns the current client
     */
    public String getCurrentClient() {
        return "ClientID";
    }

}
