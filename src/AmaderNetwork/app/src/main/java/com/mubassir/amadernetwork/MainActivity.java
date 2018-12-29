package com.mubassir.amadernetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener  {

    private LinearLayout alpha,router,ftp,tv,partnerFtp,bdix,education,sports,contact,login,links,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alpha=findViewById(R.id.alpha);
        router=findViewById(R.id.router);
        ftp=findViewById(R.id.ftp);
        tv=findViewById(R.id.tv);
        partnerFtp=findViewById(R.id.packages);
        bdix=findViewById(R.id.bdix);
        education=findViewById(R.id.education);
        sports=findViewById(R.id.sports);
        contact=findViewById(R.id.contact);
        login=findViewById(R.id.login);
        links=findViewById(R.id.links);
        about=findViewById(R.id.about);

        //alpha

        alpha.setOnClickListener(this);
        router.setOnClickListener(this);
        ftp.setOnClickListener(this);
        partnerFtp.setOnClickListener(this);
        bdix.setOnClickListener(this);
        education.setOnClickListener(this);
        sports.setOnClickListener(this);
        contact.setOnClickListener(this);
        login.setOnClickListener(this);
        links.setOnClickListener(this);
        about.setOnClickListener(this);
        tv.setOnClickListener(this);


    }
    // Notification(string x, ){

    // }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.alpha:
                Intent alphaIntent=new Intent(this,testActivity.class);
                startActivity(alphaIntent);
                break;

            case R.id.router:
                // do your code
                Intent routerIntent=new Intent(this,testActivity.class);
                startActivity(routerIntent);
                break;

            case R.id.packages:
                Intent packageIntent=new Intent(this,testActivity.class);
                startActivity(packageIntent);
                break;
            case R.id.bdix:
                // do your code
                Intent bdixIntent=new Intent(this,testActivity.class);
                startActivity(bdixIntent);
                break;

            case R.id.education:
                Intent eduIntent=new Intent(this,testActivity.class);
                startActivity(eduIntent);
                break;

            case R.id.sports:
                Intent sportsIntent=new Intent(this,testActivity.class);
                startActivity(sportsIntent);
                break;
            case R.id.login:
                // do your code
                Toast.makeText(MainActivity.this,"Upcoming Feature Please wait",Toast.LENGTH_SHORT).show();
                break;

            case R.id.contact:
                Intent contactIntent=new Intent(this,testActivity.class);
                startActivity(contactIntent);
                break;

            case R.id.links:
                Intent linksIntent=new Intent(this,testActivity.class);
                startActivity(linksIntent);
                break;
            case R.id.about:
                Intent aboutIntent=new Intent(this,testActivity.class);
                startActivity(aboutIntent);
                break;

            case R.id.ftp:
                // do your code
                Intent ftpIntent=new Intent(this,testActivity.class);
                startActivity(ftpIntent);
                break;

            case R.id.tv:
                Intent tvIntent=new Intent(this,testActivity.class);
                startActivity(tvIntent);
                break;

            default:
                break;
        }

    }


}
