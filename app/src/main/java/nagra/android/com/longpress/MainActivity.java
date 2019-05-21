package nagra.android.com.longpress;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
            event.startTracking();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
            Toast.makeText(this, "onKeyLongPress for keycode " + keyCode, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Long press KEYCODE_DPAD_CENTER ::  for keycode " + keyCode);
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if ((event.getFlags() & KeyEvent.FLAG_CANCELED_LONG_PRESS) == 0) {
            if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
                Toast.makeText(this, "onKeyUp for keycode " + keyCode, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onKeyUp pressed KEYCODE_DPAD_CENTER :: for keycode " + keyCode);
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }
}
