package com.example.yousheng.mvptest_wu;

/**
 * Created by yousheng on 17/4/10.
 */

/**
 * presenter层，用户处理事务逻辑，并将结果返回给view层好让view层显示出来
 */
public class MainPresenter {
    private IMainView iMainView;

    //presenter层中也会用到view中的这几个方法（实际就是p层调用），
    // 不过其实是view层把它的这几个方法用接口的形式通过构造器实现传了过来,类似接口回调
    public MainPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
    }

    //p层来处理登陆的逻辑
    public void login(String username,String pass) {
        if(username.isEmpty()||pass.isEmpty()){
            iMainView.LoginFailed("账号密码不能为空");
        }else if(username.length() <8 || pass.length()<9){
            iMainView.LoginFailed("账号至少8位，密码至少10位");
        }else {
            iMainView.LoginSuccess();
        }
    }
}
