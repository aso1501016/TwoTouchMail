package com.example.kanehiro.twotouchmail;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

import jp.ac.asojuku.st.twotouchmail.R;

public class PickUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);

        Button btnSend = (Button) this.findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String mail[] = new String[5];

                mail[0] = "touhoukoumakyou@gmail.com";
                mail[1] = "touhouyouyoumu@gmail.com";
                mail[2] = "touhoueiyasyou@gmail.com";
                mail[3] = "touhoufujinroku@gmail.com";
                mail[4] = "kanehiro@gmail.com";

                Random rnd = new Random();
                int ran = rnd.nextInt(5);

                RadioGroup rgPlace = (RadioGroup) findViewById(R.id.rg_place);
                int checkedId = rgPlace.getCheckedRadioButtonId();//何番目か
                String strPlace = ((RadioButton) findViewById(checkedId)).getText().toString();

                EditText edit01 = (EditText) findViewById(R.id.editText);//本文を取得
                String title = edit01.getText().toString();

                Resources res = getResources();
                Uri uri =  Uri.parse("mailto:" + mail[ran]/*res.getString(R.string.mail_to).toString()*/);

                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_SUBJECT, title);
                intent.putExtra(Intent.EXTRA_TEXT, strPlace + "に迎えにきて");
                startActivity(intent);


            }
        });
    }
}
