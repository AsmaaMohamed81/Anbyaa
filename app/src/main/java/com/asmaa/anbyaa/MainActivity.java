package com.asmaa.anbyaa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ImageView share, mail, out, in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);

        share = (ImageView) findViewById(R.id.share);
        mail = (ImageView) findViewById(R.id.mail);
        out = (ImageView) findViewById(R.id.out);
        in = (ImageView) findViewById(R.id.in);


        String[] index = getResources().getStringArray(R.array.index);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.textView, index);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion, long l) {
                Intent intent = new Intent(MainActivity.this, page.class);
                intent.putExtra("page", postion);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = "تطبيق قصص الانبياء";
                String link = "https://play.google.com/store/apps/details?id=com.makhtotat.makhtotnaa.makhtotat";

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, text + "\n" + link);
                intent.setType("text/plain");

                startActivity(intent);


            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Intent send = new Intent(Intent.ACTION_SEND);
                    send.setData(Uri.parse("mailto:"));
                    send.setType("message/rfc822");
                    send.putExtra(Intent.EXTRA_EMAIL, "smasimo81@gmail.com");
                    send.putExtra(Intent.EXTRA_TEXT, "السلام عليكم ورحمه الله وبركاته \n اقتراحي لكم :");
                    send.putExtra(Intent.EXTRA_SUBJECT, "تطبيق قصص الانبياء");
                    startActivity(send);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "عذرا لايوجد تطبيق بريد لديك ...", Toast.LENGTH_SHORT).show();
                }


            }
        });


        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();


            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent link = new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse("https://www.facebook.com/Eng.asmaa.Ellotf"));
                startActivity(link);


            }
        });


    }
}
