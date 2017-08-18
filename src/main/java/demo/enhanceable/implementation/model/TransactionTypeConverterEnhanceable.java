package demo.enhanceable.implementation.model;


import demo.enhanceable.framework.Enhanceable;
import demo.enhanceable.implementation.FeatureConstants;

import java.util.List;

/**
 * Created by michael on 17/08/2017.
 * This class can processes transactions in two different ways.
 * One way requires support of the TIDE_TO_TIDE feature and the other way does not.
 */
public class TransactionTypeConverterEnhanceable implements Enhanceable {

    /**
     *
     * @param transactionsToProcess - transactions requiring processing
     */
    public TransactionTypeConverterEnhanceable(List<Transaction> transactionsToProcess) {
        this.transactions = transactionsToProcess;
    }

    // for this particular functionality we want to get a list of transactions and store them in this list so that they can be retrieved.
    private List<Transaction> transactions;

    @Override
    public void executeWithFeature() {
        // nothing to do here really! By default transaction are utilising the new TransactionType where necessary.

    }

    @Override
    public void executeWithoutFeature() {
        // get transactions but convert tide to tide transactions types into faster payments
        transactions.forEach(t -> t.setTransactionType(t.getTransactionType() == TransactionType.ACCOUNT_TRANSFERS ? TransactionType.FASTER_PAYMENTS : t.getTransactionType()));
    }

    /**
     *
     * @return Returns the feature that is required for the enhanced version
     */
    @Override
    public String getFeature() {
        return FeatureConstants.TIDE_TO_TIDE;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
