package hm.sitek.model;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OperationsTest {

    @Autowired
    private Operations operations;

    @Test
    public void givenIdentityStrategy_whenCommitTransction_thenReturnPrimaryKey() {
        Operations operations = new Operations();
        //operations.setName("TestName");
        operations.setType(1);

        /*entityManager.getTransaction().begin();
        entityManager.persist(operations);
        Assert.assertNull(user.getId());
        entityManager.getTransaction().commit();

        Long expectPrimaryKey = 1L;
        Assert.assertEquals(expectPrimaryKey, user.getId());*/
    }
}
