package com.example.note;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements OnItem {
    private RecyclerView rvNotes;
    private NotesAdapter adapter;
    private FloatingActionButton btnOpenActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNotesRecycler();
        initViews();
    }

    private void initViews() {
        btnOpenActivity = findViewById(R.id.btn_open_activity);
        btnOpenActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    private void initNotesRecycler() {
        rvNotes = findViewById(R.id.rv_notes);
        adapter = new NotesAdapter(this);
        rvNotes.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        NotesModel model = new NotesModel(data.getStringExtra("title"),
                data.getStringExtra("description"),
                "");
        if (requestCode == 100) {
            adapter.addNote(model);
        } else if (requestCode == 20) {
            adapter.changeNote(data.getIntExtra("position", 0), model);
        }
    }

    @Override
    public void click(int position) {
        Intent intent = new Intent(this, AddNoteActivity.class);
        intent.putExtra("isEdit", adapter.getList().get(position));
        intent.putExtra("position", position);
        startActivityForResult(intent, 20);
    }
}