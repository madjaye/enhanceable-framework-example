package demo.enhanceable.implementation.web;

import demo.enhanceable.framework.EnhanceableProcessor;
import demo.enhanceable.framework.FeatureUtils;
import demo.enhanceable.implementation.model.Transaction;
import demo.enhanceable.implementation.model.TransactionTypeConverterEnhanceable;
import demo.enhanceable.implementation.service.ClientService;
import demo.enhanceable.implementation.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by michael on 17/08/2017.
 */
@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

    @Autowired private TransactionService transactionService;
    @Autowired private ClientService clientService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Transaction> getTransactions(@RequestHeader("X-Features-Understood") String featuresUnderstood) {
        // convert the header comma separated list into a list of features
        List<String> supportedFeatures = FeatureUtils.getSupportedFeatures(featuresUnderstood);

        // fetch transactions for the client
        List<Transaction> transactions = transactionService.getTransactions(clientService.getCurrentClient());

        // initialise the Enhanceable functionality
        TransactionTypeConverterEnhanceable transactionTypeConverterEnhanceable = new TransactionTypeConverterEnhanceable(transactions);

        // pass the enhanceable functionality to the processesor along with the list of features the client supports
        EnhanceableProcessor<TransactionTypeConverterEnhanceable> enhanceableProcessor = new EnhanceableProcessor<>(transactionTypeConverterEnhanceable, supportedFeatures);

        // retrieve the list of transactions that have been processed according to the features the client supports
        List<Transaction> processedTransactions = transactionTypeConverterEnhanceable.getTransactions();
        return processedTransactions;
    }

}
