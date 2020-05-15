package com.yomom.daftarpengingat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.yomom.identity.AuthAwareActivity;

public class MainActivity extends AuthAwareActivity {

    private ToDoListAdapter toDoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toDoListAdapter = new ToDoListAdapter(this);
        ListView toDoItemsListView = findViewById(R.id.to_do_items);
        toDoItemsListView.setAdapter(toDoListAdapter);
    }

    public void openToDoForm(View view){
        if(authenticationHandler.hasValidCredentials()){
            startActivityForResult(new Intent(this, ToDoFormActivity.class), 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (requestCode == RESULT_OK) {
                String newItem = data.getStringExtra("item");
                this.toDoListAdapter.addItem(newItem);
            }
        }
    }
}
