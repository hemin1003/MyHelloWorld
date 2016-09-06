package com.minbo.myhelloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TestSpinner extends AppCompatActivity {

    private static final String[] countries = {"张三","李四","王五","李明"};
    private TextView myTextView16;
    private EditText myEditText;
    private Button btn_add;
    private Button btn_remote;
    private Spinner mySpinner;
    private List allCountries;
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_spinner);

        allCountries = new ArrayList();
        for (int i=0;i<countries.length;i++){
            allCountries.add(countries[i]);
        }

        adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, allCountries);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);


        myTextView16 = (TextView) findViewById(R.id.myTextView16);
        myEditText = (EditText) findViewById(R.id.myEditText);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_remote = (Button) findViewById(R.id.btn_remote);

        mySpinner = (Spinner) findViewById(R.id.mySpinner);
        mySpinner.setAdapter(adapter);

        btn_add.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                String newCountry = myEditText.getText().toString();
                for (int i=0;i<adapter.getCount();i++){
                    if(newCountry.equals(adapter.getItem(i))){
                        Toast.makeText(TestSpinner.this, "已存在。",Toast.LENGTH_SHORT).show();;
                        return;
                    }
                }
                if(!newCountry.equals("")){
                    adapter.add(newCountry);
                    int position = adapter.getPosition(newCountry);
                    mySpinner.setSelection(position);
                    myEditText.setText("");
                }
            }
        });

        btn_remote.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mySpinner.getSelectedItem()!=null){
                    adapter.remove(mySpinner.getSelectedItem().toString());
                    myEditText.setText("");
                    if(adapter.getCount()==0){
                        myEditText.setText("");
                    }
                }
            }
        });

        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                myEditText.setText(parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
