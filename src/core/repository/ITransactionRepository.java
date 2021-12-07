package core.repository;

public interface ITransactionRepository {
    public void insert(String id, float amount, String status, String errorMessage) throws Exception;
}
