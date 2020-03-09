package fhscapstone.fisheltestapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;

public class LoadTeamActivity extends Activity {

    public static File[] files = new File[3];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_team_activity);

        infoScreen();

    }

    public void infoScreen() {
        Button team1 = (Button)findByViewId(R.id.selection1);
    }

    public static boolean addSaveFile(File f) {
        if (!files[0].equals(null)) {
            files[0] = f;
        } else if (!files[1].equals(null)) {
            files[1] = f;
        } else if (!files[2].equals(null)) {
            files[2] = f;
        } else {
            return false;
        }
        return true;
    }
}
