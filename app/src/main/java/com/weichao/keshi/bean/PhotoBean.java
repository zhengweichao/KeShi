package com.weichao.keshi.bean;

import android.text.TextUtils;

import com.facebook.drawee.view.SimpleDraweeView;
import com.weichao.keshi.R;
import com.weichao.keshi.utils.FrescoUtil;
import com.weichao.keshi.utils.LogUtils;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;
import xyz.zpayh.adapter.BaseViewHolder;
import xyz.zpayh.adapter.IMultiItem;

/**
 * @ 创建时间: 2017/10/4 on 22:46.
 * @ 描述：图说校园
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class PhotoBean extends BmobObject implements Serializable, IMultiItem {
    private String id;
    private String name;
//    private int iconId;
    private String pic;

    private String description;

    public PhotoBean() {
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


/*    public PhotoBean(int iconId, String description) {
        this.iconId = iconId;
        this.description = description;
    }*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_recycler;
    }

    @Override
    public void convert(BaseViewHolder holder) {
        if (!(pic==null)) {
            LogUtils.e("加载图片"+pic);

//            SimpleDraweeView sdv1 = holder.find(R.id.iv_icon);

            SimpleDraweeView sdv1 = holder.find(R.id.iv_icon);
            FrescoUtil.setWrapImage(sdv1, pic);
        }
    }

    @Override
    public int getSpanSize() {
        return 0;
    }

/*    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }*/
}
