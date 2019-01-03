package com.mubassir.amadernetwork;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

public class NewsFeed extends AppCompatActivity{

    Bundle extras;
    EditText edTokenId, edTitle, edBody, eddid, eddtitle, eddbody;
    String TOPIC = "feed", token = "";
    int type = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showfeed);

    edTokenId = findViewById(R.id.edTokenId);
    edTitle = findViewById(R.id.edTitle);
    edBody = findViewById(R.id.edBody);
    eddid = findViewById(R.id.eddid);
    eddtitle = findViewById(R.id.eddtitle);
    eddbody = findViewById(R.id.eddbody);

        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC);
    }

    @Override
    protected void onResume(){
        super.onResume();

        extras = getIntent().getExtras();
        if(extras == null){

        }
        else {
            FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(
                    new OnSuccessListener<InstanceIdResult>() {
                        @Override
                        public void onSuccess(InstanceIdResult instanceIdResult) {
                            token = instanceIdResult.getToken();
                            edTokenId.setText(token);
                        }
                    });


            type = extras.getInt("type");
            if(type == 0){
                eddid.setText(extras.getString("id"));
                eddtitle.setText(extras.getString("title1"));
                eddbody.setText(extras.getString("body1"));
            }
            else {
                edTitle.setText(extras.getString("title"));
                edBody.setText(extras.getString("body"));
            }
        }
    }
}
