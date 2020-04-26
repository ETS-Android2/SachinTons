package com.adityay.sachintons.fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.adityay.sachintons.R;
import com.adityay.sachintons.activities.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PostsFragment extends Fragment {

    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setTweets();
    }

    private void setTweets() {
        webView.clearCache(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                webView.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                WebDialogFragment.showDialog(getFragmentManager(), request.getUrl().toString(), "Twitter", "");
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                webView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        });
        webView.loadDataWithBaseURL("https://twitter.com", "<a class=\"twitter-timeline\" data-theme=\"light\" href=\"https://twitter.com/sachin_rt?ref_src=twsrc%5Etfw\">Tweets by sachin_rt</a> <script async src=\"https://platform.twitter.com/widgets.js\" charset=\"utf-8\"></script>", "text/html", "UTF-8", "");
    }

}
