package com.minbo.myhelloworld.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.minbo.myhelloworld.R;

public class ResultActivity extends AppCompatActivity {

    private TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initViews();
        bindData();
    }

    private void initViews() {
        text1 = (TextView) findViewById(R.id.text1);
    }

    private void bindData() {
        StringBuffer sb = new StringBuffer();
        String type = getIntent().getStringExtra("type");
        if (type.equals(TestIntent.SER_TYPE)) {
            PersonSer personSer = (PersonSer) getIntent().getSerializableExtra(
                    TestIntent.SER_KEY);
            sb.append("----From Serializable----").append("\n");
            sb.append("Name:").append(personSer.getName()).append("\n");
            sb.append("Age:").append(personSer.getAge()).append("\n");

        } else if (type.equals(TestIntent.PAR_TYPE)) {
            PersonPar personPar = (PersonPar) getIntent().getParcelableExtra(
                    TestIntent.PAR_KEY);
            sb.append("----From Parcelable----").append("\n");
            sb.append("Name:").append(personPar.getName()).append("\n");
            sb.append("Age:").append(personPar.getAge()).append("\n");
        }

        text1.setText(sb.toString());
    }
}
