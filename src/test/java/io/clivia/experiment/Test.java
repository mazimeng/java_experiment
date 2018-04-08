package io.clivia.experiment;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() {
        CashFlowActivity cashFlowActivity = CashFlowActivity.valueOf("ACCOUNTING");
        Assert.assertEquals(CashFlowActivity.ACCOUNTING, cashFlowActivity);

        ok(cashFlowActivity);
        System.out.println(ok("ACCOUNTING", CashFlowActivity.class));
    }

    @org.junit.Test
    public void test1() {
        System.out.println(0.1*3f);
    }

    private <E extends Enum<E>> void ok(E e) {

    }

    private <E extends Enum<E>> E ok(String name, Class<E> eClass) {
        return E.valueOf(eClass, name);
    }
}
