package cn.ming.test;

/**
 * 单例测试
 * @author xwtec
 */
public final class SingleCase {
    private SingleCase() {};

    static class SingleClass {
        static SingleCase singleCase = new SingleCase();
    }

    public final SingleCase getInstance() {
        return SingleClass.singleCase;
    }
}
