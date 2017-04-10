package com.example.yousheng.mvptest_wu;

/**
 * Created by yousheng on 17/4/10.
 */

/**
 * 此接口定义了view中必须实现的方法，用于具体去处理presenter层返回给view层的数据
 * presenter层中也会用到view中的这几个方法，不过其实是view层把它的这几个方法实现传了过来
 */
public interface IMainView {

    void LoginSuccess();
    void LoginFailed(String msg);
}
