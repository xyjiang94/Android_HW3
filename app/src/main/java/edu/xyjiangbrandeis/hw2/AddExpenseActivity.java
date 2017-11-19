package edu.xyjiangbrandeis.hw2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * A login screen that offers login via email/password.
 */
public class AddExpenseActivity extends AppCompatActivity {

    // UI references.
    private EditText mDespView;
    private EditText mNotesView;
    private Button mSaveButton;
    private Button mCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        mDespView = (EditText) findViewById(R.id.desp_input);
        mNotesView = (EditText) findViewById(R.id.notes_input);
        mSaveButton = (Button) findViewById(R.id.save_button);
        mCancelButton = (Button) findViewById(R.id.cancel_button);
    }


    public void clickCancelButton(View view) {
        mDespView.setText("");
        mNotesView.setText("");
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    public void clickSaveButton(View view) {
        Intent intent = new Intent();
        intent.putExtra("desp", mDespView.getText().toString());
        intent.putExtra("notes" , mNotesView.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}

