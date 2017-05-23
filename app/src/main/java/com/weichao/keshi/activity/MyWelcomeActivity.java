package com.weichao.keshi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.ParallaxPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;
import com.weichao.keshi.R;

public class MyWelcomeActivity extends WelcomeActivity {

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.start1)
                .page(new TitlePage(R.mipmap.start2,
                        "随心选择  个性配置").background(R.color.start1)
                )
                .page(new BasicPage(R.mipmap.start1,
                        "Header",
                        "More text.").background(R.color.start2)
                )
                .page(new BasicPage(R.mipmap.start4,
                        "Lorem ipsum",
                        "dolor sit amet.").background(R.color.start3)
                )
                .swipeToDismiss(true)
                .build();
    }
}
