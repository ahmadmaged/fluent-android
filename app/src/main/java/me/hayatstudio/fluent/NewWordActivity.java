package me.hayatstudio.fluent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.google.android.material.button.MaterialButton;

public class NewWordActivity
    extends AppCompatActivity
{

    ConstraintLayout layout;
    ConstraintSet constraints;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        layout = findViewById(R.id.root);
        constraints = new ConstraintSet();
        constraints.clone(layout);

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
        nounButtonAction(null);
    }

    public void nounButtonAction(View view)
    {
        constraints.connect(R.id.addWordButton, ConstraintSet.TOP,
                R.id.anSampleTextLayout, ConstraintSet.BOTTOM);
        constraints.applyTo(layout);
    }

    public void verbButtonAction(View view)
    {
    }

    public void otherButtonAction(View view)
    {
    }

}
