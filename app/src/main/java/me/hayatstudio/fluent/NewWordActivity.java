package me.hayatstudio.fluent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class NewWordActivity
    extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        AutoCompleteTextView articleDropdown = findViewById(R.id.anArticleDropdown);
        ArrayAdapter<String> articleAdapter = new ArrayAdapter<>(this,
            android.R.layout.simple_dropdown_item_1line,
            new String[] {"der", "das", "die"});
        articleDropdown.setAdapter(articleAdapter);

        TextView genderTextView = findViewById(R.id.anGenderTextView);
        articleDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (id == 0)
                    genderTextView.setText(R.string.gender_masc);
                else if (id == 1)
                    genderTextView.setText(R.string.gender_neut);
                else if (id == 2)
                    genderTextView.setText(R.string.gender_fem);
            }
        });
        genderTextView.setFirstBaselineToTopHeight(
            articleDropdown.getFirstBaselineToTopHeight());

        MaterialButton nounButton = findViewById(R.id.nounButton);
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
