package fhscapstone.fisheltestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class NewTeamActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_team_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void infoScreen () {
        Button created = (Button) findViewById(R.id.created);
        Button backToTitle = (Button) findViewById(R.id.backToTitle);
        created.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                startActivity(new Intent(NewTeamActivity.this, /* */));
            }
        });
        backToTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                startActivity(new Intent(NewTeamActivity.this, MainActivity.class));
            }
        });
        Spinner primaryPgStat = (Spinner) findViewById(R.id.primaryPgStat);
        Spinner secondaryPgStat = (Spinner) findViewById(R.id.secondaryPgStat);
        Spinner primarySgStat = (Spinner) findViewById(R.id.primarySgStat);
        Spinner secondarySgStat = (Spinner) findViewById(R.id.secondarySgStat);
        Spinner primarySfStat = (Spinner) findViewById(R.id.primarySfStat);
        Spinner secondarySfStat = (Spinner) findViewById(R.id.secondarySfStat);
        Spinner primaryPfStat = (Spinner) findViewById(R.id.primaryPfStat);
        Spinner secondaryPfStat = (Spinner) findViewById(R.id.secondaryPfStat);
        Spinner primaryCStat = (Spinner) findViewById(R.id.primaryCStat);
        Spinner secondaryCStat = (Spinner) findViewById(R.id.secondaryCStat);

    }
}
