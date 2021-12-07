package core.factory;

import core.repository.ITransactionRepository;

public interface ITransactionRepositoryFactory {
    public ITransactionRepository createTransactionRepository();
}
