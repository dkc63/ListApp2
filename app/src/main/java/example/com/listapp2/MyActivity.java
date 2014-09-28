package example.com.listapp2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MyActivity extends Activity {

    ArrayList<String> states;
   EditText tv;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        states = new ArrayList<String>();
        tv = (EditText) findViewById(R.id.textView);
        final ListView listView = (ListView) findViewById(R.id.listView1);

            states.add("Texas");
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, states);


            listView.setAdapter(adapter);
    }

    public void onAddClick(View v)
    {



        final String statesArray[] = {"Texas","Oklahoma","Maine","Hawaii","California"};


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick a state")
                .setItems(statesArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (!states.contains(statesArray[which])) {
                            states.add(statesArray[which]);
                            adapter.notifyDataSetChanged();
                        }
                    }
                });

        builder.create().show();
    }

    public void onDeleteClick(View v)
    {


                                states.remove(tv.getText().toString());
                                adapter.notifyDataSetChanged();
                                tv.setText("");



    }

    public void onShareClick(View v)
    {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            startActivity(Intent.createChooser(shareIntent, "Share"));
    }
}
