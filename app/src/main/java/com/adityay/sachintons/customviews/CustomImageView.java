package com.adityay.sachintons.customviews;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;

public class CustomImageView extends AppCompatImageView {

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setImageWithGlide(Context context, String imagePath, int placeholderId) {
        if (context == null) return;

        Glide.with(context.getApplicationContext())
                .load(imagePath)
                .placeholder(AppCompatResources.getDrawable(context, placeholderId))
                .error(AppCompatResources.getDrawable(context, placeholderId))
                .into(this);
    }

    public void setGifImageWithGlide(Context context, int imageId) {
        if (context == null) return;

        Glide.with(context.getApplicationContext())
                .asGif()
                .load(imageId)
                .into(this);
    }


}
