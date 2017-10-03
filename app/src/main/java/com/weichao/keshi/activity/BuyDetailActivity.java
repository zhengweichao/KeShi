package com.weichao.keshi.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.weichao.keshi.R;
import com.weichao.keshi.bean.BuyItem;
import com.weichao.keshi.bean.SaleItem;
import com.weichao.keshi.utils.LogUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class BuyDetailActivity extends BaseActivity {

    @Bind(R.id.tv_detail_buy_title)
    TextView tvDetailBuyTitle;
    @Bind(R.id.tv_detail_buy_price)
    TextView tvDetailBuyPrice;
    @Bind(R.id.tv_detail_buy_author)
    TextView tvDetailBuyAuthor;
    @Bind(R.id.tv_detail_buy_time)
    TextView tvDetailBuyTime;
    @Bind(R.id.tv_detail_buy_desc)
    TextView tvDetailBuyDesc;
    @Bind(R.id.tv_detail_buy_tel)
    TextView tvDetailBuyTel;
    @Bind(R.id.iv_buy_detail)
    ImageView ivBuyDetail;
    @Bind(R.id.bt_detail_buy_tel)
    Button btDetailBuyTel;
    private BuyItem Buybean;
    private SaleItem salebean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_detail;
    }

    @Override
    void initView() {
        Buybean = (BuyItem) getIntent().getSerializableExtra("buybean");
        salebean = (SaleItem) getIntent().getSerializableExtra("salebean");
        if(Buybean!=null){
            tvDetailBuyTitle.setText(Buybean.getTitle());
            tvDetailBuyAuthor.setText(Buybean.getAuthor());
            tvDetailBuyTime.setText(Buybean.getCreatedAt().substring(0, 10));
            tvDetailBuyDesc.setText(Buybean.getContent());
            tvDetailBuyTel.setText(Buybean.getTel());

            if (Buybean.getPic() != null) {
                ivBuyDetail.setVisibility(View.VISIBLE);
                Glide.with(BuyDetailActivity.this)                             //配置上下文
                        .load(Buybean.getPic().getFileUrl())      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                        .error(R.mipmap.default_image)           //设置错误图片
                        .placeholder(R.mipmap.default_image)     //设置占位图片
                        .centerCrop()
                        .into(ivBuyDetail);
            }
        }else{
            tvDetailBuyTitle.setText(salebean.getTitle());
            tvDetailBuyAuthor.setText(salebean.getAuthor());
            tvDetailBuyTime.setText(salebean.getCreatedAt().substring(0, 10));
            tvDetailBuyDesc.setText(salebean.getContent());
            tvDetailBuyTel.setText(salebean.getTel());

            if (salebean.getPic() != null) {
                ivBuyDetail.setVisibility(View.VISIBLE);
                Glide.with(BuyDetailActivity.this)                             //配置上下文
                        .load(salebean.getPic().getFileUrl())      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                        .error(R.mipmap.default_image)           //设置错误图片
                        .placeholder(R.mipmap.default_image)     //设置占位图片
                        .fitCenter()                            //完全显示
                        .into(ivBuyDetail);
            }
        }
        
    }
    @OnClick(R.id.bt_detail_buy_tel)
    public void onViewClicked() {
        if (!(Buybean==null)) {
            LogUtils.e("TEL:" + Buybean.getTel());
            //跳到拨号页面
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Buybean.getTel()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else if(!(salebean==null)){
            LogUtils.e("TEL:" + salebean.getTel());
            //跳到拨号页面
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + salebean.getTel()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else{
            Toast.makeText(this, "该用户没有留下电话信息，请私信尝试", Toast.LENGTH_SHORT).show();
        }
    }
}
