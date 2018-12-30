package com.mubassir.amadernetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivityTworow extends AppCompatActivity {

    List<Card> listMenues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tworow);

        listMenues=new ArrayList<>();
        listMenues.add(new Card("ANet",R.drawable.ic_internet,"companyName",R.color.colorPrimary,R.color.colorPrimaryDark));
        listMenues.add(new Card("FTP",R.drawable.ftp,"ftp",R.color.colorLavander,R.color.colorLavanderDark));
        listMenues.add(new Card("BDIX",R.drawable.ic_mobile,"bdix"));
        listMenues.add(new Card("Router",R.drawable.ic_router,"router"));
        listMenues.add(new Card("Offer",R.drawable.ic_billing_cycle,"offer"));

        //Setting up Recycler
        RecyclerView menuRecycaler=(RecyclerView) findViewById(R.id.mainMenuRecyclerView);
        GridCardListViewAdapter myAdapter=new GridCardListViewAdapter(this,listMenues);
        menuRecycaler.setLayoutManager(new GridLayoutManager(this,3));
        menuRecycaler.setAdapter(myAdapter);

        //click listener
        menuRecycaler.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                        switch (i) {
                            case 0:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 3:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 4:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 5:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 6:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 7:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 8:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 9:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 10:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 11:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                })
        );
    }
}
