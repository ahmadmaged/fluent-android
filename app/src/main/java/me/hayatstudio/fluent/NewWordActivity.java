package me.hayatstudio.fluent;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class NewWordActivity
    extends AppCompatActivity
{
    private MaterialButton nounButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        AutoCompleteTextView articleDropdown = findViewById(R.id.articleDropdown);
        ArrayAdapter<String> articleAdapter = new ArrayAdapter<>(this,
            android.R.layout.simple_dropdown_item_1line,
            new String[] {"der", "das", "die"});
        articleDropdown.setAdapter(articleAdapter);

        nounButton = findViewById(R.id.nounButton);
        nounButton.setChecked(true);
    }

    public void nounButtonAction(View view)
    {
    }

    public void verbButtonAction(View view)
    {
    }

    public void otherButtonAction(View view)
    {
    }
}
