package me.hayatstudio.fluent;

import android.os.Bundle;
import android.view.View;

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
