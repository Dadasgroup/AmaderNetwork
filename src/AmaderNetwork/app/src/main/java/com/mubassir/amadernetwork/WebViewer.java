package com.mubassir.amadernetwork;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class WebViewer extends AppCompatActivity {

    WebView mWebView;
    private static final String TAG="Webviewer";

    private Context mContext;
    private Activity mActivity;
    private boolean isErrorShowed=false;
    private RelativeLayout mRootLayout;

    private static final int MY_PERMISSION_REQUEST_CODE = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_viewer);
        // Get the application context
        mContext = getApplicationContext();
        mActivity = WebViewer.this;

        getIncomingIntent();


        Log.d(TAG,"onCreate: Started");
    }
    private void  getIncomingIntent(){
        if (getIntent().hasExtra("url")){
            String url=getIntent().getStringExtra("url");
            setUrlToView(url);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack() && !isErrorShowed) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void setUrlToView(String url){
        mWebView=findViewById(R.id.myWebView);
        mRootLayout = findViewById(R.id.webViewRootLayout);

        // Check permission for write external storage
        checkPermission();
        // Load the url in web view
        final ProgressBar progressBar=findViewById(R.id.progressBar);
        final TextView txtPercentage=findViewById(R.id.tetPercentage);
        Toast.makeText(this,url,Toast.LENGTH_SHORT).show();
        mWebView.setVisibility(View.INVISIBLE);

        //Performance
        WebSettings webSettings=mWebView.getSettings();

        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setAppCacheEnabled(true);
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        mWebView.clearCache(true);
        //End of Performance

        isErrorShowed=false;

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                txtPercentage.setText(newProgress+" %");
            }
        });
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }


            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                //super.onReceivedError(view, request, error);
                mWebView.loadUrl("file:///android_asset/error.html");
                if (!isErrorShowed){
                    //Toast.makeText(WebViewer.this, "Your Internet Connection May not be active Or " + error , Toast.LENGTH_LONG).show();

                    isErrorShowed=true;
                }

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                mWebView.setVisibility(View.VISIBLE);
                txtPercentage.setVisibility(View.GONE);
            }
        });



        mWebView.loadUrl(url);

        // Enable java script on web view
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDescription,
                                        String mimetype, long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(
                        DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                String fileName = URLUtil.guessFileName(url,contentDescription,mimetype);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,fileName);

                DownloadManager dManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);

                dManager.enqueue(request);


            }

        });
    }
    protected void checkPermission(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                if(shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                    // show an alert dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
                    builder.setMessage("Write external storage permission is required.");
                    builder.setTitle("Please grant permission");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(
                                    mActivity,
                                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                    MY_PERMISSION_REQUEST_CODE
                            );
                        }
                    });
                    builder.setNeutralButton("Cancel",null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }else {
                    // Request permission
                    ActivityCompat.requestPermissions(
                            mActivity,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            MY_PERMISSION_REQUEST_CODE
                    );
                }
            }else {
                // Permission already granted
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        switch(requestCode){
            case MY_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // Permission granted
                }else {
                    // Permission denied
                }
            }
        }
    }
}
