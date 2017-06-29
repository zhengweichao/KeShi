package com.weichao.keshi.activity;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;
import com.weichao.keshi.R;

/**
 * @ 创建时间: 2017/5/23 on 22:09.
 * @ 描述：引导欢迎页面
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class MyWelcomeActivity extends WelcomeActivity {

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.start1)
                .page(new TitlePage(R.mipmap.start2,
                        "随心选择  个性配置").background(R.color.start1)
                )
                .page(new BasicPage(R.mipmap.start1,
                        "科师",
                        "校园专属APP").background(R.color.start2)
                )
                .page(new BasicPage(R.mipmap.start3,
                        "功能强大",
                        "满足你的校园需求").background(R.color.start3)
                )
                .page(new BasicPage(R.mipmap.start4,
                        "立足科师",
                        "走向未来").background(R.color.start4)
                )
                .swipeToDismiss(true)
                .build();
    }
}
