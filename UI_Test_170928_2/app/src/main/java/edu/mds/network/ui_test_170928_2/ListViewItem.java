package edu.mds.network.ui_test_170928_2;

import android.graphics.drawable.Drawable;

/**
 * Created by vgg on 2017-09-27.
 */

public class ListViewItem {
    private Drawable icon_module;
    private Drawable icon_type;
    private String text_module;
    private String text_type;

    public void seticon_module(Drawable icon) {
        icon_module = icon ;
    }
    public void seticon_type(Drawable icon) {
        icon_type = icon ;
    }
    public void settext_module(String title) {
        text_module = title ;
    }
    public void settext_type(String desc) {
        text_type = desc ;
    }

    public Drawable geticon_module() {
        return this.icon_module;
    }
    public Drawable geticon_type() {
        return this.icon_type;
    }
    public String gettext_module() {
        return this.text_module;
    }
    public String gettext_type() {
        return this.text_type;
    }
}
