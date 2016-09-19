package com.minbo.myhelloworld.async;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.minbo.myhelloworld.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class TestAsync extends AppCompatActivity {

    private Button btnDownload;
    private ImageView myImageView;
    private String download_url = "http://img0.bdstatic.com/img/image/shouye/bzsjb-12326925706.jpg";
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_async);

        btnDownload = (Button) findViewById(R.id.btnDownload);
        myImageView = (ImageView) findViewById(R.id.myImageView);
        dialog = new ProgressDialog(TestAsync.this);
        dialog.setTitle("提示信息");
        dialog.setMessage("图片下载中...");
        //带刻度的提示
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCancelable(false);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyAsync().execute(download_url);
            }
        });

    }

    class MyAsync extends AsyncTask{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {
            for (int i = 0; i < 10; i++) {
                publishProgress(i*10);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;

//            byte[] result = null;
//            HttpClient httpClient = new DefaultHttpClient();
//            HttpGet httpGet = new HttpGet((String)params[0]);
//            byte[] data = new byte[1024];
//            InputStream inputStream = null;
//            long file_length = 0;
//            long total_length = 0;
//            int length = 0;
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            try {
//                HttpResponse httpResponse = httpClient.execute(httpGet);
//                file_length = httpResponse.getEntity().getContentLength();
//                if (httpResponse.getStatusLine().getStatusCode() == 200) {
//                    inputStream = httpResponse.getEntity().getContent();
//                    while ((length = inputStream.read(data)) != -1) {
//                        total_length += length;
//                        int prograssBar = (int) (total_length
//                                / (float) file_length * 100);
//                        publishProgress(prograssBar);
//                        outputStream.write(data, 0, length);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                httpClient.getConnectionManager().shutdown();
//            }
//            result = outputStream.toByteArray();
//            return result;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
            dialog.setProgress((int)values[0]);
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            myImageView.setBackgroundColor(Color.BLUE);

//            myImageView.setImageBitmap(BitmapFactory.decodeByteArray(o.toString().getBytes(), 0,
//                    o.toString().getBytes().length));

            dialog.dismiss();
        }
    }
}
