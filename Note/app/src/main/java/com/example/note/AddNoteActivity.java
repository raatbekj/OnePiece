package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddNoteActivity extends AppCompatActivity {
    private EditText etTitle, etDescription;
    private Button btnSave;
    private int position;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_noteactivity);
        initViews();
        initChangeNote();
    }

    private void initChangeNote() {
        NotesModel model = (NotesModel) getIntent().getSerializableExtra("isEdit");
        if (model != null) {
            textView = findViewById(R.id.text_view);
            textView.setText("Change Note");
            position = getIntent().getIntExtra("position", 0);
            etTitle.setText(model.getTitle());
            etDescription.setText(model.getDescription());
        }
    }

    private void initViews() {
        etTitle = findViewById(R.id.et_title);
        etDescription = findViewById(R.id.et_description);
        btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString().trim();
                String description = etDescription.getText().toString().trim();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("title", title);
                returnIntent.putExtra("description", description);
                returnIntent.putExtra("position", position);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}