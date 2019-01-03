package com.mubassir.amadernetwork;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FMS extends FirebaseMessagingService {
    private String title = "", body = "", id= "" ,title1= "", body1= "";
    private String CHANNEL_ID = "feed";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size() > 0){
            id = remoteMessage.getData().get("id");
            title1 = remoteMessage.getData().get("title1");
            body1 = remoteMessage.getData().get("body1");
            sendDataMassage(id, title1, body1);

        }

        if (remoteMessage.getNotification() != null){
            title = remoteMessage.getNotification().getTitle();
            body = remoteMessage.getNotification().getBody();
            sendNotificationMessage(title,body);
        }
    }

    private void sendDataMassage(String id, String title1, String body1){
        Uri ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(),
                    android.R.drawable.ic_btn_speak_now);
        Intent intent = new Intent( this, NewsFeed.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra( "id",id);
        intent.putExtra( "title1",title1);
        intent.putExtra( "body1",body1);
        intent.putExtra( "type", 0);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0,intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
                        .setLargeIcon(bmp)
                        .setSmallIcon(android.R.drawable.ic_btn_speak_now)
                        .setContentTitle(title1)
                        .setContentText(body1)
                        .setAutoCancel(true)
                        .setSound(ringtoneUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());

    }
    private void sendNotificationMessage(String title, String body){
        Uri ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(),
                android.R.drawable.ic_btn_speak_now);
        Intent intent = new Intent( this, NewsFeed.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra( "title",title);
        intent.putExtra( "body",body);
        intent.putExtra( "type", 1);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0,intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this,CHANNEL_ID)
                        .setLargeIcon(bmp)
                        .setSmallIcon(android.R.drawable.ic_btn_speak_now)
                        .setContentTitle(title)
                        .setContentText(body)
                        .setAutoCancel(true)
                        .setSound(ringtoneUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());

        }
    @Override
    public void onNewToken(String s){
        super.onNewToken(s);
        Log.e("NEW_TOKEN",s);
    }


}
