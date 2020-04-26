package com.adityay.sachintons.fragments;


import android.animation.ObjectAnimator;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adityay.sachintons.R;
import com.adityay.sachintons.activities.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutFragment extends Fragment {

    @BindView(R.id.tv_detail)
    TextView tvDetail;
    @BindView(R.id.tv_show_more)
    TextView tvShowMore;
    private boolean expand = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);
        setProfileDescription();
        return view;
    }

    private void setProfileDescription() {
        tvDetail.setText(getString(R.string.profile_description));
        expand = false;
        tvDetail.setMaxLines(10);
        tvShowMore.setText(getString(R.string.text_read_more));
    }

    @OnClick(R.id.tv_show_more)
    void showMore(){
        if (!expand) {
            expand = true;
            ObjectAnimator animation = ObjectAnimator.ofInt(tvDetail, "maxLines", 100);
            animation.setDuration(100).start();
            tvShowMore.setText(getString(R.string.text_read_less));
        } else {
            expand = false;
            ObjectAnimator animation = ObjectAnimator.ofInt(tvDetail, "maxLines", 10);
            animation.setDuration(100).start();
            tvShowMore.setText(getString(R.string.text_read_more));
        }
    }


    @OnClick(R.id.cv_about_me)
    void openBlog(){
        WebDialogFragment.showDialog(getFragmentManager(), getString(R.string.blog_url), "About Me", null);
    }

    @OnClick(R.id.cv_merchandise)
    void openAmazon(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.affiliate_url))));
    }

    @OnClick(R.id.cv_rate)
    void rateApp(){
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getContext().getPackageName())));
        } catch (Exception e) {
        }
    }

    @OnClick(R.id.cv_share)
    void shareApp(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Get " + getString(R.string.app_name) + " for free");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "Enjoy the memories of each centuries scored by Master Blaster using " + getString(R.string.app_name) + " App. Download it from " + "https://play.google.com/store/apps/details?id=" +
                getContext().getPackageName());
        startActivity(intent);
    }

}
