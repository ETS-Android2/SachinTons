package com.adityay.sachintons.fragments;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.adityay.sachintons.R;
import com.adityay.sachintons.activities.MainActivity;
import com.adityay.sachintons.customviews.CustomImageView;
import com.adityay.sachintons.models.Century;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MatchFragment extends Fragment {

    @BindView(R.id.iv_pic)
    CustomImageView ivPic;
    @BindView(R.id.tv_detail)
    TextView tvDetail;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_score)
    Button btnScore;
    @BindView(R.id.btn_video)
    Button btnVideo;

    private Century century;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match, container, false);
        ButterKnife.bind(this, view);
        if (getArguments() != null && getArguments().getParcelable("data") != null) {
            century = getArguments().getParcelable("data");
            setData(century);
        }
        return view;
    }

    private void setData(Century century) {
        if (century != null) {
            if (!TextUtils.isEmpty(century.getImageUrl())) {
                ivPic.setImageWithGlide(getActivity(), century.getImageUrl(), R.drawable.placeholder);
            }

            if (!TextUtils.isEmpty(century.getDescription())) {
                tvDetail.setText(century.getDescription());
            }

            if (!TextUtils.isEmpty(century.getTitle())) {
                tvTitle.setText(century.getTitle());
            }
        }
    }


    @OnClick(R.id.btn_score)
    void gotoWebView() {
        WebDialogFragment.showDialog(getFragmentManager(), century.getEspnUrl(), "Match Summary", century.getYoutubeUrl());
    }

    @OnClick(R.id.btn_video)
    void gotoYoutube() {
        if (!TextUtils.isEmpty(century.getYoutubeUrl())) {
            Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(century.getYoutubeUrl()));
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + century.getYoutubeUrl()));
            try {
                startActivity(appIntent);
            } catch (ActivityNotFoundException ex) {
                startActivity(webIntent);
            }
        }
    }

}
